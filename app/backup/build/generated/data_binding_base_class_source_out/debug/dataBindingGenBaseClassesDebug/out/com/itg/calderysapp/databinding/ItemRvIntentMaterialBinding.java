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
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel;

public abstract class ItemRvIntentMaterialBinding extends ViewDataBinding {
  @NonNull
  public final TextView lblKgTag;

  @NonNull
  public final TextView lblMaterialCode;

  @NonNull
  public final TextView lblMaterialName;

  @NonNull
  public final TextView lblMaterialRemark;

  @NonNull
  public final TextView lblPlantCode;

  @NonNull
  public final TextView lblPriceUnit;

  @NonNull
  public final TextView lblProductRemark;

  @NonNull
  public final TextView lblQuantity;

  @NonNull
  public final TextView lblUnits;

  @NonNull
  public final TextView txtMaterialCode;

  @NonNull
  public final TextView txtMaterialName;

  @NonNull
  public final TextView txtPlantCode;

  @NonNull
  public final TextView txtPriceUnit;

  @NonNull
  public final TextView txtQuantity;

  @NonNull
  public final TextView txtUnit;

  @NonNull
  public final TextView txtUnits;

  @Bindable
  protected MaterialItemViewModel mModel;

  protected ItemRvIntentMaterialBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView lblKgTag, TextView lblMaterialCode, TextView lblMaterialName,
      TextView lblMaterialRemark, TextView lblPlantCode, TextView lblPriceUnit,
      TextView lblProductRemark, TextView lblQuantity, TextView lblUnits, TextView txtMaterialCode,
      TextView txtMaterialName, TextView txtPlantCode, TextView txtPriceUnit, TextView txtQuantity,
      TextView txtUnit, TextView txtUnits) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lblKgTag = lblKgTag;
    this.lblMaterialCode = lblMaterialCode;
    this.lblMaterialName = lblMaterialName;
    this.lblMaterialRemark = lblMaterialRemark;
    this.lblPlantCode = lblPlantCode;
    this.lblPriceUnit = lblPriceUnit;
    this.lblProductRemark = lblProductRemark;
    this.lblQuantity = lblQuantity;
    this.lblUnits = lblUnits;
    this.txtMaterialCode = txtMaterialCode;
    this.txtMaterialName = txtMaterialName;
    this.txtPlantCode = txtPlantCode;
    this.txtPriceUnit = txtPriceUnit;
    this.txtQuantity = txtQuantity;
    this.txtUnit = txtUnit;
    this.txtUnits = txtUnits;
  }

  public abstract void setModel(@Nullable MaterialItemViewModel model);

  @Nullable
  public MaterialItemViewModel getModel() {
    return mModel;
  }

  @NonNull
  public static ItemRvIntentMaterialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRvIntentMaterialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRvIntentMaterialBinding>inflate(inflater, com.itg.calderysapp.R.layout.item_rv_intent_material, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRvIntentMaterialBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRvIntentMaterialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRvIntentMaterialBinding>inflate(inflater, com.itg.calderysapp.R.layout.item_rv_intent_material, null, false, component);
  }

  public static ItemRvIntentMaterialBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemRvIntentMaterialBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemRvIntentMaterialBinding)bind(component, view, com.itg.calderysapp.R.layout.item_rv_intent_material);
  }
}
