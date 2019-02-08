package com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.consignee.ConsigneeListActivity;
import com.itg.calderysapp.caldNet.newIndent.consignee.adapter.ConsigneeListAdapter;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.genericRv.BaseClickListener;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.itg.calderysapp.R2.id.recyclerView;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity.RC_CONSIGNEE;

public class ConsigneeListViewModel extends BaseObservable {

    private static ConsigneeListAdapter consigneeAdapter;
    private Context context;
    public ObservableArrayList<ConsigneeListModel> consigneeListModels=new ObservableArrayList<>();

    PaginationModel model;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    Disposable disposable;

    public OnItemClickListner listner=new OnItemClickListner() {
        @Override
        public void onItemClicked(Object o) {
            ConsigneeListModel model= (ConsigneeListModel) o;
            if(model!=null){
                Intent intent=new Intent();
                intent.putExtra(CommonMethod.CONSIGNEE,model);
                ((ConsigneeListActivity)context).setResult(RC_CONSIGNEE,intent);
                ((ConsigneeListActivity)context).finish();
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
                    int page = model.getPageNo();
                    page++;

                    model.setPageNo(page);
//                        model.setLimit(10);
//                        model.setParameter(Prefs.getString(CommonMethod.USER_ID));
                    downloadCosignee();
                }

        }
    };

    private void addFooter() {
        if(consigneeAdapter!=null)
           consigneeAdapter.addFooter();
    }

    private void removeFooter(){
        if(consigneeAdapter!=null)
            consigneeAdapter.removeFooter();
    }

    public ConsigneeListViewModel(Context context) {
        this.context = context;
        createPagination(1);
        downloadCosignee();
    }

    private void createPagination(int pageNo) {
        model=new PaginationModel();
        model.setLimit(10);
        model.setPageNo(pageNo);
        model.setParameter(Prefs.getString(CommonMethod.USER_ID));
    }

    private void downloadCosignee() {
        addFooter();
        disposable=new NetworkUtility.NetworkBuilder().build().downloadConsignee(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                List<ConsigneeListModel> models= (List<ConsigneeListModel>) message;
                removeFooter();
                consigneeListModels.addAll(models);
            }

            @Override
            public void onFailure(Object err) {
                removeFooter();
            }

            @Override
            public void onSomethingWrong(Object e) {
                removeFooter();
            }
        });
    }

    @BindingAdapter({"customAdapterConsignee","customListener"})
    public static void customEntries(RecyclerView recyclerView,ObservableArrayList<ConsigneeListModel> list,OnItemClickListner listner){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
         consigneeAdapter = new ConsigneeListAdapter(list);
        recyclerView.setAdapter(consigneeAdapter);
        consigneeAdapter.setListener(listner);

//        consigneeAdapter.addModels(list);
    }



    @BindingAdapter({"scrollListner"})
    public static void customEntries(RecyclerView recyclerView,RecyclerView.OnScrollListener listener){
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//         consigneeAdapter = new ConsigneeListAdapter(list);
//        recyclerView.setAdapter(consigneeAdapter);
//        consigneeAdapter.addModels(list);
        recyclerView.addOnScrollListener(listener);
    }



    public interface OnItemClickListner extends BaseClickListener {
//        void onItemClicked(Object o);
    }

}
