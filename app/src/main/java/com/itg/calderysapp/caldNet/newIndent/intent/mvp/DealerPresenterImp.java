package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;

import java.util.List;

public class DealerPresenterImp extends BaseWeakPresenter<IntentView.DealertView>
        implements IntentView.DealerPresenter, CommonListener.DealerListener {

    IntentView.DealertViewModule module;
    private PaginationModel model;
    private boolean isFinished = false;
    private boolean isLoading = false;

    public DealerPresenterImp(IntentView.DealertView view) {
        super(view);
        module = new DealerModuleImp();
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
                if (!isLoading && !isFinished) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                        int page = model.getPageNo();
                        page++;


//                        this.tbleName = tbleName;
//                        this.pageNo = pageNo;
//                        this.limit = limit;
//                        this.parameter = parameter;
//                        this.parameter2 = parameter2;

                        model.setParameter(getParameterIfAny());
                        getItems(model);
                    }
                }

            }
        };
    }

    @Override
    public void setViewAllAvailable(IntentView.DealertView view) {
        weakViewCreated(view);
    }

    private String getParameterIfAny() {
        return hasView()?getView().getQuery():null;
    }


    private IntentView.DealertView getIntentView() {
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

    }


    private void getItems(PaginationModel modell) {
        if (hasView()) {
            if (!getView().isPaginationLoading()) {

                getView().onShowPaginationLoading(true);
                isLoading = true;

                module.onGetAllDealerList(modell, this);
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
    public void onGetDealerList(List<DealerModel> o) {
        if (hasView()) {
            getView().onShowPaginationLoading(false);
            if (o.size() > 0)
                getView().onGetDealerList(o);
            else {
                getView().onNoMoreList();
                isFinished = true;
            }
            isLoading = false;
        }
    }
}
