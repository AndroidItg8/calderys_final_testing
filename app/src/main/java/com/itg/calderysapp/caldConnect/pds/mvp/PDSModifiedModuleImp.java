package com.itg.calderysapp.caldConnect.pds.mvp;

import com.itg.calderysapp.common.NetworkUtility;

import java.io.File;

public class PDSModifiedModuleImp implements PDSMVP.PDSDeleteModule {
    @Override
    public void onDeletePDSFromServer(String tblUpdate, String id, PDSMVP.PDSDeleteListener listener) {
        new NetworkUtility.NetworkBuilder().build().DeleteData(tblUpdate, id, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSucessDelete(message.toString());
            }

            @Override
            public void onFailure(Object err) {
                listener.onError(err);


            }

            @Override
            public void onSomethingWrong(Object e) {


            }
        });

    }

    @Override
    public void onUploadSuccessPDSFromServer(String tableName, File file, PDSMVP.PDSDeleteListener listener) {

    }

    @Override
    public void onDestroyed() {

    }
}
