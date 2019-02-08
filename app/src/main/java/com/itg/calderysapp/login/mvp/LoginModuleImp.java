package com.itg.calderysapp.login.mvp;

import com.itg.calderysapp.common.NetworkUtility;

public class LoginModuleImp implements LoginMVP.LoginModule {

//    {"msg":"Your successfully logged in","status":"1","inserid":1819,"user":"admin","accesses_level":"Super Admin"}
//[{"User_ID":"1000000007","Password":"123","UserType":"D","MSG":"Save Successfully","statuscode":200}]
    @Override
    public void onStartLoginCall( String email, String password, final LoginMVP.LoginListener listener) {


   new NetworkUtility.NetworkBuilder().build().login(email, password, new NetworkUtility.ResponseListener() {

       @Override
       public void onSuccess(Object message) {
           listener.onSuccess(message.toString());

       }

       @Override
       public void onFailure(Object err) {
           listener.onFail(err.toString());

       }

       @Override
       public void onSomethingWrong(Object e) {



       }


   });

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStartLoginCallCaldNet(String emailId, String password, LoginMVP.LoginListener listener) {
        new NetworkUtility.NetworkBuilder().build().loginCaldNet(emailId, password, new NetworkUtility.ResponseListener() {

            @Override
            public void onSuccess(Object message) {
                listener.onSuccess(message.toString());

            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                listener.onFail(e.toString());



            }


        });

    }
}
