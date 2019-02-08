package com.itg.calderysapp.caldNet.newIndent.addmaterial.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MaterialModel extends BaseObservable implements Parcelable {


	@SerializedName("ProductName")
	private String productName;

	@SerializedName("PageSize")
	private int pageSize;

	@SerializedName("IndentType")
	private Object indentType;

	@SerializedName("ProductCode")
	private String productCode;

	@SerializedName("Count")
	private int count;

	@SerializedName("PlantName")
	private String plantName;

	@SerializedName("Unit")
	private String unit;

	@SerializedName("PlantCode")
	private String plantCode;

	@SerializedName("SearchMaterial")
	private Object searchMaterial;

	@SerializedName("Type")
	private int type;

	@SerializedName("Division")
	private Object division;

	@SerializedName("PageNo")
	private int pageNo;

	@SerializedName("PricePerUnit")
	private String pricePerUnit;

	@SerializedName("TotalDiscount")
	private String totalDiscount;




	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setIndentType(Object indentType){
		this.indentType = indentType;
	}

	public Object getIndentType(){
		return indentType;
	}

	public void setProductCode(String productCode){
		this.productCode = productCode;
	}

	public String getProductCode(){
		return productCode;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setPlantName(String plantName){
		this.plantName = plantName;
	}

	public String getPlantName(){
		return plantName;
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

	public void setSearchMaterial(Object searchMaterial){
		this.searchMaterial = searchMaterial;
	}

	public Object getSearchMaterial(){
		return searchMaterial;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setDivision(Object division){
		this.division = division;
	}

	public Object getDivision(){
		return division;
	}

	public void setPageNo(int pageNo){
		this.pageNo = pageNo;
	}

	public int getPageNo(){
		return pageNo;
	}

	public void setPricePerUnit(String pricePerUnit){
		this.pricePerUnit = pricePerUnit;
	}

	public String getPricePerUnit(){
		return pricePerUnit;
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
			"MaterialModel{" + 
			"productName = '" + productName + '\'' + 
			",pageSize = '" + pageSize + '\'' + 
			",indentType = '" + indentType + '\'' + 
			",productCode = '" + productCode + '\'' + 
			",count = '" + count + '\'' + 
			",plantName = '" + plantName + '\'' + 
			",unit = '" + unit + '\'' + 
			",plantCode = '" + plantCode + '\'' + 
			",searchMaterial = '" + searchMaterial + '\'' + 
			",type = '" + type + '\'' + 
			",division = '" + division + '\'' + 
			",pageNo = '" + pageNo + '\'' + 
			",pricePerUnit = '" + pricePerUnit + '\'' + 
			",totalDiscount = '" + totalDiscount + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.productName);
		dest.writeInt(this.pageSize);
		dest.writeParcelable((Parcelable) this.indentType, flags);
		dest.writeString(this.productCode);
		dest.writeInt(this.count);
		dest.writeString(this.plantName);
		dest.writeString(this.unit);
		dest.writeString(this.plantCode);
		dest.writeParcelable((Parcelable) this.searchMaterial, flags);
		dest.writeInt(this.type);
		dest.writeParcelable((Parcelable) this.division, flags);
		dest.writeInt(this.pageNo);
		dest.writeString(this.pricePerUnit);
		dest.writeString(this.totalDiscount);
	}

	public MaterialModel() {
	}

	protected MaterialModel(Parcel in) {
		this.productName = in.readString();
		this.pageSize = in.readInt();
		this.indentType = in.readParcelable(Object.class.getClassLoader());
		this.productCode = in.readString();
		this.count = in.readInt();
		this.plantName = in.readString();
		this.unit = in.readString();
		this.plantCode = in.readString();
		this.searchMaterial = in.readParcelable(Object.class.getClassLoader());
		this.type = in.readInt();
		this.division = in.readParcelable(Object.class.getClassLoader());
		this.pageNo = in.readInt();
		this.pricePerUnit = in.readString();
		this.totalDiscount = in.readString();
	}

	public static final Parcelable.Creator<MaterialModel> CREATOR = new Parcelable.Creator<MaterialModel>() {
		@Override
		public MaterialModel createFromParcel(Parcel source) {
			return new MaterialModel(source);
		}

		@Override
		public MaterialModel[] newArray(int size) {
			return new MaterialModel[size];
		}
	};
}