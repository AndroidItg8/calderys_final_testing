package com.itg.calderysapp.caldConnect.update.mvp;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;

import java.io.File;

class UpdateModuleImp implements UpdateMVP.AddUpdateModule {
    @Override
    public void onStartAddUpdateCall(String tile, String description, String date, String filePath, String id, final UpdateMVP.AddUpdateListener listener) {
        new NetworkUtility.NetworkBuilder().build().addUpdateData(tile, description, date, filePath, id, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                if (listener != null) {
                    listener.onSuccess(id != null ? "Data Updated Successfully" : "Data Added Successfully");
                    if (!(message instanceof String))
                        listener.onSuccessData((Datum) message);
                }
            }


            @Override
            public void onFailure(Object err) {
                if (listener != null)

                    listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                if (listener != null)

                    listener.onError(e.toString());


            }


        });

    }

    @Override
    public void onDestroy() {
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();
    }

    @Override
    public void onUploadFileToServer(File absoluteFile, final UpdateMVP.AddUpdateListener listener) {
        new NetworkUtility.NetworkBuilder().build().uploadFileProgress(absoluteFile, CommonMethod.UPDATE, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                if (listener != null)
                    listener.onFileSuccess(message.toString());

            }

            @Override
            public void onFailure(Object err) {
                if (listener != null)

                    listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                if (listener != null)
                    listener.onError(e.toString());


            }


        }, new NetworkUtility.ProgressListner() {
            @Override
            public void onProgressUpdate(int percentage) {
                if (listener != null)
                    listener.onProgressUpdate(percentage);

            }

            @Override
            public void onFinished() {
                if (listener != null)

                    listener.onFinished();

            }

            @Override
            public void onFailded() {
                if (listener != null)

                    listener.onFailedProgress();
            }
        });
    }


}
