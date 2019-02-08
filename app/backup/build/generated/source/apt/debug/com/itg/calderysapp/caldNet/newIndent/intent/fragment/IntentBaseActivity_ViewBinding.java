// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntentBaseActivity_ViewBinding implements Unbinder {
  private IntentBaseActivity target;

  @UiThread
  public IntentBaseActivity_ViewBinding(IntentBaseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IntentBaseActivity_ViewBinding(IntentBaseActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mBaseContainer = Utils.findRequiredViewAsType(source, R.id.base_container, "field 'mBaseContainer'", FrameLayout.class);
    target.mFab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'mFab'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntentBaseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mBaseContainer = null;
    target.mFab = null;
  }
}
