package com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model;

import com.google.gson.annotations.SerializedName;

public class PtItem{

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("product_code")
	private String productCode;

	@SerializedName("PlantCode")
	private String plantCode;

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public String getQuantity(){
		return quantity;
	}

	public void setProductCode(String productCode){
		this.productCode = productCode;
	}

	public String getProductCode(){
		return productCode;
	}

	public void setPlantCode(String plantCode){
		this.plantCode = plantCode;
	}

	public String getPlantCode(){
		return plantCode;
	}
}