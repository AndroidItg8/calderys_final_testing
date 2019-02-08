
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Consignee_ implements Parcelable
{

    @SerializedName("DealerCode")
    @Expose
    private String dealerCode;
    @SerializedName("ConsigneeCode")
    @Expose
    private String consigneeCode;
    @SerializedName("ConsigneeName")
    @Expose
    private String consigneeName;
    @SerializedName("ConsigneeAddress")
    @Expose
    private String consigneeAddress;
    @SerializedName("ConsigneeECCNo")
    @Expose
    private String consigneeECCNo;
    @SerializedName("ConsigneeCSTNo")
    @Expose
    private String consigneeCSTNo;
    @SerializedName("ConsigneeTINNo")
    @Expose
    private String consigneeTINNo;
    public final static Creator<Consignee_> CREATOR = new Creator<Consignee_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Consignee_ createFromParcel(Parcel in) {
            return new Consignee_(in);
        }

        public Consignee_[] newArray(int size) {
            return (new Consignee_[size]);
        }

    }
    ;

    protected Consignee_(Parcel in) {
        this.dealerCode = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeCode = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeName = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeECCNo = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeCSTNo = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeTINNo = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Consignee_() {
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getConsigneeCode() {
        return consigneeCode;
    }

    public void setConsigneeCode(String consigneeCode) {
        this.consigneeCode = consigneeCode;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneeECCNo() {
        return consigneeECCNo;
    }

    public void setConsigneeECCNo(String consigneeECCNo) {
        this.consigneeECCNo = consigneeECCNo;
    }

    public String getConsigneeCSTNo() {
        return consigneeCSTNo;
    }

    public void setConsigneeCSTNo(String consigneeCSTNo) {
        this.consigneeCSTNo = consigneeCSTNo;
    }

    public String getConsigneeTINNo() {
        return consigneeTINNo;
    }

    public void setConsigneeTINNo(String consigneeTINNo) {
        this.consigneeTINNo = consigneeTINNo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dealerCode);
        dest.writeValue(consigneeCode);
        dest.writeValue(consigneeName);
        dest.writeValue(consigneeAddress);
        dest.writeValue(consigneeECCNo);
        dest.writeValue(consigneeCSTNo);
        dest.writeValue(consigneeTINNo);
    }

    public int describeContents() {
        return  0;
    }

}
