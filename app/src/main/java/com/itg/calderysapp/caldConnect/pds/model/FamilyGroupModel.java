package com.itg.calderysapp.caldConnect.pds.model;

import java.util.List;

import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class FamilyGroupModel implements Parcelable
{

    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Errorcode")
    @Expose
    private Integer errorcode;
    @SerializedName("data")
    @Expose
    private List<FamilyGroupData> data = null;
    public final static Creator<FamilyGroupModel> CREATOR = new Creator<FamilyGroupModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FamilyGroupModel createFromParcel(Parcel in) {
            return new FamilyGroupModel(in);
        }

        public FamilyGroupModel[] newArray(int size) {
            return (new FamilyGroupModel[size]);
        }

    }
            ;

    protected FamilyGroupModel(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.errorcode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.data, (FamilyGroupData.class.getClassLoader()));
    }

    public FamilyGroupModel() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public List<FamilyGroupData> getData() {
        return data;
    }

    public void setData(List<FamilyGroupData> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(errorcode);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}