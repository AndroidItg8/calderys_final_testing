// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntentFragment_ViewBinding implements Unbinder {
  private IntentFragment target;

  @UiThread
  public IntentFragment_ViewBinding(IntentFragment target, View source) {
    this.target = target;

    target.mTabs = Utils.findRequiredViewAsType(source, R.id.tabs, "field 'mTabs'", TabLayout.class);
    target.mViewpagerFragment = Utils.findRequiredViewAsType(source, R.id.viewpagerFragment, "field 'mViewpagerFragment'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTabs = null;
    target.mViewpagerFragment = null;
  }
}
