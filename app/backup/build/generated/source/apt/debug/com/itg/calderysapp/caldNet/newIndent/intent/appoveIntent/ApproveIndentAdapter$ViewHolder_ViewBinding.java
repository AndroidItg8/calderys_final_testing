// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ApproveIndentAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ApproveIndentAdapter.ViewHolder target;

  @UiThread
  public ApproveIndentAdapter$ViewHolder_ViewBinding(ApproveIndentAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.lblTitles = Utils.findRequiredViewAsType(source, R.id.lbl_titles, "field 'lblTitles'", TextView.class);
    target.txtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'txtTitles'", TextView.class);
    target.lblDate = Utils.findRequiredViewAsType(source, R.id.lbl_date, "field 'lblDate'", TextView.class);
    target.txtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'txtDate'", TextView.class);
    target.lblConsignee = Utils.findRequiredViewAsType(source, R.id.lbl_consignee, "field 'lblConsignee'", TextView.class);
    target.txtConsigneename = Utils.findRequiredViewAsType(source, R.id.txt_Cognee_name, "field 'txtConsigneename'", TextView.class);
    target.layoutTable = Utils.findRequiredViewAsType(source, R.id.layoutTable, "field 'layoutTable'", TableLayout.class);
    target.viewCenter = Utils.findRequiredView(source, R.id.viewCenter, "field 'viewCenter'");
    target.btnAcceptIndent = Utils.findRequiredViewAsType(source, R.id.btnAcceptIndent, "field 'btnAcceptIndent'", TextView.class);
    target.btnRejectIndent = Utils.findRequiredViewAsType(source, R.id.btnRejectIndent, "field 'btnRejectIndent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ApproveIndentAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lblTitles = null;
    target.txtTitles = null;
    target.lblDate = null;
    target.txtDate = null;
    target.lblConsignee = null;
    target.txtConsigneename = null;
    target.layoutTable = null;
    target.viewCenter = null;
    target.btnAcceptIndent = null;
    target.btnRejectIndent = null;
  }
}
