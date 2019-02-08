package com.itg.calderysapp.caldConnect.pds.mvp;

import android.content.Context;

import com.itg.calderysapp.caldConnect.pds.model.CompleteResultModel;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.db.AppDatabase;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.io.File;
import java.util.List;

public class PDSAddModuleImp implements PDSMVP.PDSAddModule {

    @Override
    public void onDestroyed() {

    }

    @Override
    public void onDownloadProductType(PDSMVP.PDSAddListener listenr, Context context) {
        new NetworkUtility.NetworkBuilder().build().getProductType(new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listenr.onSuccess((List<TblProductType>) message);

            }

            @Override
            public void onFailure(Object err) {
                listenr.onFail(err.toString());


            }

            @Override
            public void onSomethingWrong(Object e) {
                AppDatabase.destroyInstance();

                listenr.onFail(e
                        .toString());

            }


        });
    }


    @Override
    public void onGetPDSListFromServer(String tableName, int perPage, int PageNumber, PDSMVP.PDSAddListener listener) {
        new NetworkUtility.NetworkBuilder().build().getPDSList(tableName, perPage, PageNumber, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {

                listener.onGetItemFirstPDS((List<Data>) message);
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
    public void onDownloadFamilyGroupe(PDSMVP.PDSAddListener listener, Context context) {


        new NetworkUtility.NetworkBuilder().build().getFamilyGroup(new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {

                listener.onSuccessFamilyGroupe((List<TblFamilyGroup>) message);

            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());


            }

            @Override
            public void onSomethingWrong(Object e) {

                listener.onFail(e.toString());
                AppDatabase.destroyInstance();

            }


        });
    }

    @Override
    public void onSubmitPDS(String productName, String productType, String FamilyGroup, String FileName, String date, String share, String id, PDSMVP.PDSAddListener listener) {
        new NetworkUtility.NetworkBuilder().build().addPDS(productName, productType,FamilyGroup,  date,FileName, share, id, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                if(listener!=null)

                        listener.onSuccessSave(id != null ? "Data Updated Successfully" : "Data Added Successfully");



            }

            @Override
            public void onFailure(Object err) {
                if(listener!=null)
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                if(listener!=null)
                listener.onError(e.toString());


            }


        });
    }

    @Override
    public void onUploadFileToServer(File absoluteFile, PDSMVP.PDSAddListener listener) {
        new NetworkUtility.NetworkBuilder().build().uploadFileProgress(absoluteFile, CommonMethod.PDS,new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                if(listener!=null)
                listener.onFileSuccess(message.toString());

            }

            @Override
            public void onFailure(Object err) {
                if(listener!=null)
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                if(listener!=null)
                listener.onError(e.toString());


            }


        }, new NetworkUtility.ProgressListner() {
            @Override
            public void onProgressUpdate(int percentage) {
                if(listener!=null)
                listener.onProgressUpdate(percentage);

            }

            @Override
            public void onFinished() {
                if(listener!=null)
                listener.onFinished();

            }

            @Override
            public void onFailded() {
                if(listener!=null)
                listener.onFailedProgress();
            }
        });
    }





}
