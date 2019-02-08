// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
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

public class AddSetting_ViewBinding implements Unbinder {
  private AddSetting target;

  @UiThread
  public AddSetting_ViewBinding(AddSetting target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddSetting_ViewBinding(AddSetting target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mLblHeading = Utils.findRequiredViewAsType(source, R.id.lbl_heading, "field 'mLblHeading'", TextView.class);
    target.mEdtDesciption = Utils.findRequiredViewAsType(source, R.id.edt_desciption, "field 'mEdtDesciption'", EditText.class);
    target.mLblRadio = Utils.findRequiredViewAsType(source, R.id.lbl_radio, "field 'mLblRadio'", TextView.class);
    target.mRdActive = Utils.findRequiredViewAsType(source, R.id.rd_active, "field 'mRdActive'", RadioButton.class);
    target.mRdDeactive = Utils.findRequiredViewAsType(source, R.id.rd_deactive, "field 'mRdDeactive'", RadioButton.class);
    target.mRgActive = Utils.findRequiredViewAsType(source, R.id.rgActive, "field 'mRgActive'", RadioGroup.class);
    target.mBtnSubmit = Utils.findRequiredViewAsType(source, R.id.btnSubmit, "field 'mBtnSubmit'", Button.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddSetting target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mLblHeading = null;
    target.mEdtDesciption = null;
    target.mLblRadio = null;
    target.mRdActive = null;
    target.mRdDeactive = null;
    target.mRgActive = null;
    target.mBtnSubmit = null;
    target.mProgress = null;
  }
}
