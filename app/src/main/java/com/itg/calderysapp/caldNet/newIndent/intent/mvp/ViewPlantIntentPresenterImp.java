package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.ViewPantIntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.Prefs;

import java.util.List;

public class ViewPlantIntentPresenterImp extends BaseWeakPresenter<IntentView.ViewPlantIntentView> implements IntentView.ViewPlantIntentPresenter, CommonListener.MyIntentListener {
    IntentView.ViewPlantIntentModule module;
    private boolean isLoading = false;
    private boolean isFinished = false;
    private PaginationModel model;



    public ViewPlantIntentPresenterImp(IntentView.ViewPlantIntentView view) {
        super(view);
        module = new ViewPlantIntentModuleImp();
        model = new PaginationModel();
        model.setPageNo(1);
        model.setLimit(10);
        model.setParameter(Prefs.getString(CommonMethod.USER_ID));

    }

    @Override
    public void onSubmitApproved(View v, String userType) {
        if (hasView()) {

            boolean isValid = true;

            String srtDate = getView().getStartDate();
            String endDate = getView().getEndDate();

            if (TextUtils.isEmpty(srtDate)) {
                isValid = false;
                getView().onStartDateInvalid(v.getContext().getString(R.string.empty));
            } else {
                isValid = true;
                getView().onStartDateInvalid(null);
            }
            if (TextUtils.isEmpty(endDate)) {
                isValid = false;
                getView().onEndDateInvalid(v.getContext().getString(R.string.empty));
            } else {
                isValid = true;
                getView().onEndDateInvalid(null);
            }


            if (isValid) {
                getView().showProgress();
//                PaginationModel model = new PaginationModel();
//                model.setLimit(10);
//                model.setParameter(srtDate);
//                model.setParameter2(endDate);
//                model.setPageNo(1);
//                if (userType.equalsIgnoreCase(UserType.S.toString()))
//                    model.setTbleName(null);
//                else
//                    model.setTbleName(Prefs.getString(CommonMethod.USER_ID));

                this.model.setParameter2(srtDate);
                this.model.setParameter3(endDate);
                getViewPlantIntentView().addScrollListener();
                module.onGetAllViewIntent(this.model, this);


            }


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
                        loadMore();
                    }
                }

            }
        };
    }
    @Override
    public void onCancelMyIntent(IndentModel indentModel) {
        if(hasView()){
            module.onDeleteIndent(indentModel, this);
        }

    }

    @Override
    public void setViewAllAvailable(IntentView.ViewPlantIntentView view) {
        weakViewCreated(view);
    }


    @Override
    public void loadMore() {
        int page = model.getPageNo();
        page++;
        model.setPageNo(page);
        getItems(model);
    }


    private IntentView.ViewPlantIntentView getViewPlantIntentView() {
        return getView();
    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onLoadMore(PaginationModel tbleName) {
        getItems(tbleName);
    }


    @Override
    public void onLoadMoreItem(PaginationModel tbleName) {
        onLoadMore(tbleName);
    }


    @Override
    public void onFail(String message) {
        if (hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onError(message);
        }
    }

    @Override
    public void onError(Object t) {
        if (hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onFail((PaginationModel) t);
        }
    }

    @Override
    public void onSuccess(Object o, String approved) {
        if(hasView()){
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onSuccess((IndentModel) o);
        }

    }


    private void getItems(PaginationModel model) {
        if (hasView()) {
            getView().onShowPaginationLoading(true);
            isLoading = true;
            module.onGetAllViewIntent(model, this);
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
            getViewPlantIntentView().hideProgress();

            getViewPlantIntentView().onShowPaginationLoading(false);
            if (o.size() > 0)
                getViewPlantIntentView().onGetAllViewPlantIntentList(o);
            else {
                getViewPlantIntentView().onNoMoreList();
                isFinished = true;
            }
            isLoading = false;
        }

    }
}
