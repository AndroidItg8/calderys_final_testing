package com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.MaterailAddActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.ProductListActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.TransportListActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.GenericSpinnerAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.DatePickerGeneric;
import com.itg.calderysapp.common.SpinnerItemSelect;
import com.itg.calderysapp.BR;

import java.util.Calendar;

import static com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel.RC_MATERIAL;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel.RC_PRODUCT;

public class MaterialAddViewModel extends BaseObservable {

    private static final String TAG = "MaterialAddViewModel";

    public static final int RC_TRANSPORT = 200;
    public static final int MATERIAL_LIST = 1;
    public static final int TRANSPORT_LIST = 2;
    private Context context;
    public SaveMaterialModel model;
    public ObservableArrayList<MaterialModel> materialModels=new ObservableArrayList<>();
    public ObservableArrayList<SpinnerGenericModel> yesNo=new ObservableArrayList<>();
    public ObservableInt unitPosition;


    public ObservableField<String> units=new ObservableField<>(SpinnerFileName.UNITS);


    private PaginationModel materialPagination;

    public MaterialAddViewModel(Context context) {
        this.context = context;
        model=new SaveMaterialModel();
        unitPosition=new ObservableInt(0);

        addYesNo();
    }

    private void addYesNo() {
        yesNo.addAll(CommonMethod.getYesNoModel());
    }

    public void downloadMaterialList(PaginationModel model){

    }

    public void onMaterialListShow(View view){
        Intent intent=new Intent(context,ProductListActivity.class);
        intent.putExtra(CommonMethod.INDENT_TYPE,materialPagination.getParameter2());
        intent.putExtra(CommonMethod.PLANT_CODE,materialPagination.getParameter3());
        intent.putExtra(CommonMethod.DIVISION,materialPagination.getParameter4());
        ((MaterailAddActivity)context).startActivityForResult(intent,RC_MATERIAL);
    }

    public void onTransportClick(View view){
        Intent intent=new Intent(context,TransportListActivity.class);
        intent.putExtra(CommonMethod.FROM,TRANSPORT_LIST);
        ((MaterailAddActivity)context).startActivityForResult(intent,RC_TRANSPORT);
    }


    @BindingAdapter(value = {"customEntriesMaterialStatic","customEntriesMaterialValues","objectMaterialModel"},requireAll = true)
    public static void staticAdapter(Spinner spinner, ObservableArrayList<SpinnerGenericModel> list, String value,Object o){
        spinner.setAdapter(new GenericSpinnerAdapter(spinner.getContext(),list));
        spinner.setOnItemSelectedListener(new SpinnerItemSelect(o,value));

    }

    @BindingAdapter({"customMaterialEntries","customMaterialValues","objectMaterialModel", "objectSelectedModel"})
    public static void bindCityAdapter(Spinner spinner, ObservableField<String> fileName,String value,Object model, ObservableInt unitPosition){
        spinner.setAdapter(new GenericSpinnerAdapter(spinner.getContext(),CommonMethod.parseXML(fileName.get())));
        spinner.setOnItemSelectedListener(new SpinnerItemSelect(model,value));
        spinner.setSelection(unitPosition.get());
    }

    @BindingAdapter({"error"})
    public static void setError(EditText editText,String s){
        editText.setError(s);
        editText.requestFocus();
    }


    public void setMaterialPagination(PaginationModel model) {
       this.materialPagination=model;
       this.model.setPlantCode(model.getParameter3());
    }

    public void setSelectedMaterial(MaterialModel model) {
        this.model.setMaterialName(model.getProductName());
        this.model.setProductCode(model.getProductCode());
        this.model.setUnits(model.getUnit());
        unitPosition.set(CommonMethod.getItemPositionFromXMLFile(SpinnerFileName.UNITS,model.getUnit()));
        this.model.setMaterialPricing(model.getPricePerUnit());
        this.model.setTotalDiscount(model.getTotalDiscount());
    }

    public void dispatchDatePick(View view){
        DatePickerGeneric generic=new DatePickerGeneric(Calendar.getInstance(), new DatePickerGeneric.DatePickerListener() {
            @Override
            public void onDateSelect(String date) {
                model.setDispatchDate(date);
            }
        });
        generic.showPicker(view.getContext());
    }

    public void setSelectedTransport(TransportModel model) {
        this.model.setTransporterCode(model.getTransporterCode());
        this.model.setTransporterName(model.getTransporterName());
    }

    public void onSubmit(View view){
        Log.d(TAG, "onSubmit: "+new Gson().toJson(model));


        if (getValidationForIndent(model.getMaterialName(), "Material Name", view)) {
            return;
        }
        if (getValidationForIndent(model.getProductCode(), "Material Code", view)) {
            return;
        }
        if (getValidationForIndent(model.getQuantity(), "Quantity ", view)) {
            return;
        }
        if (getValidationForIndentFor(model.getMaterialPricing(), "Material Price ", view)) {
            return;
        }
        if (getValidationForIndent(model.getDispatchDate(), "Dispatch Date ", view)) {
            return;
        }



        Intent intent=new Intent();
        intent.putExtra(CommonMethod.FULL_MATERIAL,model);
        ((MaterailAddActivity)context).setResult(RC_PRODUCT,intent);
        ((MaterailAddActivity)context).finish();
    }

    private boolean getValidationForIndentFor(String value, String error, View view) {
        if (TextUtils.isEmpty(value) && value == null && value.length()>0.0) {
            showSnackBar(error, view);
            return true;
        }
        return false;
    }

    private boolean getValidationForIndent(String value, String error, View view) {
        if (TextUtils.isEmpty(value) && value == null) {
            showSnackBar(error, view);

            return true;
        }
        return false;
    }

    private void showSnackBar(String error, View view) {
        Snackbar.make(view, "Please select " + error, Snackbar.LENGTH_SHORT).show();
    }


    @Bindable
    public SaveMaterialModel getModel() {
        return model;
    }

    public void setModel(SaveMaterialModel materialModel) {
        this.model=materialModel;
        notifyPropertyChanged(BR.model);
        unitPosition.set(CommonMethod.getItemPositionFromXMLFile(SpinnerFileName.UNITS,materialModel.getUnits()));
        unitPosition.notifyChange();
    }
}
