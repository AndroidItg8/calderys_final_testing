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
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel;

public abstract class ContentTransportListBinding extends ViewDataBinding {
  @Bindable
  protected TransportListViewModel mTransportModel;

  protected ContentTransportListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setTransportModel(@Nullable TransportListViewModel transportModel);

  @Nullable
  public TransportListViewModel getTransportModel() {
    return mTransportModel;
  }

  @NonNull
  public static ContentTransportListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentTransportListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentTransportListBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_transport_list, root, attachToRoot, component);
  }

  @NonNull
  public static ContentTransportListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentTransportListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentTransportListBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_transport_list, null, false, component);
  }

  public static ContentTransportListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentTransportListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentTransportListBinding)bind(component, view, com.itg.calderysapp.R.layout.content_transport_list);
  }
}
