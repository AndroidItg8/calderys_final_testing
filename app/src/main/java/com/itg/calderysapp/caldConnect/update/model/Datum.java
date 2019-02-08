
package com.itg.calderysapp.caldConnect.update.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("Discription")
    @Expose
    private String discription;
    @SerializedName("upload_date")
    @Expose
    private String uploadDate;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("email_sent")
    @Expose
    private String emailSent;
    @SerializedName("date")
    @Expose
    private String date;
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

    public boolean isDownload() {
        return isDownload;
    }

    private boolean isDownload =false;
    private boolean isProgress =false;
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
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.discription = ((String) in.readValue((String.class.getClassLoader())));
        this.uploadDate = ((String) in.readValue((String.class.getClassLoader())));
        this.file = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.emailSent = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.insertBy = ((String) in.readValue((String.class.getClassLoader())));
        this.ip = ((String) in.readValue((String.class.getClassLoader())));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.modified = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(String emailSent) {
        this.emailSent = emailSent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        dest.writeValue(title);
        dest.writeValue(discription);
        dest.writeValue(uploadDate);
        dest.writeValue(file);
        dest.writeValue(status);
        dest.writeValue(emailSent);
        dest.writeValue(date);
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
