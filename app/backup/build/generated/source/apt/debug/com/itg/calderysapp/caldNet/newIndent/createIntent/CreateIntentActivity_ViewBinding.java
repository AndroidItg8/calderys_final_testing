// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.createIntent;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CreateIntentActivity_ViewBinding implements Unbinder {
  private CreateIntentActivity target;

  @UiThread
  public CreateIntentActivity_ViewBinding(CreateIntentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreateIntentActivity_ViewBinding(CreateIntentActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mHeaderItemText = Utils.findRequiredViewAsType(source, R.id.headerItemText, "field 'mHeaderItemText'", TextView.class);
    target.mLblDealerName = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_name, "field 'mLblDealerName'", TextView.class);
    target.mEditDealerName = Utils.findRequiredViewAsType(source, R.id.editDealerName, "field 'mEditDealerName'", EditText.class);
    target.mLblPoNumber = Utils.findRequiredViewAsType(source, R.id.lbl_Po_Number, "field 'mLblPoNumber'", TextView.class);
    target.mEdtPoNumber = Utils.findRequiredViewAsType(source, R.id.edtPoNumber, "field 'mEdtPoNumber'", EditText.class);
    target.mStrut = Utils.findRequiredView(source, R.id.strut, "field 'mStrut'");
    target.mLblIgst = Utils.findRequiredViewAsType(source, R.id.lbl_igst, "field 'mLblIgst'", TextView.class);
    target.mEdtIgstSpinner = Utils.findRequiredViewAsType(source, R.id.edt_igst, "field 'mEdtIgstSpinner'", Spinner.class);
    target.mLblSgstCgst = Utils.findRequiredViewAsType(source, R.id.lbl_sgst_cgst, "field 'mLblSgstCgst'", TextView.class);
    target.mEdtSgstCgstSpinner = Utils.findRequiredViewAsType(source, R.id.edt_sgst_cgst, "field 'mEdtSgstCgstSpinner'", Spinner.class);
    target.mLblIntentType = Utils.findRequiredViewAsType(source, R.id.lbl_intent_type, "field 'mLblIntentType'", TextView.class);
    target.mEdtIntentTypeSpinner = Utils.findRequiredViewAsType(source, R.id.edtIntentTypeSpinner, "field 'mEdtIntentTypeSpinner'", Spinner.class);
    target.mLblPlantCode = Utils.findRequiredViewAsType(source, R.id.lbl_plant_code, "field 'mLblPlantCode'", TextView.class);
    target.mEdtPlantCodeSpinner = Utils.findRequiredViewAsType(source, R.id.edtPlantCodeSpinner, "field 'mEdtPlantCodeSpinner'", Spinner.class);
    target.mLblConstiteCode = Utils.findRequiredViewAsType(source, R.id.lbl_constite_code, "field 'mLblConstiteCode'", TextView.class);
    target.mLblNameConsingee = Utils.findRequiredViewAsType(source, R.id.lbl_name_consingee, "field 'mLblNameConsingee'", TextView.class);
    target.mEdtConsingee = Utils.findRequiredViewAsType(source, R.id.edtConsingee, "field 'mEdtConsingee'", EditText.class);
    target.mEdtAddConsingee = Utils.findRequiredViewAsType(source, R.id.edtAddConsingee, "field 'mEdtAddConsingee'", EditText.class);
    target.mLblTaxInfo = Utils.findRequiredViewAsType(source, R.id.lbl_tax_info, "field 'mLblTaxInfo'", TextView.class);
    target.mEdtTaxInfo = Utils.findRequiredViewAsType(source, R.id.edtTaxInfo, "field 'mEdtTaxInfo'", EditText.class);
    target.mLblPoDate = Utils.findRequiredViewAsType(source, R.id.lbl_po_date, "field 'mLblPoDate'", TextView.class);
    target.mEdtPODate = Utils.findRequiredViewAsType(source, R.id.edtPODate, "field 'mEdtPODate'", EditText.class);
    target.mLblDeliveryDate = Utils.findRequiredViewAsType(source, R.id.lbl_delivery_date, "field 'mLblDeliveryDate'", TextView.class);
    target.mEdtDeliveryDate = Utils.findRequiredViewAsType(source, R.id.edtDeliveryDate, "field 'mEdtDeliveryDate'", EditText.class);
    target.mLblDivision = Utils.findRequiredViewAsType(source, R.id.lbl_division, "field 'mLblDivision'", TextView.class);
    target.mEdtDivisionSpinner = Utils.findRequiredViewAsType(source, R.id.edtDivision, "field 'mEdtDivisionSpinner'", Spinner.class);
    target.mLblConsingeeName = Utils.findRequiredViewAsType(source, R.id.lbl_consingee_name, "field 'mLblConsingeeName'", TextView.class);
    target.mEdtConsingeeName = Utils.findRequiredViewAsType(source, R.id.edtConsingeeName, "field 'mEdtConsingeeName'", EditText.class);
    target.mLblCcEmailId = Utils.findRequiredViewAsType(source, R.id.lbl_cc_email_id, "field 'mLblCcEmailId'", TextView.class);
    target.mEdtCCEMailId = Utils.findRequiredViewAsType(source, R.id.edtCCEMailId, "field 'mEdtCCEMailId'", EditText.class);
    target.mBtnSubmit = Utils.findRequiredViewAsType(source, R.id.btnSubmit, "field 'mBtnSubmit'", Button.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mProgressEdit = Utils.findRequiredViewAsType(source, R.id.progressEdit, "field 'mProgressEdit'", ProgressBar.class);
    target.mFab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'mFab'", FloatingActionButton.class);
    target.mLlEdit = Utils.findRequiredViewAsType(source, R.id.ll_edit, "field 'mLlEdit'", LinearLayout.class);
    target.btnApprove = Utils.findRequiredViewAsType(source, R.id.btnApprove, "field 'btnApprove'", Button.class);
    target.btnReject = Utils.findRequiredViewAsType(source, R.id.btnReject, "field 'btnReject'", Button.class);
    target.llApproveReject = Utils.findRequiredViewAsType(source, R.id.llApproveReject, "field 'llApproveReject'", LinearLayout.class);
    target.mBtnAddConsignee = Utils.findRequiredViewAsType(source, R.id.btn_add_consignee, "field 'mBtnAddConsignee'", Button.class);
    target.mBtnAddMaterial = Utils.findRequiredViewAsType(source, R.id.btn_add_material, "field 'mBtnAddMaterial'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CreateIntentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mHeaderItemText = null;
    target.mLblDealerName = null;
    target.mEditDealerName = null;
    target.mLblPoNumber = null;
    target.mEdtPoNumber = null;
    target.mStrut = null;
    target.mLblIgst = null;
    target.mEdtIgstSpinner = null;
    target.mLblSgstCgst = null;
    target.mEdtSgstCgstSpinner = null;
    target.mLblIntentType = null;
    target.mEdtIntentTypeSpinner = null;
    target.mLblPlantCode = null;
    target.mEdtPlantCodeSpinner = null;
    target.mLblConstiteCode = null;
    target.mLblNameConsingee = null;
    target.mEdtConsingee = null;
    target.mEdtAddConsingee = null;
    target.mLblTaxInfo = null;
    target.mEdtTaxInfo = null;
    target.mLblPoDate = null;
    target.mEdtPODate = null;
    target.mLblDeliveryDate = null;
    target.mEdtDeliveryDate = null;
    target.mLblDivision = null;
    target.mEdtDivisionSpinner = null;
    target.mLblConsingeeName = null;
    target.mEdtConsingeeName = null;
    target.mLblCcEmailId = null;
    target.mEdtCCEMailId = null;
    target.mBtnSubmit = null;
    target.mRecyclerView = null;
    target.mProgressEdit = null;
    target.mFab = null;
    target.mLlEdit = null;
    target.btnApprove = null;
    target.btnReject = null;
    target.llApproveReject = null;
    target.mBtnAddConsignee = null;
    target.mBtnAddMaterial = null;
  }
}
