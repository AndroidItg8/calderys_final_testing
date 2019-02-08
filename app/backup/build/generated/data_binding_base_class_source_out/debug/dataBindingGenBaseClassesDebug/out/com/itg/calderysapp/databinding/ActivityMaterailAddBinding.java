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
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel;

public abstract class ActivityMaterailAddBinding extends ViewDataBinding {
  @NonNull
  public final ContentMaterailAddBinding content;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected MaterialAddViewModel mMaterialAddViewModel;

  protected ActivityMaterailAddBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentMaterailAddBinding content, FloatingActionButton fab,
      Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.fab = fab;
    this.toolbar = toolbar;
  }

  public abstract void setMaterialAddViewModel(@Nullable MaterialAddViewModel materialAddViewModel);

  @Nullable
  public MaterialAddViewModel getMaterialAddViewModel() {
    return mMaterialAddViewModel;
  }

  @NonNull
  public static ActivityMaterailAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMaterailAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMaterailAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_materail_add, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMaterailAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMaterailAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMaterailAddBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_materail_add, null, false, component);
  }

  public static ActivityMaterailAddBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMaterailAddBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMaterailAddBinding)bind(component, view, com.itg.calderysapp.R.layout.activity_materail_add);
  }
}
