package com.itg.calderysapp.notification;


import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;




/**
 * Created by itg_Android on 12/3/2016.
 */

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    public static final String REGISTRATION_SUCCESS = "RegistrationSuccess";
    private static final String TAG = "MyFirebaseIIDService";

//    @Override
//    public void onTokenRefresh() {
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        Log.d(TAG, "Refreshed :" + refreshedToken);
//        sendRegistrationToServer(refreshedToken);
//    }


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d(TAG, "onNewToken: s"+s);

    }

//    private void sendRegistrationToServer(String refreshedToken) {
//        if(!TextUtils.isEmpty(Prefs.getString(CommonMethod.HEADER))) {
//         //   MyApplication.getInstance().getRetroController().sendFirebaseTokenToServer(getString(R.string.url_firebase_token), refreshedToken);
//
//        }
//    }
}
