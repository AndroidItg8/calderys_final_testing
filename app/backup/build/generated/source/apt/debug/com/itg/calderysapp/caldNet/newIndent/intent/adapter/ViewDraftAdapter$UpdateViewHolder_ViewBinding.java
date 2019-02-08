// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ViewDraftAdapter$UpdateViewHolder_ViewBinding implements Unbinder {
  private ViewDraftAdapter.UpdateViewHolder target;

  @UiThread
  public ViewDraftAdapter$UpdateViewHolder_ViewBinding(ViewDraftAdapter.UpdateViewHolder target,
      View source) {
    this.target = target;

    target.mTxtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'mTxtTitles'", TextView.class);
    target.mLblTitles = Utils.findRequiredViewAsType(source, R.id.lbl_titles, "field 'mLblTitles'", TextView.class);
    target.mLblStatus = Utils.findRequiredViewAsType(source, R.id.lbl_status, "field 'mLblStatus'", TextView.class);
    target.mTxtStatus = Utils.findRequiredViewAsType(source, R.id.txt_status, "field 'mTxtStatus'", TextView.class);
    target.mImgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'mImgDelete'", ImageView.class);
    target.mProgressDelete = Utils.findRequiredViewAsType(source, R.id.progress_delete, "field 'mProgressDelete'", ProgressBar.class);
    target.mImgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'mImgEdit'", ImageView.class);
    target.mRlEdit = Utils.findRequiredViewAsType(source, R.id.rl_edit, "field 'mRlEdit'", RelativeLayout.class);
    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.mView = Utils.findRequiredView(source, R.id.view, "field 'mView'");
  }

  @Override
  @CallSuper
  public void unbind() {
    ViewDraftAdapter.UpdateViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtTitles = null;
    target.mLblTitles = null;
    target.mLblStatus = null;
    target.mTxtStatus = null;
    target.mImgDelete = null;
    target.mProgressDelete = null;
    target.mImgEdit = null;
    target.mRlEdit = null;
    target.mTxtDate = null;
    target.mView = null;
  }
}
