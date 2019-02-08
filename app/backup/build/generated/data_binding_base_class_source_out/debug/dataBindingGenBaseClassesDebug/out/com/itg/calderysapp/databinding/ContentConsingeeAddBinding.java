package com.itg.calderysapp.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel;

public abstract class ContentConsingeeAddBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final EditText editDealerName;

  @NonNull
  public final EditText edtConsingeeAddress;

  @NonNull
  public final EditText edtContactPerson;

  @NonNull
  public final AppCompatSpinner edtCountry;

  @NonNull
  public final EditText edtCstNo;

  @NonNull
  public final EditText edtEccNumber;

  @NonNull
  public final EditText edtEmailAddress;

  @NonNull
  public final EditText edtFaxNo;

  @NonNull
  public final EditText edtLstDate;

  @NonNull
  public final EditText edtLstNo;

  @NonNull
  public final EditText edtMobileNumber;

  @NonNull
  public final EditText edtPostal;

  @NonNull
  public final AppCompatSpinner edtRegion;

  @NonNull
  public final EditText edtTelephoneNumber;

  @NonNull
  public final EditText edtTinNumber;

  @NonNull
  public final TextView headerItemText;

  @NonNull
  public final TextView lblConsingeeAddress;

  @NonNull
  public final TextView lblContantPerson;

  @NonNull
  public final TextView lblCountry;

  @NonNull
  public final TextView lblCstNo;

  @NonNull
  public final TextView lblDealerName;

  @NonNull
  public final TextView lblEccNumber;

  @NonNull
  public final TextView lblEmailAddress;

  @NonNull
  public final TextView lblFaxNo;

  @NonNull
  public final TextView lblLstDate;

  @NonNull
  public final TextView lblLstNo;

  @NonNull
  public final TextView lblMobileNumber;

  @NonNull
  public final TextView lblPostal;

  @NonNull
  public final TextView lblRegion;

  @NonNull
  public final TextView lblTelephoneNo;

  @NonNull
  public final TextView lblTinNumber;

  @NonNull
  public final View strut;

  @Bindable
  protected ConsigneeViewModel mConsigneeModel;

  protected ContentConsingeeAddBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnSubmit, EditText editDealerName, EditText edtConsingeeAddress,
      EditText edtContactPerson, AppCompatSpinner edtCountry, EditText edtCstNo,
      EditText edtEccNumber, EditText edtEmailAddress, EditText edtFaxNo, EditText edtLstDate,
      EditText edtLstNo, EditText edtMobileNumber, EditText edtPostal, AppCompatSpinner edtRegion,
      EditText edtTelephoneNumber, EditText edtTinNumber, TextView headerItemText,
      TextView lblConsingeeAddress, TextView lblContantPerson, TextView lblCountry,
      TextView lblCstNo, TextView lblDealerName, TextView lblEccNumber, TextView lblEmailAddress,
      TextView lblFaxNo, TextView lblLstDate, TextView lblLstNo, TextView lblMobileNumber,
      TextView lblPostal, TextView lblRegion, TextView lblTelephoneNo, TextView lblTinNumber,
      View strut) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSubmit = btnSubmit;
    this.editDealerName = editDealerName;
    this.edtConsingeeAddress = edtConsingeeAddress;
    this.edtContactPerson = edtContactPerson;
    this.edtCountry = edtCountry;
    this.edtCstNo = edtCstNo;
    this.edtEccNumber = edtEccNumber;
    this.edtEmailAddress = edtEmailAddress;
    this.edtFaxNo = edtFaxNo;
    this.edtLstDate = edtLstDate;
    this.edtLstNo = edtLstNo;
    this.edtMobileNumber = edtMobileNumber;
    this.edtPostal = edtPostal;
    this.edtRegion = edtRegion;
    this.edtTelephoneNumber = edtTelephoneNumber;
    this.edtTinNumber = edtTinNumber;
    this.headerItemText = headerItemText;
    this.lblConsingeeAddress = lblConsingeeAddress;
    this.lblContantPerson = lblContantPerson;
    this.lblCountry = lblCountry;
    this.lblCstNo = lblCstNo;
    this.lblDealerName = lblDealerName;
    this.lblEccNumber = lblEccNumber;
    this.lblEmailAddress = lblEmailAddress;
    this.lblFaxNo = lblFaxNo;
    this.lblLstDate = lblLstDate;
    this.lblLstNo = lblLstNo;
    this.lblMobileNumber = lblMobileNumber;
    this.lblPostal = lblPostal;
    this.lblRegion = lblRegion;
    this.lblTelephoneNo = lblTelephoneNo;
    this.lblTinNumber = lblTinNumber;
    this.strut = strut;
  }

  public abstract void setConsigneeModel(@Nullable ConsigneeViewModel consigneeModel);

  @Nullable
  public ConsigneeViewModel getConsigneeModel() {
    return mConsigneeModel;
  }

  @NonNull
  public static ContentConsingeeAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentConsingeeAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentConsingeeAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_consingee_add, root, attachToRoot, component);
  }

  @NonNull
  public static ContentConsingeeAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentConsingeeAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentConsingeeAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_consingee_add, null, false, component);
  }

  public static ContentConsingeeAddBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentConsingeeAddBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentConsingeeAddBinding)bind(component, view, com.itg.calderysapp.R.layout.content_consingee_add);
  }
}
