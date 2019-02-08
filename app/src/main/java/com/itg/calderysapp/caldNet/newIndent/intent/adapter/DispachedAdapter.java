package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DispachedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_PROGRESS = 2;
    private static final int ITEM_MAIN = 1;
    private final Context context;
    private final List<DispachedModel> models;



    public DispachedAdapter(Context context, List<DispachedModel> list) {

        this.context = context;
        this.models = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) == null)
            return ITEM_PROGRESS;
        else
            return ITEM_MAIN;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == ITEM_MAIN) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_dispached, parent, false);
            UpdateViewHolder vi = new UpdateViewHolder(view);
            return vi;

        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpdateViewHolder) {


//            ((UpdateViewHolder) holder).mTxtDate.setText((models.get(position).getSONumber()));
//            ((UpdateViewHolder) holder).mTxtDate.setText((models.get(position).getInvoiceDate()));
//            ((UpdateViewHolder) holder).mTxtSO.setText((models.get(position).getSODate()));


            ((UpdateViewHolder) holder).txtPoNumber.setText(checkNull(models.get(position).getPONumber()));
            ((UpdateViewHolder) holder).txtProductCode.setText(checkNull(models.get(position).getProductCode()));
            ((UpdateViewHolder) holder).txtInvoiceCode.setText(checkNull(models.get(position).getInvoiceNumber()));
            ((UpdateViewHolder) holder).txtInvoiceAmt.setText(checkNull(String.valueOf(models.get(position).getInvoiceAmount())));
            ((UpdateViewHolder) holder).txtSoNumber.setText(checkNull(models.get(position).getSONumber()));
//                ((UpdateViewHolder) holder).mTxtSoQty.setText(String.valueOf(models.get(position).getSOQuantity()));

            ((UpdateViewHolder) holder).txtDispachQty.setText(checkNull(String.valueOf(models.get(position).getDispatchQuantity())));
            ((UpdateViewHolder) holder).txtBalanceQty.setText(checkNull(String.valueOf(models.get(position).getBalanceQuantity())));
            ((UpdateViewHolder) holder).txtSoQty.setText(checkNull(String.valueOf(models.get(position).getSOQuantity())));
            ((UpdateViewHolder) holder).txtTransport.setText(checkNull(models.get(position).getTransporterName()));
            ((UpdateViewHolder) holder).txtTrackNo.setText(checkNull(models.get(position).getTruckno()));
            ((UpdateViewHolder) holder).txtLrDetails.setText(checkNull(models.get(position).getLRDetails()));


        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }
    }

    private String checkNull(String value) {
        return TextUtils.isEmpty(value)?"":value;
    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public void addItems(List<DispachedModel> o) {

        models.addAll(o);
        notifyDataSetChanged();

    }

    public void addFooter() {
        models.add(null);
        notifyItemInserted(models.size() - 1);
    }

    public void removeFooter() {
        if (models.size() > 0) {
            final int itemRemoved = models.size() - 1;
            models.remove(itemRemoved);
            notifyItemRemoved(itemRemoved);
            notifyItemRangeChanged(itemRemoved, models.size());
        }
    }

    public void clearData() {
        models.clear();
        notifyDataSetChanged();
    }


//    public interface OnItemClickedListner {
//        void onItemClicked(int position, IndentModel model, int from);
//        void onItemClickedDispatched(int position, IndentModel model, int from);
//    }

    public class UpdateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lbl_product_code)
        TextView lblProductCode;
        @BindView(R.id.txt_product_code)
        TextView txtProductCode;
        @BindView(R.id.tbl_row_product)
        TableRow tblRowProduct;
        @BindView(R.id.lbl_invoice_number)
        TextView lblInvoiceNumber;
        @BindView(R.id.txt_invoice_code)
        TextView txtInvoiceCode;
        @BindView(R.id.tbl_row_invoice_number)
        TableRow tblRowInvoiceNumber;
        @BindView(R.id.lbl_invoic_amt)
        TextView lblInvoicAmt;
        @BindView(R.id.txt_invoice_amt)
        TextView txtInvoiceAmt;
        @BindView(R.id.tbl_row_invoice_amt)
        TableRow tblRowInvoiceAmt;
        @BindView(R.id.lbl_so_number)
        TextView lblSoNumber;
        @BindView(R.id.txt_so_number)
        TextView txtSoNumber;
        @BindView(R.id.lbl_po_number)
        TextView lblPoNumber;
        @BindView(R.id.txt_po_number)
        TextView txtPoNumber;
        @BindView(R.id.lbl_transport_name)
        TextView lblTransportName;
        @BindView(R.id.txt_transport)
        TextView txtTransport;
        @BindView(R.id.lbl_truck_number)
        TextView lblTruckNumber;
        @BindView(R.id.txt_track_no)
        TextView txtTrackNo;
        @BindView(R.id.lbl_lr_detais)
        TextView lblLrDetais;
        @BindView(R.id.txt_lr_details)
        TextView txtLrDetails;
        @BindView(R.id.lbl_dispached_qty)
        TextView lblDispachedQty;
        @BindView(R.id.txt_so_qty)
        TextView txtSoQty;
        @BindView(R.id.lbl_So_qty)
        TextView lblSoQty;
        @BindView(R.id.txt_dispach_qty)
        TextView txtDispachQty;
        @BindView(R.id.lbl_balance_qty)
        TextView lblBalanceQty;
        @BindView(R.id.txt_balance_qty)
        TextView txtBalanceQty;
        @BindView(R.id.simpleTableLayout)
        TableLayout simpleTableLayout;


        public UpdateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }
}
