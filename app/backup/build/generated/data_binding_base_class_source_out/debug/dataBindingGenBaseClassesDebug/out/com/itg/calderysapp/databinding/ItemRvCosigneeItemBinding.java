package com.itg.calderysapp.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel;

public abstract class ItemRvCosigneeItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView lblConsigneeAddress;

  @NonNull
  public final TextView lblConsigneeCode;

  @NonNull
  public final TextView lblConsigneeCstNo;

  @NonNull
  public final TextView lblConsigneeEccno;

  @NonNull
  public final TextView lblConsigneeModel;

  @NonNull
  public final TextView lblConsigneeTinNo;

  @NonNull
  public final TextView txtConsigneeAddress;

  @NonNull
  public final TextView txtConsigneeCode;

  @NonNull
  public final TextView txtConsigneeCstNo;

  @NonNull
  public final TextView txtConsigneeEccNo;

  @NonNull
  public final TextView txtConsigneeModel;

  @NonNull
  public final TextView txtConsigneeTinNo;

  @Bindable
  protected ConsigneeItemViewModel mConsigneeModel;

  protected ItemRvCosigneeItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView lblConsigneeAddress, TextView lblConsigneeCode,
      TextView lblConsigneeCstNo, TextView lblConsigneeEccno, TextView lblConsigneeModel,
      TextView lblConsigneeTinNo, TextView txtConsigneeAddress, TextView txtConsigneeCode,
      TextView txtConsigneeCstNo, TextView txtConsigneeEccNo, TextView txtConsigneeModel,
      TextView txtConsigneeTinNo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lblConsigneeAddress = lblConsigneeAddress;
    this.lblConsigneeCode = lblConsigneeCode;
    this.lblConsigneeCstNo = lblConsigneeCstNo;
    this.lblConsigneeEccno = lblConsigneeEccno;
    this.lblConsigneeModel = lblConsigneeModel;
    this.lblConsigneeTinNo = lblConsigneeTinNo;
    this.txtConsigneeAddress = txtConsigneeAddress;
    this.txtConsigneeCode = txtConsigneeCode;
    this.txtConsigneeCstNo = txtConsigneeCstNo;
    this.txtConsigneeEccNo = txtConsigneeEccNo;
    this.txtConsigneeModel = txtConsigneeModel;
    this.txtConsigneeTinNo = txtConsigneeTinNo;
  }

  public abstract void setConsigneeModel(@Nullable ConsigneeItemViewModel consigneeModel);

  @Nullable
  public ConsigneeItemViewModel getConsigneeModel() {
    return mConsigneeModel;
  }

  @NonNull
  public static ItemRvCosigneeItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRvCosigneeItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRvCosigneeItemBinding>inflate(inflater, com.itg.calderysapp.R.layout.item_rv_cosignee_item, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRvCosigneeItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRvCosigneeItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRvCosigneeItemBinding>inflate(inflater, com.itg.calderysapp.R.layout.item_rv_cosignee_item, null, false, component);
  }

  public static ItemRvCosigneeItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemRvCosigneeItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemRvCosigneeItemBinding)bind(component, view, com.itg.calderysapp.R.layout.item_rv_cosignee_item);
  }
}
