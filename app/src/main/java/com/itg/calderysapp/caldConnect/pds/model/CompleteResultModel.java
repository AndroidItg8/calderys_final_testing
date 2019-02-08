package com.itg.calderysapp.caldConnect.pds.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.ArrayList;
import java.util.List;

public class CompleteResultModel implements Parcelable {

    public List<TblProductType> datumList= new ArrayList<>();
    public List<TblFamilyGroup> dataList =new ArrayList<>();

    public CompleteResultModel(List<TblProductType> datumList, List<TblFamilyGroup> dataList) {

        this.datumList = datumList;
        this.dataList = dataList;
    }

    public List<TblProductType> getDatumList() {

        return datumList;
    }

    public void setDatumList(List<TblProductType> datumList) {
        this.datumList = datumList;
    }

    public List<TblFamilyGroup> getDataList() {
        return dataList;
    }

    public void setDataList(List<TblFamilyGroup> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.datumList);
        dest.writeList(this.dataList);
    }

    public CompleteResultModel() {
    }

    protected CompleteResultModel(Parcel in) {
        this.datumList = new ArrayList<TblProductType>();
        in.readList(this.datumList, TblProductType.class.getClassLoader());
        this.dataList = new ArrayList<TblFamilyGroup>();
        in.readList(this.dataList, TblFamilyGroup.class.getClassLoader());
    }

    public static final Creator<CompleteResultModel> CREATOR = new Creator<CompleteResultModel>() {
        @Override
        public CompleteResultModel createFromParcel(Parcel source) {
            return new CompleteResultModel(source);
        }

        @Override
        public CompleteResultModel[] newArray(int size) {
            return new CompleteResultModel[size];
        }
    };
}
