package com.itg.calderysapp.caldConnect.pds.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data  implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("family_group")
    @Expose
    private String familyGroup;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("industry_applicant")
    @Expose
    private String industryApplicant;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("uploaded_date")
    @Expose
    private String uploadedDate;
    @SerializedName("email_sent")
    @Expose
    private String emailSent;
    @SerializedName("share")
    @Expose
    private String share;
    @SerializedName("insertBy")
    @Expose
    private String insertBy;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    private boolean isDownload;
    private boolean isProgress;

    public boolean isDownload() {
        return isDownload;
    }

    public boolean isProgress() {
        return isProgress;
    }

    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;


    protected Data(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.productName = ((String) in.readValue((String.class.getClassLoader())));
        this.familyGroup = ((String) in.readValue((String.class.getClassLoader())));
        this.productType = ((String) in.readValue((String.class.getClassLoader())));
        this.industryApplicant = ((String) in.readValue((String.class.getClassLoader())));
        this.file = ((String) in.readValue((String.class.getClassLoader())));
        this.uploadedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.emailSent = ((String) in.readValue((String.class.getClassLoader())));
        this.share = ((String) in.readValue((String.class.getClassLoader())));
        this.insertBy = ((String) in.readValue((String.class.getClassLoader())));
        this.ip = ((String) in.readValue((String.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.modified = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param industryApplicant
     * @param familyGroup
     * @param insertBy
     * @param modified
     * @param productType
     * @param ip
     * @param id
     * @param share
     * @param created
     * @param file
     * @param emailSent
     * @param productName
     * @param uploadedDate
     */
    public Data(String id, String productName, String familyGroup, String productType, String industryApplicant, String file, String uploadedDate, String emailSent, String share, String insertBy, String ip, String created, String modified) {
        super();
        this.id = id;
        this.productName = productName;
        this.familyGroup = familyGroup;
        this.productType = productType;
        this.industryApplicant = industryApplicant;
        this.file = file;
        this.uploadedDate = uploadedDate;
        this.emailSent = emailSent;
        this.share = share;
        this.insertBy = insertBy;
        this.ip = ip;
        this.created = created;
        this.modified = modified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFamilyGroup() {
        return familyGroup;
    }

    public void setFamilyGroup(String familyGroup) {
        this.familyGroup = familyGroup;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getIndustryApplicant() {
        return industryApplicant;
    }

    public void setIndustryApplicant(String industryApplicant) {
        this.industryApplicant = industryApplicant;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(String emailSent) {
        this.emailSent = emailSent;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(productName);
        dest.writeValue(familyGroup);
        dest.writeValue(productType);
        dest.writeValue(industryApplicant);
        dest.writeValue(file);
        dest.writeValue(uploadedDate);
        dest.writeValue(emailSent);
        dest.writeValue(share);
        dest.writeValue(insertBy);
        dest.writeValue(ip);
        dest.writeValue(created);
        dest.writeValue(modified);
    }

    public int describeContents() {
        return  0;
    }
    public void setDownload(boolean b) {
        isDownload = b;


    }

    public void setProgress(boolean b) {
        isProgress=b;

    }

}