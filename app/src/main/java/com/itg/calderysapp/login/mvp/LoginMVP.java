package com.itg.calderysapp.login.mvp;

import android.view.View;

import com.itg.calderysapp.common.BaseView;
import com.itg.calderysapp.common.UserType;

public interface LoginMVP {
    public interface LoginView extends BaseView {
        String getEmailId();
        String getPassword();
        void onSuccess(String message);
        void onFail(String message);
        void onError(Object t);

        void onEmailIdInvalid(String err);

        void onPasswordInvalid(String err);


    }

    public interface LoginPresenter{
        void onDestroy();
        void onLoginClicked(View view, UserType type);

    }

    public interface LoginListener{
        void onSuccess(String message);
        void onFail(String message);
        void onError(Object t);

    }

    public interface LoginModule{
        void onStartLoginCall(String email, String password, LoginListener listener);
        void onDestroy();

        void onStartLoginCallCaldNet(String emailId, String password, LoginListener listener);
    }
}
