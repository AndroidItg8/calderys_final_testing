package com.itg.calderysapp.db.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import static com.itg.calderysapp.db.table.TblProductType.ID;
import static com.itg.calderysapp.db.table.TblProductType.TABLE_PRODUCT_TYPE;

@Entity(tableName = TABLE_PRODUCT_TYPE )
public class TblProductType {

    static final String TABLE_PRODUCT_TYPE="PRODUCT_TYPE";

    public static final String PRODUCT_TYPE = "product_type";
    public static final String INSERT_BY = "insert_by";
    public static final String CREATED = "created";
    public static final String MODIFIED = "modified";
    public static final String IP = "ip";
    public static final String ID = "id";

    @SerializedName(ID)
    @Expose
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = ID)
    private String id;
    @ColumnInfo(name = PRODUCT_TYPE)
    @SerializedName("product_type")
    @Expose
    private String productType;
    @ColumnInfo(name = INSERT_BY)
    @SerializedName("insert_by")
    @Expose
    private String insertBy;
    @ColumnInfo(name = CREATED)
    @SerializedName("created")
    @Expose
    private String created;
    @ColumnInfo(name= MODIFIED)
    @SerializedName("modified")
    @Expose
    private String modified;
    @ColumnInfo(name = IP)
    @SerializedName("ip")
    @Expose
    private String ip;

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
}
