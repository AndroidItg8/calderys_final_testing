// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mRdCalderysConnect = Utils.findRequiredViewAsType(source, R.id.rd_calderys_connect, "field 'mRdCalderysConnect'", RadioButton.class);
    target.mRdCalderysNet = Utils.findRequiredViewAsType(source, R.id.rd_calderys_net, "field 'mRdCalderysNet'", RadioButton.class);
    target.mRdCalderysGroup = Utils.findRequiredViewAsType(source, R.id.rdCalderysGroup, "field 'mRdCalderysGroup'", RadioGroup.class);
    target.mTxtLogin = Utils.findRequiredViewAsType(source, R.id.txtLogin, "field 'mTxtLogin'", TextView.class);
    target.mEdtEmail = Utils.findRequiredViewAsType(source, R.id.edt_email, "field 'mEdtEmail'", EditText.class);
    target.mEdtPassword = Utils.findRequiredViewAsType(source, R.id.edt_password, "field 'mEdtPassword'", EditText.class);
    target.mBtnLogin = Utils.findRequiredViewAsType(source, R.id.btn_login, "field 'mBtnLogin'", Button.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mFab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'mFab'", FloatingActionButton.class);
    target.mCoordinator = Utils.findRequiredViewAsType(source, R.id.coordinator, "field 'mCoordinator'", CoordinatorLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mRdCalderysConnect = null;
    target.mRdCalderysNet = null;
    target.mRdCalderysGroup = null;
    target.mTxtLogin = null;
    target.mEdtEmail = null;
    target.mEdtPassword = null;
    target.mBtnLogin = null;
    target.mProgress = null;
    target.mFab = null;
    target.mCoordinator = null;
  }
}
