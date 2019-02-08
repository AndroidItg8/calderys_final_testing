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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel;

public abstract class ContentMaterailAddBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSubmitMaterial;

  @NonNull
  public final Spinner editInspectionsSpinner;

  @NonNull
  public final EditText editMaterialCodeSpinner;

  @NonNull
  public final EditText editMaterialNameSpinner;

  @NonNull
  public final EditText editProductRemark;

  @NonNull
  public final EditText editTransportCodeSpinner;

  @NonNull
  public final EditText editTransportNameSpinner;

  @NonNull
  public final EditText edtDispatchedDate;

  @NonNull
  public final EditText edtHiddenDiscount;

  @NonNull
  public final EditText edtOpenDiscount;

  @NonNull
  public final EditText edtPriceUnit;

  @NonNull
  public final EditText edtQuantity;

  @NonNull
  public final Spinner edtRlRequiredSpinner;

  @NonNull
  public final Spinner edtTcRequiredSpinner;

  @NonNull
  public final EditText edtTotalDiscount;

  @NonNull
  public final EditText edtTotalPriceAfterDiscount;

  @NonNull
  public final Spinner edtUnitSpinner;

  @NonNull
  public final TextView lblDispatchedDate;

  @NonNull
  public final TextView lblHiddenDiscount;

  @NonNull
  public final TextView lblInspections;

  @NonNull
  public final TextView lblMaterialCode;

  @NonNull
  public final TextView lblMaterialName;

  @NonNull
  public final TextView lblOpenDiscount;

  @NonNull
  public final TextView lblPriceUnit;

  @NonNull
  public final TextView lblProductRemark;

  @NonNull
  public final TextView lblQuantity;

  @NonNull
  public final TextView lblRlRequired;

  @NonNull
  public final TextView lblTcRequired;

  @NonNull
  public final TextView lblTotalDiscount;

  @NonNull
  public final TextView lblTotalPriceAfterDiscount;

  @NonNull
  public final TextView lblTransportCode;

  @NonNull
  public final TextView lblTransportName;

  @NonNull
  public final TextView lblUnit;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final RelativeLayout rlMaterial;

  @NonNull
  public final View struts;

  @Bindable
  protected MaterialAddViewModel mMaterialAddViewModel;

  protected ContentMaterailAddBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnSubmitMaterial, Spinner editInspectionsSpinner,
      EditText editMaterialCodeSpinner, EditText editMaterialNameSpinner,
      EditText editProductRemark, EditText editTransportCodeSpinner,
      EditText editTransportNameSpinner, EditText edtDispatchedDate, EditText edtHiddenDiscount,
      EditText edtOpenDiscount, EditText edtPriceUnit, EditText edtQuantity,
      Spinner edtRlRequiredSpinner, Spinner edtTcRequiredSpinner, EditText edtTotalDiscount,
      EditText edtTotalPriceAfterDiscount, Spinner edtUnitSpinner, TextView lblDispatchedDate,
      TextView lblHiddenDiscount, TextView lblInspections, TextView lblMaterialCode,
      TextView lblMaterialName, TextView lblOpenDiscount, TextView lblPriceUnit,
      TextView lblProductRemark, TextView lblQuantity, TextView lblRlRequired,
      TextView lblTcRequired, TextView lblTotalDiscount, TextView lblTotalPriceAfterDiscount,
      TextView lblTransportCode, TextView lblTransportName, TextView lblUnit, ProgressBar progress,
      RelativeLayout rlMaterial, View struts) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSubmitMaterial = btnSubmitMaterial;
    this.editInspectionsSpinner = editInspectionsSpinner;
    this.editMaterialCodeSpinner = editMaterialCodeSpinner;
    this.editMaterialNameSpinner = editMaterialNameSpinner;
    this.editProductRemark = editProductRemark;
    this.editTransportCodeSpinner = editTransportCodeSpinner;
    this.editTransportNameSpinner = editTransportNameSpinner;
    this.edtDispatchedDate = edtDispatchedDate;
    this.edtHiddenDiscount = edtHiddenDiscount;
    this.edtOpenDiscount = edtOpenDiscount;
    this.edtPriceUnit = edtPriceUnit;
    this.edtQuantity = edtQuantity;
    this.edtRlRequiredSpinner = edtRlRequiredSpinner;
    this.edtTcRequiredSpinner = edtTcRequiredSpinner;
    this.edtTotalDiscount = edtTotalDiscount;
    this.edtTotalPriceAfterDiscount = edtTotalPriceAfterDiscount;
    this.edtUnitSpinner = edtUnitSpinner;
    this.lblDispatchedDate = lblDispatchedDate;
    this.lblHiddenDiscount = lblHiddenDiscount;
    this.lblInspections = lblInspections;
    this.lblMaterialCode = lblMaterialCode;
    this.lblMaterialName = lblMaterialName;
    this.lblOpenDiscount = lblOpenDiscount;
    this.lblPriceUnit = lblPriceUnit;
    this.lblProductRemark = lblProductRemark;
    this.lblQuantity = lblQuantity;
    this.lblRlRequired = lblRlRequired;
    this.lblTcRequired = lblTcRequired;
    this.lblTotalDiscount = lblTotalDiscount;
    this.lblTotalPriceAfterDiscount = lblTotalPriceAfterDiscount;
    this.lblTransportCode = lblTransportCode;
    this.lblTransportName = lblTransportName;
    this.lblUnit = lblUnit;
    this.progress = progress;
    this.rlMaterial = rlMaterial;
    this.struts = struts;
  }

  public abstract void setMaterialAddViewModel(@Nullable MaterialAddViewModel materialAddViewModel);

  @Nullable
  public MaterialAddViewModel getMaterialAddViewModel() {
    return mMaterialAddViewModel;
  }

  @NonNull
  public static ContentMaterailAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentMaterailAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentMaterailAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_materail_add, root, attachToRoot, component);
  }

  @NonNull
  public static ContentMaterailAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentMaterailAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentMaterailAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_materail_add, null, false, component);
  }

  public static ContentMaterailAddBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentMaterailAddBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentMaterailAddBinding)bind(component, view, com.itg.calderysapp.R.layout.content_materail_add);
  }
}
