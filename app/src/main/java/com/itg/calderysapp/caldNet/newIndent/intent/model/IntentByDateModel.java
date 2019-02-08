package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;

public class IntentByDateModel implements Parcelable {

   private  String tbleName;
   private  String  startDate;
   private  String  endDate;
   private  String  dealerCode;
   private  String  intentCode;

    public IntentByDateModel() {
    }

    public String getTbleName() {

        return tbleName;
    }

    public void setTbleName(String tbleName) {
        this.tbleName = tbleName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getIntentCode() {
        return intentCode;
    }

    public void setIntentCode(String intentCode) {
        this.intentCode = intentCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public IntentByDateModel(String tbleName, String startDate, String endDate, String dealerCode, String intentCode, String statusCode) {

        this.tbleName = tbleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealerCode = dealerCode;
        this.intentCode = intentCode;
        this.statusCode = statusCode;
    }

    private  String  statusCode;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tbleName);
        dest.writeString(this.startDate);
        dest.writeString(this.endDate);
        dest.writeString(this.dealerCode);
        dest.writeString(this.intentCode);
        dest.writeString(this.statusCode);
    }

    protected IntentByDateModel(Parcel in) {
        this.tbleName = in.readString();
        this.startDate = in.readString();
        this.endDate = in.readString();
        this.dealerCode = in.readString();
        this.intentCode = in.readString();
        this.statusCode = in.readString();
    }

    public static final Parcelable.Creator<IntentByDateModel> CREATOR = new Parcelable.Creator<IntentByDateModel>() {
        @Override
        public IntentByDateModel createFromParcel(Parcel source) {
            return new IntentByDateModel(source);
        }

        @Override
        public IntentByDateModel[] newArray(int size) {
            return new IntentByDateModel[size];
        }
    };
}
