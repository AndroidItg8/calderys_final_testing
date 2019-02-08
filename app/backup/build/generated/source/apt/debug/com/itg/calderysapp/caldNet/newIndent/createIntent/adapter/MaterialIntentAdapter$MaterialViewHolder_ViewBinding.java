// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.createIntent.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MaterialIntentAdapter$MaterialViewHolder_ViewBinding implements Unbinder {
  private MaterialIntentAdapter.MaterialViewHolder target;

  @UiThread
  public MaterialIntentAdapter$MaterialViewHolder_ViewBinding(
      MaterialIntentAdapter.MaterialViewHolder target, View source) {
    this.target = target;

    target.lblMaterialName = Utils.findRequiredViewAsType(source, R.id.lbl_materialName, "field 'lblMaterialName'", TextView.class);
    target.txtMaterialName = Utils.findRequiredViewAsType(source, R.id.txt_materialName, "field 'txtMaterialName'", TextView.class);
    target.txtUnits = Utils.findRequiredViewAsType(source, R.id.txt_units, "field 'txtUnits'", TextView.class);
    target.lblKgTag = Utils.findRequiredViewAsType(source, R.id.lbl_kg_tag, "field 'lblKgTag'", TextView.class);
    target.lblMaterialCode = Utils.findRequiredViewAsType(source, R.id.lbl_material_code, "field 'lblMaterialCode'", TextView.class);
    target.txtMaterialCode = Utils.findRequiredViewAsType(source, R.id.txt_material_code, "field 'txtMaterialCode'", TextView.class);
    target.lblProductRemark = Utils.findRequiredViewAsType(source, R.id.lbl_product_remark, "field 'lblProductRemark'", TextView.class);
    target.lblMaterialRemark = Utils.findRequiredViewAsType(source, R.id.lbl_material_remark, "field 'lblMaterialRemark'", TextView.class);
    target.lblQuantity = Utils.findRequiredViewAsType(source, R.id.lbl_quantity, "field 'lblQuantity'", TextView.class);
    target.lblPlantCode = Utils.findRequiredViewAsType(source, R.id.lbl_plant_code, "field 'lblPlantCode'", TextView.class);
    target.lblUnits = Utils.findRequiredViewAsType(source, R.id.lbl_units, "field 'lblUnits'", TextView.class);
    target.lblPriceUnit = Utils.findRequiredViewAsType(source, R.id.lbl_price_unit, "field 'lblPriceUnit'", TextView.class);
    target.txtQuantity = Utils.findRequiredViewAsType(source, R.id.txt_quantity, "field 'txtQuantity'", TextView.class);
    target.txtPlantCode = Utils.findRequiredViewAsType(source, R.id.txt_plant_code, "field 'txtPlantCode'", TextView.class);
    target.txtPriceUnit = Utils.findRequiredViewAsType(source, R.id.txt_price_unit, "field 'txtPriceUnit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MaterialIntentAdapter.MaterialViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lblMaterialName = null;
    target.txtMaterialName = null;
    target.txtUnits = null;
    target.lblKgTag = null;
    target.lblMaterialCode = null;
    target.txtMaterialCode = null;
    target.lblProductRemark = null;
    target.lblMaterialRemark = null;
    target.lblQuantity = null;
    target.lblPlantCode = null;
    target.lblUnits = null;
    target.lblPriceUnit = null;
    target.txtQuantity = null;
    target.txtPlantCode = null;
    target.txtPriceUnit = null;
  }
}
