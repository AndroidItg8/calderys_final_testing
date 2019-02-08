
package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealerModel implements Parcelable
{

    @SerializedName("DealerCode")
    @Expose
    private String DealerCode;
    @SerializedName("Country")
    @Expose
    private String Country;
    @SerializedName("FirstName")
    @Expose
    private String FirstName;
    @SerializedName("LastName")
    @Expose
    private String LastName;
    @SerializedName("City")
    @Expose
    private String City;
    @SerializedName("PostalCode")
    @Expose
    private String PostalCode;
    @SerializedName("Address")
    @Expose
    private String Address;
    @SerializedName("Count")
    @Expose
    private int Count;
    @SerializedName("PageNo")
    @Expose
    private int PageNo;
    public final static Parcelable.Creator<DealerModel> CREATOR = new Creator<DealerModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DealerModel createFromParcel(Parcel in) {
            DealerModel instance = new DealerModel();
            instance.DealerCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.Country = ((String) in.readValue((String.class.getClassLoader())));
            instance.FirstName = ((String) in.readValue((String.class.getClassLoader())));
            instance.LastName = ((String) in.readValue((String.class.getClassLoader())));
            instance.City = ((String) in.readValue((String.class.getClassLoader())));
            instance.PostalCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.Address = ((String) in.readValue((String.class.getClassLoader())));
            instance.Count = ((int) in.readValue((int.class.getClassLoader())));
            instance.PageNo = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public DealerModel[] newArray(int size) {
            return (new DealerModel[size]);
        }

    }
    ;

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
     *     The Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * 
     * @param Country
     *     The Country
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * 
     * @return
     *     The FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * 
     * @param FirstName
     *     The FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * 
     * @return
     *     The LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * 
     * @param LastName
     *     The LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * 
     * @return
     *     The City
     */
    public String getCity() {
        return City;
    }

    /**
     * 
     * @param City
     *     The City
     */
    public void setCity(String City) {
        this.City = City;
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
     *     The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * 
     * @param Address
     *     The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 
     * @return
     *     The Count
     */
    public int getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

    /**
     * 
     * @return
     *     The PageNo
     */
    public int getPageNo() {
        return PageNo;
    }

    /**
     * 
     * @param PageNo
     *     The PageNo
     */
    public void setPageNo(int PageNo) {
        this.PageNo = PageNo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(DealerCode);
        dest.writeValue(Country);
        dest.writeValue(FirstName);
        dest.writeValue(LastName);
        dest.writeValue(City);
        dest.writeValue(PostalCode);
        dest.writeValue(Address);
        dest.writeValue(Count);
        dest.writeValue(PageNo);
    }

    public int describeContents() {
        return  0;
    }

}
