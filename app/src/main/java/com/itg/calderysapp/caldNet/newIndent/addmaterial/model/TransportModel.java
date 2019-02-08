package com.itg.calderysapp.caldNet.newIndent.addmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TransportModel implements Parcelable {



	@SerializedName("SearchTransport")
	private Object searchTransport;

	@SerializedName("Type")
	private Object type;

	@SerializedName("PageSize")
	private int pageSize;

	@SerializedName("TransporterName")
	private String transporterName;

	@SerializedName("PageNo")
	private int pageNo;

	@SerializedName("Count")
	private int count;

	@SerializedName("TransporterCode")
	private String transporterCode;

	public void setSearchTransport(Object searchTransport){
		this.searchTransport = searchTransport;
	}

	public Object getSearchTransport(){
		return searchTransport;
	}

	public void setType(Object type){
		this.type = type;
	}

	public Object getType(){
		return type;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setTransporterName(String transporterName){
		this.transporterName = transporterName;
	}

	public String getTransporterName(){
		return transporterName;
	}

	public void setPageNo(int pageNo){
		this.pageNo = pageNo;
	}

	public int getPageNo(){
		return pageNo;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setTransporterCode(String transporterCode){
		this.transporterCode = transporterCode;
	}

	public String getTransporterCode(){
		return transporterCode;
	}

	@Override
 	public String toString(){
		return 
			"TransportModel{" + 
			"searchTransport = '" + searchTransport + '\'' + 
			",type = '" + type + '\'' + 
			",pageSize = '" + pageSize + '\'' + 
			",transporterName = '" + transporterName + '\'' + 
			",pageNo = '" + pageNo + '\'' + 
			",count = '" + count + '\'' + 
			",transporterCode = '" + transporterCode + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.pageSize);
		dest.writeString(this.transporterName);
		dest.writeInt(this.pageNo);
		dest.writeInt(this.count);
		dest.writeString(this.transporterCode);
	}

	public TransportModel() {
	}

	protected TransportModel(Parcel in) {
		this.pageSize = in.readInt();
		this.transporterName = in.readString();
		this.pageNo = in.readInt();
		this.count = in.readInt();
		this.transporterCode = in.readString();
	}

	public static final Parcelable.Creator<TransportModel> CREATOR = new Parcelable.Creator<TransportModel>() {
		@Override
		public TransportModel createFromParcel(Parcel source) {
			return new TransportModel(source);
		}

		@Override
		public TransportModel[] newArray(int size) {
			return new TransportModel[size];
		}
	};
}