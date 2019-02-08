// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyIntentFragment_ViewBinding implements Unbinder {
  private MyIntentFragment target;

  @UiThread
  public MyIntentFragment_ViewBinding(MyIntentFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mImgNo = Utils.findRequiredViewAsType(source, R.id.img_no, "field 'mImgNo'", ImageView.class);
    target.mTxtNoData = Utils.findRequiredViewAsType(source, R.id.txt_no_data, "field 'mTxtNoData'", TextView.class);
    target.mRlNoData = Utils.findRequiredViewAsType(source, R.id.rlNoData, "field 'mRlNoData'", RelativeLayout.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyIntentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mImgNo = null;
    target.mTxtNoData = null;
    target.mRlNoData = null;
    target.swipeRefreshLayout = null;
  }
}