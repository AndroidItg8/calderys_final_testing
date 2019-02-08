package com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.addmaterial.TransportListActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.adapter.TransportAdapter;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.ConsigneeListActivity;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

import io.reactivex.disposables.Disposable;

import static com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.RC_TRANSPORT;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity.RC_CONSIGNEE;

public class TransportListViewModel extends BaseObservable {

    private static TransportAdapter transportAdapter;
    private Context context;

    public ObservableArrayList<TransportModel> transportModels=new ObservableArrayList<>();
    private boolean isFinished=false;


    public ConsigneeListViewModel.OnItemClickListner listner=new ConsigneeListViewModel.OnItemClickListner() {
        @Override
        public void onItemClicked(Object o) {
            TransportModel model= (TransportModel) o;
            if(model!=null){
                Intent intent=new Intent();
                intent.putExtra(CommonMethod.TRANSPORT,model);
                ((TransportListActivity)context).setResult(RC_TRANSPORT,intent);
                ((TransportListActivity)context).finish();
            }
        }
    };



    public RecyclerView.OnScrollListener scrollListener=new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager linearLayoutManager= (LinearLayoutManager) recyclerView.getLayoutManager();
            int visibleItemCount = linearLayoutManager.getChildCount();
            int totalItemCount = linearLayoutManager.getItemCount();
            int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0)
            {
                if(!isFinished) {
                    int page = model.getPageNo();
                    page++;

                    model.setPageNo(page);
//                        model.setLimit(10);
//                        model.setParameter(Prefs.getString(CommonMethod.USER_ID));
                    downloadTransportList();
                }
            }

        }
    };

    PaginationModel model;

//    {
//        "Type":"16",
//            "PageSize":1000,
//            "PageNo":1,
//            "SearchTransport":""
//    }
    public TransportListViewModel(Context context) {
        this.context = context;
        model=new PaginationModel();
        generateInitModel(1,"");
        downloadTransportList();
    }

    private void downloadTransportList() {
        addFooter();
        Disposable disposable=new NetworkUtility.NetworkBuilder().build().downloadTransport(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                List<TransportModel> models= (List<TransportModel>) message;
                removeFooter();
                transportModels.addAll(models);
            }

            @Override
            public void onFailure(Object err) {
                removeFooter();
                isFinished=true;
            }

            @Override
            public void onSomethingWrong(Object e) {
                removeFooter();

            }
        });
    }

    private void generateInitModel(int pageNo,String search) {
        model.setPageNo(pageNo);
        model.setLimit(10);
        model.setParameter(String.valueOf(16));
        model.setParameter2(search);
    }


    private void addFooter() {
        if(transportAdapter !=null)
            transportAdapter.addFooter();
    }

    private void removeFooter(){
        if(transportAdapter !=null)
            transportAdapter.removeFooter();
    }


    @BindingAdapter({"customAdapterTransport","customListener"})
    public static void customEntries(RecyclerView recyclerView, ObservableArrayList<TransportModel> list, ConsigneeListViewModel.OnItemClickListner listner){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        transportAdapter = new TransportAdapter(list);
        recyclerView.setAdapter(transportAdapter);
        transportAdapter.setListener(listner);

    }

    @BindingAdapter({"scrollListner"})
    public static void customEntries(RecyclerView recyclerView,RecyclerView.OnScrollListener listener){
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//         consigneeAdapter = new ConsigneeListAdapter(list);
//        recyclerView.setAdapter(consigneeAdapter);
//        consigneeAdapter.addModels(list);
        recyclerView.addOnScrollListener(listener);
    }


    public void setSearch(String s) {
        model.setPageNo(1);
        model.setParameter2(s);
        transportModels.clear();
        downloadTransportList();
    }


}
