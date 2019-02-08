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
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel;

public abstract class ActivityCreateIntentBinding extends ViewDataBinding {
  @NonNull
  public final ContentCreateIntentBinding content;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected CreateIndentViewModel mCreateIndentModel;

  @Bindable
  protected SpinnerViewModel mSpinnerModel;

  protected ActivityCreateIntentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentCreateIntentBinding content, FloatingActionButton fab,
      Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.fab = fab;
    this.toolbar = toolbar;
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
  public static ActivityCreateIntentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCreateIntentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCreateIntentBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_create_intent, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCreateIntentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCreateIntentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCreateIntentBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_create_intent, null, false, component);
  }

  public static ActivityCreateIntentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityCreateIntentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityCreateIntentBinding)bind(component, view, com.itg.calderysapp.R.layout.activity_create_intent);
  }
}
