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
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel;

public abstract class ContentProductListBinding extends ViewDataBinding {
  @Bindable
  protected ProductListViewModel mProductListModel;

  protected ContentProductListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setProductListModel(@Nullable ProductListViewModel productListModel);

  @Nullable
  public ProductListViewModel getProductListModel() {
    return mProductListModel;
  }

  @NonNull
  public static ContentProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentProductListBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_product_list, root, attachToRoot, component);
  }

  @NonNull
  public static ContentProductListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ContentProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ContentProductListBinding>inflate(inflater, com.itg.calderysapp.R.layout.content_product_list, null, false, component);
  }

  public static ContentProductListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ContentProductListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ContentProductListBinding)bind(component, view, com.itg.calderysapp.R.layout.content_product_list);
  }
}
