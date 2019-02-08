
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product_ implements Parcelable {

    @SerializedName("indent_code")
    @Expose
    private String indentCode;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("ProductName")
    @Expose
    private String productName;
    @SerializedName("total_price")
    @Expose
    private String totalPrice;
    @SerializedName("Units")
    @Expose
    private String units;
    @SerializedName("OpenDiscount")
    @Expose
    private String openDiscount;
    @SerializedName("HiddenDiscount")
    @Expose
    private String hiddenDiscount;
    @SerializedName("material_Pricing")
    @Expose
    private String materialPricing;
    @SerializedName("Inspection")
    @Expose
    private String inspection;
    @SerializedName("TCrequired")
    @Expose
    private String tCrequired;
    @SerializedName("TransporterCode")
    @Expose
    private String transporterCode;

    private String transporterName;
    @SerializedName("lrrequired")
    @Expose
    private String lrrequired;
    @SerializedName("Dispatch_date")
    @Expose
    private String dispatchDate;
    @SerializedName("PlantCode")
    @Expose
    private String plantCode;
    @SerializedName("ProductRemarks")
    @Expose
    private String productRemarks;
    @SerializedName("productMaster")
    @Expose
    private Object productMaster;
    @SerializedName("TransportMaster")
    @Expose
    private Object transportMaster;

    public Product_() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getIndentCode() {
        return indentCode;
    }

    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getOpenDiscount() {
        return openDiscount;
    }

    public void setOpenDiscount(String openDiscount) {
        this.openDiscount = openDiscount;
    }

    public String getHiddenDiscount() {
        return hiddenDiscount;
    }

    public void setHiddenDiscount(String hiddenDiscount) {
        this.hiddenDiscount = hiddenDiscount;
    }

    public String getMaterialPricing() {
        return materialPricing;
    }

    public void setMaterialPricing(String materialPricing) {
        this.materialPricing = materialPricing;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getTCrequired() {
        return tCrequired;
    }

    public void setTCrequired(String tCrequired) {
        this.tCrequired = tCrequired;
    }

    public String getTransporterCode() {
        return transporterCode;
    }

    public void setTransporterCode(String transporterCode) {
        this.transporterCode = transporterCode;
    }

    public String getLrrequired() {
        return lrrequired;
    }

    public void setLrrequired(String lrrequired) {
        this.lrrequired = lrrequired;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getProductRemarks() {
        return productRemarks;
    }

    public void setProductRemarks(String productRemarks) {
        this.productRemarks = productRemarks;
    }

    public Object getProductMaster() {
        return productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }

    public Object getTransportMaster() {
        return transportMaster;
    }

    public void setTransportMaster(TransportMaster transportMaster) {
        this.transportMaster = transportMaster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.indentCode);
        dest.writeString(this.quantity);
        dest.writeString(this.productCode);
        dest.writeString(this.productName);
        dest.writeString(this.totalPrice);
        dest.writeString(this.units);
        dest.writeString(this.openDiscount);
        dest.writeString(this.hiddenDiscount);
        dest.writeString(this.materialPricing);
        dest.writeString(this.inspection);
        dest.writeString(this.tCrequired);
        dest.writeString(this.transporterCode);
        dest.writeString(this.transporterName);
        dest.writeString(this.lrrequired);
        dest.writeString(this.dispatchDate);
        dest.writeString(this.plantCode);
        dest.writeString(this.productRemarks);
    }

    protected Product_(Parcel in) {
        this.indentCode = in.readString();
        this.quantity = in.readString();
        this.productCode = in.readString();
        this.productName = in.readString();
        this.totalPrice = in.readString();
        this.units = in.readString();
        this.openDiscount = in.readString();
        this.hiddenDiscount = in.readString();
        this.materialPricing = in.readString();
        this.inspection = in.readString();
        this.tCrequired = in.readString();
        this.transporterCode = in.readString();
        this.transporterName = in.readString();
        this.lrrequired = in.readString();
        this.dispatchDate = in.readString();
        this.plantCode = in.readString();
        this.productRemarks = in.readString();
        this.productMaster = in.readParcelable(Object.class.getClassLoader());
        this.transportMaster = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Creator<Product_> CREATOR = new Creator<Product_>() {
        @Override
        public Product_ createFromParcel(Parcel source) {
            return new Product_(source);
        }

        @Override
        public Product_[] newArray(int size) {
            return new Product_[size];
        }
    };
}
