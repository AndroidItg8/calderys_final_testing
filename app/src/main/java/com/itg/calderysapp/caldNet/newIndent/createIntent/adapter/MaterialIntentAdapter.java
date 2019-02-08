package com.itg.calderysapp.caldNet.newIndent.createIntent.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product_;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ProductItem;
import com.itg.calderysapp.common.CommonMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.UNITS;

public class MaterialIntentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_PROGRESS = 2;
    private static final int ITEM_MAIN = 1;
    private final Context context;
    private List<Product_> models ;

    OnItemClickedListner listner;
    private static final String TAG = "MaterialIntentAdapter";

    public MaterialIntentAdapter(Context context, Product list, OnItemClickedListner listner) {

        this.context = context;
        this.models = list.getProduct();
        this.listner = listner;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_intent_material, parent, false);
        MaterialViewHolder vi = new MaterialViewHolder(view);
        return vi;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MaterialViewHolder) {
            CommonMethod.setLeftRightDrawable(((MaterialViewHolder) holder).txtPriceUnit,R.drawable.ic_rupee,0);
            ((MaterialViewHolder) holder).txtPriceUnit.setCompoundDrawablePadding(0);
            ((MaterialViewHolder) holder).txtMaterialName.setText(checkNull(models.get(position).getProductName()));
            ((MaterialViewHolder) holder).txtMaterialCode.setText(checkNull(models.get(position).getProductCode()));
            ((MaterialViewHolder) holder).lblMaterialRemark.setText(checkNull(models.get(position).getProductRemarks()));
            ((MaterialViewHolder) holder).txtPriceUnit.setText(CommonMethod.setValueKL(models.get(position).getTotalPrice()));
            ((MaterialViewHolder) holder).txtPlantCode.setText(checkNull(models.get(position).getPlantCode()));
            ((MaterialViewHolder) holder).txtQuantity.setText(checkNull(models.get(position).getQuantity()));
            Log.d(TAG, "onBindViewHolder: Units Item:"+CommonMethod.getItemValueFromXMLFile(UNITS, models.get(position).getUnits()));
            String value = CommonMethod.getItemValueFromXMLFile(UNITS, models.get(position).getUnits());
            ((MaterialViewHolder) holder).txtUnits.setText(checkNull(value));

        }
    }

    private String setRoundOff(String totalPrice) {
        if(TextUtils.isEmpty(totalPrice) )
            return " ";

        return String.format("%.2f%n",Double.valueOf(totalPrice));
    }

    private String checkNull(String productName) {
        return TextUtils.isEmpty(productName)?" ":productName;    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public interface OnItemClickedListner {
        void onItemClicked(int position, com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product_ datum);
    }

    public class MaterialViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lbl_materialName)
        TextView lblMaterialName;
        @BindView(R.id.txt_materialName)
        TextView txtMaterialName;
        @BindView(R.id.txt_units)
        TextView txtUnits;
        @BindView(R.id.lbl_kg_tag)
        TextView lblKgTag;
        @BindView(R.id.lbl_material_code)
        TextView lblMaterialCode;
        @BindView(R.id.txt_material_code)
        TextView txtMaterialCode;
        @BindView(R.id.lbl_product_remark)
        TextView lblProductRemark;
        @BindView(R.id.lbl_material_remark)
        TextView lblMaterialRemark;
        @BindView(R.id.lbl_quantity)
        TextView lblQuantity;
        @BindView(R.id.lbl_plant_code)
        TextView lblPlantCode;
        @BindView(R.id.lbl_units)
        TextView lblUnits;
        @BindView(R.id.lbl_price_unit)
        TextView lblPriceUnit;
        @BindView(R.id.txt_quantity)
        TextView txtQuantity;
        @BindView(R.id.txt_plant_code)
        TextView txtPlantCode;

        @BindView(R.id.txt_price_unit)
        TextView txtPriceUnit;


        public MaterialViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClicked(getAdapterPosition(), models.get(getAdapterPosition()));
                }
            });
        }


    }
}
