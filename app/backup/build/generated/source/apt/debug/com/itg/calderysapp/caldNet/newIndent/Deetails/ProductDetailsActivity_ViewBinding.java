// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.Deetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductDetailsActivity_ViewBinding implements Unbinder {
  private ProductDetailsActivity target;

  @UiThread
  public ProductDetailsActivity_ViewBinding(ProductDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductDetailsActivity_ViewBinding(ProductDetailsActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.txtDeliveryDate = Utils.findRequiredViewAsType(source, R.id.txt_delivery_date, "field 'txtDeliveryDate'", TextView.class);
    target.lblMaterialCode = Utils.findRequiredViewAsType(source, R.id.lbl_material_code, "field 'lblMaterialCode'", TextView.class);
    target.txtMaterialCode = Utils.findRequiredViewAsType(source, R.id.txt_material_code, "field 'txtMaterialCode'", TextView.class);
    target.tblRowProduct = Utils.findRequiredViewAsType(source, R.id.tbl_row_product, "field 'tblRowProduct'", TableRow.class);
    target.lblProductRemark = Utils.findRequiredViewAsType(source, R.id.lbl_product_remark, "field 'lblProductRemark'", TextView.class);
    target.txtProductRemark = Utils.findRequiredViewAsType(source, R.id.txt_product_remark, "field 'txtProductRemark'", TextView.class);
    target.lblQuanity = Utils.findRequiredViewAsType(source, R.id.lbl_quanity, "field 'lblQuanity'", TextView.class);
    target.txtQuantity = Utils.findRequiredViewAsType(source, R.id.txt_quantity, "field 'txtQuantity'", TextView.class);
    target.lblPlantCode = Utils.findRequiredViewAsType(source, R.id.lbl_plant_code, "field 'lblPlantCode'", TextView.class);
    target.txtPlantCode = Utils.findRequiredViewAsType(source, R.id.txt_plant_code, "field 'txtPlantCode'", TextView.class);
    target.lblOpenDiscount = Utils.findRequiredViewAsType(source, R.id.lbl_open_discount, "field 'lblOpenDiscount'", TextView.class);
    target.txtOpenDiscount = Utils.findRequiredViewAsType(source, R.id.txt_open_discount, "field 'txtOpenDiscount'", TextView.class);
    target.lblHiddenDiscount = Utils.findRequiredViewAsType(source, R.id.lbl_hidden_discount, "field 'lblHiddenDiscount'", TextView.class);
    target.txtHidden = Utils.findRequiredViewAsType(source, R.id.txt_hidden, "field 'txtHidden'", TextView.class);
    target.lblUnits = Utils.findRequiredViewAsType(source, R.id.lbl_units, "field 'lblUnits'", TextView.class);
    target.txtUnits = Utils.findRequiredViewAsType(source, R.id.txt_units, "field 'txtUnits'", TextView.class);
    target.lblTransportCode = Utils.findRequiredViewAsType(source, R.id.lbl_transport_code, "field 'lblTransportCode'", TextView.class);
    target.txtTransportCode = Utils.findRequiredViewAsType(source, R.id.txt_transport_code, "field 'txtTransportCode'", TextView.class);
    target.lblTransportName = Utils.findRequiredViewAsType(source, R.id.lbl_transport_name, "field 'lblTransportName'", TextView.class);
    target.txtTransportNamr = Utils.findRequiredViewAsType(source, R.id.txt_transport_namr, "field 'txtTransportNamr'", TextView.class);
    target.lblAddTaxInfo = Utils.findRequiredViewAsType(source, R.id.lbl_add_tax_info, "field 'lblAddTaxInfo'", TextView.class);
    target.txtAddTaxInfo = Utils.findRequiredViewAsType(source, R.id.txt_add_tax_info, "field 'txtAddTaxInfo'", TextView.class);
    target.simpleTableLayout = Utils.findRequiredViewAsType(source, R.id.simpleTableLayout, "field 'simpleTableLayout'", TableLayout.class);
    target.lblInspections = Utils.findRequiredViewAsType(source, R.id.lbl_inspections, "field 'lblInspections'", TextView.class);
    target.lblTcRequired = Utils.findRequiredViewAsType(source, R.id.lbl_tc_required, "field 'lblTcRequired'", TextView.class);
    target.lblLcRequired = Utils.findRequiredViewAsType(source, R.id.lbl_lc_required, "field 'lblLcRequired'", TextView.class);
    target.txtInspections = Utils.findRequiredViewAsType(source, R.id.txt_inspections, "field 'txtInspections'", TextView.class);
    target.txtTcRequired = Utils.findRequiredViewAsType(source, R.id.txt_tc_required, "field 'txtTcRequired'", TextView.class);
    target.txtLcRequired = Utils.findRequiredViewAsType(source, R.id.txt_lc_required, "field 'txtLcRequired'", TextView.class);
    target.tblLbl = Utils.findRequiredViewAsType(source, R.id.tbl_lbl, "field 'tblLbl'", TableLayout.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", FloatingActionButton.class);
    target.txtTotalPriceAfterDiscount = Utils.findRequiredViewAsType(source, R.id.txt_total_price_after_discount, "field 'txtTotalPriceAfterDiscount'", TextView.class);
    target.txtPriceUnit = Utils.findRequiredViewAsType(source, R.id.txt_price_unit, "field 'txtPriceUnit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.txtDeliveryDate = null;
    target.lblMaterialCode = null;
    target.txtMaterialCode = null;
    target.tblRowProduct = null;
    target.lblProductRemark = null;
    target.txtProductRemark = null;
    target.lblQuanity = null;
    target.txtQuantity = null;
    target.lblPlantCode = null;
    target.txtPlantCode = null;
    target.lblOpenDiscount = null;
    target.txtOpenDiscount = null;
    target.lblHiddenDiscount = null;
    target.txtHidden = null;
    target.lblUnits = null;
    target.txtUnits = null;
    target.lblTransportCode = null;
    target.txtTransportCode = null;
    target.lblTransportName = null;
    target.txtTransportNamr = null;
    target.lblAddTaxInfo = null;
    target.txtAddTaxInfo = null;
    target.simpleTableLayout = null;
    target.lblInspections = null;
    target.lblTcRequired = null;
    target.lblLcRequired = null;
    target.txtInspections = null;
    target.txtTcRequired = null;
    target.txtLcRequired = null;
    target.tblLbl = null;
    target.fab = null;
    target.txtTotalPriceAfterDiscount = null;
    target.txtPriceUnit = null;
  }
}
