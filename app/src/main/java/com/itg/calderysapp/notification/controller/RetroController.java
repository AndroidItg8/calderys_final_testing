package com.itg.calderysapp.notification.controller;

import com.itg.calderysapp.notification.NotificationModel.Message;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetroController {
//
//    @Headers({"Authorization: key=AAAAg8McGOQ:APA91bEn1Qhg--Qs3nDuce76GLNYaLkpfHAvu4RCeysejqtGgf98W-xMWZDKmTSpominJ9rwQPdJV3AbQuAP8Kkhzx3x0M_A7eFo8SfR04gHPcepw75ZZ1QgiZPmvgdU6LM9lsaviqJF","content-type: applicatiion/json"})
    @POST("fcm/send")
    Observable<ResponseBody> sendNotification(@Header("Authorization") String key,@Header("Content-Type")String content,@Body Message model);
}
