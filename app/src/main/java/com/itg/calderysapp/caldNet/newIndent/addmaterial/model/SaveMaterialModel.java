package com.itg.calderysapp.caldNet.newIndent.addmaterial.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.itg.calderysapp.BR;


import com.google.gson.annotations.SerializedName;


public class SaveMaterialModel extends BaseObservable implements Parcelable {


    @SerializedName("material_Pricing")
    private String materialPricing;

    @SerializedName("quantity")
    private String quantity;

    @SerializedName("lrrequired")
    private String lrrequired;

    @SerializedName("total_price")
    private String totalPrice;

    @SerializedName("Inspection")
    private String inspection;

    @SerializedName("product_code")
    private String productCode;

    @SerializedName("PlantCode")
    private String plantCode;

    @SerializedName("Units")
    private String units;

    @SerializedName("OpenDiscount")
    private String openDiscount;

    @SerializedName("indent_code")
    private String indentCode;

    @SerializedName("HiddenDiscount")
    private String hiddenDiscount;

    @SerializedName("Dispatch_date")
    private String dispatchDate;

    @SerializedName("TransporterCode")
    private String transporterCode;

    @SerializedName("TCrequired")
    private String tCrequired;

    @SerializedName("ProductRemarks")
    private String productRemarks;

    private String materialName;
    private String transporterName;
    private String totalDiscount;

    @Bindable
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
        notifyPropertyChanged(BR.materialName);
    }

    public void setMaterialPricing(String materialPricing) {
        this.materialPricing = materialPricing;
        calculateTotalPrice();
        notifyPropertyChanged(BR.materialPricing);
    }

    @Bindable
    public String getMaterialPricing() {
        return materialPricing;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
        calculateTotalPrice();
    }


    public String getQuantity() {
        return quantity;
    }

    public void setLrrequired(String lrrequired) {
        this.lrrequired = lrrequired;
    }

    public String getLrrequired() {
        return lrrequired;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
        notifyPropertyChanged(BR.totalPrice);
    }

    @Bindable
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getInspection() {
        return inspection;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
        notifyPropertyChanged(BR.productCode);
    }

    @Bindable
    public String getProductCode() {
        return productCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setUnits(String units) {
        this.units = units;
        notifyPropertyChanged(BR.units);
    }

    @Bindable
    public String getUnits() {
        return units;
    }

    public void setOpenDiscount(String openDiscount) {
        this.openDiscount = openDiscount;
        calculateTotalPrice();
    }

    public String getOpenDiscount() {
        return openDiscount;
    }

    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
    }

    public String getIndentCode() {
        return indentCode;
    }

    public void setHiddenDiscount(String hiddenDiscount) {
        this.hiddenDiscount = hiddenDiscount;
        calculateTotalPrice();
    }

    public String getHiddenDiscount() {
        return hiddenDiscount;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
        notifyPropertyChanged(BR.dispatchDate);
    }

    @Bindable
    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setTransporterCode(String transporterCode) {
        this.transporterCode = transporterCode;
        notifyPropertyChanged(BR.transporterCode);
    }

    @Bindable
    public String getTransporterCode() {
        return transporterCode;
    }

    public void setTCrequired(String tCrequired) {
        this.tCrequired = tCrequired;
    }

    public String getTCrequired() {
        return tCrequired;
    }

    public void setProductRemarks(String productRemarks) {
        this.productRemarks = productRemarks;
    }

    public String getProductRemarks() {
        return productRemarks;
    }

    @Override
    public String toString() {
        return
                "SaveMaterialModel{" +
                        "material_Pricing = '" + materialPricing + '\'' +
                        ",quantity = '" + quantity + '\'' +
                        ",lrrequired = '" + lrrequired + '\'' +
                        ",total_price = '" + totalPrice + '\'' +
                        ",inspection = '" + inspection + '\'' +
                        ",product_code = '" + productCode + '\'' +
                        ",plantCode = '" + plantCode + '\'' +
                        ",units = '" + units + '\'' +
                        ",openDiscount = '" + openDiscount + '\'' +
                        ",indent_code = '" + indentCode + '\'' +
                        ",hiddenDiscount = '" + hiddenDiscount + '\'' +
                        ",dispatch_date = '" + dispatchDate + '\'' +
                        ",transporterCode = '" + transporterCode + '\'' +
                        ",tCrequired = '" + tCrequired + '\'' +
                        ",productRemarks = '" + productRemarks + '\'' +
                        "}";
    }


    private void calculateTotalPrice() {
        float totalDiscount = checkNull(getOpenDiscount()) + checkNull(getHiddenDiscount());
        float actualPrice = checkNull(getMaterialPricing()) * checkNull(getQuantity());
        double finalDiscount = calculateDiscount(totalDiscount, actualPrice);
        setTotalDiscount(String.valueOf(totalDiscount));
        setTotalPrice(String.valueOf(finalDiscount));
    }

    private float calculateDiscount(float dis, float totalPrice) {
        float s = 100 - dis;

        return (s * totalPrice) / 100;
    }

    private float checkNull(String val) {
        if (TextUtils.isEmpty(val))
            return 0;
        return Float.parseFloat(val);
    }


    private double setTotalPrice()
    {

      return   round(Double.parseDouble(totalPrice), 2);

//        String.format("%.2f", Integer.totalPrice);
//      float t =  power(Float.MAX_VALUE, 2);
//
//      return t;


    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


    public SaveMaterialModel() {
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
        notifyPropertyChanged(BR.transporterName);
    }

    @Bindable
    public String getTransporterName() {
        return transporterName;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
       // calculateTotalPrice();
        notifyPropertyChanged(BR.totalDiscount);
    }

    @Bindable
    public String getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.materialPricing);
        dest.writeString(this.quantity);
        dest.writeString(this.lrrequired);
        dest.writeString(this.totalPrice);
        dest.writeString(this.inspection);
        dest.writeString(this.productCode);
        dest.writeString(this.plantCode);
        dest.writeString(this.units);
        dest.writeString(this.openDiscount);
        dest.writeString(this.indentCode);
        dest.writeString(this.hiddenDiscount);
        dest.writeString(this.dispatchDate);
        dest.writeString(this.transporterCode);
        dest.writeString(this.tCrequired);
        dest.writeString(this.productRemarks);
        dest.writeString(this.materialName);
        dest.writeString(this.transporterName);
        dest.writeString(this.totalDiscount);
    }

    protected SaveMaterialModel(Parcel in) {
        this.materialPricing = in.readString();
        this.quantity = in.readString();
        this.lrrequired = in.readString();
        this.totalPrice = in.readString();
        this.inspection = in.readString();
        this.productCode = in.readString();
        this.plantCode = in.readString();
        this.units = in.readString();
        this.openDiscount = in.readString();
        this.indentCode = in.readString();
        this.hiddenDiscount = in.readString();
        this.dispatchDate = in.readString();
        this.transporterCode = in.readString();
        this.tCrequired = in.readString();
        this.productRemarks = in.readString();
        this.materialName = in.readString();
        this.transporterName = in.readString();
        this.totalDiscount = in.readString();
    }

    public static final Creator<SaveMaterialModel> CREATOR = new Creator<SaveMaterialModel>() {
        @Override
        public SaveMaterialModel createFromParcel(Parcel source) {
            return new SaveMaterialModel(source);
        }

        @Override
        public SaveMaterialModel[] newArray(int size) {
            return new SaveMaterialModel[size];
        }
    };
}