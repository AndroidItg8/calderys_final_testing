package com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.ViewIntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;

import java.util.List;

public class ApprovedIntentPresenterImp extends BaseWeakPresenter<IntentView.ApprovedIntentView> implements IntentView.ApprovedIntentPresenter, CommonListener.ApprovedIntentListener {

    @Override
    public void setViewAllAvailable(ViewIntentFragment viewIntentFragment) {
        weakViewCreated(viewIntentFragment);
    }

    IntentView.ApprovedIntentModule module;
    private PaginationModel model;
    private boolean isLoading = false;
    private boolean isFinished = false;

    @Override
    public void onCancelMyIntent(IndentModel indentModel) {
        if (hasView()) {
            module.onCancelIndent(indentModel, this);
        }

    }

    public ApprovedIntentPresenterImp(IntentView.ApprovedIntentView view) {
        super(view);
        module = new ApprovedIntentModuleImp();
        model = new PaginationModel();
    }

    @Override
    public void onGetAllApprovedIntent(List<IndentModel> o) {

        if (hasView()) {
            getView().hideProgress();
            getView().onShowPaginationLoading(false);
            if (o.size() > 0)
                getView().onGetAllApprovedIntent(o);
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
                        loadMore();
                    }
                }

            }
        };
    }

    @Override
    public void allViewAvailable(IntentView.ApprovedIntentView view) {
        weakViewCreated(view);
    }

    @Override
    public void loadMore() {
        if(!isLoading) {
            int page = model.getPageNo();
            page++;
//                        model.setPageNo(page);
            if (model != null) {
                if (hasView()) {
                    getView().createPaginationModel(page, model);
                }
            }

            getItems(model);
        }
    }


    private IntentView.ApprovedIntentView getIntentView() {
        return getView();
    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }


    @Override
    public void onSubmitApproved(View view, int fromViewIntent) {
        if (hasView()) {

            boolean isValid = true;
            String dealerCode = getView().getDealerCode();
            String indentCode = getView().getIndentCode();
            String srtDate = getView().getStartDate();
            String endDate = getView().getEndDate();
            String status = getView().getStatus();
//            if(fromViewIntent == CommonMethod.FROM_VIEW_INTENT){
//                if(TextUtils.isEmpty(status))
//                {
//                    isValid=false;
//                    getView().onStatusCodeInvalid(view.getContext().getString(R.string.empty));
//                }else{
//                    isValid=true;
//                    getView().onStatusCodeInvalid(null);
//                }
//            }


//            if(TextUtils.isEmpty(dealerCode))
//            {
//                isValid=false;
//                getView().onDealerCodeInvalid(view.getContext().getString(R.string.empty));
//            }else{
//                isValid=true;
//                getView().onDealerCodeInvalid(null);
//            }


//            if(TextUtils.isEmpty(indentCode))
//            {
//                isValid=false;
//                getView().onIndentCodeInvalid(view.getContext().getString(R.string.empty));
//            }else{
//                isValid = true;
//                getView().onIndentCodeInvalid(null);
//
//            }

            if (TextUtils.isEmpty(srtDate)) {
                isValid = false;
                getView().onStartDateInvalid(view.getContext().getString(R.string.empty));
            } else {
                isValid = true;
                getView().onStartDateInvalid(null);
            }
            if (TextUtils.isEmpty(endDate)) {
                isValid = false;
                getView().onEndDateInvalid(view.getContext().getString(R.string.empty));
            } else {
                isValid = true;
                getView().onEndDateInvalid(null);
            }


            if (isValid) {
                getView().showProgress();
//                IntentByDateModel model =  new IntentByDateModel();
//                model.setDealerCode(dealerCode);
//                model.setIntentCode(indentCode);
//                model.setStartDate(srtDate);
//                model.setEndDate(endDate);
//                model.setStatusCode(status);
//                model.setTbleName(CommonMethod.TBL_APPROVED_INDENT);
                getIntentView().addScrollListener();
                getIntentView().createPaginationModel(1, model);


                module.onGetApprovedIntentListByDate(model, this);
            }


        }

    }

    @Override
    public void onApproveClicked(IndentModel model) {

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


    private void getItems(PaginationModel model) {
        if (hasView()) {
            getView().onShowPaginationLoading(true);
            isLoading = true;
            module.onGetApprovedIntentListByDate(model, this);
        }
    }


    @Override
    public void onPaginationError() {
        if (hasView()) {
            getView().onShowPaginationLoading(false);
        }
    }

}
