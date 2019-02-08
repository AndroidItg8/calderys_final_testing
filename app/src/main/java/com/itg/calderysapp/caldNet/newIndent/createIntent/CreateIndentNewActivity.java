package com.itg.calderysapp.caldNet.newIndent.createIntent;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.databinding.ActivityCreateIntentBinding;

import static com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel.RC_PRODUCT;

public class CreateIndentNewActivity extends AppCompatActivity {

    public static final int RC_CONSIGNEE = 100;
    ActivityCreateIntentBinding binding;
    CreateIndentViewModel model=null;
    SpinnerViewModel spinnerModel;
    private static final String TAG = "CreateIndentNewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_intent);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setDrawableBackground();

        setModels();

    }

    private void setDrawableBackground() {
        CommonMethod.setBackgroundDrawable(binding.content.edtIgst, R.drawable.bg_cus_spinner, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setBackgroundDrawable(binding.content.edtSgstCgst, R.drawable.bg_cus_spinner, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setBackgroundDrawable(binding.content.edtIntentTypeSpinner, R.drawable.bg_cus_spinner, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setBackgroundDrawable(binding.content.edtPlantCodeSpinner, R.drawable.bg_cus_spinner, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setBackgroundDrawable(binding.content.edtDivision, R.drawable.bg_cus_spinner, R.drawable.ic_arrow_drop_down_black_24dp);

    }

    private void setModels() {

        model = new CreateIndentViewModel(this);
        if (getIntent().hasExtra(CommonMethod.INDENT)) {
            IndentsModel modelIndent = getIntent().getParcelableExtra(CommonMethod.INDENT);
            model.setModel(modelIndent);
        } else if (getIntent().hasExtra(CommonMethod.FROM_VIEW_INTENTS)) {
            IndentsModel modelIndent = getIntent().getParcelableExtra(CommonMethod.FROM_VIEW_INTENTS);
            model.setModel(modelIndent);

        } else if (getIntent().hasExtra(CommonMethod.FROM_VIEW_PLANT_INTENTS)) {
            IndentsModel modelIndent = getIntent().getParcelableExtra(CommonMethod.FROM_VIEW_PLANT_INTENTS);
            model.setModel(modelIndent);
        } else if (getIntent().hasExtra(CommonMethod.FROM_NOTIFICATION_CREATE)) {
            IndentsModel modelIndent = getIntent().getParcelableExtra(CommonMethod.FROM_NOTIFICATION_CREATE);
            model.setModel(modelIndent);
        } else if (getIntent().hasExtra(CommonMethod.FROM_VIEWDRAFT)) {
            ViewDraftModel modelIndent = getIntent().getParcelableExtra(CommonMethod.FROM_VIEWDRAFT);
            IndentsModel modelt = new Gson().fromJson(new Gson().toJson(modelIndent), IndentsModel.class);
            model.setModel(modelt);


        }
        spinnerModel = new SpinnerViewModel(this, CreateIndentViewModel.getModel());
        setSpinnerModels(CreateIndentViewModel.getModel());
        spinnerModel.setRootView(binding.getRoot());
        binding.setCreateIndentModel(model);
        binding.setSpinnerModel(spinnerModel);
    }

    public void setSpinnerModels(IndentsModel model) {
        if (spinnerModel != null)
            spinnerModel.setModel(model);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)
            return;
        if (requestCode == RC_CONSIGNEE) {
//            if(resultCode==RESULT_OK){
            if (data.hasExtra(CommonMethod.CONSIGNEE)) {
                ConsigneeListModel model = data.getParcelableExtra(CommonMethod.CONSIGNEE);
                this.model.setConsignee(model);
            }
//            }
        } else if (requestCode == RC_PRODUCT) {
            SaveMaterialModel model = data.getParcelableExtra(CommonMethod.FULL_MATERIAL);
            Log.d(TAG, "onActivityResult: "+new Gson().toJson(model));
            if (model != null) {
                this.model.addProduct(model);
            }


        }
    }

    public void showSnackBar(String s) {
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(binding.content.btnApprove, s, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {

//                    presenter.saveApprove(model);
            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
