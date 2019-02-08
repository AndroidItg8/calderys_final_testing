package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.itg.calderysapp.common.CommonListener;

public class PaginationModel  {
    private String tbleName;
    private int pageNo;
    private int limit;
    private String parameter;
     private String parameter2;
     private String parameter3;
     private String parameter4;
    private String mParameter5m;


    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public String getParameter4() {
        return parameter4;
    }

    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }

    public String getTbleName() {
        return tbleName;
    }


    public void setTbleName(String tbleName) {

        this.tbleName = tbleName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }


    public PaginationModel() {
    }

    public PaginationModel(String tbleName, int pageNo, int limit, String parameter, String parameter2) {

        this.tbleName = tbleName;
        this.pageNo = pageNo;
        this.limit = limit;
        this.parameter = parameter;
        this.parameter2 = parameter2;

    }



    protected PaginationModel(Parcel in) {
        this.tbleName = in.readString();
        this.parameter = in.readString();
        this.parameter2 = in.readString();
        this.pageNo = in.readInt();
        this.limit = in.readInt();
    }


    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public void setParameter5(String parameter5) {
        mParameter5m = parameter5;
    }

    public String getParameter5() {
        return mParameter5m;
    }
}
