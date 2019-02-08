// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DispachedAdapter$UpdateViewHolder_ViewBinding implements Unbinder {
  private DispachedAdapter.UpdateViewHolder target;

  @UiThread
  public DispachedAdapter$UpdateViewHolder_ViewBinding(DispachedAdapter.UpdateViewHolder target,
      View source) {
    this.target = target;

    target.lblProductCode = Utils.findRequiredViewAsType(source, R.id.lbl_product_code, "field 'lblProductCode'", TextView.class);
    target.txtProductCode = Utils.findRequiredViewAsType(source, R.id.txt_product_code, "field 'txtProductCode'", TextView.class);
    target.tblRowProduct = Utils.findRequiredViewAsType(source, R.id.tbl_row_product, "field 'tblRowProduct'", TableRow.class);
    target.lblInvoiceNumber = Utils.findRequiredViewAsType(source, R.id.lbl_invoice_number, "field 'lblInvoiceNumber'", TextView.class);
    target.txtInvoiceCode = Utils.findRequiredViewAsType(source, R.id.txt_invoice_code, "field 'txtInvoiceCode'", TextView.class);
    target.tblRowInvoiceNumber = Utils.findRequiredViewAsType(source, R.id.tbl_row_invoice_number, "field 'tblRowInvoiceNumber'", TableRow.class);
    target.lblInvoicAmt = Utils.findRequiredViewAsType(source, R.id.lbl_invoic_amt, "field 'lblInvoicAmt'", TextView.class);
    target.txtInvoiceAmt = Utils.findRequiredViewAsType(source, R.id.txt_invoice_amt, "field 'txtInvoiceAmt'", TextView.class);
    target.tblRowInvoiceAmt = Utils.findRequiredViewAsType(source, R.id.tbl_row_invoice_amt, "field 'tblRowInvoiceAmt'", TableRow.class);
    target.lblSoNumber = Utils.findRequiredViewAsType(source, R.id.lbl_so_number, "field 'lblSoNumber'", TextView.class);
    target.txtSoNumber = Utils.findRequiredViewAsType(source, R.id.txt_so_number, "field 'txtSoNumber'", TextView.class);
    target.lblPoNumber = Utils.findRequiredViewAsType(source, R.id.lbl_po_number, "field 'lblPoNumber'", TextView.class);
    target.txtPoNumber = Utils.findRequiredViewAsType(source, R.id.txt_po_number, "field 'txtPoNumber'", TextView.class);
    target.lblTransportName = Utils.findRequiredViewAsType(source, R.id.lbl_transport_name, "field 'lblTransportName'", TextView.class);
    target.txtTransport = Utils.findRequiredViewAsType(source, R.id.txt_transport, "field 'txtTransport'", TextView.class);
    target.lblTruckNumber = Utils.findRequiredViewAsType(source, R.id.lbl_truck_number, "field 'lblTruckNumber'", TextView.class);
    target.txtTrackNo = Utils.findRequiredViewAsType(source, R.id.txt_track_no, "field 'txtTrackNo'", TextView.class);
    target.lblLrDetais = Utils.findRequiredViewAsType(source, R.id.lbl_lr_detais, "field 'lblLrDetais'", TextView.class);
    target.txtLrDetails = Utils.findRequiredViewAsType(source, R.id.txt_lr_details, "field 'txtLrDetails'", TextView.class);
    target.lblDispachedQty = Utils.findRequiredViewAsType(source, R.id.lbl_dispached_qty, "field 'lblDispachedQty'", TextView.class);
    target.txtSoQty = Utils.findRequiredViewAsType(source, R.id.txt_so_qty, "field 'txtSoQty'", TextView.class);
    target.lblSoQty = Utils.findRequiredViewAsType(source, R.id.lbl_So_qty, "field 'lblSoQty'", TextView.class);
    target.txtDispachQty = Utils.findRequiredViewAsType(source, R.id.txt_dispach_qty, "field 'txtDispachQty'", TextView.class);
    target.lblBalanceQty = Utils.findRequiredViewAsType(source, R.id.lbl_balance_qty, "field 'lblBalanceQty'", TextView.class);
    target.txtBalanceQty = Utils.findRequiredViewAsType(source, R.id.txt_balance_qty, "field 'txtBalanceQty'", TextView.class);
    target.simpleTableLayout = Utils.findRequiredViewAsType(source, R.id.simpleTableLayout, "field 'simpleTableLayout'", TableLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DispachedAdapter.UpdateViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lblProductCode = null;
    target.txtProductCode = null;
    target.tblRowProduct = null;
    target.lblInvoiceNumber = null;
    target.txtInvoiceCode = null;
    target.tblRowInvoiceNumber = null;
    target.lblInvoicAmt = null;
    target.txtInvoiceAmt = null;
    target.tblRowInvoiceAmt = null;
    target.lblSoNumber = null;
    target.txtSoNumber = null;
    target.lblPoNumber = null;
    target.txtPoNumber = null;
    target.lblTransportName = null;
    target.txtTransport = null;
    target.lblTruckNumber = null;
    target.txtTrackNo = null;
    target.lblLrDetais = null;
    target.txtLrDetails = null;
    target.lblDispachedQty = null;
    target.txtSoQty = null;
    target.lblSoQty = null;
    target.txtDispachQty = null;
    target.lblBalanceQty = null;
    target.txtBalanceQty = null;
    target.simpleTableLayout = null;
  }
}
