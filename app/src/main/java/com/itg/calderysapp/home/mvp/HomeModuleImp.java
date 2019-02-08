package com.itg.calderysapp.home.mvp;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.home.model.GalleryData;

import java.util.List;

import io.reactivex.disposables.Disposable;

class HomeModuleImp implements HomeMVP.HomeModule {
    private Disposable disposable=null;

    @Override
    public void onGetUpdateListFromServer(String tableName, int perPage, int PageNumber, HomeMVP.HomeListener listener) {
       disposable= new NetworkUtility.NetworkBuilder().build().getUpdateList(tableName, perPage, PageNumber, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {

                listener.onGetList((List<Datum>) message);
            }

            @Override
            public void onFailure(Object err) {


                listener.onPaginationError();

            }

            @Override
            public void onSomethingWrong(Object e) {

            }


        });
    }

    @Override
    public void onGetGalleryModels(String tbleName, HomeMVP.HomeListener listener) {
         disposable =new NetworkUtility.NetworkBuilder().build().DownloadGallery(tbleName, new NetworkUtility.ResponseListener() {
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
    public void onDestroy() {
       new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();
    }
}
