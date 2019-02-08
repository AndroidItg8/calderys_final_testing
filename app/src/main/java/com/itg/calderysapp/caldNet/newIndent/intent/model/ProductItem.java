
package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductItem implements Parcelable
{

    @SerializedName("indent_code")
    @Expose
    private String indentCode;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("product_code")
    @Expose
    private String productCode;
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

    @SerializedName("ProductDetails")
    @Expose
    private ProductDetails productDetails;
    public final static Creator<ProductItem> CREATOR = new Creator<ProductItem>() {



        @SuppressWarnings({
            "unchecked"
        })
        public ProductItem createFromParcel(Parcel in) {
            return new ProductItem(in);
        }

        public ProductItem[] newArray(int size) {
            return (new ProductItem[size]);
        }

    }
    ;

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    protected ProductItem(Parcel in) {
        this.indentCode = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((String) in.readValue((String.class.getClassLoader())));
        this.productCode = ((String) in.readValue((String.class.getClassLoader())));
        this.totalPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.units = ((String) in.readValue((String.class.getClassLoader())));
        this.openDiscount = ((String) in.readValue((String.class.getClassLoader())));
        this.hiddenDiscount = ((String) in.readValue((String.class.getClassLoader())));
        this.materialPricing = ((String) in.readValue((String.class.getClassLoader())));
        this.inspection = ((String) in.readValue((String.class.getClassLoader())));
        this.tCrequired = ((String) in.readValue((String.class.getClassLoader())));
        this.transporterCode = ((String) in.readValue((String.class.getClassLoader())));
        this.lrrequired = ((String) in.readValue((String.class.getClassLoader())));
        this.dispatchDate = ((String) in.readValue((String.class.getClassLoader())));
        this.plantCode = ((String) in.readValue((String.class.getClassLoader())));
        this.productRemarks = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProductItem() {
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
        if(productRemarks==null) {
            productRemarks = "";
            return;
        }
        this.productRemarks = productRemarks;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(indentCode);
        dest.writeValue(quantity);
        dest.writeValue(productCode);
        dest.writeValue(totalPrice);
        dest.writeValue(units);
        dest.writeValue(openDiscount);
        dest.writeValue(hiddenDiscount);
        dest.writeValue(materialPricing);
        dest.writeValue(inspection);
        dest.writeValue(tCrequired);
        dest.writeValue(transporterCode);
        dest.writeValue(lrrequired);
        dest.writeValue(dispatchDate);
        dest.writeValue(plantCode);
        dest.writeValue(productRemarks);
    }

    public int describeContents() {
        return  0;
    }

}
