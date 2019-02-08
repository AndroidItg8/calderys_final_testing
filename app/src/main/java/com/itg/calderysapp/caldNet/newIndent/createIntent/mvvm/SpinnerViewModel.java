package com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.Spinner;

import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.GenericSpinnerAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.common.SpinnerItemSelect;
import com.itg.calderysapp.BR;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class SpinnerViewModel extends BaseObservable {
    private Context context;
    public IndentsModel model;

    public ObservableArrayList<SpinnerGenericModel> igst;
    public ObservableArrayList<SpinnerGenericModel> sgst;
    public ObservableField<String> indentType=new ObservableField<>(SpinnerFileName.INDENTTYPE);
    public ObservableField<String> division=new ObservableField<>(SpinnerFileName.DIVISION);
    public ObservableField<String> selectedPlantCode=new ObservableField<>();

    public ObservableArrayList<SpinnerGenericModel> plantcode=new ObservableArrayList<>();
    private View rootView;

    public SpinnerViewModel(Context context, IndentsModel model){
        this.context = context;
        initIgstSgst();

        setModel(model);
        downloadPlantCodes();

    }

    private void initIgstSgst() {
        igst=new ObservableArrayList<>();
        sgst=new ObservableArrayList<>();
        generateIgst();
        generateSgst();
    }


    private void generateIgst(){
        igst.addAll(SpinnerFileName.generateIGST());
    }

    private void generateSgst(){
        sgst.addAll(SpinnerFileName.generateISGST());
    }

    private void downloadPlantCodes() {
        Disposable d=new NetworkUtility.NetworkBuilder().build().downloadPlantCode(new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                List<SpinnerGenericModel> list= (List<SpinnerGenericModel>) message;
                plantcode.addAll(list);
                checkIfPrevious();
            }

            @Override
            public void onFailure(Object err) {
                showError();
            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });
    }

    private void showError() {

    }

    private void checkIfPrevious() {
        if(model.plantCode!=null){
            selectedPlantCode.set(model.getPlantCode());
        }
    }


    @BindingAdapter({"customEntries","customValues","customMyModel","customSelectedItem"})
    public static void bindCityAdapter(Spinner spinner, String fileName,String value,Object o,String selectedItem){
        GenericSpinnerAdapter adapter = new GenericSpinnerAdapter(spinner.getContext(), CommonMethod.parseXML(fileName));
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerItemSelect(o,value));
        spinner.setSelection(adapter.findItemPosition(selectedItem));
    }


    @BindingAdapter({"customEntriesStatic","customEntriesValues","customMyModelStatic","customSelectedItem"})
    public static void staticAdapter(Spinner spinner,ObservableArrayList<SpinnerGenericModel> list,String value,Object o,String selectedItem){
        GenericSpinnerAdapter adapter = new GenericSpinnerAdapter(spinner.getContext(), list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerItemSelect(o,value));
        spinner.setSelection(adapter.findItemPosition(selectedItem));
    }


    public void onResetClick(View view){
        initIgstSgst();
    }


    public void setModel(IndentsModel model) {
        this.model = model;
        notifyPropertyChanged(BR.model);
    }

    @Bindable
    public IndentsModel getModel() {
        return model;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public View getRootView() {
        return rootView;
    }
}
