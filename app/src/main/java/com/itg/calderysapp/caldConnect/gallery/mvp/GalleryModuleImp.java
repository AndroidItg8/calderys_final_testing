package com.itg.calderysapp.caldConnect.gallery.mvp;

import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.home.model.GalleryData;

import java.util.List;

public class GalleryModuleImp implements GalleryMVP.GalleryModule {


    @Override
    public void onGetGalleryModels(String tbleName, GalleryMVP.GalleryListener listener) {
        new NetworkUtility.NetworkBuilder().build().DownloadGallery(tbleName, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetImagesGallery((List<GalleryData>) message);

            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                listener.onError(e.toString());

            }
        });
    }

    @Override
    public void onDeletePDSFromServer(String tblUpdate, String id, GalleryMVP.GalleryListener listener) {
        new NetworkUtility.NetworkBuilder().build().DeleteData(tblUpdate, id,new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSucessDelete(String.valueOf(message));

            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                listener.onError(e.toString());

            }
        });
    }

    @Override
    public void onDestroy() {
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();
    }
}
