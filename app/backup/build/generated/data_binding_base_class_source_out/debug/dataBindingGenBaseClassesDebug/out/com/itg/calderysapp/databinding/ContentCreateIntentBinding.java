package com.itg.calderysapp.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel;

public abstract class ContentCreateIntentBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAddConsignee;

  @NonNull
  public final Button btnAddMaterial;

  @NonNull
  public final Button btnApprove;

  @NonNull
  public final Button btnReject;

  @NonNull
  public final Button btnReset;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final EditText editDealerName;

  @NonNull
  public final EditText edtAddConsingee;

  @NonNull
  public final EditText edtCCEMailId;

  @NonNull
  public final EditText edtConsingee;

  @NonNull
  public final EditText edtConsingeeName;

  @NonNull
  public final EditText edtDeliveryDate;

  @NonNull
  public final Spinner edtDivision;

  @NonNull
  public final Spinner edtIgst;

  @NonNull
  public final Spinner edtIntentTypeSpinner;

  @NonNull
  public final EditText edtPODate;

  @NonNull
  public final Spinner edtPlantCodeSpinner;

  @NonNull
  public final EditText edtPoNumber;

  @NonNull
  public final Spinner edtSgstCgst;

  @NonNull
  public final EditText edtTaxInfo;

  @NonNull
  public final TextView headerItemText;

  @NonNull
  public final TextView lblCcEmailId;

  @NonNull
  public final TextView lblConsingeeName;

  @NonNull
  public final TextView lblConstiteCode;

  @NonNull
  public final TextView lblDealerName;

  @NonNull
  public final TextView lblDeliveryDate;

  @NonNull
  public final TextView lblDivision;

  @NonNull
  public final TextView lblIgst;

  @NonNull
  public final TextView lblIntentType;

  @NonNull
  public final TextView lblNameConsingee;

  @NonNull
  public final TextView lblPlantCode;

  @NonNull
  public final TextView lblPoDate;

  @NonNull
  public final TextView lblPoNumber;

  @NonNull
  public final TextView lblSgstCgst;

  @NonNull
  public final TextView lblTaxInfo;

  @NonNull
  public final LinearLayout llApproveReject;

  @NonNull
  public final LinearLayout llBtn;

  @NonNull
  public final LinearLayout llEdit;

  @NonNull
  public final ProgressBar progressEdit;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final View strut;

  @NonNull
  public final TextView totalValue;

  @NonNull
  public final TextView totalValueActual;

  @Bindable
  protected CreateIndentViewModel mCreateIndentModel;

  @Bindable
  protected SpinnerViewModel mSpinnerModel;

  protected ContentCreateIntentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnAddConsignee, Button btnAddMaterial, Button btnApprove,
      Button btnReject, Button btnReset, Button btnSave, Button btnSubmit, EditText editDealerName,
      EditText edtAddConsingee, EditText edtCCEMailId, EditText edtConsingee,
      EditText edtConsingeeName, EditText edtDeliveryDate, Spinner edtDivision, Spinner edtIgst,
      Spinner edtIntentTypeSpinner, EditText edtPODate, Spinner edtPlantCodeSpinner,
      EditText edtPoNumber, Spinner edtSgstCgst, EditText edtTaxInfo, TextView headerItemText,
      TextView lblCcEmailId, TextView lblConsingeeName, TextView lblConstiteCode,
      TextView lblDealerName, TextView lblDeliveryDate, TextView lblDivision, TextView lblIgst,
      TextView lblIntentType, TextView lblNameConsingee, TextView lblPlantCode, TextView lblPoDate,
      TextView lblPoNumber, TextView lblSgstCgst, TextView lblTaxInfo, LinearLayout llApproveReject,
      LinearLayout llBtn, LinearLayout llEdit, ProgressBar progressEdit, RecyclerView recyclerView,
      View strut, TextView totalValue, TextView totalValueActual) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAddConsignee = btnAddConsignee;
    this.btnAddMaterial = btnAddMaterial;
    this.btnApprove = btnApprove;
    this.btnReject = btnReject;
    this.btnReset = btnReset;
    this.btnSave = btnSave;
    this.btnSubmit = btnSubmit;
    this.editDealerName = editDealerName;
    this.edtAddConsingee = edtAddConsingee;
    this.edtCCEMailId = edtCCEMailId;
    this.edtConsingee = edtConsingee;
    this.edtConsingeeName = edtConsingeeName;
    this.edtDeliveryDate = edtDeliveryDate;
    this.edtDivision = edtDivision;
    this.edtIgst = edtIgst;
    this.edtIntentTypeSpinner = edtIntentTypeSpinner;
    this.edtPODate = edtPODate;
    this.edtPlantCodeSpinner = edtPlantCodeSpinner;
    this.edtPoNumber = edtPoNumber;
    this.edtSgstCgst = edtSgstCgst;
    this.edtTaxInfo = edtTaxInfo;
    this.headerItemText = headerItemText;
    this.lblCcEmailId = lblCcEmailId;
    this.lblConsingeeName = lblConsingeeName;
    this.lblConstiteCode = lblConstiteCode;
    this.lblDealerName = lblDealerName;
    this.lblDeliveryDate = lblDeliveryDate;
    this.lblDivision = lblDivision;
    this.lblIgst = lblIgst;
    this.lblIntentType = lblIntentType;
    this.lblNameConsingee = lblNameConsingee;
    this.lblPlantCode = lblPlantCode;
    this.lblPoDate = lblPoDate;
    this.lblPoNumber = lblPoNumber;
    this.lblSgstCgst = lblSgstCgst;
    this.lblTaxInfo = lblTaxInfo;
    this.llApproveReject = llApproveReject;
    this.llBtn = llBtn;
    this.llEdit = llEdit;
    this.progressEdit = progressEdit;
    this.recyclerView = recyclerView;
    this.strut = strut;
    this.totalValue = totalValue;
    this.totalValueActual = totalValueActual;
  }

  public abstract void setCreateIndentModel(@Nullable CreateIndentViewModel createIndentModel);

  @Nullable
  public CreateIndentViewModel getCreateIndentModel() {
    return mCreateIndentModel;
  }

  public abstract void setSpinnerModel(@Nullable SpinnerViewModel spinnerModel);

  @Nullable
  public SpinnerViewModel getSpinnerModel() {
    return mSpinnerModel;
  }

  @NonNull
  public static ContentCreateIntentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentCreateIntentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentCreateIntentBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_create_intent, root, attachToRoot, component);
  }

  @NonNull
  public static ContentCreateIntentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentCreateIntentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentCreateIntentBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_create_intent, null, false, component);
  }

  public static ContentCreateIntentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentCreateIntentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentCreateIntentBinding)bind(component, view, com.itg.calderysapp.R.layout.content_create_intent);
  }
}
