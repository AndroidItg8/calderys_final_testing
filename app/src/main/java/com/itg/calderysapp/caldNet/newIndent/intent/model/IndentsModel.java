
package com.itg.calderysapp.caldNet.newIndent.intent.model;

import java.util.List;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itg.calderysapp.BR;
import com.itg.calderysapp.common.CommonMethod;

public class IndentsModel extends BaseObservable implements Parcelable
{

    @SerializedName("indent_code")
    @Expose
    public String indentCode;
    @SerializedName("dealer_code")
    @Expose
    public String dealerCode;
    @SerializedName("indent_date")
    @Expose
    private String indentDate;
    @SerializedName("PONumber")
    @Expose
    public String pONumber;
    @SerializedName("PODate")
    @Expose
    public String pODate;
    @SerializedName("CST")
    @Expose
    public String cST;
    @SerializedName("SGST")
    @Expose
    public String sgst;

    @SerializedName("ConsigneeCode")
    @Expose
    public String consigneeCode;
    @SerializedName("Excise_Duty")
    @Expose
    public String exciseDuty;
    @SerializedName("ind_apprvl_status")
    @Expose
    public String indApprvlStatus;
    @SerializedName("Status_date")
    @Expose
    public String statusDate;
    @SerializedName("VAT")
    @Expose
    public String vAT;
    @SerializedName("CreatedDate")
    @Expose
    public String createdDate;
    @SerializedName("DispatchDate")
    @Expose
    public String dispatchDate;
    @SerializedName("IndentType")
    @Expose
    public String indentType;
    @SerializedName("Division")
    @Expose
    public String division;
    @SerializedName("AddlTax")
    @Expose
    public String addlTax;
    @SerializedName("ConsigneeName")
    @Expose
    public String consigneeName;
    @SerializedName("PlantCode")
    @Expose
    public String plantCode;
    @SerializedName("ProductItem")
    @Expose
    public List<ProductItem> productItem = null;

    public String getSgst() {
        return sgst;
    }

    public void setSgst(String sgst) {
        this.sgst = sgst;
    }

    public final static Creator<IndentsModel> CREATOR = new Creator<IndentsModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IndentsModel createFromParcel(Parcel in) {
            return new IndentsModel(in);
        }

