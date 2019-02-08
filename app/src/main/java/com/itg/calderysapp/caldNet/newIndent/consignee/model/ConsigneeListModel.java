package com.itg.calderysapp.caldNet.newIndent.consignee.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ConsigneeListModel extends BaseObservable implements Parcelable {

	@SerializedName("DealerCode")
	private String dealerCode;

	@SerializedName("ConsigneeName")
	private String consigneeName;

	@SerializedName("ConsigneeECCNo")
	private String consigneeECCNo;

	@SerializedName("ConsigneeCode")
	private String consigneeCode;

	@SerializedName("ConsigneeCSTNo")
	private String consigneeCSTNo;

	@SerializedName("PageNo")
	private int pageNo;

	@SerializedName("ConsigneeAddress")
	private String consigneeAddress;

	@SerializedName("Count")
	private int count;

	@SerializedName("ConsigneeTINNo")
	private String consigneeTINNo;

	public void setDealerCode(String dealerCode){
		this.dealerCode = dealerCode;
	}

	public String getDealerCode(){
		return dealerCode;
	}

	public void setConsigneeName(String consigneeName){
		this.consigneeName = consigneeName;
	}

	public String getConsigneeName(){
		return consigneeName;
	}

	public void setConsigneeECCNo(String consigneeECCNo){
		this.consigneeECCNo = consigneeECCNo;
	}

	public String getConsigneeECCNo(){
		return consigneeECCNo;
	}

	public void setConsigneeCode(String consigneeCode){
		this.consigneeCode = consigneeCode;
	}

	public String getConsigneeCode(){
		return consigneeCode;
	}

	public void setConsigneeCSTNo(String consigneeCSTNo){
		this.consigneeCSTNo = consigneeCSTNo;
	}

	public String getConsigneeCSTNo(){
		return consigneeCSTNo;
	}

	public void setPageNo(int pageNo){
		this.pageNo = pageNo;
	}

	public int getPageNo(){
		return pageNo;
	}

	public void setConsigneeAddress(String consigneeAddress){
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneeAddress(){
		return consigneeAddress;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setConsigneeTINNo(String consigneeTINNo){
		this.consigneeTINNo = consigneeTINNo;
	}

	public String getConsigneeTINNo(){
		return consigneeTINNo;
	}

	@Override
 	public String toString(){
		return 
			"ConsigneeListModel{" + 
			"dealerCode = '" + dealerCode + '\'' + 
			",consigneeName = '" + consigneeName + '\'' + 
			",consigneeECCNo = '" + consigneeECCNo + '\'' + 
			",consigneeCode = '" + consigneeCode + '\'' + 
			",consigneeCSTNo = '" + consigneeCSTNo + '\'' + 
			",pageNo = '" + pageNo + '\'' + 
			",consigneeAddress = '" + consigneeAddress + '\'' + 
			",count = '" + count + '\'' + 
			",consigneeTINNo = '" + consigneeTINNo + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.dealerCode);
		dest.writeString(this.consigneeName);
		dest.writeString(this.consigneeECCNo);
		dest.writeString(this.consigneeCode);
		dest.writeString(this.consigneeCSTNo);
		dest.writeInt(this.pageNo);
		dest.writeString(this.consigneeAddress);
		dest.writeInt(this.count);
		dest.writeString(this.consigneeTINNo);
	}

	public ConsigneeListModel() {
	}

	protected ConsigneeListModel(Parcel in) {
		this.dealerCode = in.readString();
		this.consigneeName = in.readString();
		this.consigneeECCNo = in.readString();
		this.consigneeCode = in.readString();
		this.consigneeCSTNo = in.readString();
		this.pageNo = in.readInt();
		this.consigneeAddress = in.readString();
		this.count = in.readInt();
		this.consigneeTINNo = in.readString();
	}

	public static final Parcelable.Creator<ConsigneeListModel> CREATOR = new Parcelable.Creator<ConsigneeListModel>() {
		@Override
		public ConsigneeListModel createFromParcel(Parcel source) {
			return new ConsigneeListModel(source);
		}

		@Override
		public ConsigneeListModel[] newArray(int size) {
			return new ConsigneeListModel[size];
		}
	};
}