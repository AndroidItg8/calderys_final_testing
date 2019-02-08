package com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.ProductListActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.TransportListActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.adapter.ProductAdapter;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.adapter.TransportAdapter;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

import io.reactivex.disposables.Disposable;

import static com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.RC_TRANSPORT;

public class ProductListViewModel extends BaseObservable {
    public static final int RC_MATERIAL = 202;
    private final Context context;
    private static ProductAdapter adapter;

    private boolean isFinished=false;
    private static final String TAG = "ProductListViewModel";


    public ObservableArrayList<MaterialModel> transportModels=new ObservableArrayList<>();

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


    public ConsigneeListViewModel.OnItemClickListner listner=new ConsigneeListViewModel.OnItemClickListner() {
        @Override
        public void onItemClicked(Object o) {
            MaterialModel model= (MaterialModel) o;
            if(model!=null){
                Intent intent=new Intent();
                intent.putExtra(CommonMethod.FROM_MATERIAL,model);
                ((ProductListActivity)context).setResult(RC_MATERIAL,intent);
                ((ProductListActivity)context).finish();
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
    public ProductListViewModel(Context context) {
        this.context = context;
        model=new PaginationModel();
        generateInitModel(1,"");
    }

    private void downloadTransportList() {
        addFooter();
        Disposable disposable=new NetworkUtility.NetworkBuilder().build().downloadProducts(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                List<MaterialModel> models= (List<MaterialModel>) message;
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
        model.setParameter(String.valueOf(13));
        model.setParameter2(search);
    }


    private void addFooter() {
        if(adapter !=null)
            adapter.addFooter();
    }

    private void removeFooter(){
        if(adapter !=null)
            adapter.removeFooter();
    }


    @BindingAdapter({"customAdapterProduct","customListener"})
    public static void customEntries(RecyclerView recyclerView, ObservableArrayList<MaterialModel> list, ConsigneeListViewModel.OnItemClickListner listner){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        adapter = new ProductAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setListener(listner);
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
        model.setParameter(String.valueOf(14));
        model.setParameter5(s);
        transportModels.clear();
        downloadTransportList();
    }

    public void setPagination(PaginationModel model) {
        this.model=model;
        downloadTransportList();
    }
}
