package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IntentByDateModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;

import java.util.List;

public class ViewIntentPresenterImp  extends BaseWeakPresenter<IntentView.ViewIntentView> implements IntentView.ViewIntentPresenter,CommonListener.MyIntentListener{
    private PaginationModel model;
    IntentView.ViewIntentModule module;
    private boolean isLoading=false;
    private boolean isFinished=false;

    public ViewIntentPresenterImp(IntentView.ViewIntentView viewIntentView) {
        super(viewIntentView);
        module= new ViewIntentModuleImp();
        model = new PaginationModel();
    }







    @Override
    public void onSubmitViewIntent(IntentByDateModel model) {
        if(hasView())
        {
            getView().showProgress();
            module.onGetViewIntentListByDate(model, this);
        }
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
                        model.setTbleName(TbleName);

                        getItems(page,model.getLimit());
                    }
                }

            }
        };
    }






    private IntentView.ViewIntentView getViewPlantIntentView() {
        return getView();
    }
    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onLoadMore(String tbleName) {
        model.setTbleName(tbleName);
        getItems(model.getPageNo(),model.getLimit());
    }

    @Override
    public void onLoadMoreItem(String tbleName) {
        onLoadMore(tbleName);
    }



    @Override
    public void onFail(String message) {
        if(hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onError(t);
        }
    }

    @Override
    public void onSuccess(Object o, String approved) {

    }





    private void getItems(int page, int limit) {
        if(hasView()){
            getView().onShowPaginationLoading(true);
            isLoading=true;
            model = new PaginationModel();
            model.setLimit(limit);
            model.setPageNo(page);
            model.setTbleName("");
            module.onGetAllViewIntent(model,this);
        }
    }





    @Override
    public void onPaginationError() {
        if(hasView()){
            getView().onShowPaginationLoading(false);
        }
    }


    @Override
    public void onGetMyIntentsListAvailable(List<IndentModel> o) {
        if(hasView())
        {
            getView().showProgress();
            module.onGetAllViewIntent(model, this);
        }
    }
}
