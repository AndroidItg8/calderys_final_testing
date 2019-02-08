package com.itg.calderysapp.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel;

public abstract class ActivityProductListBinding extends ViewDataBinding {
  @NonNull
  public final ContentProductListBinding content;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected ProductListViewModel mProductListModel;

  protected ActivityProductListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ContentProductListBinding content, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.content = content;
    setContainedBinding(this.content);;
    this.toolbar = toolbar;
  }

  public abstract void setProductListModel(@Nullable ProductListViewModel productListModel);

  @Nullable
  public ProductListViewModel getProductListModel() {
    return mProductListModel;
  }

  @NonNull
  public static ActivityProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityProductListBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_product_list, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProductListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityProductListBinding>inflate(inflater, com.itg.calderysapp.R.layout.activity_product_list, null, false, component);
  }

  public static ActivityProductListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityProductListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityProductListBinding)bind(component, view, com.itg.calderysapp.R.layout.activity_product_list);
  }
}
