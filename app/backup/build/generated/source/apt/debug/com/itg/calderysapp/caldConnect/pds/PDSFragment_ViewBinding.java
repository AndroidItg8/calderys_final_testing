// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.pds;

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

public class PDSFragment_ViewBinding implements Unbinder {
  private PDSFragment target;

  @UiThread
  public PDSFragment_ViewBinding(PDSFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mLblResult = Utils.findRequiredViewAsType(source, R.id.lbl_result, "field 'mLblResult'", TextView.class);
    target.mFrame = Utils.findRequiredViewAsType(source, R.id.frame, "field 'mFrame'", FrameLayout.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PDSFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mLblResult = null;
    target.mFrame = null;
    target.swipeRefreshLayout = null;
  }
}
