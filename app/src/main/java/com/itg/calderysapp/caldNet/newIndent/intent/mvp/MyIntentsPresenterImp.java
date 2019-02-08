package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.CommonMethod;


import java.util.List;

public class MyIntentsPresenterImp extends BaseWeakPresenter<IntentView.MyIntentsView>
        implements IntentView.MyIntentsPresenter, CommonListener.MyIntentListener {

    IntentView.MyIntentsModule module;
    private PaginationModel model;
    private boolean isFinished = false;
    private boolean isLoading = false;

    @Override
    public void allViewAvailable(IntentView.MyIntentsView myIntentFragment) {
        weakViewCreated(myIntentFragment);

    }

    public MyIntentsPresenterImp(IntentView.MyIntentsView view) {
        super(view);
        module = new MyIntentsModuleImp();
        model = new PaginationModel();
        model.setLimit(10);
        model.setPageNo(1);
        model.setTbleName(CommonMethod.TBL_MYINDENT);
    }


    @Override
    public void onDownLoadMyIntents(PaginationModel model) {
        if (hasView()) {
            getView().onShowPaginationLoading(true);
            isLoading = true;
            getItems(model);

        }


    }

    @Override
    public void onCancelMyIntent(IndentModel MyIntentId) {
        if (hasView()) {
            module.onCancelMyIntent(MyIntentId, this);

        }

    }


    @Override
    public RecyclerView.OnScrollListener scrollListener(LinearLayoutManager linearLayoutManager, String userId) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (!isLoading && !isFinished) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                        int page = model.getPageNo();
                        page++;
                        model.setPageNo(page);
                        getItems(model);
                    }
                }

            }
        };
    }


    private IntentView.MyIntentsView getIntentView() {
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
        if (hasView()) {
            getIntentView().hideProgress();
            getIntentView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if (hasView()) {
            getIntentView().hideProgress();
            getIntentView().onError(t);
        }
    }

    @Override
    public void onSuccess(Object o, String approved) {
        if (hasView()) {
            getIntentView().hideProgress();
            getIntentView().onSuccess((IndentModel) o);
        }

    }


    private void getItems(PaginationModel modell) {
        if (hasView()) {
            if (!getView().isPaginationLoading()) {
                if (modell.getPageNo() == 1)
                    getView().getPageItem(modell.getPageNo(), true);
                else
                    getView().onShowPaginationLoading(true);
                isLoading = true;
//                if(modell.getParameter()==null)
                module.onGetMyIntent(modell, this);
//                else
//                     module.onGetSingleIndent(modell, this);
            }
        }
    }


    @Override
    public void onPaginationError() {
        if (hasView()) {
            getView().onShowPaginationLoading(false);
        }
    }

    @Override
    public void onGetMyIntentsListAvailable(List<IndentModel> o) {
        if (hasView()) {
            getView().onShowPaginationLoading(false);
            if (o.size() > 0)
                getView().onGetMyIntentsListAvailable(o);
            else {
                getView().onNoMoreList();

                isFinished = true;
            }
            isLoading = false;
        }
    }


}

