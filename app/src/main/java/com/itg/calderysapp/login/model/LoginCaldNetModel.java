package com.itg.calderysapp.login.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginCaldNetModel implements Parcelable
{

    @SerializedName("User_ID")
    @Expose
    private String userID;
    @SerializedName("First_Name")
    @Expose
    private String firstName;
    @SerializedName("Last_Name")
    @Expose
    private String lastName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Email_ID")
    @Expose
    private String emailID;
    @SerializedName("Password_Last_Modified_Date")
    @Expose
    private String passwordLastModifiedDate;
    @SerializedName("Deleted")
    @Expose
    private String deleted;
    @SerializedName("Created_By")
    @Expose
    private String createdBy;
    @SerializedName("Created_Date")
    @Expose
    private String createdDate;
    @SerializedName("Modified_By")
    @Expose
    private String modifiedBy;
    @SerializedName("Modified_Date")
    @Expose
    private String modifiedDate;
    @SerializedName("IsExpired")
    @Expose
    private String isExpired;
    @SerializedName("UserType")
    @Expose
    private String userType;
    @SerializedName("SalesContactPerson")
    @Expose
    private String salesContactPerson;
    @SerializedName("PlantCode")
    @Expose
    private String plantCode;
    public final static Parcelable.Creator<LoginCaldNetModel> CREATOR = new Creator<LoginCaldNetModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginCaldNetModel createFromParcel(Parcel in) {
            return new LoginCaldNetModel(in);
        }

        public LoginCaldNetModel[] newArray(int size) {
            return (new LoginCaldNetModel[size]);
        }

    }
            ;

    protected LoginCaldNetModel(Parcel in) {
        this.userID = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.emailID = ((String) in.readValue((String.class.getClassLoader())));
        this.passwordLastModifiedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.deleted = ((String) in.readValue((String.class.getClassLoader())));
        this.createdBy = ((String) in.readValue((String.class.getClassLoader())));
        this.createdDate = ((String) in.readValue((String.class.getClassLoader())));
        this.modifiedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.modifiedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isExpired = ((String) in.readValue((String.class.getClassLoader())));
        this.userType = ((String) in.readValue((String.class.getClassLoader())));
        this.salesContactPerson = ((String) in.readValue((String.class.getClassLoader())));
        this.plantCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LoginCaldNetModel() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPasswordLastModifiedDate() {
        return passwordLastModifiedDate;
    }

    public void setPasswordLastModifiedDate(String passwordLastModifiedDate) {
        this.passwordLastModifiedDate = passwordLastModifiedDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(String isExpired) {
        this.isExpired = isExpired;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSalesContactPerson() {
        return salesContactPerson;
    }

    public void setSalesContactPerson(String salesContactPerson) {
        this.salesContactPerson = salesContactPerson;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userID);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(password);
        dest.writeValue(emailID);
        dest.writeValue(passwordLastModifiedDate);
        dest.writeValue(deleted);
        dest.writeValue(createdBy);
        dest.writeValue(createdDate);
        dest.writeValue(modifiedBy);
        dest.writeValue(modifiedDate);
        dest.writeValue(isExpired);
        dest.writeValue(userType);
        dest.writeValue(salesContactPerson);
        dest.writeValue(plantCode);
    }

    public int describeContents() {
        return 0;
    }

}