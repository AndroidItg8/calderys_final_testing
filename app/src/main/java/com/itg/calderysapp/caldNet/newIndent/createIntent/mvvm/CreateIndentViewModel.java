package com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product_;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.MaterailAddActivity;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.ConsigneeListActivity;
import com.itg.calderysapp.caldNet.newIndent.consignee.ConsingeeAddActivity;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIntentActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.MaterialIndentAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.DatePickerGeneric;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.TextSetWatcher;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.common.genericRv.GenericAdapter;

import com.itg.calderysapp.BR;
import com.itg.calderysapp.login.model.LoginCaldNetModel;
import com.itg.calderysapp.notification.NotificationModel.Data;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.notification.controller.FirebaseMessageController;

import java.util.Calendar;

import io.reactivex.disposables.Disposable;

public class CreateIndentViewModel extends BaseObservable {

    private static final String TAG = "CreateIndentViewModel";

    public static final int RC_PRODUCT = 102;
    public static IndentsModel model;
    private final ProgressBar progressBar;
    private Context context;
    public ObservableField<String> dealerName;

    public ObservableField<String> dispatchDate;
    public ObservableField<String> poDate;


    public static final int RC_NEW_MATERIAL = 103;

    public ObservableArrayList<SaveMaterialModel> materiaList;

    public ObservableField<String> totalValue;
    private View root;

    private boolean isProductDownloaded=false;


    public CreateIndentViewModel(Context context) {
        this.context = context;

        dispatchDate=new ObservableField<>();
        poDate=new ObservableField<>();
        materiaList = new ObservableArrayList<>();
        dealerName = new ObservableField<>();

        setModel(new IndentsModel());
        progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleSmall);

