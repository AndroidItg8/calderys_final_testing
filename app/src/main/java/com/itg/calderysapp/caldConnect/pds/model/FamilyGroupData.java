package com.itg.calderysapp.caldConnect.pds.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;


public class FamilyGroupData implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("group_name")
    @Expose
    private String groupName;
    @SerializedName("insert_by")
    @Expose
    private String insertBy;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("ip")
    @Expose
    private String ip;

    public final static Creator<FamilyGroupData> CREATOR = new Creator<FamilyGroupData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FamilyGroupData createFromParcel(Parcel in) {
            return new FamilyGroupData(in);
        }

        public FamilyGroupData[] newArray(int size) {
            return (new FamilyGroupData[size]);
        }

    }
            ;

    protected FamilyGroupData(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.groupName = ((String) in.readValue((String.class.getClassLoader())));
        this.insertBy = ((String) in.readValue((String.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.modified = ((String) in.readValue((String.class.getClassLoader())));
        this.ip = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FamilyGroupData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        dest.writeValue(groupName);
        dest.writeValue(insertBy);
        dest.writeValue(created);
        dest.writeValue(modified);
        dest.writeValue(ip);
    }

    public int describeContents() {
        return  0;
    }

    public TblFamilyGroup copyData(){
        TblFamilyGroup type=new TblFamilyGroup();
        type.setId(this.id);
        type.setGroupName(this.groupName);
        type.setIp(this.ip);
        type.setCreated(this.created);
        type.setModified(this.modified);
        type.setInsertBy(this.insertBy);

        return type;
    }
}