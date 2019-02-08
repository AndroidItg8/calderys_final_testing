package com.itg.calderysapp.caldConnect.pds.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductTypeModel implements Parcelable
{

  @SerializedName("Status")
  @Expose
  private Integer status;
  @SerializedName("Errorcode")
  @Expose
  private Integer errorcode;
  @SerializedName("data")
  @Expose
  private List<Datum> data = null;
  public final static Creator<ProductTypeModel> CREATOR = new Creator<ProductTypeModel>() {


    @SuppressWarnings({
            "unchecked"
    })
    public ProductTypeModel createFromParcel(Parcel in) {
      return new ProductTypeModel(in);
    }

    public ProductTypeModel[] newArray(int size) {
      return (new ProductTypeModel[size]);
    }

  }
          ;

  protected ProductTypeModel(Parcel in) {
    this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
    this.errorcode = ((Integer) in.readValue((Integer.class.getClassLoader())));
    in.readList(this.data, (Datum.class.getClassLoader()));
  }

  public ProductTypeModel() {
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

  public List<Datum> getData() {
    return data;
  }

  public void setData(List<Datum> data) {
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