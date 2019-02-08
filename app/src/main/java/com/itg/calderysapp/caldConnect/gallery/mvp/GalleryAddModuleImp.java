package com.itg.calderysapp.caldConnect.gallery.mvp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.notification.NotificationModel.Data;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.notification.NotificationModel.NotificationModel;
import com.itg.calderysapp.notification.controller.FirebaseMessageController;

import java.io.File;

public class GalleryAddModuleImp implements GalleryMVP.AddGalleryModule {
    @Override
    public void onStartAddGalleryCall(String tile, String description, String date, String eventDate, String filePath, String id, JsonObject data, GalleryMVP.AddGalleryListener listener) {
        new NetworkUtility.NetworkBuilder().build().addGalleryData(tile, description, date, eventDate,filePath,id, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSuccess(message.toString());
                sendNotificationAlso(data);
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

    private void sendNotificationAlso(JsonObject data) {
        FirebaseMessageController controller=new FirebaseMessageController();
        controller.sendNotification(createNotificationData(data));
    }

    private Message createNotificationData(JsonObject message) {
        Data data=new Data();
        data.setClasstype(CommonMethod.GALLERY_ITEM);
        data.setData(message.toString());
        data.setMessage(message.get("title").getAsString());
        data.setTitle("New Advertisement posted on Calde Connect");
        Message msg=new Message();
        msg.setData(data);
        msg.setTo("/topics/"+ AppType.getAppType());
        return msg;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onUploadFileToServer(File absoluteFile, GalleryMVP.AddGalleryListener listener) {
        new NetworkUtility.NetworkBuilder().build().uploadFileImageProgress(absoluteFile, CommonMethod.FILDER_IMAGES,new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onFileSuccess(message.toString());

            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                listener.onError(e.toString());


            }


        }, new NetworkUtility.ProgressListner() {
            @Override
            public void onProgressUpdate(int percentage) {
                listener.onProgressGallery(percentage);

            }

            @Override
            public void onFinished() {
                listener.onFinished();

            }

            @Override
            public void onFailded() {
                listener.onFailedProgress();
            }
        });
    }
    }

