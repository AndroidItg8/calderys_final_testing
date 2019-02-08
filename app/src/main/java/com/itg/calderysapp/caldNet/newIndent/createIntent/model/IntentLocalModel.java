package com.itg.calderysapp.caldNet.newIndent.createIntent.model;

import android.os.Parcel;
import android.os.Parcelable;

public class IntentLocalModel implements Parcelable {
     public  String dealerName;
     public String poNumber;
     public String igst;
     public String sgst;
     public String intentType;
     public String  intentCode;
     public  String consingneeCode;
     public  String consingeeName;
     public String addTaxInfo;

     public String poDate;
     public String deliveryDate;
     public String division;
     public String ccEmailId;


    public IntentLocalModel() {
    }

    public IntentLocalModel(String dealerName, String poNumber, String igst, String sgst, String intentType, String intentCode, String consingneeCode, String consingeeName, String addTaxInfo, String poDate, String deliveryDate, String division, String ccEmailId) {

        this.dealerName = dealerName;
        this.poNumber = poNumber;
        this.igst = igst;
        this.sgst = sgst;
        this.intentType = intentType;
        this.intentCode = intentCode;
        this.consingneeCode = consingneeCode;
        this.consingeeName = consingeeName;
        this.addTaxInfo = addTaxInfo;
        this.poDate = poDate;
        this.deliveryDate = deliveryDate;
        this.division = division;
        this.ccEmailId = ccEmailId;
    }

    public String getDealerName() {

        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getIgst() {
        return igst;
    }

    public void setIgst(String igst) {
        this.igst = igst;
    }

    public String getSgst() {
        return sgst;
    }

    public void setSgst(String sgst) {
        this.sgst = sgst;
    }

    public String getIntentType() {
        return intentType;
    }

    public void setIntentType(String intentType) {
        this.intentType = intentType;
    }

    public String getIntentCode() {
        return intentCode;
    }

    public void setIntentCode(String intentCode) {
        this.intentCode = intentCode;
    }

    public String getConsingneeCode() {
        return consingneeCode;
    }

    public void setConsingneeCode(String consingneeCode) {
        this.consingneeCode = consingneeCode;
    }

    public String getConsingeeName() {
        return consingeeName;
    }

    public void setConsingeeName(String consingeeName) {
        this.consingeeName = consingeeName;
    }

    public String getAddTaxInfo() {
        return addTaxInfo;
    }

    public void setAddTaxInfo(String addTaxInfo) {
        this.addTaxInfo = addTaxInfo;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCcEmailId() {
        return ccEmailId;
    }

    public void setCcEmailId(String ccEmailId) {
        this.ccEmailId = ccEmailId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dealerName);
        dest.writeString(this.poNumber);
        dest.writeString(this.igst);
        dest.writeString(this.sgst);
        dest.writeString(this.intentType);
        dest.writeString(this.intentCode);
        dest.writeString(this.consingneeCode);
        dest.writeString(this.consingeeName);
        dest.writeString(this.addTaxInfo);
        dest.writeString(this.poDate);
        dest.writeString(this.deliveryDate);
        dest.writeString(this.division);
        dest.writeString(this.ccEmailId);
    }

    protected IntentLocalModel(Parcel in) {
        this.dealerName = in.readString();
        this.poNumber = in.readString();
        this.igst = in.readString();
        this.sgst = in.readString();
        this.intentType = in.readString();
        this.intentCode = in.readString();
        this.consingneeCode = in.readString();
        this.consingeeName = in.readString();
        this.addTaxInfo = in.readString();
        this.poDate = in.readString();
        this.deliveryDate = in.readString();
        this.division = in.readString();
        this.ccEmailId = in.readString();
    }

    public static final Parcelable.Creator<IntentLocalModel> CREATOR = new Parcelable.Creator<IntentLocalModel>() {
        @Override
        public IntentLocalModel createFromParcel(Parcel source) {
            return new IntentLocalModel(source);
        }

        @Override
        public IntentLocalModel[] newArray(int size) {
            return new IntentLocalModel[size];
        }
    };
}
