package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;

import java.util.List;

public class ViewDraftPresenterImp extends BaseWeakPresenter<IntentView.ViewDraftView> implements IntentView.ViewDraftPresenter, CommonListener.ViewDraftListener {
    IntentView.ViewDraftModule module;
    private PaginationModel model;
    private boolean isFinished = false;
    private boolean isLoading = false;

    public ViewDraftPresenterImp(IntentView.ViewDraftView viewDraftView) {
        super(viewDraftView);
        module = new ViewDraftModuleImp();
        model = new PaginationModel();
    }


    @Override
    public void onGetViewDraftsListAvailable(List<ViewDraftModel> o) {
        if (hasView()) {
            getView().onShowPaginationLoading(false);

            if (o.size() > 0)
                getView().onGetViewDraftListAvailable(o);
            else {
                getView().onNoMoreList();
                isFinished = true;
            }
            isLoading = false;
        }
    }

    @Override
    public RecyclerView.OnScrollListener scrollListener(LinearLayoutManager linearLayoutManager) {
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
//                        model.setLimit(10);
//                        model.setParameter(Prefs.getString(CommonMethod.USER_ID));
                        getItems(model);
                    }
                }

            }
        };
    }

    @Override
    public void onSuccessDelete(Object message) {
        if (hasView()) {
//            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onSuccesDelete((ViewDraftModel) message);
        }
    }

    @Override
    public void onCancelViewDraft(ViewDraftModel model) {
        if (hasView()) {
            getView().showProgress();
            module.onCancelViewDraft(model, this);
        }


    }

    @Override
    public void allViewAvailable(IntentView.ViewDraftView view) {
        weakViewCreated(view);
    }

    private IntentView.ViewDraftView getViewPlantIntentView() {
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
    public void onLoadMoreItem(PaginationModel tbleName) {
        this.model = tbleName;
        onLoadMore(tbleName);
    }


    @Override
    public void onFail(String message) {
        if (hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if (hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onError(t);
        }
    }

    @Override
    public void onSuccess(Object o, String approved) {
        if (hasView()) {
//            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onSuccess((ViewDraftModel) o);
        }

    }


    private void getItems(PaginationModel model) {
        if (hasView()) {
            if (model.getPageNo() == 1)
                getView().setSwipeForPage(model.getPageNo(), true);
            else

                getView().onShowPaginationLoading(true);
            isLoading = true;

            module.onGetViewDraftList(model, this);
        }
    }


    @Override
    public void onPaginationError() {
        if (hasView()) {
            getView().onShowPaginationLoading(false);
        }
    }


}
