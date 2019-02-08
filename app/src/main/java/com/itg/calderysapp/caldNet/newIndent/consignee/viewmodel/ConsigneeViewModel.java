package com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel;

import android.app.DatePickerDialog;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.gson.Gson;
import com.itg.calderysapp.caldNet.newIndent.consignee.ConsingeeAddActivity;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.GenericSpinnerAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.common.SpinnerItemSelect;
import com.itg.calderysapp.common.TextSetWatcher;

import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ConsigneeViewModel extends BaseObservable {

    private static final String TAG = "ConsigneeViewModel";
    private Context context;

    public static ConsigneeModel model;



    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel(CommonMethod.convertDateToString(myCalendar));
        }

    };
    private Calendar myCalendar;

    private void updateLabel(String s) {
        model.setLSTDate(s);
    }


    public ObservableArrayList<SpinnerGenericModel> allContriesObs=new ObservableArrayList<>();
    public static ObservableArrayList<SpinnerGenericModel> allReagions=new ObservableArrayList<>();

    CompositeDisposable compositeDisposable=new CompositeDisposable();
    private Disposable disposable;


    public ConsigneeViewModel(Context context) {
        this.context = context;
        myCalendar=Calendar.getInstance();
        model=new ConsigneeModel();
        model.Status="P";
        downloadAllCountries();
    }

    private static void downloadAllRegions(String id) {
        Disposable disposableNew = new NetworkUtility.NetworkBuilder().build().downloadRegion(id, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                List<SpinnerGenericModel> allRegion = (List<SpinnerGenericModel>) message;
                allReagions.clear();
                allReagions.addAll(allRegion);
            }

            @Override
            public void onFailure(Object err) {
                allReagions.clear();
                model.RegionCode=null;
            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });


    }

    private void downloadAllCountries() {
        disposable=new NetworkUtility.NetworkBuilder().build().downloadContries(new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                List<SpinnerGenericModel> allContries= (List<SpinnerGenericModel>) message;
                allContriesObs.addAll(allContries);
            }

            @Override
            public void onFailure(Object err) {


            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });
        compositeDisposable.add(disposable);
    }


    @BindingAdapter({"textwatcher"})
    public static void bindTextWatcherToEditText(EditText editText, final String textField){
        TextSetWatcher watcher=new TextSetWatcher(model,textField);
        editText.addTextChangedListener(watcher);
    }

    @BindingAdapter({"customEntriesCounty"})
    public static void bindSpinnerAdapter(AppCompatSpinner spinner, ObservableArrayList<SpinnerGenericModel> allContriesObs){
        spinner.setAdapter(new GenericSpinnerAdapter(spinner.getContext(),allContriesObs));
        SpinnerItemSelect itemDate = new SpinnerItemSelect(model, "CountryCode");
        itemDate.setOnItemAvailListener(new SpinnerItemSelect.OnItemSelectListener() {
            @Override
            public void onItemSelect(String id) {
                downloadAllRegions(id);
            }
        });
        spinner.setOnItemSelectedListener(itemDate);
    }

    @BindingAdapter({"customEntriesRegion"})
    public static void bindCityAdapter(AppCompatSpinner spinner, ObservableArrayList<SpinnerGenericModel> allContriesObs){
        spinner.setAdapter(new GenericSpinnerAdapter(spinner.getContext(),allContriesObs));
        SpinnerItemSelect itemDate = new SpinnerItemSelect(model, "RegionCode");
//        itemDate.setOnItemAvailListener(new SpinnerItemSelect.OnItemSelectListener() {
//            @Override
//            public void onItemSelect(String id) {
//                downloadAllRegions(id);
//            }
//        });
        spinner.setOnItemSelectedListener(itemDate);
    }

    public void onDatePick(View view){
        new DatePickerDialog(view.getContext(), date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }




    Snackbar s=null;

    public void onSubmitClick(View view){
        Log.d(TAG, "onSubmitClick: "+new Gson().toJson(model));
        disposable =new NetworkUtility.NetworkBuilder().build().addConsignee(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                ((ConsingeeAddActivity)context).finish();
            }

            @Override
            public void onFailure(Object err) {
                s=Snackbar.make(view,err.toString(),Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       s.dismiss();
                    }
                });
                s.show();
            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });
    }




}
