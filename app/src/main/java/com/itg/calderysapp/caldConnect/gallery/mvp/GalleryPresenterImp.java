package com.itg.calderysapp.caldConnect.gallery.mvp;

import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.home.model.GalleryData;

import java.util.List;

public class GalleryPresenterImp  extends BaseWeakPresenter<GalleryMVP.GalleryView> implements GalleryMVP.GalleryListener,GalleryMVP.GalleryPresenter {
    private GalleryMVP.GalleryModule module;


    @Override
    public void setAllViewAvailable(GalleryMVP.GalleryView view) {
        weakViewCreated(view);

    }

    public GalleryPresenterImp(GalleryMVP.GalleryView updateView) {
        super(updateView);
        module = new GalleryModuleImp();
    }

    @Override
    public void onDownloadImages(String tbleName) {
        if(hasView()){
            getView().showProgress();
            module.onGetGalleryModels(tbleName,this);
        }
    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }




    private GalleryMVP.GalleryView getUpdateView() {
        return getView();
    }

    @Override
    public void onFail(String message) {
        if(hasView()) {
            getUpdateView().hideProgress();
            getUpdateView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getUpdateView().hideProgress();
            getUpdateView().onError(t);
        }
    }


    @Override
    public void deleteGallery(String tblUpdate, String id) {
        if(hasView()){
            getUpdateView().hideLlBottom();
            getUpdateView().showProgress();
            module.onDeletePDSFromServer(tblUpdate, id, this);
        }
    }

    @Override
    public void onSucessDelete(String message) {
        if(hasView()){
            getUpdateView().hideProgress();
            getUpdateView().showLlBottom();

            getUpdateView().onDeleteSucess(message);
        }
    }

    @Override
    public void onGetImagesGallery(List<GalleryData> models) {
        if(hasView()){
            getView().hideProgress();
            getView().onSuccessImages(models);
        }

    }
}
