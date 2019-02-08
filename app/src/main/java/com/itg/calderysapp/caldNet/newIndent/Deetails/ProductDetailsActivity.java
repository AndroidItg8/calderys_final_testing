package com.itg.calderysapp.caldNet.newIndent.Deetails;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product_;
import com.itg.calderysapp.common.CommonMethod;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.UNITS;

public class ProductDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_delivery_date)
    TextView txtDeliveryDate;
    @BindView(R.id.lbl_material_code)
    TextView lblMaterialCode;
    @BindView(R.id.txt_material_code)
    TextView txtMaterialCode;
    @BindView(R.id.tbl_row_product)
    TableRow tblRowProduct;
    @BindView(R.id.lbl_product_remark)
    TextView lblProductRemark;
    @BindView(R.id.txt_product_remark)
    TextView txtProductRemark;
    @BindView(R.id.lbl_quanity)
    TextView lblQuanity;
    @BindView(R.id.txt_quantity)
    TextView txtQuantity;
    @BindView(R.id.lbl_plant_code)
    TextView lblPlantCode;
    @BindView(R.id.txt_plant_code)
    TextView txtPlantCode;
    @BindView(R.id.lbl_open_discount)
    TextView lblOpenDiscount;
    @BindView(R.id.txt_open_discount)
    TextView txtOpenDiscount;
    @BindView(R.id.lbl_hidden_discount)
    TextView lblHiddenDiscount;
    @BindView(R.id.txt_hidden)
    TextView txtHidden;
    @BindView(R.id.lbl_units)
    TextView lblUnits;
    @BindView(R.id.txt_units)
    TextView txtUnits;
    @BindView(R.id.lbl_transport_code)
    TextView lblTransportCode;
    @BindView(R.id.txt_transport_code)
    TextView txtTransportCode;
    @BindView(R.id.lbl_transport_name)
    TextView lblTransportName;
    @BindView(R.id.txt_transport_namr)
    TextView txtTransportNamr;
    @BindView(R.id.lbl_add_tax_info)
    TextView lblAddTaxInfo;
    @BindView(R.id.txt_add_tax_info)
    TextView txtAddTaxInfo;
    @BindView(R.id.simpleTableLayout)
    TableLayout simpleTableLayout;
    @BindView(R.id.lbl_inspections)
    TextView lblInspections;
    @BindView(R.id.lbl_tc_required)
    TextView lblTcRequired;
    @BindView(R.id.lbl_lc_required)
    TextView lblLcRequired;
    @BindView(R.id.txt_inspections)
    TextView txtInspections;
    @BindView(R.id.txt_tc_required)
    TextView txtTcRequired;
    @BindView(R.id.txt_lc_required)
    TextView txtLcRequired;
    @BindView(R.id.tbl_lbl)
    TableLayout tblLbl;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.txt_total_price_after_discount)
    TextView txtTotalPriceAfterDiscount;
    @BindView(R.id.txt_price_unit)
    TextView txtPriceUnit;
    @BindView(R.id.txt_indent_code)
    TextView txtIndentCode;
    @BindView(R.id.tbl_inspsction)
    TableRow tblInspsction;
    @BindView(R.id.lbl_total_price_after_discount)
    TextView lblTotalPriceAfterDiscount;
    @BindView(R.id.lbl_price_unit)
    TextView lblPriceUnit;
    private Product_ productItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setDrawableLeftRight();
        checkIntent();

    }

    private void setDrawableLeftRight() {
        CommonMethod.setLeftRightDrawable(txtPriceUnit, R.drawable.ic_rupee, 0);
        CommonMethod.setLeftRightDrawable(txtTotalPriceAfterDiscount, R.drawable.ic_rupee, 0);
        CommonMethod.setLeftRightDrawable(txtDeliveryDate, R.drawable.ic_date, 0);
    }

    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_PRODUCT)) {
            productItem = getIntent().getParcelableExtra(CommonMethod.FROM_PRODUCT);
            setItemsAll(productItem);
        }
    }

    private void setItemsAll(Product_ productIte) {
        getSupportActionBar().setTitle(productIte.getProductName());
        txtDeliveryDate.setText(checkNullItem(CommonMethod.getDDMMYYYYfromDateServerForField(productIte.getDispatchDate())));
        txtUnits.setText(checkNullItem(productIte.getUnits()));
        txtQuantity.setText(checkNullItem(productIte.getQuantity()));
        txtPlantCode.setText(checkNullItem(productIte.getPlantCode()));
        txtMaterialCode.setText(productIte.getProductCode());
        txtIndentCode.setText(productIte.getIndentCode());
        txtHidden.setText(checkNullItem(productIte.getHiddenDiscount()));
        txtOpenDiscount.setText(productIte.getOpenDiscount());
        txtPriceUnit.setText(checkNullItem(productIte.getMaterialPricing()));
        txtInspections.setText(getInspectData(productIte.getInspection()));
        txtProductRemark.setText(checkNullItem(productIte.getProductRemarks()));
        txtUnits.setText(checkNullItem(CommonMethod.getItemValueFromXMLFile(UNITS, productIte.getUnits())));
        txtLcRequired.setText(getInspectData(productIte.getLrrequired()));
        txtTcRequired.setText(getInspectData(productIte.getTCrequired()));
        txtTransportCode.setText(checkNullItem((productIte.getTransporterCode())));
        txtTotalPriceAfterDiscount.setText(checkNullItem(productIte.getTotalPrice()));
        txtTransportNamr.setText(checkNullItem(productIte.getTransporterName()));
        txtTotalPriceAfterDiscount.setText(checkNullItem(productIte.getTotalPrice()));


    }

    private String checkNullItem(String units) {
        return units != null ? units : "";
    }

    private String getInspectData(String inspection) {
        return inspection.equalsIgnoreCase("1") ? "Yes" : "No";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
