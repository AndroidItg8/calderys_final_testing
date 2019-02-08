package com.itg.calderysapp.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel;

public abstract class ActivityConsingeeAddBinding extends ViewDataBinding {
  @NonNull
  public final ContentConsingeeAddBinding content;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected ConsigneeViewModel mConsigneeModel;

  protected ActivityConsingeeAddBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentConsingeeAddBinding content, FloatingActionButton fab,
      Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.fab = fab;
    this.toolbar = toolbar;
  }

  public abstract void setConsigneeModel(@Nullable ConsigneeViewModel consigneeModel);

  @Nullable
  public ConsigneeViewModel getConsigneeModel() {
    return mConsigneeModel;
  }

  @NonNull
  public static ActivityConsingeeAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityConsingeeAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityConsingeeAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_consingee_add, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityConsingeeAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityConsingeeAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityConsingeeAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_consingee_add, null, false, component);
  }

  public static ActivityConsingeeAddBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityConsingeeAddBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityConsingeeAddBinding)bind(component, view, com.itg.calderysapp.R.layout.activity_consingee_add);
  }
}
