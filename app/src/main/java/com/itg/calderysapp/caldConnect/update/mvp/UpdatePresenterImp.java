package com.itg.calderysapp.caldConnect.update.mvp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.notification.NotificationModel.Data;
import com.itg.calderysapp.notification.NotificationModel.Message;

import com.itg.calderysapp.notification.controller.FirebaseMessageController;

import java.io.File;
import java.util.Calendar;

public class UpdatePresenterImp extends BaseWeakPresenter<UpdateMVP.AddUpdateView> implements UpdateMVP.AddUpdateListener,UpdateMVP.AddUpdatePresenter  {
    private final UpdateMVP.AddUpdateModule module;
    private final Context context;
    private String titles;
    private String description;
    private String filePath;
    private String id;

    public UpdatePresenterImp(UpdateMVP.AddUpdateView addUpdateView, Context context) {
        super(addUpdateView);
        this.context = context;
        module=new UpdateModuleImp();
    }



    @Override
    public void onAddUpdateClicked(UpdateMVP.AddUpdateView view) {
        if(hasView()){

            boolean isValid=true;
            titles=getLoginView().getTitles();
            description=getLoginView().getDescription();
            filePath=getLoginView().getFilePath();
            id =getLoginView().getID();
            if(TextUtils.isEmpty(description))
            {
                isValid=false;
                getLoginView().onDescriptionInvalid(context.getString(R.string.empty));
            }

            if(TextUtils.isEmpty(titles))
            {
                isValid=false;
                getLoginView().onTitleInvalid(context.getString(R.string.empty));
            }
//            if(TextUtils.isEmpty(filePath))
//            {
//                isValid=false;
//                getLoginView().onTitleInvalid(context.getString(R.string.empty));
//            }


            if(isValid){
                getLoginView().showProgress();
                module.onStartAddUpdateCall(titles,description, CommonMethod.getDDMMYYYYfromDate(Calendar.getInstance()), filePath,id,this);
            }

        }


    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onSuccess(String message) {
        if(hasView()){
            getLoginView().hideProgress();
            getLoginView().onSuccess(message);
        }
    }

    @Override
    public void onFail(String message) {
        if(hasView()) {
            getLoginView().hideProgress();
            getLoginView().hideFabProgress();
            getLoginView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getLoginView().hideProgress();
            getLoginView().hideFabProgress();

            getLoginView().onError(t);
        }
    }

    @Override
    public void onFileSuccess(String message) {
        if(hasView()){
            getLoginView().hideFabProgress();
            getLoginView().onSuccessFile(message);
        }

    }

    @Override
    public void onProgressUpdate(int prrogress) {
        if(hasView()){
            getLoginView().showFabProgress();
            getLoginView().onProgressUpdate(prrogress);
        }
    }

    @Override
    public void onFailedProgress() {
        if(hasView()){
            getLoginView().hideFabProgress();
            getLoginView().hideFabProgress();

            getLoginView().failedFileUpload();
        }
    }

    @Override
    public void onFinished() {
        if(hasView()){
            getLoginView().showFabProgress();
            getLoginView().onFinishedFileUpload();
        }

    }

    @Override
    public void onSuccessData(Datum message) {
        FirebaseMessageController controller=new FirebaseMessageController();
        controller.sendNotification(createNotificationData(message));
    }

    private Message createNotificationData(Datum message) {
        Data data=new Data();
        data.setClasstype(CommonMethod.UPDATE_ITEM);
        data.setData(new Gson().toJson(message));
        data.setMessage(message.getTitle());
        data.setTitle("New Update posted on Calde Connect");
        Message msg=new Message();
        msg.setData(data);
        msg.setTo("/topics/"+AppType.getAppType());
        return msg;
    }

    @Override
    public void onFileUpload(String absoluteFile, View view) {

        if(hasView()) {

            boolean isValid = true;
            String titles =getLoginView() .getTitles();
            String description =getLoginView().getDescription();
            String filePath = getLoginView().getFilePath();
            if (TextUtils.isEmpty(description)) {
                isValid = false;
                getLoginView().onDescriptionInvalid(view.getContext().getString(R.string.empty));
            }

            if (TextUtils.isEmpty(titles)) {
                isValid = false;
                getLoginView().onTitleInvalid(view.getContext().getString(R.string.empty));
            }
//            if (absoluteFile == null && TextUtils.isEmpty(absoluteFile) || TextUtils.isEmpty(filePath)) {
//
//                isValid = false;
//                getLoginView().onFileInvalid(view.getContext().getString(R.string.empty));
//            }


            if (isValid) {
                getLoginView().showProgress();
                getLoginView().showFabProgress();
                module.onUploadFileToServer(new File(absoluteFile).getAbsoluteFile(), this);

            }

        }}





    private UpdateMVP.AddUpdateView getLoginView(){
        return  getView();
    }
}
