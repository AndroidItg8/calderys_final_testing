package com.itg.calderysapp.caldNet.newIndent.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetMVP;
import com.itg.calderysapp.caldNet.newIndent.setting.mvp.HomeCalderysNetSavePresenterImp;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddSetting extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, HomeCalderysNetMVP.HomeCalderysNetSaveView {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.lbl_heading)
    TextView mLblHeading;
    @BindView(R.id.edt_desciption)
    EditText mEdtDesciption;
    @BindView(R.id.lbl_radio)
    TextView mLblRadio;
    @BindView(R.id.rd_active)
    RadioButton mRdActive;
    @BindView(R.id.rd_deactive)
    RadioButton mRdDeactive;
    @BindView(R.id.rgActive)
    RadioGroup mRgActive;
    @BindView(R.id.btnSubmit)
    Button mBtnSubmit;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    private AdapterStringModel model;
    private boolean type = true;
    private HomeCalderysNetMVP.HomeCalderysNetSavePresenter presener;
    private int from = -1;
    private boolean isViewEnable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_setting);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        isViewEnable = true;
        presener = new HomeCalderysNetSavePresenterImp(this);


        intView();


    }

    private void intView() {
        setOnClickedListner();
        if (getIntent().hasExtra((CommonMethod.FROM_SETTING))) {
            model = getIntent().getParcelableExtra(CommonMethod.FROM_SETTING);
            setData();



        }
         if (getIntent().hasExtra(CommonMethod.FROM)) {
            from = getIntent().getIntExtra(CommonMethod.FROM, -1);
            if(from == 1){
                mLblHeading.setText("Upload Important Message");
               setTitle("Add Important Message");

            }

            else{
                setTitle("Add Success Stories");
                mLblHeading.setText("Upload Success Stories");


            }



        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    public void setTitle(String value) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(value);


    }

    private void setOnClickedListner() {
        mBtnSubmit.setOnClickListener(this);
        mRgActive.setOnCheckedChangeListener(this);
    }

    private void setData() {
        if (model != null) {
            if (model.getFrom().equalsIgnoreCase(CommonMethod.FROM_MESSAGE)) {
                mLblHeading.setText("Upload Important Message");
                setTitle("Add Important Message");
                from = 1;
            } else {
                mLblHeading.setText("Upload Success Stories");
                setTitle("Add Success Stories");
                from = 2;
            }
            mEdtDesciption.setText(model.getTitle());
            if (model.isActive())
                mRdActive.setChecked(true);
            else
                mRdDeactive.setChecked(true);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rd_active:
                type = true;
                break;
            case R.id.rd_deactive:
                type = false;
                break;
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSubmit:
                presener.onLoginClicked(v);

                break;
        }
    }

    @Override
    public String getDescption() {
        return mEdtDesciption.getText().toString();
    }

    @Override
    public boolean isActive() {
        return type;
    }


    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mBtnSubmit, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(CommonMethod.FROM_CHECK,"" );
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            });
        }

    }

    @Override
    public void onSuccess(Object object) {
        if (isViewEnable) {
             if(object instanceof  AdapterStringModel) {
                 AdapterStringModel mo = (AdapterStringModel) object;

                 UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mBtnSubmit, mo.getTitle(), new UtilSnackbar.OnSnackbarActionClickListener() {
                     @Override
                     public void onRetryClicked() {
                         Intent resultIntent = new Intent();
                         resultIntent.putExtra(CommonMethod.FROM_CHECK, mo);
                         setResult(RESULT_OK, resultIntent);
                         finish();

                         }
                 });
             }
            }


    }


    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mBtnSubmit, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            Intent resultIntent = new Intent();
                            resultIntent.putExtra(CommonMethod.FROM_CHECK,"" );
                            setResult(RESULT_OK, resultIntent);
                            finish();
                        }
            }
                    );
        }

    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mBtnSubmit, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                  setResult(RESULT_OK);
                  finish();

                }
            });
        }

    }


    @Override
    public void showProgress() {
        if (isViewEnable) {
            mProgress.setVisibility(View.VISIBLE);
            mBtnSubmit.setVisibility(View.GONE);
        }

    }

    @Override
    public void hideProgress() {
        if (isViewEnable) {
            mProgress.setVisibility(View.GONE);
            mBtnSubmit.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onDesciptionInvalid(String err) {
        mEdtDesciption.setError(err);

    }

    @Override
    public void onIsActiveInvalid(String err) {
        mLblRadio.setError(err);

    }

    @Override
    public int getFromWhere() {
        return from;
    }

    @Override
    public boolean isFromEdit() {
        return model != null;
    }

    @Override
    public String getId() {
        return model != null ? String.valueOf(model.getId()) : null;
    }


}
