package com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SAPModel{

	@SerializedName("dealer_code")
	private String dealerCode;

	@SerializedName("PONumber")
	private String pONumber;

	@SerializedName("PODate")
	private String pODate;

	@SerializedName("DispatchDate")
	private String dispatchDate;

	@SerializedName("DistChannel")
	private String distChannel;

	@SerializedName("pt")
	private List<PtItem> pt;

	@SerializedName("ConsigneeCode")
	private String consigneeCode;

	@SerializedName("Division")
	private String division;

	@SerializedName("SO_Type")
	private String sOType;

	@SerializedName("AID")
	private AID aID;

	public void setDealerCode(String dealerCode){
		this.dealerCode = dealerCode;
	}

	public String getDealerCode(){
		return dealerCode;
	}

	public void setPONumber(String pONumber){
		this.pONumber = pONumber;
	}

	public String getPONumber(){
		return pONumber;
	}

	public void setPODate(String pODate){
		this.pODate = pODate;
	}

	public String getPODate(){
		return pODate;
	}

	public void setDispatchDate(String dispatchDate){
		this.dispatchDate = dispatchDate;
	}

	public String getDispatchDate(){
		return dispatchDate;
	}

	public void setDistChannel(String distChannel){
		this.distChannel = distChannel;
	}

	public String getDistChannel(){
		return distChannel;
	}

	public void setPt(List<PtItem> pt){
		this.pt = pt;
	}

	public List<PtItem> getPt(){
		return pt;
	}

	public void setConsigneeCode(String consigneeCode){
		this.consigneeCode = consigneeCode;
	}

	public String getConsigneeCode(){
		return consigneeCode;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setSOType(String sOType){
		this.sOType = sOType;
	}

	public String getSOType(){
		return sOType;
	}

	public void setAID(AID aID){
		this.aID = aID;
	}

	public AID getAID(){
		return aID;
	}
}