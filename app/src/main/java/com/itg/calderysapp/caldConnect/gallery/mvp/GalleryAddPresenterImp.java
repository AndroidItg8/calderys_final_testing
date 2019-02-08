package com.itg.calderysapp.caldConnect.gallery.mvp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.JsonObject;
import com.itg.calderysapp.R;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;

import java.io.File;
import java.util.Calendar;

public class GalleryAddPresenterImp extends BaseWeakPresenter<GalleryMVP.AddGalleryView> implements GalleryMVP.AddGalleryListener,GalleryMVP.AddGalleryPresenter  {
private final GalleryMVP.AddGalleryModule module;
        private final Context context;

        public GalleryAddPresenterImp(GalleryMVP.AddGalleryView addGalleryView, Context context) {
        super(addGalleryView);
        this.context = context;
        module=new GalleryAddModuleImp();
        }



    @Override
    public void onAddGalleryClicked(GalleryMVP.AddGalleryView view, String file, boolean fromEdit) {
        if(hasView()){

            boolean isValid=true;
            String titles=getGalleryView().getTitles();
            String date=getGalleryView().getEventDate();
            String description=getGalleryView().getDescription();
            String filePath=getGalleryView().getFilePath();
            String id=getGalleryView().getID();

            if(TextUtils.isEmpty(description))
            {
                isValid=false;
                getGalleryView().onDescriptionInvalid(context.getString(R.string.empty));
            } if( TextUtils.isEmpty(date) && TextUtils.isDigitsOnly(date) )
            {
                isValid=false;
                getGalleryView().onEventDateInvalid(context.getString(R.string.empty));
            }

            if(TextUtils.isEmpty(titles))
            {
                isValid=false;
                getGalleryView().onTitleInvalid(context.getString(R.string.empty));
            }
            if(TextUtils.isEmpty(filePath))
            {
                isValid=false;
                getGalleryView().onTitleInvalid(context.getString(R.string.empty));
            }


            if(isValid){
                getGalleryView().showProgress();
                JsonObject jsonObject=new JsonObject();
                jsonObject.addProperty("title",titles);
                jsonObject.addProperty("description",description);
                jsonObject.addProperty("date",CommonMethod.getDDMMYYYYfromDate(Calendar.getInstance()));
                jsonObject.addProperty("eventDate",date);
                jsonObject.addProperty("filePath",file);
                jsonObject.addProperty("id",id);
                module.onStartAddGalleryCall(
                        titles,
                        description,
                        CommonMethod.getDDMMYYYYfromDate(Calendar.getInstance()),
                        date,
                        file,
                        id,jsonObject,
                        this);
            }

        }
    }

    

    @Override
    public void onProgressGallery(int prrogress) {
        if(hasView()){
            getGalleryView().showFabProgress();
            getGalleryView().onProgressGallery(prrogress);
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
            getGalleryView().hideProgress();
            getGalleryView().onSuccess(message);


        }
    }

    private GalleryMVP.AddGalleryView getGalleryView() {
        return getView();
    }

    @Override
    public void onFail(String message) {
        if(hasView()) {
            getGalleryView().hideProgress();
            getGalleryView().hideFabProgress();
            getGalleryView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getGalleryView().hideProgress();
            getGalleryView().hideFabProgress();

            getGalleryView().onError(t);
        }
    }

    @Override
    public void onFileSuccess(String message) {
        if(hasView()){
            getGalleryView().hideFabProgress();
            getGalleryView().onSuccessFile(message);
        }

    }

  

    @Override
    public void onFailedProgress() {
        if(hasView()){
            getGalleryView().hideFabProgress();
            getGalleryView().hideFabProgress();

            getGalleryView().failedFileUpload();
        }
    }

    @Override
    public void onFinished() {
        if(hasView()){
            getGalleryView().showFabProgress();
            getGalleryView().onFinishedFileUpload();
        }

    }

    @Override
    public void onFileUpload(String absoluteFile, View view) {

        if(hasView()) {

            boolean isValid = true;
            String titles =getGalleryView() .getTitles();
            String date =getGalleryView() .getEventDate();
            String description =getGalleryView().getDescription();
            String filePath = getGalleryView().getFilePath();
            if (TextUtils.isEmpty(description)) {
                isValid = false;
                getGalleryView().onDescriptionInvalid(view.getContext().getString(R.string.empty));
            }

            if (TextUtils.isEmpty(titles)) {
                isValid = false;
                getGalleryView().onTitleInvalid(view.getContext().getString(R.string.empty));
            }else
                getGalleryView().onTitleInvalid(null);

            if (TextUtils.isEmpty(date)) {
                isValid = false;
                getGalleryView().onEventDateInvalid(view.getContext().getString(R.string.empty));
            }else
                getGalleryView().onEventDateInvalid(null);
            if (absoluteFile == null && TextUtils.isEmpty(absoluteFile) || filePath==null) {
                isValid = false;
                getGalleryView().onFileInvalid(view.getContext().getString(R.string.empty));
            }else
                getGalleryView().onFileInvalid(null);


            if (isValid) {
                getGalleryView().onShowHideView();
                getGalleryView().showProgress();
                getGalleryView().showFabProgress();
                module.onUploadFileToServer(new File(absoluteFile).getAbsoluteFile(), this);

            }

        }}


}
        
