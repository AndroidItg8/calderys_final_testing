// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.Deetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
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

    target.lblIntentsDetails = Utils.findRequiredViewAsType(source, R.id.lbl_intents_details, "field 'lblIntentsDetails'", TextView.class);
    target.lblIndentCode = Utils.findRequiredViewAsType(source, R.id.lbl_indent_code, "field 'lblIndentCode'", TextView.class);
    target.txtIndentCode = Utils.findRequiredViewAsType(source, R.id.txt_indent_code, "field 'txtIndentCode'", TextView.class);
    target.tblRowProduct = Utils.findRequiredViewAsType(source, R.id.tbl_row_product, "field 'tblRowProduct'", TableRow.class);
    target.lblIndentStatus = Utils.findRequiredViewAsType(source, R.id.lbl_indent_status, "field 'lblIndentStatus'", TextView.class);
    target.txtIndentStatus = Utils.findRequiredViewAsType(source, R.id.txt_indent_status, "field 'txtIndentStatus'", TextView.class);
    target.lblDealerName = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_name, "field 'lblDealerName'", TextView.class);
    target.txtDealerName = Utils.findRequiredViewAsType(source, R.id.txt_dealer_name, "field 'txtDealerName'", TextView.class);
    target.txtConsigneeCode = Utils.findRequiredViewAsType(source, R.id.txt_consignee_code, "field 'txtConsigneeCode'", TextView.class);
    target.lblIndentDate = Utils.findRequiredViewAsType(source, R.id.lbl_indent_date, "field 'lblIndentDate'", TextView.class);
    target.txtIndentDate = Utils.findRequiredViewAsType(source, R.id.txt_indent_date, "field 'txtIndentDate'", TextView.class);
    target.lblPoNumber = Utils.findRequiredViewAsType(source, R.id.lbl_po_number, "field 'lblPoNumber'", TextView.class);
    target.txtPoNumber = Utils.findRequiredViewAsType(source, R.id.txt_po_number, "field 'txtPoNumber'", TextView.class);
    target.lblPoDate = Utils.findRequiredViewAsType(source, R.id.lbl_po_date, "field 'lblPoDate'", TextView.class);
    target.txtPoDate = Utils.findRequiredViewAsType(source, R.id.txt_po_date, "field 'txtPoDate'", TextView.class);
    target.lblIgst = Utils.findRequiredViewAsType(source, R.id.lbl_igst, "field 'lblIgst'", TextView.class);
    target.txtIgst = Utils.findRequiredViewAsType(source, R.id.txt_igst, "field 'txtIgst'", TextView.class);
    target.lblSgst = Utils.findRequiredViewAsType(source, R.id.lbl_sgst, "field 'lblSgst'", TextView.class);
    target.txtSgst = Utils.findRequiredViewAsType(source, R.id.txt_sgst, "field 'txtSgst'", TextView.class);
    target.lblConsigneeName = Utils.findRequiredViewAsType(source, R.id.lbl_consignee_name, "field 'lblConsigneeName'", TextView.class);
    target.txtConsigneeName = Utils.findRequiredViewAsType(source, R.id.txt_consignee_name, "field 'txtConsigneeName'", TextView.class);
    target.lblDeliveryDate = Utils.findRequiredViewAsType(source, R.id.lbl_Delivery_date, "field 'lblDeliveryDate'", TextView.class);
    target.txtDeliveryDate = Utils.findRequiredViewAsType(source, R.id.txt_delivery_date, "field 'txtDeliveryDate'", TextView.class);
    target.lblAddTaxInfo = Utils.findRequiredViewAsType(source, R.id.lbl_add_tax_info, "field 'lblAddTaxInfo'", TextView.class);
    target.txtAddTaxInfo = Utils.findRequiredViewAsType(source, R.id.txt_add_tax_info, "field 'txtAddTaxInfo'", TextView.class);
    target.simpleTableLayout = Utils.findRequiredViewAsType(source, R.id.simpleTableLayout, "field 'simpleTableLayout'", TableLayout.class);
    target.rlIndents = Utils.findRequiredViewAsType(source, R.id.rl_indents, "field 'rlIndents'", RelativeLayout.class);
    target.lblProductDetails = Utils.findRequiredViewAsType(source, R.id.lbl_product_details, "field 'lblProductDetails'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
    target.rlMaterial = Utils.findRequiredViewAsType(source, R.id.rl_material, "field 'rlMaterial'", RelativeLayout.class);
    target.lblSoDetails = Utils.findRequiredViewAsType(source, R.id.lbl_so_details, "field 'lblSoDetails'", TextView.class);
    target.struts = Utils.findRequiredView(source, R.id.struts, "field 'struts'");
    target.lblSoType = Utils.findRequiredViewAsType(source, R.id.lbl_so_type, "field 'lblSoType'", TextView.class);
    target.soTypeSpinner = Utils.findRequiredViewAsType(source, R.id.so_type_spinner, "field 'soTypeSpinner'", Spinner.class);
    target.lblSalesOffice = Utils.findRequiredViewAsType(source, R.id.lbl_sales_office, "field 'lblSalesOffice'", TextView.class);
    target.salesSpinner = Utils.findRequiredViewAsType(source, R.id.sales_spinner, "field 'salesSpinner'", Spinner.class);
    target.lblDistributionChannel = Utils.findRequiredViewAsType(source, R.id.lbl_distribution_channel, "field 'lblDistributionChannel'", TextView.class);
    target.edtDestributionChannel = Utils.findRequiredViewAsType(source, R.id.edt_destribution_channel, "field 'edtDestributionChannel'", EditText.class);
    target.lblUsageIndicator = Utils.findRequiredViewAsType(source, R.id.lbl_usage_indicator, "field 'lblUsageIndicator'", TextView.class);
    target.usagaSpinner = Utils.findRequiredViewAsType(source, R.id.usaga_spinner, "field 'usagaSpinner'", Spinner.class);
    target.lblProcessCode = Utils.findRequiredViewAsType(source, R.id.lbl_process_code, "field 'lblProcessCode'", TextView.class);
    target.processCodeSpinner = Utils.findRequiredViewAsType(source, R.id.process_code_spinner, "field 'processCodeSpinner'", Spinner.class);
    target.lblDevision = Utils.findRequiredViewAsType(source, R.id.lbl_devision, "field 'lblDevision'", TextView.class);
    target.edtDevision = Utils.findRequiredViewAsType(source, R.id.edt_devision, "field 'edtDevision'", EditText.class);
    target.lblSalesOrganization = Utils.findRequiredViewAsType(source, R.id.lbl_sales_organization, "field 'lblSalesOrganization'", TextView.class);
    target.edtSalesOrganization = Utils.findRequiredViewAsType(source, R.id.edt_sales_organization, "field 'edtSalesOrganization'", EditText.class);
    target.lblEquipment = Utils.findRequiredViewAsType(source, R.id.lbl_equipment, "field 'lblEquipment'", TextView.class);
    target.equipmentSpinner = Utils.findRequiredViewAsType(source, R.id.equipment_spinner, "field 'equipmentSpinner'", Spinner.class);
    target.lblSplProcessIndicator = Utils.findRequiredViewAsType(source, R.id.lbl_spl_process_indicator, "field 'lblSplProcessIndicator'", TextView.class);
    target.splProcessIndicatorSpinner = Utils.findRequiredViewAsType(source, R.id.spl_process_indicator_spinner, "field 'splProcessIndicatorSpinner'", Spinner.class);
    target.lblPartner = Utils.findRequiredViewAsType(source, R.id.lbl_partner, "field 'lblPartner'", TextView.class);
    target.edtPartner = Utils.findRequiredViewAsType(source, R.id.edt_partner, "field 'edtPartner'", EditText.class);
    target.lblSalesGrp = Utils.findRequiredViewAsType(source, R.id.lbl_sales_grp, "field 'lblSalesGrp'", TextView.class);
    target.salesGroupSpinner = Utils.findRequiredViewAsType(source, R.id.sales_group_spinner, "field 'salesGroupSpinner'", Spinner.class);
    target.lblSalesPackage = Utils.findRequiredViewAsType(source, R.id.lbl_sales_package, "field 'lblSalesPackage'", TextView.class);
    target.salesPackageSpinner = Utils.findRequiredViewAsType(source, R.id.sales_package_spinner, "field 'salesPackageSpinner'", Spinner.class);
    target.lblApproveReject = Utils.findRequiredViewAsType(source, R.id.lbl_approve_reject, "field 'lblApproveReject'", TextView.class);
    target.lblCommentForApproved = Utils.findRequiredViewAsType(source, R.id.lbl_comment_for_approved, "field 'lblCommentForApproved'", TextView.class);
    target.edtApprovedReject = Utils.findRequiredViewAsType(source, R.id.edt_approved_reject, "field 'edtApprovedReject'", EditText.class);
    target.btnApprove = Utils.findRequiredViewAsType(source, R.id.btnApprove, "field 'btnApprove'", Button.class);
    target.progress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progress'", ProgressBar.class);
    target.btnReject = Utils.findRequiredViewAsType(source, R.id.btnReject, "field 'btnReject'", Button.class);
    target.rlApprovedReject = Utils.findRequiredViewAsType(source, R.id.rl_approved_reject, "field 'rlApprovedReject'", RelativeLayout.class);
    target.nestedScrolling = Utils.findRequiredViewAsType(source, R.id.nestedScrolling, "field 'nestedScrolling'", NestedScrollView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IndentDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lblIntentsDetails = null;
    target.lblIndentCode = null;
    target.txtIndentCode = null;
    target.tblRowProduct = null;
    target.lblIndentStatus = null;
    target.txtIndentStatus = null;
    target.lblDealerName = null;
    target.txtDealerName = null;
    target.txtConsigneeCode = null;
    target.lblIndentDate = null;
    target.txtIndentDate = null;
    target.lblPoNumber = null;
    target.txtPoNumber = null;
    target.lblPoDate = null;
    target.txtPoDate = null;
    target.lblIgst = null;
    target.txtIgst = null;
    target.lblSgst = null;
    target.txtSgst = null;
    target.lblConsigneeName = null;
    target.txtConsigneeName = null;
    target.lblDeliveryDate = null;
    target.txtDeliveryDate = null;
    target.lblAddTaxInfo = null;
    target.txtAddTaxInfo = null;
    target.simpleTableLayout = null;
    target.rlIndents = null;
    target.lblProductDetails = null;
    target.recyclerView = null;
    target.rlMaterial = null;
    target.lblSoDetails = null;
    target.struts = null;
    target.lblSoType = null;
    target.soTypeSpinner = null;
    target.lblSalesOffice = null;
    target.salesSpinner = null;
    target.lblDistributionChannel = null;
    target.edtDestributionChannel = null;
    target.lblUsageIndicator = null;
    target.usagaSpinner = null;
    target.lblProcessCode = null;
    target.processCodeSpinner = null;
    target.lblDevision = null;
    target.edtDevision = null;
    target.lblSalesOrganization = null;
    target.edtSalesOrganization = null;
    target.lblEquipment = null;
    target.equipmentSpinner = null;
    target.lblSplProcessIndicator = null;
    target.splProcessIndicatorSpinner = null;
    target.lblPartner = null;
    target.edtPartner = null;
    target.lblSalesGrp = null;
    target.salesGroupSpinner = null;
    target.lblSalesPackage = null;
    target.salesPackageSpinner = null;
    target.lblApproveReject = null;
    target.lblCommentForApproved = null;
    target.edtApprovedReject = null;
    target.btnApprove = null;
    target.progress = null;
    target.btnReject = null;
    target.rlApprovedReject = null;
    target.nestedScrolling = null;
  }
}
