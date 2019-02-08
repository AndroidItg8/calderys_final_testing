package com.itg.calderysapp.notification.NotificationModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

	@SerializedName("data")
	private String data;

	@SerializedName("type")
	private int type;

	@SerializedName("message")
	private String message;

	@SerializedName("title")
	private String title;

	@SerializedName("classtype")
	private int classtype;

	@SerializedName("salesContactPerson")
	 private String salesContactPerson;

	public int getClasstype() {
		return classtype;
	}

	public void setClasstype(int classtype) {
		this.classtype = classtype;
	}

	public void setData(String data){
		this.data = data;
	}

	public String getData(){
		return data;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"data = '" + data + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}

	public Data() {
	}

	public String getSalesContactPerson() {
		return salesContactPerson;
	}

	public void setSalesContactPerson(String salesContactPerson) {
		this.salesContactPerson = salesContactPerson;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.data);
		dest.writeInt(this.type);
		dest.writeString(this.message);
		dest.writeString(this.title);
		dest.writeInt(this.classtype);
		dest.writeString(this.salesContactPerson);
	}

	protected Data(Parcel in) {
		this.data = in.readString();
		this.type = in.readInt();
		this.message = in.readString();
		this.title = in.readString();
		this.classtype = in.readInt();
		this.salesContactPerson = in.readString();
	}

	public static final Creator<Data> CREATOR = new Creator<Data>() {
		@Override
		public Data createFromParcel(Parcel source) {
			return new Data(source);
		}

		@Override
		public Data[] newArray(int size) {
			return new Data[size];
		}
	};
}