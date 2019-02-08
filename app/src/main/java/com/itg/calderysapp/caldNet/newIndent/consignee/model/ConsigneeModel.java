package com.itg.calderysapp.caldNet.newIndent.consignee.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.itg.calderysapp.BR;

import com.google.gson.annotations.SerializedName;

public class ConsigneeModel extends BaseObservable {

	@SerializedName("Status")
	public String Status;

	@SerializedName("LSTDate")
	public String LSTDate;

	@SerializedName("Email")
	public String Email;

	@SerializedName("RegionCode")
	public String RegionCode;

	@SerializedName("PostalCode")
	public String PostalCode;

	@SerializedName("TinNo")
	public String TinNo;

	@SerializedName("Mobile")
	public String Mobile;

	@SerializedName("ContactPerson")
	public String ContactPerson;

	@SerializedName("DealerCode")
	public String DealerCode;

	@SerializedName("CSTNo")
	public String CSTNo;

	@SerializedName("ConsigneeName")
	public String ConsigneeName;

	@SerializedName("Phone")
	public String Phone;

	@SerializedName("FaxNo")
	public String FaxNo;

	@SerializedName("ConsigneeCode")
	public Object ConsigneeCode;

	@SerializedName("ConsigneeAddress")
	public String ConsigneeAddress;

	@SerializedName("LSTNo")
	public String LSTNo;

	@SerializedName("CountryCode")
	public String CountryCode;

	@SerializedName("EccNo")
	public String EccNo;

	public void setLSTDate(String LSTDate) {
		this.LSTDate = LSTDate;
		notifyPropertyChanged(BR.lSTDate);
	}

	@Bindable
	public String getLSTDate() {
		return LSTDate;
	}

	//	public void setStatus(String status){
//		this.status = status;
//	}
//
//	public String getStatus(){
//		return status;
//	}
//
//	public void setLSTDate(String lSTDate){
//		this.lSTDate = lSTDate;
//	}
//
//	public String getLSTDate(){
//		return lSTDate;
//	}
//
//	public void setEmail(String email){
//		this.email = email;
//	}
//
//	public String getEmail(){
//		return email;
//	}
//
//	public void setRegionCode(String regionCode){
//		this.regionCode = regionCode;
//	}
//
//	public String getRegionCode(){
//		return regionCode;
//	}
//
//	public void setPostalCode(String postalCode){
//		this.postalCode = postalCode;
//	}
//
//	public String getPostalCode(){
//		return postalCode;
//	}
//
//	public void setTinNo(String tinNo){
//		this.tinNo = tinNo;
//	}
//
//	public String getTinNo(){
//		return tinNo;
//	}
//
//	public void setMobile(String mobile){
//		this.mobile = mobile;
//	}
//
//	public String getMobile(){
//		return mobile;
//	}
//
//	public void setContactPerson(String contactPerson){
//		this.contactPerson = contactPerson;
//	}
//
//	public String getContactPerson(){
//		return contactPerson;
//	}
//
//	public void setDealerCode(String dealerCode){
//		this.dealerCode = dealerCode;
//	}
//
//	public String getDealerCode(){
//		return dealerCode;
//	}
//
//	public void setCSTNo(String cSTNo){
//		this.cSTNo = cSTNo;
//	}
//
//	public String getCSTNo(){
//		return cSTNo;
//	}
//
//	public void setConsigneeName(String consigneeName){
//		this.consigneeName = consigneeName;
//	}
//
//	public String getConsigneeName(){
//		return consigneeName;
//	}
//
//	public void setPhone(String phone){
//		this.phone = phone;
//	}
//
//	public String getPhone(){
//		return phone;
//	}
//
//	public void setFaxNo(String faxNo){
//		this.faxNo = faxNo;
//	}
//
//	public String getFaxNo(){
//		return faxNo;
//	}
//
//	public void setConsigneeCode(Object consigneeCode){
//		this.consigneeCode = consigneeCode;
//	}
//
//	public Object getConsigneeCode(){
//		return consigneeCode;
//	}
//
//	public void setConsigneeAddress(String consigneeAddress){
//		this.consigneeAddress = consigneeAddress;
//	}
//
//	public String getConsigneeAddress(){
//		return consigneeAddress;
//	}
//
//	public void setLSTNo(String lSTNo){
//		this.lSTNo = lSTNo;
//	}
//
//	public String getLSTNo(){
//		return lSTNo;
//	}
//
//	public void setCountryCode(String countryCode){
//		this.countryCode = countryCode;
//	}
//
//	public String getCountryCode(){
//		return countryCode;
//	}
//
//	public void setEccNo(String eccNo){
//		this.eccNo = eccNo;
//	}
//
//	public String getEccNo(){
//		return eccNo;
//	}

}