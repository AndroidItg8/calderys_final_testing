// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.mFabHome = Utils.findRequiredViewAsType(source, R.id.fab_home, "field 'mFabHome'", FloatingActionButton.class);
    target.mFrameContainer = Utils.findRequiredViewAsType(source, R.id.frame_container, "field 'mFrameContainer'", FrameLayout.class);
    target.mNavigation = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'mNavigation'", BottomNavigationView.class);
    target.mContainer = Utils.findRequiredViewAsType(source, R.id.container, "field 'mContainer'", CoordinatorLayout.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mRl = Utils.findRequiredViewAsType(source, R.id.rl, "field 'mRl'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFabHome = null;
    target.mFrameContainer = null;
    target.mNavigation = null;
    target.mContainer = null;
    target.mToolbar = null;
    target.mRl = null;
  }
}
