package com.itg.calderysapp.caldConnect.pds.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itg.calderysapp.caldConnect.pds.model.*;
import com.itg.calderysapp.db.table.TblProductType;


public class Datum implements Parcelable
{
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private String id;
    @ColumnInfo(name = "product_type")
    @SerializedName("product_type")
    @Expose
    private String productType;
    @ColumnInfo(name = "insert_by")
    @SerializedName("insert_by")
    @Expose
    private String insertBy;
    @ColumnInfo(name = "created")
    @SerializedName("created")
    @Expose
    private String created;
    @ColumnInfo(name="modified")
    @SerializedName("modified")
    @Expose
    private String modified;
    @ColumnInfo(name = "ip")
    @SerializedName("ip")
    @Expose
    private String ip;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
            ;

    protected Datum(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.productType = ((String) in.readValue((String.class.getClassLoader())));
        this.insertBy = ((String) in.readValue((String.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.modified = ((String) in.readValue((String.class.getClassLoader())));
        this.ip = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(productType);
        dest.writeValue(insertBy);
        dest.writeValue(created);
        dest.writeValue(modified);
        dest.writeValue(ip);
    }

    public int describeContents() {
        return  0;
    }

    public TblProductType copyData(){
        TblProductType type=new TblProductType();
        type.setId(this.id);
        type.setProductType(this.productType);
        type.setIp(this.ip);
        type.setCreated(this.created);
        type.setModified(this.modified);
        type.setInsertBy(this.insertBy);

        return type;
    }

}