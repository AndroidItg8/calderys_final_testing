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
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;

public abstract class ContentConsigneeListBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvConsigneeList;

  @Bindable
  protected ConsigneeListViewModel mConsigneeListModel;

  protected ContentConsigneeListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvConsigneeList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvConsigneeList = rvConsigneeList;
  }

  public abstract void setConsigneeListModel(@Nullable ConsigneeListViewModel consigneeListModel);

  @Nullable
  public ConsigneeListViewModel getConsigneeListModel() {
    return mConsigneeListModel;
  }

  @NonNull
  public static ContentConsigneeListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentConsigneeListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentConsigneeListBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_consignee_list, root, attachToRoot, component);
  }

  @NonNull
  public static ContentConsigneeListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentConsigneeListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentConsigneeListBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_consignee_list, null, false, component);
  }

  public static ContentConsigneeListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentConsigneeListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentConsigneeListBinding)bind(component, view, com.itg.calderysapp.R.layout.content_consignee_list);
  }
}
