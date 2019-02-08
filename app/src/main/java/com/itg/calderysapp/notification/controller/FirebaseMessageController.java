package com.itg.calderysapp.notification.controller;

import android.util.Log;

import com.google.gson.Gson;

import com.itg.calderysapp.notification.NotificationModel.Message;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirebaseMessageController {
    private static final String TAG = "FirebaseMessageControll";
    private final RetroController controller;
    CompositeDisposable compositeDisposable=new CompositeDisposable();

    public FirebaseMessageController() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(5, TimeUnit.MINUTES);
//        if (MyApplication.getInstance().isLoggingNeeded)
//            builder.addInterceptor(interceptor);
//        builder.readTimeout(5, TimeUnit.MINUTES);

//            builder.addInterceptor("Hearders",Prefs.getString(CommonMethod.TOKEN));

//        OkHttpClient client = builder.build();
//        Gson gson = new GsonBuilder().setLenient().create();
//                        .addConverterFactory(GsonConverterFactory.create(gson))


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fcm.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        controller=retrofit.create(RetroController.class);
    }

    public void sendNotification(Message model){
//        JsonObject jsonObject = new JsonObject();
//        JsonObject jsonObjectMessage = new JsonObject();
//        JsonObject datajsonObject = new JsonObject();

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), model.toString());

//
//        jsonObjectMessage.addProperty("Message",);
        Log.d(TAG, "sendNotification: model"+new Gson().toJson(model));

        Disposable disposable=controller.sendNotification("key=AAAAg8McGOQ:APA91bEn1Qhg--Qs3nDuce76GLNYaLkpfHAvu4RCeysejqtGgf98W-xMWZDKmTSpominJ9rwQPdJV3AbQuAP8Kkhzx3x0M_A7eFo8SfR04gHPcepw75ZZ1QgiZPmvgdU6LM9lsaviqJF","application/json",model)
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String data=responseBody.string();
                        Log.d(TAG, "accept:data "+new Gson().toJson(data));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

        compositeDisposable.add(disposable);
    }

    public void distroyAll(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}
