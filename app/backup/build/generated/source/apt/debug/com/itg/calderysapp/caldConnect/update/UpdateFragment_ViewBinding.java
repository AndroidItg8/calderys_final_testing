// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.update;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateFragment_ViewBinding implements Unbinder {
  private UpdateFragment target;

  @UiThread
  public UpdateFragment_ViewBinding(UpdateFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.lblResult = Utils.findRequiredViewAsType(source, R.id.lbl_result, "field 'lblResult'", TextView.class);
    target.frame = Utils.findRequiredViewAsType(source, R.id.frame, "field 'frame'", FrameLayout.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.lblResult = null;
    target.frame = null;
    target.swipeRefreshLayout = null;
  }
}
