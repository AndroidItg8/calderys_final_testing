package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;

import java.util.List;

public class DispachedPresenterImp  extends BaseWeakPresenter<IntentView.DispachedView>
        implements IntentView.DispachedPresenter,CommonListener.DispachedListener {

    IntentView. DispacheModule module;
    private PaginationModel model;
    private boolean isFinished=false;
    private boolean isLoading=false;

    public DispachedPresenterImp(IntentView.DispachedView view) {
        super(view);
        module=new DispachedModuleImp();
        model = new PaginationModel();
    }

    @Override
    public RecyclerView.OnScrollListener scrollListener(LinearLayoutManager linearLayoutManager, String TbleName) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (!isLoading && !isFinished)
                {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0)
                    {
                        int page = model.getPageNo();
                        page++;

//                        this.tbleName = tbleName;
//                        this.pageNo = pageNo;
//                        this.limit = limit;
//                        this.parameter = parameter;
//                        this.parameter2 = parameter2;

                        model.setPageNo(page);
                        model.setLimit(10);
                        model.setParameter(TbleName);



                        getItems(model);
                    }
                }

            }
        };
    }

    @Override
    public void setViewAllAvailable(IntentView.DispachedView view) {
        weakViewCreated(view);
    }


    private IntentView.DispachedView getIntentView() {
        return getView();
    }
    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onLoadMore(PaginationModel model) {
        getItems(model);
    }

    @Override
    public void onLoadMoreItem(PaginationModel model) {
        onLoadMore(model);
    }



    @Override
    public void onFail(String message) {
        if(hasView()) {
            getIntentView().hideProgress();
            getIntentView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getIntentView().hideProgress();
            getIntentView().onError(t);
        }
    }

    @Override
    public void onSuccess(Object o, String approved) {

    }





    private void getItems(PaginationModel modell) {
        if(hasView()){
            getView().onShowPaginationLoading(true);
            isLoading=true;

            module.onGetDispached(modell,this);
        }
    }





    @Override
    public void onPaginationError() {
        if(hasView()){
            getView().onShowPaginationLoading(false);
        }
    }

    @Override
    public void onGetAllDispachedList(List<DispachedModel> o) {
        if(hasView()){
            getView().onShowPaginationLoading(false);
            if(o.size()>0)
                getView().onGetDispachedList(o);
            else {
                getView().onNoMoreList();
                isFinished=true;
            }
            isLoading=false;
        }
    }




}
