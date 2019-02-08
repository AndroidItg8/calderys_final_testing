
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Indents implements Parcelable
{

    @SerializedName("indent_code")
    @Expose
    private String indentCode;
    @SerializedName("dealer_code")
    @Expose
    private String dealerCode;
    @SerializedName("indent_date")
    @Expose
    private String indentDate;
    @SerializedName("PONumber")
    @Expose
    private String pONumber;
    @SerializedName("PODate")
    @Expose
    private String pODate;
    @SerializedName("CST")
    @Expose
    private String cST;
    @SerializedName("ConsigneeCode")
    @Expose
    private String consigneeCode;
    @SerializedName("Excise_Duty")
    @Expose
    private String exciseDuty;
    @SerializedName("ind_apprvl_status")
    @Expose
    private String indApprvlStatus;
    @SerializedName("SO_Type")
    @Expose
    private String sOType;
    @SerializedName("Status_date")
    @Expose
    private String statusDate;
    @SerializedName("VAT")
    @Expose
    private String vAT;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("ModifiedDate")
    @Expose
    private String modifiedDate;
    @SerializedName("Approvedby")
    @Expose
    private String approvedby;
    @SerializedName("SO_number")
    @Expose
    private String sONumber;
    @SerializedName("SO_Date")
    @Expose
    private String sODate;
    @SerializedName("Comments")
    @Expose
    private String comments;
    @SerializedName("DispatchDate")
    @Expose
    private String dispatchDate;
    @SerializedName("IndentType")
    @Expose
    private String indentType;
    @SerializedName("Division")
    @Expose
    private String division;
    @SerializedName("AddlTax")
    @Expose
    private String addlTax;
    @SerializedName("consignee")
    @Expose
    private Object consignee;

    @SerializedName("ConsigneeName")
    private String consigneeName;
    @SerializedName("plant")
    @Expose
    private Object plant;
    private String plantName;
    @SerializedName("product")
    @Expose
    private Object product;
    @SerializedName("PlantCode")
    @Expose
    private String plantCode;

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Indents() {
    }

    public String getIndentCode() {
        return indentCode;
    }

    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getIndentDate() {
        return indentDate;
    }

    public void setIndentDate(String indentDate) {
        this.indentDate = indentDate;
    }

    public String getPONumber() {
        return pONumber;
    }

    public void setPONumber(String pONumber) {
        this.pONumber = pONumber;
    }

    public String getPODate() {
        return pODate;
    }

    public void setPODate(String pODate) {
        this.pODate = pODate;
    }

    public String getCST() {
        return cST;
    }

    public void setCST(String cST) {
        this.cST = cST;
    }

    public String getConsigneeCode() {
        return consigneeCode;
    }

    public void setConsigneeCode(String consigneeCode) {
        this.consigneeCode = consigneeCode;
    }

    public String getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(String exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public String getIndApprvlStatus() {
        return indApprvlStatus;
    }

    public void setIndApprvlStatus(String indApprvlStatus) {
        this.indApprvlStatus = indApprvlStatus;
    }

    public String getSOType() {
        return sOType;
    }

    public void setSOType(String sOType) {
        this.sOType = sOType;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getVAT() {
        return vAT;
    }

    public void setVAT(String vAT) {
        this.vAT = vAT;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public String getSONumber() {
        return sONumber;
    }

    public void setSONumber(String sONumber) {
        this.sONumber = sONumber;
    }

    public String getSODate() {
        return sODate;
    }

    public void setSODate(String sODate) {
        this.sODate = sODate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getIndentType() {
        return indentType;
    }

    public void setIndentType(String indentType) {
        this.indentType = indentType;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAddlTax() {
        return addlTax;
    }

    public void setAddlTax(String addlTax) {
        this.addlTax = addlTax;
    }

    public Object getConsignee() {
        return consignee;
    }

    public void setConsignee(Consignee consignee) {
        this.consignee = consignee;
    }

    public Object getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.indentCode);
        dest.writeString(this.dealerCode);
        dest.writeString(this.indentDate);
        dest.writeString(this.pONumber);
        dest.writeString(this.pODate);
        dest.writeString(this.cST);
        dest.writeString(this.consigneeCode);
        dest.writeString(this.exciseDuty);
        dest.writeString(this.indApprvlStatus);
        dest.writeString(this.sOType);
        dest.writeString(this.statusDate);
        dest.writeString(this.vAT);
        dest.writeString(this.createdDate);
        dest.writeString(this.modifiedDate);
        dest.writeString(this.approvedby);
        dest.writeString(this.sONumber);
        dest.writeString(this.sODate);
        dest.writeString(this.comments);
        dest.writeString(this.dispatchDate);
        dest.writeString(this.indentType);
        dest.writeString(this.division);
        dest.writeString(this.addlTax);
        dest.writeString(this.consigneeName);
        dest.writeString(this.plantName);
        dest.writeParcelable((Parcelable) this.product, flags);
    }

    protected Indents(Parcel in) {
        this.indentCode = in.readString();
        this.dealerCode = in.readString();
        this.indentDate = in.readString();
        this.pONumber = in.readString();
        this.pODate = in.readString();
        this.cST = in.readString();
        this.consigneeCode = in.readString();
        this.exciseDuty = in.readString();
        this.indApprvlStatus = in.readString();
        this.sOType = in.readString();
        this.statusDate = in.readString();
        this.vAT = in.readString();
        this.createdDate = in.readString();
        this.modifiedDate = in.readString();
        this.approvedby = in.readString();
        this.sONumber = in.readString();
        this.sODate = in.readString();
        this.comments = in.readString();
        this.dispatchDate = in.readString();
        this.indentType = in.readString();
        this.division = in.readString();
        this.addlTax = in.readString();
        this.consignee = in.readParcelable(Object.class.getClassLoader());
        this.consigneeName = in.readString();
        this.plant = in.readParcelable(Object.class.getClassLoader());
        this.plantName = in.readString();
        this.product = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Creator<Indents> CREATOR = new Creator<Indents>() {
        @Override
        public Indents createFromParcel(Parcel source) {
            return new Indents(source);
        }

        @Override
        public Indents[] newArray(int size) {
            return new Indents[size];
        }
    };

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getPlantCode() {
        return plantCode;
    }
}
