package com.itg.calderysapp.caldConnect.pds.mvp;

import com.itg.calderysapp.caldConnect.update.UpdateDetailFragment;
import com.itg.calderysapp.common.BaseWeakPresenter;

import java.io.File;

public class PDSModifiedPresenterImp extends BaseWeakPresenter<PDSMVP.PDSDeleteViw> implements PDSMVP.PDSDeleteListener,PDSMVP.PDSDeletePresenter {

    private final PDSMVP.PDSDeleteModule module;

    public PDSModifiedPresenterImp(PDSMVP.PDSDeleteViw pdsDeleteViw) {
        super(pdsDeleteViw);
        module= new PDSModifiedModuleImp();
    }


    @Override
    public void deletePDS(String tblUpdate, String id) {
        if(hasView()){
            getPDSView().showProgress();
            module.onDeletePDSFromServer(tblUpdate,id, this);
        }

    }

    @Override
    public void downloadPdsFile(String tableName, File file) {

    }

    @Override
    public void setViewAllAvailable(PDSMVP.PDSDeleteViw viewAllAvailable) {
        weakViewCreated(viewAllAvailable);
    }




    @Override
    public void onSucessDelete(String message) {
        if(hasView()){
            getPDSView().hideProgress();
            getPDSView().onDeleteSucess(message);
        }
    }

    @Override
    public void onSucessDownload(String fileName) {
        if(hasView()){
            getPDSView().hideProgress();
            getPDSView().onDownloadFileSucess(fileName);
        }
    }


    @Override
    public void onDestroy() {
        detactView();
        module.onDestroyed();
    }



    private PDSMVP.PDSDeleteViw getPDSView() {
        return getView();
    }


    @Override
    public void onFail(String message) {
        if(hasView()) {
            getPDSView().hideProgress();
            getPDSView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getPDSView().hideProgress();
            getPDSView().onError(t);
        }
    }

}