        LoginCaldNetModel model = MyApplication.getInstance().getLoginModel();
        if (model != null) {
            dealerName.set(model.getFirstName() + " " + model.getLastName());
            CreateIndentViewModel.model.setDealerCode(model.getUserID());
            CreateIndentViewModel.model.setConsigneeName(dealerName.get());
            CreateIndentViewModel.model.setConsigneeCode(model.getUserID());
        }
        totalValue = new ObservableField<>();
    }


    @Bindable
    public static IndentsModel getModel() {
        return model;
    }



    public void setModel(IndentsModel model) {
        if(model!=null) {
            CreateIndentViewModel.model = model;
            CreateIndentViewModel.model.setDispatchDate(model.getDispatchDate());
            dispatchDate.set(CommonMethod.getDDMMYYYYfromDateServerForField(model.getDispatchDate()));
            poDate.set(CommonMethod.getDDMMYYYYfromDateServerForField(model.getPODate()));

            ((CreateIndentNewActivity) context).setSpinnerModels(CreateIndentViewModel.model);
            downloadOtherDetailsAbtProduct(model);
            notifyPropertyChanged(BR.model);
        }

    }

    private void downloadOtherDetailsAbtProduct(IndentsModel model) {
        if(isProductDownloaded)
            return;
        if (model.getIndentCode() != null && model.getIndentDate() != null) {
            ViewDraftModel model1 = new ViewDraftModel();
            model1.setIndentCode(model.getIndentCode());
            model1.setIndentDate(model.getIndentDate());
            new NetworkUtility.NetworkBuilder().setHeader().build().getEditViewDraftModel(model1, new NetworkUtility.ResponseListener() {
                @Override
                public void onSuccess(Object message) {
                    Indents i = (Indents) message;
                    isProductDownloaded=true;
                    createIndentModelByIndent(i);
                    getProducts(i);

                }

                @Override
                public void onFailure(Object err) {
                    isProductDownloaded=true;

                    ((CreateIndentNewActivity) context).showSnackBar(err.toString());

                }

                @Override
                public void onSomethingWrong(Object e) {
                    ((Throwable)e).printStackTrace();
                    isProductDownloaded=true;


                }
            });

        }
    }

    private void createIndentModelByIndent(Indents i) {
        Log.d(TAG, "createIndentModelByIndent: "+ new Gson().toJson(i));
        IndentsModel model=new Gson().fromJson(new Gson().toJson(i),IndentsModel.class);
        model.setConsigneeName(i.getConsigneeName());
        setModel(model);

    }



      private void getProducts(Indents i) {
        Product p = (Product) i.getProduct();
        Log.d(TAG, "getProducts: "+new Gson().toJson(p));
        SaveMaterialModel m;
        if (p == null)
            return;

        for (Product_ ps :
                p.getProduct()) {
            if (ps != null) {


                m = new Gson().fromJson(new Gson().toJson(ps), SaveMaterialModel.class);
                m.setMaterialName(ps.getProductName());
                m.setTransporterName(ps.getTransporterName());
                m.setHiddenDiscount(ps.getHiddenDiscount());
                addProduct(m);
            }
        }
    }


    @BindingAdapter({"indenttextwatcher"})
    public static void bindTextWatcherToEditText(EditText editText, final String textField) {
        TextSetWatcher watcher = new TextSetWatcher(model, textField);
        editText.addTextChangedListener(watcher);
    }

    public void consigneeOpen(View view) {
        Intent intent = new Intent(context, ConsigneeListActivity.class);
        ((CreateIndentNewActivity) context).startActivityForResult(intent, CreateIndentNewActivity.RC_CONSIGNEE);
    }

    public void onCreateConsignee(View view) {

        ((CreateIndentNewActivity) context).startActivity(new Intent(context, ConsingeeAddActivity.class));
    }

    public void podate(View view) {
        DatePickerGeneric generic = new DatePickerGeneric(Calendar.getInstance(), new DatePickerGeneric.DatePickerListener() {
            @Override
            public void onDateSelect(String date) {
                model.setPODate(CommonMethod.getDDMMYYYYfromDateServer(date));
                poDate.set(date);
            }
        });
        generic.showPicker(view.getContext());
    }

    public void deliveryDate(View view) {
        DatePickerGeneric generic = new DatePickerGeneric(Calendar.getInstance(), new DatePickerGeneric.DatePickerListener() {
            @Override
            public void onDateSelect(String date) {
                model.setDispatchDate(CommonMethod.getDDMMYYYYfromDateServer(date));
                dispatchDate.set(date);
            }
        });
        generic.showPicker(view.getContext());
    }

    public void setConsignee(ConsigneeListModel consigneeModel) {
        model.setConsigneeCode(consigneeModel.getConsigneeCode());
        model.setConsigneeName(consigneeModel.getConsigneeName());
    }

    public void addMaterialClicked(View view) {

        Log.d(TAG, "addMaterialClicked: model : "+ new Gson().toJson(model));
        if (model.getIndentType() == null || model.getIndentType().equals("0")) {
            Snackbar.make(view, "Please select Indent Type", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if (model.getPlantCode() == null || model.getPlantCode().equals("")) {
            Snackbar.make(view, "Please select Plant Code", Snackbar.LENGTH_SHORT).show();
            return;
        }
        if (model.getDivision() == null || model.getDivision().equals("")) {
            Snackbar.make(view, "Please select Division", Snackbar.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this.context, MaterailAddActivity.class);
        intent.putExtra(CommonMethod.INDENT_TYPE, model.getIndentType());
        intent.putExtra(CommonMethod.PLANT_CODE, model.getPlantCode());
        intent.putExtra(CommonMethod.DIVISION, model.getDivision());
        ((CreateIndentNewActivity) context).startActivityForResult(intent, RC_PRODUCT);
    }

    public void addProduct(SaveMaterialModel model) {
        SaveMaterialModel m = null;
        for (int i = 0; i < materiaList.size(); i++)
            if (materiaList.get(i).getProductCode().equalsIgnoreCase(model.getProductCode())) {
                m = materiaList.get(i);
            }
        if (m != null) {
            materiaList.remove(m);
        }
        model.setDispatchDate(CommonMethod.getDDMMYYYYfromDateServer(model.getDispatchDate()));
        materiaList.add(model);
        calculateTotal();
    }

    private void calculateTotal() {
        double s = 0;
        for (SaveMaterialModel m :
                materiaList) {
            s += Double.parseDouble(m.getTotalPrice());
        }
        totalValue.set("\u20B9 "+String.format("%.00f", s));
    }

    public ConsigneeListViewModel.OnItemClickListner myListener = new ConsigneeListViewModel.OnItemClickListner() {
        @Override
        public void onItemClicked(Object o) {
            startActivity((SaveMaterialModel) o);
        }
    };

    @BindingAdapter(value = {"customSaveMaterialAdapter", "customListener"}, requireAll = false)
    public static void productRecyclerview(RecyclerView recyclerView, ObservableArrayList<SaveMaterialModel> models, ConsigneeListViewModel.OnItemClickListner listner) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        setParameterForAllModel(models);
        MaterialItemViewModel itemModel = new MaterialItemViewModel();
        itemModel.setListener(listner);
        recyclerView.setAdapter(new GenericAdapter<>(models, itemModel,listner));
    }

    private static void setParameterForAllModel(ObservableArrayList<SaveMaterialModel> models) {
        if(models!=null && models.size()>0){



        }
    }

    private void startActivity(SaveMaterialModel o) {
        Intent intent = new Intent(context, MaterailAddActivity.class);
        intent.putExtra(CommonMethod.FROM_PRODUCT, o);
        intent.putExtra(CommonMethod.INDENT_TYPE, model.getIndentType());
        intent.putExtra(CommonMethod.PLANT_CODE, model.getPlantCode());
        intent.putExtra(CommonMethod.DIVISION, model.getDivision());
        ((CreateIndentNewActivity) context).startActivityForResult(intent, RC_PRODUCT);
    }

    public void onSumitClick(View view) {


        if (model.getIndentDate() == null) {

            model.setIndentDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
            model.setCreatedDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
            model.setStatusDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
            model.setPODate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
        }


        if (getValidationForIndent(model.getPONumber(), "PO Number", view)) {
            return;
        }
        if (getValidationForIndent(model.getIndentType(), "Indent Type", view)) {
            return;
        }
        if (getValidationForIndent(model.getPlantCode(), "Plant Code", view)) {
            return;
        }
        if (getValidationForIndent(model.getPODateValidate(), "Po Date ", view)) {
            return;
        }
        if (getValidationForIndent(model.getDispatchDateValided(), "Delivery Date ", view)) {
            return;
        }
        if (getValidationForIndent(model.getDivision(), "Division ", view)) {
            return;
        }

//        model.setDispatchDateForServer(model.getDispatchDate());
//        model.setPODateForServer(model.getPODate());
        model.setIndApprvlStatus("P");

        Log.d(TAG, "onSumitClick: " + new Gson().toJson(model));
        Log.d(TAG, "onSumitClick: " + new Gson().toJson(materiaList));

        submitDetail();


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

    private void submitDetail() {

        Disposable disposable = new NetworkUtility.NetworkBuilder().build().saveIndent(model, materiaList, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                if (context != null) {
                    if (message instanceof String) {
                        IndentsModel model = new Gson().fromJson(message.toString(), IndentsModel.class);
                        Log.d(TAG, "onSuccess: Check Indent Status "+ new Gson().toJson(message.toString()));
                        FirebaseMessageController controller = new FirebaseMessageController();
                        controller.sendNotification(createNotificationData(model));

                    } else if (message instanceof Integer) {
                        if ((Integer) message == 1) {
                            ((CreateIndentNewActivity) context).showSnackBar(model.getIndentCode() == null ? "Save Successfully" : "Update Successfully");
                            ((CreateIndentNewActivity) context).finish();
                        }
//                        }else {
//                            ((CreateIndentNewActivity)context).showSnackBar(model.getIndentCode()== null?"Failed  Save":" Failed Update ");
//                        }

                    }
                }
            }

            @Override
            public void onFailure(Object err) {
                ((CreateIndentNewActivity) context).showSnackBar(err.toString());


            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });
    }

    private Message createNotificationData(IndentsModel message) {
        Data data = new Data();
        data.setClasstype(CommonMethod.CREATE_INDENT);
        data.setData(new Gson().toJson(message));
        LoginCaldNetModel modell = MyApplication.getInstance().getLoginModel();
        if (modell != null)
            data.setSalesContactPerson(modell.getSalesContactPerson());

        data.setMessage("New Indent Code " + message.getIndentCode() + " Added");
        data.setTitle("New Indent created on CaldNet");
        Message msg = new Message();
        msg.setData(data);
        msg.setTo("/topics/" + AppType.getAppType());
        Log.d(TAG, "createNotificationData: IndenstModel" + new Gson().toJson(msg));

        return msg;

    }

    public void onSaveClick(View view) {
        if (model.getIndentDate() == null) {
            model.setIndentDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
            model.setCreatedDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
            model.setStatusDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
            model.setPODate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
        }
        model.setDispatchDate(model.getDispatchDate());
        model.setPODate(model.getPODate());

        if (getValidationForIndent(model.getPONumber(), "PO Number", view)) {
            return;
        }
        if (getValidationForIndent(model.getIndentType(), "Indent Type", view)) {
            return;
        }
        if (getValidationForIndent(model.getPlantCode(), "Plant Code", view)) {
            return;
        }
        if (getValidationForIndent(model.getPODateValidate(), "Po Date ", view)) {
            return;
        }
        if (getValidationForIndent(model.getDispatchDateValided(), "Delivery Date ", view)) {
            return;
        }
        if (getValidationForIndent(model.getDivision(), "Division ", view)) {
            return;
        }
        model.setIndApprvlStatus("M");

        Log.d(TAG, "onSaveClick: " + new Gson().toJson(model));
        Log.d(TAG, "onSaveClick: " + new Gson().toJson(materiaList));

        submitDetail();

    }

    public void onResetClick(View view) {
        setModel(new IndentsModel());
        materiaList.clear();
    }


    public void setRootView(View root) {
        this.root = root;
    }
}
