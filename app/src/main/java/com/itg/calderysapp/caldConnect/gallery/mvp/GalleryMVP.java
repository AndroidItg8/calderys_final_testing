package com.itg.calderysapp.caldConnect.gallery.mvp;

import android.view.View;

import com.google.gson.JsonObject;
import com.itg.calderysapp.caldConnect.gallery.GalleryFragment;
import com.itg.calderysapp.common.BaseView;
import com.itg.calderysapp.home.model.GalleryData;

import java.io.File;
import java.util.List;

public interface GalleryMVP {

    public interface GalleryView extends BaseView{
        void onSuccessImages(List<GalleryData> model);
        void onDeleteSucess(String message);


        void onFail(String message);

        void onError(Object t);


        void hideLlBottom();

        void showLlBottom();
    }
    public  interface GalleryPresenter {
        void onDownloadImages(String tbleName);
        void deleteGallery(String tblUpdate, String id);
        void onDestroy();


        void setAllViewAvailable(GalleryView view);
    }

    public interface GalleryListener {
        void onFail(String message);

        void onError(Object t);

        void onSucessDelete(String message);
        void onGetImagesGallery(List<GalleryData> models);
    }

    public interface GalleryModule {
        void onGetGalleryModels(String tbleName, GalleryListener listener);
        void onDeletePDSFromServer(String tblUpdate, String id, GalleryListener listener);

        void onDestroy();

    }

    public interface AddGalleryView extends BaseView {
        String getTitles();

        String getDescription();

        String getFilePath();
        String getEventDate();

        void onSuccess(String message);

        void onSuccessFile(String message);

        void onFail(String message);

        void onError(Object t);

        void showFabProgress();

        void hideFabProgress();

        void onTitleInvalid(String err);
        void onEventDateInvalid(String err);

        void onDescriptionInvalid(String err);

        void onFileInvalid(String err);

        void onProgressGallery(int prrogress);

        void failedFileUpload();

        void onFinishedFileUpload();

        void onShowHideView();

        String getID();
    }

    public interface AddGalleryPresenter {
        void onDestroy();

        void onAddGalleryClicked(AddGalleryView view, String file, boolean fromEdit);

        void onFileUpload(String absoluteFile, View v);
    }

    public interface AddGalleryListener {
        void onFileSuccess(String message);

        void onSuccess(String message);

        void onFail(String message);

        void onError(Object t);

        void onProgressGallery(int prrogress);
        void onFailedProgress();
        void onFinished();
    }

    public interface AddGalleryModule {
        void onStartAddGalleryCall(String tile, String description, String date, String eventDate, String filePath, String id, JsonObject data, AddGalleryListener listener);

        void onDestroy();

        void onUploadFileToServer(File absoluteFile, AddGalleryListener listener);
    }


}
