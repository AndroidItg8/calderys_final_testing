
package com.itg.calderysapp.caldNet.newIndent.createIntent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddConsigneeModel implements Parcelable
{

    @SerializedName("ConsigneeName")
    @Expose
    private String ConsigneeName;
    @SerializedName("ConsigneeAddress")
    @Expose
    private String ConsigneeAddress;
    @SerializedName("Status")
    @Expose
    private String Status;
    @SerializedName("ConsigneeCode")
    @Expose
    private Object ConsigneeCode;
    @SerializedName("DealerCode")
    @Expose
    private String DealerCode;
    @SerializedName("PostalCode")
    @Expose
    private String PostalCode;
    @SerializedName("CountryCode")
    @Expose
    private String CountryCode;
    @SerializedName("RegionCode")
    @Expose
    private String RegionCode;
    @SerializedName("EccNo")
    @Expose
    private String EccNo;
    @SerializedName("CSTNo")
    @Expose
    private String CSTNo;
    @SerializedName("LSTNo")
    @Expose
    private String LSTNo;
    @SerializedName("LSTDate")
    @Expose
    private String LSTDate;
    @SerializedName("TinNo")
    @Expose
    private String TinNo;
    @SerializedName("Phone")
    @Expose
    private String Phone;
    @SerializedName("Mobile")
    @Expose
    private String Mobile;
    @SerializedName("FaxNo")
    @Expose
    private String FaxNo;
    @SerializedName("Email")
    @Expose
    private String Email;
    @SerializedName("ContactPerson")
    @Expose
    private String ContactPerson;
    public final static Parcelable.Creator<AddConsigneeModel> CREATOR = new Creator<AddConsigneeModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AddConsigneeModel createFromParcel(Parcel in) {
            AddConsigneeModel instance = new AddConsigneeModel();
            instance.ConsigneeName = ((String) in.readValue((String.class.getClassLoader())));
            instance.ConsigneeAddress = ((String) in.readValue((String.class.getClassLoader())));
            instance.Status = ((String) in.readValue((String.class.getClassLoader())));
            instance.ConsigneeCode = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.DealerCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.PostalCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.CountryCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.RegionCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.EccNo = ((String) in.readValue((String.class.getClassLoader())));
            instance.CSTNo = ((String) in.readValue((String.class.getClassLoader())));
            instance.LSTNo = ((String) in.readValue((String.class.getClassLoader())));
            instance.LSTDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.TinNo = ((String) in.readValue((String.class.getClassLoader())));
            instance.Phone = ((String) in.readValue((String.class.getClassLoader())));
            instance.Mobile = ((String) in.readValue((String.class.getClassLoader())));
            instance.FaxNo = ((String) in.readValue((String.class.getClassLoader())));
            instance.Email = ((String) in.readValue((String.class.getClassLoader())));
            instance.ContactPerson = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public AddConsigneeModel[] newArray(int size) {
            return (new AddConsigneeModel[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The ConsigneeName
     */
    public String getConsigneeName() {
        return ConsigneeName;
    }

    /**
     * 
     * @param ConsigneeName
     *     The ConsigneeName
     */
    public void setConsigneeName(String ConsigneeName) {
        this.ConsigneeName = ConsigneeName;
    }

    /**
     * 
     * @return
     *     The ConsigneeAddress
     */
    public String getConsigneeAddress() {
        return ConsigneeAddress;
    }

    /**
     * 
     * @param ConsigneeAddress
     *     The ConsigneeAddress
     */
    public void setConsigneeAddress(String ConsigneeAddress) {
        this.ConsigneeAddress = ConsigneeAddress;
    }

    /**
     * 
     * @return
     *     The Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * 
     * @param Status
     *     The Status
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * 
     * @return
     *     The ConsigneeCode
     */
    public Object getConsigneeCode() {
        return ConsigneeCode;
    }

    /**
     * 
     * @param ConsigneeCode
     *     The ConsigneeCode
     */
    public void setConsigneeCode(Object ConsigneeCode) {
        this.ConsigneeCode = ConsigneeCode;
    }

    /**
     * 
     * @return
     *     The DealerCode
     */
    public String getDealerCode() {
        return DealerCode;
    }

    /**
     * 
     * @param DealerCode
     *     The DealerCode
     */
    public void setDealerCode(String DealerCode) {
        this.DealerCode = DealerCode;
    }

    /**
     * 
     * @return
     *     The PostalCode
     */
    public String getPostalCode() {
        return PostalCode;
    }

    /**
     * 
     * @param PostalCode
     *     The PostalCode
     */
    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    /**
     * 
     * @return
     *     The CountryCode
     */
    public String getCountryCode() {
        return CountryCode;
    }

    /**
     * 
     * @param CountryCode
     *     The CountryCode
     */
    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    /**
     * 
     * @return
     *     The RegionCode
     */
    public String getRegionCode() {
        return RegionCode;
    }

    /**
     * 
     * @param RegionCode
     *     The RegionCode
     */
    public void setRegionCode(String RegionCode) {
        this.RegionCode = RegionCode;
    }

    /**
     * 
     * @return
     *     The EccNo
     */
    public String getEccNo() {
        return EccNo;
    }

    /**
     * 
     * @param EccNo
     *     The EccNo
     */
    public void setEccNo(String EccNo) {
        this.EccNo = EccNo;
    }

    /**
     * 
     * @return
     *     The CSTNo
     */
    public String getCSTNo() {
        return CSTNo;
    }

    /**
     * 
     * @param CSTNo
     *     The CSTNo
     */
    public void setCSTNo(String CSTNo) {
        this.CSTNo = CSTNo;
    }

    /**
     * 
     * @return
     *     The LSTNo
     */
    public String getLSTNo() {
        return LSTNo;
    }

    /**
     * 
     * @param LSTNo
     *     The LSTNo
     */
    public void setLSTNo(String LSTNo) {
        this.LSTNo = LSTNo;
    }

    /**
     * 
     * @return
     *     The LSTDate
     */
    public String getLSTDate() {
        return LSTDate;
    }

    /**
     * 
     * @param LSTDate
     *     The LSTDate
     */
    public void setLSTDate(String LSTDate) {
        this.LSTDate = LSTDate;
    }

    /**
     * 
     * @return
     *     The TinNo
     */
    public String getTinNo() {
        return TinNo;
    }

    /**
     * 
     * @param TinNo
     *     The TinNo
     */
    public void setTinNo(String TinNo) {
        this.TinNo = TinNo;
    }

    /**
     * 
     * @return
     *     The Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * 
     * @param Phone
     *     The Phone
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * 
     * @return
     *     The Mobile
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     * 
     * @param Mobile
     *     The Mobile
     */
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    /**
     * 
     * @return
     *     The FaxNo
     */
    public String getFaxNo() {
        return FaxNo;
    }

    /**
     * 
     * @param FaxNo
     *     The FaxNo
     */
    public void setFaxNo(String FaxNo) {
        this.FaxNo = FaxNo;
    }

    /**
     * 
     * @return
     *     The Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * 
     * @param Email
     *     The Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * 
     * @return
     *     The ContactPerson
     */
    public String getContactPerson() {
        return ContactPerson;
    }

    /**
     * 
     * @param ContactPerson
     *     The ContactPerson
     */
    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ConsigneeName);
        dest.writeValue(ConsigneeAddress);
        dest.writeValue(Status);
        dest.writeValue(ConsigneeCode);
        dest.writeValue(DealerCode);
        dest.writeValue(PostalCode);
        dest.writeValue(CountryCode);
        dest.writeValue(RegionCode);
        dest.writeValue(EccNo);
        dest.writeValue(CSTNo);
        dest.writeValue(LSTNo);
        dest.writeValue(LSTDate);
        dest.writeValue(TinNo);
        dest.writeValue(Phone);
        dest.writeValue(Mobile);
        dest.writeValue(FaxNo);
        dest.writeValue(Email);
        dest.writeValue(ContactPerson);
    }

    public int describeContents() {
        return  0;
    }

}
