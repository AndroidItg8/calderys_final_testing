// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.common;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProgressViewHolder_ViewBinding implements Unbinder {
  private ProgressViewHolder target;

  @UiThread
  public ProgressViewHolder_ViewBinding(ProgressViewHolder target, View source) {
    this.target = target;

    target.progress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProgressViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progress = null;
  }
}
