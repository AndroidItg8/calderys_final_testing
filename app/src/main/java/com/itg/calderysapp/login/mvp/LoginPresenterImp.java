package com.itg.calderysapp.login.mvp;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.itg.calderysapp.R;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.UserType;


/**
 * Created by itg_Android on 9/6/2017.
 */

public class LoginPresenterImp extends BaseWeakPresenter<LoginMVP.LoginView> implements LoginMVP.LoginListener,LoginMVP.LoginPresenter {

    LoginMVP.LoginModule module;
    public LoginPresenterImp(LoginMVP.LoginView view) {
        super(view);
        module=new LoginModuleImp();
    }



    @Override
    public void onLoginClicked(View view, UserType type) {
        if(hasView()){

            boolean isValid=true;
            String password=getLoginView().getPassword();
            String emailId=getLoginView().getEmailId();
            if(TextUtils.isEmpty(password))
            {
                isValid=false;
                getLoginView().onPasswordInvalid(view.getContext().getString(R.string.empty));
            }else{
                isValid=true;
                getLoginView().onPasswordInvalid(null);
            }

//            if(type.toString().equalsIgnoreCase(UserType.CalderysConnect.name()) ){
//                if (password.length() < 6) {
//                    isValid = false;
//                    getLoginView().onPasswordInvalid(view.getContext().getString(R.string.invalid_pass));
//                }else{
//                    isValid=true;
//                    getLoginView().onPasswordInvalid(null);
//
//                }
//            }
            if(TextUtils.isEmpty(emailId))
            {
                isValid=false;
                getLoginView().onEmailIdInvalid(view.getContext().getString(R.string.empty));
            }else{
                isValid = true;
                getLoginView().onEmailIdInvalid(null);

            }

            if(type.toString().equalsIgnoreCase(UserType.CalderysConnect.name())) {
                if(TextUtils.isEmpty(password))
                {
                    isValid=false;
                    getLoginView().onPasswordInvalid(view.getContext().getString(R.string.empty));
                }else{
                    isValid=true;
                    getLoginView().onPasswordInvalid(null);
                }

                 if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
                    isValid = false;
                    getLoginView().onEmailIdInvalid(view.getContext().getString(R.string.invalid_email));
                }
                 else{
                     isValid = true;
                     getLoginView().onEmailIdInvalid(null);
                 }
            }

            if(isValid){
                getLoginView().showProgress();
                if(type.toString().equalsIgnoreCase(UserType.CalderysConnect.toString())) {

                    module.onStartLoginCall(emailId, password, this);
                }else
                    module.onStartLoginCallCaldNet(emailId, password, this);


           }


            }


    }
    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onSuccess(String message) {
        if(hasView()){
            getLoginView().hideProgress();
            getLoginView().onSuccess(message);
        }
    }

    @Override
    public void onFail(String message) {
        if(hasView()) {
            getLoginView().hideProgress();
            getLoginView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getLoginView().hideProgress();
            getLoginView().onError(t);
        }
    }



    private LoginMVP.LoginView getLoginView(){
        return (LoginMVP.LoginView) getView();
    }
}
