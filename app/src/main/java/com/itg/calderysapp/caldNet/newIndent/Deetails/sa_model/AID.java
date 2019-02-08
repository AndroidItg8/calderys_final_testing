package com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model;

import com.google.gson.annotations.SerializedName;

public class AID{

	@SerializedName("UsageIndicator")
	private String usageIndicator;

	@SerializedName("EquipmentCode")
	private String equipmentCode;

	@SerializedName("ProcessCode")
	private String processCode;

	@SerializedName("SpecialProcIndicator")
	private String specialProcIndicator;

	@SerializedName("SalesPackage")
	private String salesPackage;

	@SerializedName("Sales_Org")
	private String salesOrg;

	@SerializedName("Partner")
	private String partner;

	public void setUsageIndicator(String usageIndicator){
		this.usageIndicator = usageIndicator;
	}

	public String getUsageIndicator(){
		return usageIndicator;
	}

	public void setEquipmentCode(String equipmentCode){
		this.equipmentCode = equipmentCode;
	}

	public String getEquipmentCode(){
		return equipmentCode;
	}

	public void setProcessCode(String processCode){
		this.processCode = processCode;
	}

	public String getProcessCode(){
		return processCode;
	}

	public void setSpecialProcIndicator(String specialProcIndicator){
		this.specialProcIndicator = specialProcIndicator;
	}

	public String getSpecialProcIndicator(){
		return specialProcIndicator;
	}

	public void setSalesPackage(String salesPackage){
		this.salesPackage = salesPackage;
	}

	public String getSalesPackage(){
		return salesPackage;
	}

	public void setSalesOrg(String salesOrg){
		this.salesOrg = salesOrg;
	}

	public String getSalesOrg(){
		return salesOrg;
	}

	public void setPartner(String partner){
		this.partner = partner;
	}

	public String getPartner(){
		return partner;
	}
}