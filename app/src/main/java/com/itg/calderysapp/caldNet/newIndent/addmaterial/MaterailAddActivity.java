package com.itg.calderysapp.caldNet.newIndent.addmaterial;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.databinding.ActivityMaterailAddBinding;

import static com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.RC_TRANSPORT;
import static com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel.RC_MATERIAL;
import static com.itg.calderysapp.common.CommonMethod.FROM_MATERIAL;
import static com.itg.calderysapp.common.CommonMethod.TRANSPORT;


public class MaterailAddActivity extends AppCompatActivity {

    private boolean isViewEnable = false;

    private static final String TAG = "MaterailAddActivity";
    PaginationModel model;

    ActivityMaterailAddBinding binding;
    MaterialAddViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_materail_add);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViewModel();
        model=new PaginationModel();
        initView();
        setDrawable();



    }

    private void setDrawable() {
        CommonMethod.setLeftRightDrawable(binding.content.edtTotalDiscount, 0, R.drawable.ic_percent);
        CommonMethod.setLeftRightDrawable(binding.content.edtOpenDiscount,  0,R.drawable.ic_percent);
        CommonMethod.setLeftRightDrawable(binding.content.edtHiddenDiscount,  0,R.drawable.ic_percent);


        CommonMethod.setLeftRightDrawable(binding.content.lblMaterialCode, 0, R.drawable.ic_arrow_create_next);
        CommonMethod.setLeftRightDrawable(binding.content.lblMaterialName, 0, R.drawable.ic_arrow_create_next);
        CommonMethod.setLeftRightDrawable(binding.content.lblTransportCode, 0, R.drawable.ic_arrow_create_next);
        CommonMethod.setLeftRightDrawable(binding.content.lblTransportName, 0, R.drawable.ic_arrow_create_next);
        CommonMethod.setLeftRightDrawable(binding.content.lblInspections, 0, R.drawable.ic_arrow_create_next);

        CommonMethod.setBackgroundDrawable(binding.content.editMaterialNameSpinner,  R.drawable.bg_cus_spinner,0);
        CommonMethod.setBackgroundDrawable(binding.content.edtTcRequiredSpinner,  R.drawable.bg_cus_spinner,0);
        CommonMethod.setBackgroundDrawable(binding.content.edtRlRequiredSpinner,  R.drawable.bg_cus_spinner,0);
        CommonMethod.setBackgroundDrawable(binding.content.edtUnitSpinner,  R.drawable.bg_cus_spinner,0);
    }

    private void initViewModel() {
        viewModel=new MaterialAddViewModel(this);
        if(getIntent().hasExtra(CommonMethod.FROM_PRODUCT)){
            Log.d(TAG, "initViewModel: "+getIntent().getParcelableExtra(CommonMethod.FROM_PRODUCT));
            SaveMaterialModel materialModel =getIntent().getParcelableExtra(CommonMethod.FROM_PRODUCT);
            viewModel.setModel(materialModel);
        }
        binding.setMaterialAddViewModel(viewModel);
//        binding
    }

    private void initView() {
        checkIntent();

    }


    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.INDENT)) {
            IndentsModel model = getIntent().getParcelableExtra(CommonMethod.INDENT);
        }
//        intent.putExtra(CommonMethod.INDENT_TYPE,model.getIndentType());
//        intent.putExtra(CommonMethod.PLANT_CODE,model.getPlantCode());
//        intent.putExtra(CommonMethod.DIVISION,model.getDivision());
        if(getIntent().hasExtra(CommonMethod.INDENT_TYPE)){
            model.setPageNo(1);
            model.setLimit(10);
            model.setParameter(String.valueOf(13));
            model.setParameter2(getIntent().getStringExtra(CommonMethod.INDENT_TYPE));
            model.setParameter3(getIntent().getStringExtra(CommonMethod.PLANT_CODE));
            model.setParameter4(getIntent().getStringExtra(CommonMethod.DIVISION));
            viewModel.setMaterialPagination(model);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data!=null) {
            if (requestCode == RC_MATERIAL) {
                MaterialModel model = data.getParcelableExtra(FROM_MATERIAL);
                if (model != null) {
                    viewModel.setSelectedMaterial(model);
                }
            } else if (requestCode == RC_TRANSPORT) {
                TransportModel model = data.getParcelableExtra(TRANSPORT);
                if (model != null) {
                    viewModel.setSelectedTransport(model);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


}
