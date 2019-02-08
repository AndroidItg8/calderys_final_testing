package com.itg.calderysapp.caldNet.newIndent.consignee;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.TextSetWatcher;
import com.itg.calderysapp.databinding.ActivityConsingeeAddBinding;

public class ConsingeeAddActivity extends AppCompatActivity {

    ActivityConsingeeAddBinding binding;
    ConsigneeViewModel model;
    ConsigneeModel modelConsignee=new ConsigneeModel();

    private static final String TAG = "ConsingeeAddActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();
        binding=DataBindingUtil.setContentView(this,R.layout.activity_consingee_add);
        createBindingModel();
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CommonMethod.setBackgroundDrawable(binding.content.edtCountry,R.drawable.bg_cus_spinner,0);
        CommonMethod.setBackgroundDrawable(binding.content.edtRegion,R.drawable.bg_cus_spinner,0);
//        binding.content.editDealerName.addTextChangedListener(new TextSetWatcher(modelConsignee,"ConsigneeName"));
//        binding.content.lblDealerName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: "+new Gson().toJson(modelConsignee));
//            }
//        });
    }


    private void createBindingModel() {
        model=new ConsigneeViewModel(this);
        binding.setConsigneeModel(model);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

}
