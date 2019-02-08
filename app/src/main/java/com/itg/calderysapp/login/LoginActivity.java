package com.itg.calderysapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.UserType;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;
import com.itg.calderysapp.R;
import com.itg.calderysapp.login.mvp.LoginMVP;
import com.itg.calderysapp.login.mvp.LoginPresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener ,LoginMVP.LoginView {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rd_calderys_connect)
    RadioButton mRdCalderysConnect;
    @BindView(R.id.rd_calderys_net)
    RadioButton mRdCalderysNet;
    @BindView(R.id.rdCalderysGroup)
    RadioGroup mRdCalderysGroup;
    @BindView(R.id.txtLogin)
    TextView mTxtLogin;
    @BindView(R.id.edt_email)
    EditText mEdtEmail;
    @BindView(R.id.edt_password)
    EditText mEdtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.coordinator)
    CoordinatorLayout mCoordinator;
    private boolean AppTheme=true;
    private LoginMVP.LoginPresenter presenter;
    UserType type;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDrawableLeftRight();
        MyApplication.getInstance().setURLMain(CommonMethod.CALDECONNECT);
        init();

        MyApplication.getInstance().unsubscribeFromAllTopics();


    }

    private void setDrawableLeftRight() {
        CommonMethod.setLeftRightDrawable(mEdtEmail,R.drawable.ic_mail_outline_black_24dp,0 );
        CommonMethod.setLeftRightDrawable(mEdtPassword,R.drawable.ic_lock_outline_black_24dp, 0);

    }

    private void init() {
        presenter = new LoginPresenterImp(this);
        mBtnLogin.setOnClickListener(this);
        mRdCalderysGroup.setOnCheckedChangeListener(this);
        type = UserType.CalderysConnect;
        setCaldConnect();
    }

    private void setCaldConnect() {
       setApplicationUrl(CommonMethod.CALDECONNECT);
    }

    private void setCaldNet(){
        setApplicationUrl(CommonMethod.CALDNET);
    }

    private void setApplicationUrl(int type) {
        MyApplication.getInstance().setURLMain(type);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rd_calderys_connect:
                type= UserType.CalderysConnect;
                setCaldConnect();
                break;
            case R.id.rd_calderys_net:
                type= UserType.CalderysNet;
                setCaldNet();
                break;
        }

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                this.view = v;
                presenter.onLoginClicked(v, type);
                break;
        }

    }

    @Override
    public String getEmailId() {
        return mEdtEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdtPassword.getText().toString();
    }

    @Override
    public void onSuccess(String message) {
        this.finish();
        startActivity(new Intent(this, HomeActivity.class));

    }



    @Override
    public void onEmailIdInvalid(String err) {
        mEdtEmail.setError(err);

    }

    @Override
    public void onPasswordInvalid(String err) {
        mEdtPassword.setError(err);


    }
    @Override
    public void onFail(String message) {
        UtilSnackbar.showSnakbarTypeFail(mBtnLogin, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.onLoginClicked(view, type);


            }
        });

    }

    @Override
    public void onError(Object t) {
        UtilSnackbar.showSnakbarTypeFail(mBtnLogin, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.onLoginClicked(view, type);

            }
        });
    }

    @Override
    public void onNoInternet() {
        UtilSnackbar.showSnakbarTypeFail(mBtnLogin, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {

                presenter.onLoginClicked(view, type);

            }
        });

    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
        mBtnLogin.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
        mBtnLogin.setVisibility(View.VISIBLE);


    }
}