        public IndentsModel[] newArray(int size) {
            return (new IndentsModel[size]);
        }

    }
    ;

    @Bindable
    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
        notifyPropertyChanged(BR.consigneeName);
    }

    @Bindable
    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
        notifyPropertyChanged(BR.plantCode);
    }

    protected IndentsModel(Parcel in) {
        this.indentCode = ((String) in.readValue((String.class.getClassLoader())));
        this.dealerCode = ((String) in.readValue((String.class.getClassLoader())));
        this.indentDate = ((String) in.readValue((String.class.getClassLoader())));
        this.pONumber = ((String) in.readValue((String.class.getClassLoader())));
        this.pODate = ((String) in.readValue((String.class.getClassLoader())));
        this.cST = ((String) in.readValue((String.class.getClassLoader())));
        this.consigneeCode = ((String) in.readValue((String.class.getClassLoader())));
        this.exciseDuty = ((String) in.readValue((String.class.getClassLoader())));
        this.indApprvlStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.statusDate = ((String) in.readValue((String.class.getClassLoader())));
        this.vAT = ((String) in.readValue((String.class.getClassLoader())));
        this.createdDate = ((String) in.readValue((String.class.getClassLoader())));
        this.dispatchDate = ((String) in.readValue((String.class.getClassLoader())));
        this.indentType = ((String) in.readValue((String.class.getClassLoader())));
        this.division = ((String) in.readValue((String.class.getClassLoader())));
        this.addlTax = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.productItem, (ProductItem.class.getClassLoader()));
    }


    public IndentsModel() {
    }

    @Bindable
    public String getIndentCode() {
        return indentCode;
    }

    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
        notifyPropertyChanged(BR.indentCode);
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    @Bindable
    public String getIndentDate() {
        return indentDate;
    }


    public void setIndentDate(String indentDate) {
        this.indentDate = indentDate;
        notifyPropertyChanged(BR.indentDate);
    }

    @Bindable
    public String getPONumber() {
        return pONumber;
    }

    public void setPONumber(String pONumber) {
        this.pONumber = pONumber;
        notifyPropertyChanged(BR.pONumber);
    }

    @Bindable
    public String getPODate() {
//        if(CommonMethod.isValidFormat(pODate) || CommonMethod.isValidFormatT(pODate)){
//            this.pODate=CommonMethod.getDDMMYYYYfromDateServerForField(pODate);
//        }
        return pODate;
    }

    public void setPODate(String pODate) {
//        if(CommonMethod.isValidFormat(pODate)){
//            this.pODate=CommonMethod.getDDMMYYYYfromDateServerForField(pODate);
//        }else
            this.pODate = pODate;
        notifyPropertyChanged(BR.pODate);
    }

    public void setPODateForServer(String pODate) {
            this.pODate=CommonMethod.getDDMMYYYYfromDateServer(pODate);
    }



    @Bindable
    public String getCST() {
        return cST;
    }


    public void setCST(String cST) {
        this.cST = cST;
        notifyPropertyChanged(BR.cST);
    }

    @Bindable
    public String getConsigneeCode() {
        return consigneeCode;
    }

    public void setConsigneeCode(String consigneeCode) {
        this.consigneeCode = consigneeCode;
        notifyPropertyChanged(BR.consigneeCode);
    }

    public String getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(String exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public String getIndApprvlStatus() {
        return indApprvlStatus;
    }

    public void setIndApprvlStatus(String indApprvlStatus) {
        this.indApprvlStatus = indApprvlStatus;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    @Bindable
    public String getVAT() {
        return vAT;
    }

    public void setVAT(String vAT) {
        this.vAT = vAT;
        notifyPropertyChanged(BR.vAT);
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Bindable
    public String getDispatchDate() {
//        if(CommonMethod.isValidFormat(dispatchDate) || CommonMethod.isValidFormatT(dispatchDate)){
//            this.dispatchDate=CommonMethod.getDDMMYYYYfromDateServerForField(dispatchDate);
//        }
        return dispatchDate;
    }

    public String getDispatchDateValided() {

        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
//        if(CommonMethod.isValidFormat(dispatchDate)){
//            this.dispatchDate=CommonMethod.getDDMMYYYYfromDateServerForField(dispatchDate);
//        }else
            this.dispatchDate = dispatchDate;
        notifyPropertyChanged(BR.dispatchDate);
    }

    public void setDispatchDateForServer(String dispatchDate){
        this.dispatchDate=CommonMethod.getDDMMYYYYfromDateServer(dispatchDate);
    }

    @Bindable
    public String getIndentType() {
        return indentType;
    }

    public void setIndentType(String indentType) {
        this.indentType = indentType;
        notifyPropertyChanged(BR.indentType);
    }

    @Bindable
    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
        notifyPropertyChanged(BR.division);
    }

    public String getAddlTax() {
        return addlTax;
    }

    public void setAddlTax(String addlTax) {
        this.addlTax = addlTax;
    }

    public List<ProductItem> getProductItem() {
        return productItem;
    }

    public void setProductItem(List<ProductItem> productItem) {
        this.productItem = productItem;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(indentCode);
        dest.writeValue(dealerCode);
        dest.writeValue(indentDate);
        dest.writeValue(pONumber);
        dest.writeValue(pODate);
        dest.writeValue(cST);
        dest.writeValue(consigneeCode);
        dest.writeValue(exciseDuty);
        dest.writeValue(indApprvlStatus);
        dest.writeValue(statusDate);
        dest.writeValue(vAT);
        dest.writeValue(createdDate);
        dest.writeValue(dispatchDate);
        dest.writeValue(indentType);
        dest.writeValue(division);
        dest.writeValue(addlTax);
        dest.writeList(productItem);
    }

    public int describeContents() {
        return  0;
    }

    public String getPODateValidate() {
        return pODate;
    }


}
