package com.itg.calderysapp.common;

import android.app.Application;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.login.model.LoginCaldNetModel;
import com.squareup.picasso.Picasso;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import java.io.IOException;


/**
 * Created by swapnilmeshram on 15/03/18.
 */

//@ReportsCrashes(formUri = "", mailTo = "app.itechgalaxy@gmail.com", mode = ReportingInteractionMode.SILENT)
public class MyApplication extends Application {
    private static final String PREF_NAME="Calderys_APP";
    private static MyApplication mInstance;
    public boolean isLoggingNeeded;

    private static final String TAG = "MyApplication";

    LoginCaldNetModel loginModel;


    public static MyApplication getInstance() {
        return mInstance;
    }




    @Override
    public void onCreate() {
        super.onCreate();
        isLoggingNeeded=true;
//          ACRA.init(this);

          test();

        mInstance=this;
        mInstance.initPref();
        if(Prefs.contains(AppType.USER_TYPE)){
            setURLMain();
        }

        setLoginClass();

//        if(getApplicationContext()!=null)
//            Picasso.get().setLoggingEnabled(true);

    }

    private void test() {
        float  g= 989.77f;
//        ((""+a).substring(0, n));
//        int value = g.indexOf(g,1);


        Log.d(TAG, "test: "+Integer.parseInt((""+g).substring(0, 2)));
    }


    private void initPref() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(PREF_NAME)
                .setUseDefaultSharedPreference(false)
                .build();
    }

    public void setLoginClass(){
        String loginString=Prefs.getString(CommonMethod.USER_DETAIL);
        if(loginString!=null){
            loginModel=new Gson().fromJson(loginString,LoginCaldNetModel.class);
        }
    }

    public LoginCaldNetModel getLoginModel() {
        setLoginClass();
        return loginModel;
    }

    public void setURLMain(int type){
        Prefs.putInt(AppType.USER_TYPE,type);
        setURLMain();
    }

    public void setURLMain(){

        new AppType.Builder().setUserType().build();
    }

    public boolean isCommercialUser(){
        String tag="MyApplication";
        if(Prefs.contains(CommonMethod.USER_TYPE)){
            Log.d(tag, "isCommercialUser: "+Prefs.getString(CommonMethod.USER_TYPE));
            return Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase("commercial");
        }
        return false;
    }
    public boolean isAdminUser(){
        if(Prefs.contains(CommonMethod.USER_TYPE)){
            return Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase("Super Admin");
        }
        return false;
    }

    public boolean isD(){
        if(Prefs.contains(CommonMethod.USER_TYPE)){
            return Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase("D");
        }
        return false;
    }

    public boolean isP(){
        if(Prefs.contains(CommonMethod.USER_TYPE)){
            return Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase("P");
        }
        return false;
    }

    public boolean isS(){
        if(Prefs.contains(CommonMethod.USER_TYPE)){
            return Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase("S");
        }
        return false;
    }

    public boolean isC(){
        if(Prefs.contains(CommonMethod.USER_TYPE)){
            return Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase("C");
        }
        return false;
    }



    public void unsubscribeFromAllTopics(){
        try {
            FirebaseInstanceId.getInstance().deleteInstanceId();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void supbscribeToTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic(AppType.getAppType())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
//                        String msg = getString(R.string.msg_subscribed);
//                        if (!task.isSuccessful()) {
//                            msg = getString(R.string.msg_subscribe_failed);
//                        }
//                        Log.d(TAG, msg);
                        Log.d(TAG, "onComplete: task"+task);

                    }
                });
    }


    public void saveUserDetails(final  String res) {
        Handler mainHandler = new Handler(getMainLooper());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                Prefs.putString(CommonMethod.USER_DETAIL, res);

            }
        };
        mainHandler.post(myRunnable);
    }
}
