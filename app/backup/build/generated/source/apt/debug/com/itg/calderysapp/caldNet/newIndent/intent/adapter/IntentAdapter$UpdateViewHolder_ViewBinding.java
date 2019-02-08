// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntentAdapter$UpdateViewHolder_ViewBinding implements Unbinder {
  private IntentAdapter.UpdateViewHolder target;

  @UiThread
  public IntentAdapter$UpdateViewHolder_ViewBinding(IntentAdapter.UpdateViewHolder target,
      View source) {
    this.target = target;

    target.txtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'txtTitles'", TextView.class);
    target.lblTitles = Utils.findRequiredViewAsType(source, R.id.lbl_titles, "field 'lblTitles'", TextView.class);
    target.lblStatus = Utils.findRequiredViewAsType(source, R.id.lbl_status, "field 'lblStatus'", TextView.class);
    target.txtStatus = Utils.findRequiredViewAsType(source, R.id.txt_status, "field 'txtStatus'", TextView.class);
    target.lblSoNumber = Utils.findRequiredViewAsType(source, R.id.lbl_so_number, "field 'lblSoNumber'", TextView.class);
    target.txtDealerCode = Utils.findRequiredViewAsType(source, R.id.txt_dealer_code, "field 'txtDealerCode'", TextView.class);
    target.lblDelearCode = Utils.findRequiredViewAsType(source, R.id.lbl_delear_code, "field 'lblDelearCode'", TextView.class);
    target.txtSoNumber = Utils.findRequiredViewAsType(source, R.id.txt_so_number, "field 'txtSoNumber'", TextView.class);
    target.imgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'imgDelete'", ImageView.class);
    target.imgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'imgEdit'", ImageView.class);
    target.rlEdit = Utils.findRequiredViewAsType(source, R.id.rl_edit, "field 'rlEdit'", RelativeLayout.class);
    target.checkbox = Utils.findRequiredViewAsType(source, R.id.checkbox, "field 'checkbox'", AppCompatCheckBox.class);
    target.txtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'txtDate'", TextView.class);
    target.view = Utils.findRequiredView(source, R.id.view, "field 'view'");
    target.txtEdit = Utils.findRequiredViewAsType(source, R.id.txt_edit, "field 'txtEdit'", TextView.class);
    target.txtCancel = Utils.findRequiredViewAsType(source, R.id.txt_cancel, "field 'txtCancel'", TextView.class);
    target.llDetails = Utils.findRequiredViewAsType(source, R.id.ll_details, "field 'llDetails'", LinearLayout.class);
    target.progressDelete = Utils.findRequiredViewAsType(source, R.id.progress_delete, "field 'progressDelete'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntentAdapter.UpdateViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtTitles = null;
    target.lblTitles = null;
    target.lblStatus = null;
    target.txtStatus = null;
    target.lblSoNumber = null;
    target.txtDealerCode = null;
    target.lblDelearCode = null;
    target.txtSoNumber = null;
    target.imgDelete = null;
    target.imgEdit = null;
    target.rlEdit = null;
    target.checkbox = null;
    target.txtDate = null;
    target.view = null;
    target.txtEdit = null;
    target.txtCancel = null;
    target.llDetails = null;
    target.progressDelete = null;
  }
}
