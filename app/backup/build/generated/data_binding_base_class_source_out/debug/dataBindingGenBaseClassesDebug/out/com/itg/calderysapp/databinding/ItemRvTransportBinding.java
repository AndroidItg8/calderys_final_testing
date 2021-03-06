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
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel;

public abstract class ItemRvTransportBinding extends ViewDataBinding {
  @NonNull
  public final TextView lblDealerCode;

  @NonNull
  public final TextView lblDealerName;

  @NonNull
  public final TextView txtDealerCode;

  @NonNull
  public final TextView txtDealerName;

  @Bindable
  protected TransportItemViewModel mTransportModel;

  protected ItemRvTransportBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView lblDealerCode, TextView lblDealerName, TextView txtDealerCode,
      TextView txtDealerName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lblDealerCode = lblDealerCode;
    this.lblDealerName = lblDealerName;
    this.txtDealerCode = txtDealerCode;
    this.txtDealerName = txtDealerName;
  }

  public abstract void setTransportModel(@Nullable TransportItemViewModel transportModel);

  @Nullable
  public TransportItemViewModel getTransportModel() {
    return mTransportModel;
  }

  @NonNull
  public static ItemRvTransportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRvTransportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRvTransportBinding>inflate(inflater, com.itg.calderysapp.R.layout.item_rv_transport, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRvTransportBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRvTransportBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRvTransportBinding>inflate(inflater, com.itg.calderysapp.R.layout.item_rv_transport, null, false, component);
  }

  public static ItemRvTransportBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemRvTransportBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemRvTransportBinding)bind(component, view, com.itg.calderysapp.R.layout.item_rv_transport);
  }
}
