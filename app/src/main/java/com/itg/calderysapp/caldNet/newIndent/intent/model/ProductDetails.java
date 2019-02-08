package com.itg.calderysapp.caldNet.newIndent.intent.model;

import com.google.gson.annotations.SerializedName;

public class ProductDetails{

	@SerializedName("MGID")
	private String mGID;

	@SerializedName("ProductName")
	private String productName;

	@SerializedName("ProductCode")
	private String productCode;

	@SerializedName("DistributionChannel")
	private String distributionChannel;

	@SerializedName("ProductID")
	private String productID;

	@SerializedName("Division")
	private String division;

	@SerializedName("PricePerUnit")
	private String pricePerUnit;

	@SerializedName("Unit")
	private String unit;

	@SerializedName("PlantCode")
	private String plantCode;

	@SerializedName("TotalDiscount")
	private String totalDiscount;

	public void setMGID(String mGID){
		this.mGID = mGID;
	}

	public String getMGID(){
		return mGID;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductCode(String productCode){
		this.productCode = productCode;
	}

	public String getProductCode(){
		return productCode;
	}

	public void setDistributionChannel(String distributionChannel){
		this.distributionChannel = distributionChannel;
	}

	public String getDistributionChannel(){
		return distributionChannel;
	}

	public void setProductID(String productID){
		this.productID = productID;
	}

	public String getProductID(){
		return productID;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setPricePerUnit(String pricePerUnit){
		this.pricePerUnit = pricePerUnit;
	}

	public String getPricePerUnit(){
		return pricePerUnit;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setPlantCode(String plantCode){
		this.plantCode = plantCode;
	}

	public String getPlantCode(){
		return plantCode;
	}

	public void setTotalDiscount(String totalDiscount){
		this.totalDiscount = totalDiscount;
	}

	public String getTotalDiscount(){
		return totalDiscount;
	}

	@Override
 	public String toString(){
		return 
			"ProductDetails{" + 
			"mGID = '" + mGID + '\'' + 
			",productName = '" + productName + '\'' + 
			",productCode = '" + productCode + '\'' + 
			",distributionChannel = '" + distributionChannel + '\'' + 
			",productID = '" + productID + '\'' + 
			",division = '" + division + '\'' + 
			",pricePerUnit = '" + pricePerUnit + '\'' + 
			",unit = '" + unit + '\'' + 
			",plantCode = '" + plantCode + '\'' + 
			",totalDiscount = '" + totalDiscount + '\'' + 
			"}";
		}
}