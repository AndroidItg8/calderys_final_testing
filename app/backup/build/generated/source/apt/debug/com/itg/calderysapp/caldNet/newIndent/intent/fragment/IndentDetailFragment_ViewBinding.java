// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IndentDetailFragment_ViewBinding implements Unbinder {
  private IndentDetailFragment target;

  @UiThread
  public IndentDetailFragment_ViewBinding(IndentDetailFragment target, View source) {
    this.target = target;

    target.mImgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'mImgDelete'", ImageView.class);
    target.mImgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'mImgEdit'", ImageView.class);
    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.mView = Utils.findRequiredView(source, R.id.view, "field 'mView'");
    target.mTxtIndentDetail = Utils.findRequiredViewAsType(source, R.id.txt_indentDetail, "field 'mTxtIndentDetail'", TextView.class);
    target.mView2 = Utils.findRequiredView(source, R.id.view2, "field 'mView2'");
    target.mLblIndentCode = Utils.findRequiredViewAsType(source, R.id.lbl_indent_code, "field 'mLblIndentCode'", TextView.class);
    target.mTxtIndentCode = Utils.findRequiredViewAsType(source, R.id.txt_indentCode, "field 'mTxtIndentCode'", TextView.class);
    target.mLblDealerCode = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_code, "field 'mLblDealerCode'", TextView.class);
    target.mTxtDealerCode = Utils.findRequiredViewAsType(source, R.id.txt_dealer_code, "field 'mTxtDealerCode'", TextView.class);
    target.mLblConsingeeCode = Utils.findRequiredViewAsType(source, R.id.lbl_consingee_code, "field 'mLblConsingeeCode'", TextView.class);
    target.mTxtConsigneeCode = Utils.findRequiredViewAsType(source, R.id.txt_consignee_code, "field 'mTxtConsigneeCode'", TextView.class);
    target.mLblSoType = Utils.findRequiredViewAsType(source, R.id.lbl_so_type, "field 'mLblSoType'", TextView.class);
    target.mTxtSoType = Utils.findRequiredViewAsType(source, R.id.txt_so_type, "field 'mTxtSoType'", TextView.class);
    target.mLblPoNumber = Utils.findRequiredViewAsType(source, R.id.lbl_po_number, "field 'mLblPoNumber'", TextView.class);
    target.mTxtPoNumber = Utils.findRequiredViewAsType(source, R.id.txt_po_number, "field 'mTxtPoNumber'", TextView.class);
    target.mLblIndentType = Utils.findRequiredViewAsType(source, R.id.lbl_indent_type, "field 'mLblIndentType'", TextView.class);
    target.mTxtIntentType = Utils.findRequiredViewAsType(source, R.id.txt_intent_type, "field 'mTxtIntentType'", TextView.class);
    target.mLblDivision = Utils.findRequiredViewAsType(source, R.id.lbl_division, "field 'mLblDivision'", TextView.class);
    target.mTxtDivision = Utils.findRequiredViewAsType(source, R.id.txt_division, "field 'mTxtDivision'", TextView.class);
    target.mLblApprovedBy = Utils.findRequiredViewAsType(source, R.id.lbl_approved_by, "field 'mLblApprovedBy'", TextView.class);
    target.mTxtApprovedBy = Utils.findRequiredViewAsType(source, R.id.txt_approved_by, "field 'mTxtApprovedBy'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IndentDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImgDelete = null;
    target.mImgEdit = null;
    target.mTxtDate = null;
    target.mView = null;
    target.mTxtIndentDetail = null;
    target.mView2 = null;
    target.mLblIndentCode = null;
    target.mTxtIndentCode = null;
    target.mLblDealerCode = null;
    target.mTxtDealerCode = null;
    target.mLblConsingeeCode = null;
    target.mTxtConsigneeCode = null;
    target.mLblSoType = null;
    target.mTxtSoType = null;
    target.mLblPoNumber = null;
    target.mTxtPoNumber = null;
    target.mLblIndentType = null;
    target.mTxtIntentType = null;
    target.mLblDivision = null;
    target.mTxtDivision = null;
    target.mLblApprovedBy = null;
    target.mTxtApprovedBy = null;
  }
}
