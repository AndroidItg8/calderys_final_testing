// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.Deetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ViewDetailsActivity_ViewBinding implements Unbinder {
  private ViewDetailsActivity target;

  @UiThread
  public ViewDetailsActivity_ViewBinding(ViewDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ViewDetailsActivity_ViewBinding(ViewDetailsActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.frameContainer = Utils.findRequiredViewAsType(source, R.id.frame_container, "field 'frameContainer'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ViewDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.frameContainer = null;
  }
}
