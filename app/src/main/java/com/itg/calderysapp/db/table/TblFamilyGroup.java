package com.itg.calderysapp.db.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import static com.itg.calderysapp.db.table.TblFamilyGroup.TABLE_FAMILY_GROUP;
import static com.itg.calderysapp.db.table.TblProductType.ID;


@Entity(tableName = TABLE_FAMILY_GROUP )
public class TblFamilyGroup {

   public static final String TABLE_FAMILY_GROUP = "FAMILY_GROUP";
    public static final String GROUP_NAME = "group_name";
    public static final String INSERT_BY = "insert_by";
    public static final String CREATED = "created";
    public  static final String MODIFIED = "modified";
    public   static final String IP = "ip";
    public   static final String ID = "id";
    @SerializedName(ID)
    @Expose
    @PrimaryKey
    @NonNull

    @ColumnInfo(name = ID)
    private String id;
    @ColumnInfo(name = GROUP_NAME)
    @SerializedName(GROUP_NAME)
    @Expose
    private String groupName;
    @ColumnInfo(name = INSERT_BY)
    @SerializedName(INSERT_BY)
    @Expose
    private String insertBy;
    @ColumnInfo(name = CREATED)
    @SerializedName(CREATED)
    @Expose
    private String created;
    @ColumnInfo(name = MODIFIED)
    @SerializedName(MODIFIED)
    @Expose
    private String modified;
    @ColumnInfo(name = IP)
    @SerializedName(IP)
    @Expose
    private String ip;

    public static String getTableFamilyGroup() {
        return TABLE_FAMILY_GROUP;
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


}
