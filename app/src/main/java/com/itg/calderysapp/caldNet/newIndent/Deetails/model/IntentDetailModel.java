package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IntentDetailModel implements Parcelable {


    //            "UserType":"DD",
//                "indent_code":"dfsdf",
//                "UserID":"sdfs",
//                "IsRejection":"dsfsd",
//                "SO_Type":"sdfsd",
//                "indent_status":"S",
//                "ApprovedBy":"fdsf",
//                "Comments":"sdfsd",
//                "SO_number":"sfd",
//                "Sales_Org":"",
//                "DistChannel":"",
//                "Division":"",
//                "SalesOffice":"",
//                "SalesGroup":"",
//                "UsageIndicator":"",
//                "SpecialProcIndicator":"",
//                "Partner":"",
//                "ProcessCode":"",
//                "EquipmentCode":"",
//                "SalesPackage":"",
//                "ApprovalType":"y"
    public   String soType;
    public  String distributionChannel;
    public  String salesOffice;
    public  String usaguageIndicator;
    public  String processCode;
    public  String equipmentCode;
    public  String salesOrganization;
    public  String division;
    public  String salesGroup;
    public  String salesPackage;
    public  String splProcessIndicator;
    public  String partner;
    public String userType;
    public String indentCode;
    public String isRejection;
    public String indentStatus;
    public String approvedBy;
    public  String approvalType;
    private String dealerCode;
    private String poNumber;
    private String poDate;
    private String consigneeCode;
    private List<Product_> productList;
    private String indentType;
    private String dispatchDate;
    private String transportName;

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    private String soNumber;

    public String getIndentDate() {
        return indentDate;
    }

    public void setIndentDate(String indentDate) {
        this.indentDate = indentDate;
    }

    public  String indentDate;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIndentCode() {
        return indentCode;
    }

    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
    }

    public String getIsRejection() {
        return isRejection;
    }

    public void setIsRejection(String isRejection) {
        this.isRejection = isRejection;
    }

    public String getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(String indentStatus) {
        this.indentStatus = indentStatus;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getCommentsForAppovedReject() {
        return commentsForAppovedReject;
    }

    public void setCommentsForAppovedReject(String commentsForAppovedReject) {
        this.commentsForAppovedReject = commentsForAppovedReject;
    }

    private String commentsForAppovedReject;
    public IntentDetailModel() {
    }

    public IntentDetailModel(String soType, String distributionChannel, String salesOffice, String usaguageIndicator, String processCode, String equipmentCode, String salesOrganization, String division, String salesGroup, String splProcessIndicator, String partner, String salesPackage) {
    
        this.soType = soType;
        this.distributionChannel = distributionChannel;
        this.salesOffice = salesOffice;
        this.usaguageIndicator = usaguageIndicator;
        this.processCode = processCode;
        this.equipmentCode = equipmentCode;
        this.salesOrganization = salesOrganization;
        this.division = division;
        this.salesGroup = salesGroup;
        this.splProcessIndicator = splProcessIndicator;
        this.partner = partner;
        this.salesPackage = salesPackage;
    }

    public String getSoType() {
    
        return soType;
    }

    public void setSoType(String soType) {
        this.soType = soType;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getSalesOffice() {
        return salesOffice;
    }

    public void setSalesOffice(String salesOffice) {
        this.salesOffice = salesOffice;
    }

    public String getUsaguageIndicator() {
        return usaguageIndicator;
    }

    public void setUsaguageIndicator(String usaguageIndicator) {
        this.usaguageIndicator = usaguageIndicator;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getSalesOrganization() {
        return salesOrganization;
    }

    public void setSalesOrganization(String salesOrganization) {
        this.salesOrganization = salesOrganization;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSalesGroup() {
        return salesGroup;
    }

    public void setSalesGroup(String salesGroup) {
        this.salesGroup = salesGroup;
    }

    public String getSplProcessIndicator() {
        return splProcessIndicator;
    }

    public void setSplProcessIndicator(String splProcessIndicator) {
        this.splProcessIndicator = splProcessIndicator;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getSalesPackage() {
        return salesPackage;
    }

    public void setSalesPackage(String salesPackage) {
        this.salesPackage = salesPackage;
    }


    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setConsigneeCode(String consigneeCode) {

        this.consigneeCode = consigneeCode;
    }

    public String getConsigneeCode() {
        return consigneeCode;
    }

    public void setProductList(List<Product_> productList) {
        this.productList = productList;
    }

    public List<Product_> getProductList() {
        return productList;
    }

    public void setIndentType(String indentType) {
        this.indentType = indentType;
    }

    public String getIndentType() {
        return indentType;
    }


    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.soType);
        dest.writeString(this.distributionChannel);
        dest.writeString(this.salesOffice);
        dest.writeString(this.usaguageIndicator);
        dest.writeString(this.processCode);
        dest.writeString(this.equipmentCode);
        dest.writeString(this.salesOrganization);
        dest.writeString(this.division);
        dest.writeString(this.salesGroup);
        dest.writeString(this.salesPackage);
        dest.writeString(this.splProcessIndicator);
        dest.writeString(this.partner);
        dest.writeString(this.userType);
        dest.writeString(this.indentCode);
        dest.writeString(this.isRejection);
        dest.writeString(this.indentStatus);
        dest.writeString(this.approvedBy);
        dest.writeString(this.approvalType);
        dest.writeString(this.dealerCode);
        dest.writeString(this.poNumber);
        dest.writeString(this.poDate);
        dest.writeString(this.consigneeCode);
        dest.writeTypedList(this.productList);
        dest.writeString(this.indentType);
        dest.writeString(this.dispatchDate);
        dest.writeString(this.soNumber);
        dest.writeString(this.indentDate);
        dest.writeString(this.commentsForAppovedReject);
    }

    protected IntentDetailModel(Parcel in) {
        this.soType = in.readString();
        this.distributionChannel = in.readString();
        this.salesOffice = in.readString();
        this.usaguageIndicator = in.readString();
        this.processCode = in.readString();
        this.equipmentCode = in.readString();
        this.salesOrganization = in.readString();
        this.division = in.readString();
        this.salesGroup = in.readString();
        this.salesPackage = in.readString();
        this.splProcessIndicator = in.readString();
        this.partner = in.readString();
        this.userType = in.readString();
        this.indentCode = in.readString();
        this.isRejection = in.readString();
        this.indentStatus = in.readString();
        this.approvedBy = in.readString();
        this.approvalType = in.readString();
        this.dealerCode = in.readString();
        this.poNumber = in.readString();
        this.poDate = in.readString();
        this.consigneeCode = in.readString();
        this.productList = in.createTypedArrayList(Product_.CREATOR);
        this.indentType = in.readString();
        this.dispatchDate = in.readString();
        this.soNumber = in.readString();
        this.indentDate = in.readString();
        this.commentsForAppovedReject = in.readString();
    }

    public static final Creator<IntentDetailModel> CREATOR = new Creator<IntentDetailModel>() {
        @Override
        public IntentDetailModel createFromParcel(Parcel source) {
            return new IntentDetailModel(source);
        }

        @Override
        public IntentDetailModel[] newArray(int size) {
            return new IntentDetailModel[size];
        }
    };

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportName() {
        return transportName;
    }
}
