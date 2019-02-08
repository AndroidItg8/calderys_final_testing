package com.itg.calderysapp.caldNet.newIndent.createIntent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;

import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.notification.NotificationModel.Data;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.notification.controller.FirebaseMessageController;

import java.util.List;

public class CreateIntentPresenterImp extends BaseWeakPresenter<CreateIntentMVP.CreatIntentView> implements CreateIntentMVP.CreateIntentPresenter, CommonListener.CreateIntentListener {
    private static final String TAG = "CreateIntentPresenterIm";
    CreateIntentMVP.CreateIntentModule module;
    private PaginationModel model;
    private boolean isFinished = false;
    private boolean isLoading = false;

    @Override
    public void onSuccessNotification(IntentDetailModel message) {
//        IndentsModel model = new Gson().fromJson(message.toString(), IndentsModel.class);
        FirebaseMessageController controller = new FirebaseMessageController();
        controller.sendNotification(createNotificationData(message));
    }

    private Message createNotificationData(IntentDetailModel model) {
        Log.d(TAG, "createNotificationData: IndenstModel" + new Gson().toJson(model));
        Data data = new Data();
        data.setClasstype(CommonMethod.INDENT_STATUS);
        data.setData(new Gson().toJson(model));
        String ststus = null;
        if (model.getIndentStatus().equalsIgnoreCase(CommonMethod.SO_GENRATED))
            ststus = "Approve";
        else if (model.getIndentStatus().equalsIgnoreCase(CommonMethod.REJECT))
            ststus = "Reject";
        data.setTitle("Indent Code : is " + ststus + "on CaldNet");
        data.setMessage(" Indent Code: " + model.getIndentCode() + ststus + " on CaldNet");
        Message msg = new Message();
        msg.setData(data);
        msg.setTo("/topics/" + AppType.getAppType());
        return msg;
    }

    @Override
    public void sendAllApprovedDatabase(IntentDetailModel message, View view, int fromApproved) {
        if (hasView()) {
            getViewPlantIntentView().showProgress();
            module.onSaveApproved(message, this);
        }

    }

    @Override
    public void downloadEqpCode(String id) {
        if(hasView()){
            module.downloadEqpCode(id);
        }
    }

    @Override
    public void sendAllApproved(IntentDetailModel model, View view, int from) {
        if (hasView()) {
            boolean isValidate = true;
            String approvedeject = getViewPlantIntentView().getApprovedeject();
            if (from == CommonMethod.FROM_APPROVED) {

//                if (TextUtils.isEmpty(approvedeject)) {
//                    isValidate = false;
//                    getViewPlantIntentView().onInvalideApproveReject(view.getContext().getString(R.string.empty));
//                } else {
//                    isValidate = true;
//                    model.setCommentsForAppovedReject(approvedeject);
//                }

                if (getValidationForIndent(model.getSoType(),"So Type")) {
                    return;

                }
                if (getValidationForIndent(model.getSalesOffice(),"Sales Office")) {
                    return;
                }
                if (getValidationForIndent(model.getDistributionChannel(),"Distributor Channel")) {
                    return;
                }
                if (getValidationForIndent(model.getUsaguageIndicator(),"Usage indicator")) {
                    return;
                }
                if (getValidationForIndent(model.getProcessCode(),"Process code")) {
                    return;
                }

                if (getValidationForIndent(model.getSplProcessIndicator(),"Special Process Indicator")) {
                    return;
                }
                if (getValidationForIndent(model.getEquipmentCode(),"Equipment Process")) {
                    return;
                }

                if (getValidationForIndent(model.getSalesGroup(),"Sales Group")) {
                    return;
                }
                if (getValidationForIndent(model.getSalesPackage(),"Sales Package")) {
                    return;
                }


            }

            if (isValidate) {
                getViewPlantIntentView().showProgress();
                if (from == CommonMethod.FROM_APPROVED)
                    getView().setSAPModel(model);
                else
                    module.onSaveReject(model, this);


            }


        }
    }

    public boolean getValidationForIndent(String model,String error) {
        if (TextUtils.isEmpty(model)) {
            getViewPlantIntentView().showSnackbar(error);
            return true;
        }
        return false;


    }

    @Override
    public void onDeletIndent(IntentDetailModel indentModel) {
        if (hasView()) {
            getViewPlantIntentView().showProgress();
            module.onDeleteIndent(indentModel, this);
        }
    }

    @Override
    public void setViewAllAvailable(CreateIntentMVP.CreatIntentView view) {
        weakViewCreated(view);
    }

    public CreateIntentPresenterImp(CreateIntentMVP.CreatIntentView view) {
        super(view);
        module = new CreateIntentModuleImp();
        model = new PaginationModel();
    }


    @Override
    public void onEditViewDraftData(ViewDraftModel model) {
        if (hasView()) {
            getViewPlantIntentView().showProgress();
            module.onDownloadEditViewDraft(model, this);

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
                if (!isLoading && !isFinished) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                        int page = model.getPageNo();
                        page++;
                        model.setTbleName(TbleName);

                        getItems(page, model.getLimit());
                    }
                }

            }
        };
    }


    @Override
    public void saveApprove(IntentDetailModel model) {


    }

    @Override
    public void saveReject(IntentDetailModel model, View view, int from) {
        if (hasView()) {
            getView().showProgress();
            module.onSaveReject(model, this);
        }
    }

    private CreateIntentMVP.CreatIntentView getViewPlantIntentView() {
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
        getItems(model.getPageNo(), model.getLimit());
    }

    @Override
    public void onLoadMoreItem(String tbleName) {
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
    public void onSuccess(Object o, String status) {
        if (hasView()) {
            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().createNotification(status);
            getViewPlantIntentView().onSuccess(o.toString(),status );
        }

    }


    private void getItems(int page, int limit) {
        if (hasView()) {
            getView().onShowPaginationLoading(true);
            isLoading = true;
            model = new PaginationModel();
            model.setLimit(limit);
            model.setPageNo(page);
            model.setTbleName("");
            module.onDownloadMaterialList(model, this);
        }
    }


    @Override
    public void onPaginationError() {
        if (hasView()) {
            getView().onShowPaginationLoading(false);
        }
    }


    @Override
    public void onGetMaterialList(List<IndentModel> o) {

    }

    @Override
    public void onDownloadEditViewDraft(Indents model) {
        if (hasView()) {

            getViewPlantIntentView().hideProgress();
            getViewPlantIntentView().onGetEditDraft(model);
        }

    }
}
