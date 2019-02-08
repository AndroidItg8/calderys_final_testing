// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingFragment_ViewBinding implements Unbinder {
  private SettingFragment target;

  @UiThread
  public SettingFragment_ViewBinding(SettingFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mRdSuccessStories = Utils.findRequiredViewAsType(source, R.id.rd_success_stories, "field 'mRdSuccessStories'", RadioButton.class);
    target.mRdImportantMessage = Utils.findRequiredViewAsType(source, R.id.rd_important_message, "field 'mRdImportantMessage'", RadioButton.class);
    target.mRdCalderysGroup = Utils.findRequiredViewAsType(source, R.id.rdCalderysGroup, "field 'mRdCalderysGroup'", RadioGroup.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mLblCreate = Utils.findRequiredViewAsType(source, R.id.lbl_create, "field 'mLblCreate'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mRdSuccessStories = null;
    target.mRdImportantMessage = null;
    target.mRdCalderysGroup = null;
    target.mProgress = null;
    target.mLblCreate = null;
  }
}
