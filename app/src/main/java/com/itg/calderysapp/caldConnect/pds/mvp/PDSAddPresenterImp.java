package com.itg.calderysapp.caldConnect.pds.mvp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.CompleteResultModel;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.notification.controller.FirebaseMessageController;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class PDSAddPresenterImp extends BaseWeakPresenter<PDSMVP.PDSAddView> implements PDSMVP.PDSAddListener, PDSMVP.PDSAddPresenter {

    private final Context context;
    private PDSMVP.PDSAddModule module;
    private String id;

    public PDSAddPresenterImp(PDSMVP.PDSAddView pdsAddView, Context context) {
        super(pdsAddView);
        this.context = context;
        module = new PDSAddModuleImp();
    }

    @Override
    public void getFirstPDSItem() {
        if (hasView()) {
            module.onGetPDSListFromServer(CommonMethod.TBL_PDS, 1, 1, this);
        }
    }

    @Override
    public void onFileUpload(String absoluteFile, View v) {

        if (hasView()) {

            boolean isValid = true;
            String share = getPDSView().getFileType();
            String productType = getPDSView().getProductType();
            String familyGroup = getPDSView().getFamilyGroup();
            String productName = getPDSView().getProductName();
            if (TextUtils.isEmpty(productName)) {
                isValid = false;
                getPDSView().onProductNameInvalid(context.getString(R.string.empty));
            }
            if (TextUtils.isEmpty(productType)) {
                isValid = false;
                getPDSView().onProductTypeInvalid(context.getString(R.string.empty));
            }

            if (absoluteFile == null && TextUtils.isEmpty(absoluteFile)) {
                isValid = false;
                getPDSView().onFileInvalid(context.getString(R.string.empty));
            }
            if (TextUtils.isEmpty(familyGroup)) {
                isValid = false;
                getPDSView().onProductFamilyGroupInvalid(context.getString(R.string.empty));
            }


            if (isValid) {
                getPDSView().showProgress();
                getPDSView().showFabProgress();
                module.onUploadFileToServer(new File(absoluteFile).getAbsoluteFile(), this);
            }
//

        }
    }

    @Override
    public void onSuccessFamilyGroupe(List<TblFamilyGroup> message) {
        if (hasView()) {
            getPDSView().hideProgress();
            getPDSView().onSuccessFamilyGroupe(message);
        }

    }

    @Override
    public void onDownloadFamily() {
        if (hasView()) {
            getPDSView().showProgress();
            module.onDownloadFamilyGroupe(this, context);
        }
    }

    @Override
    public void onDownloadSpinner() {
        if (hasView()) {
            getPDSView().showProgress();
            module.onDownloadProductType(this, context);
        }
    }

    @Override
    public void onGetItemFirstPDS(List<Data> message) {
        if (message.size() > 0) {
            onSuccessDataNotification(message.get(0));
        }
    }

    @Override
    public void onSuccessDataNotification(Data message) {
        FirebaseMessageController controller = new FirebaseMessageController();
        controller.sendNotification(createNotificationData(message));
        if(hasView()){
            getPDSView().setData(message);
            getPDSView().onSuccessSave("Save Successfully");
        }
    }

    private Message createNotificationData(Data message) {


        com.itg.calderysapp.notification.NotificationModel.Data data = new com.itg.calderysapp.notification.NotificationModel.Data();
        data.setClasstype(CommonMethod.PDS_ITEM);
        data.setData(new Gson().toJson(message));
        data.setMessage(message.getProductName());
        data.setTitle("New PDS posted on Calde Connect");
        Message msg = new Message();
        msg.setData(data);
        msg.setTo("/topics/" + AppType.getAppType());
        return msg;

    }

    @Override
    public void onSubmitbtnClicked(PDSMVP.PDSAddView view) {

        if (hasView()) {

            boolean isValid = true;
            String share = getPDSView().getFileType();
            String productType = getPDSView().getProductType();
            String familyGroup = getPDSView().getFamilyGroup();
            String productName = getPDSView().getProductName();
         String   filePath=getPDSView().getFilePath();
       id = getPDSView().getID();

            if (TextUtils.isEmpty(productName)) {
                isValid = false;
                getPDSView().onProductNameInvalid(context.getString(R.string.empty));
            }
            if (TextUtils.isEmpty(productType)) {
                isValid = false;
                getPDSView().onProductFileTypeInvalid(context.getString(R.string.empty));
            }

            if (TextUtils.isEmpty(share)) {
                isValid = false;
                getPDSView().onFileInvalid(context.getString(R.string.empty));
            }
            if (TextUtils.isEmpty(familyGroup)) {
                isValid = false;
                getPDSView().onProductFamilyGroupInvalid(context.getString(R.string.empty));
            }


            if (isValid) {
                getPDSView().showProgress();
                module.onSubmitPDS(productName, productType, familyGroup, CommonMethod.getDDMMYYYYfromDate(Calendar.getInstance()), filePath, share, id, this);
            }

        }

    }

    @Override
    public void onDownloadedCompelete(CompleteResultModel tableName) {
        if (hasView()) {
            getPDSView().hideProgress();

        }
    }


    @Override
    public void onDestroy() {
        detactView();
        module.onDestroyed();
    }


    private PDSMVP.PDSAddView getPDSView() {
        return getView();
    }

    @Override
    public void onSuccess(List<TblProductType> message) {
        if (hasView()) {
            getPDSView().hideProgress();
            getPDSView().onSuccess(message);

        }
    }

    @Override
    public void onFail(String message) {
        if (hasView()) {
            getPDSView().hideProgress();
            getPDSView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if (hasView()) {
            getPDSView().hideProgress();
            getPDSView().onError(t);
        }
    }

    @Override
    public void onSuccessSave(String s) {
        if (hasView()) {
            getPDSView().hideProgress();
            getPDSView().onSuccessSave(s);
        }
    }

    @Override
    public void onFileSuccess(String s) {
        if (hasView()) {
            getPDSView().hideFabProgress();
            getPDSView().onSuccessFile(s);
        }
    }


    @Override
    public void onProgressUpdate(int prrogress) {
        if (hasView()) {
            getPDSView().showFabProgress();
            getPDSView().onProgressUpdate(prrogress);
        }
    }

    @Override
    public void onFailedProgress() {
        if (hasView()) {
            getPDSView().hideFabProgress();
            getPDSView().failedFileUpload();
        }
    }

    @Override
    public void onFinished() {
        if (hasView()) {
            getPDSView().showFabProgress();
            getPDSView().onFinishedFileUpload();
        }

    }
}
