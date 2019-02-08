
package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndentModel
        implements Parcelable
{

    @SerializedName("indent_code")
    @Expose
    private String indentCode;
    @SerializedName("dealer_code")
    @Expose
    private String dealerCode;
    @SerializedName("indent_date")
    @Expose
    private String indentDate;
    @SerializedName("PONumber")
    @Expose
    private String PONumber;
    @SerializedName("PODate")
    @Expose
    private String PODate;
    @SerializedName("CST")
    @Expose
    private String CST;
    @SerializedName("ConsigneeCode")
    @Expose
    private String ConsigneeCode;
    @SerializedName("Excise_Duty")
    @Expose
    private String ExciseDuty;
    @SerializedName("ind_apprvl_status")
    @Expose
    private String indApprvlStatus;
    @SerializedName("SO_Type")
    @Expose
    private String SOType;
    @SerializedName("Sap_Upload")
    @Expose
    private int SapUpload;
    @SerializedName("indent_status")
    @Expose
    private String indentStatus;
    @SerializedName("Status_date")
    @Expose
    private String StatusDate;
    @SerializedName("VAT")
    @Expose
    private String VAT;
    @SerializedName("CreatedDate")
    @Expose
    private String CreatedDate;
    @SerializedName("ModifiedDate")
    @Expose
    private Object ModifiedDate;
    @SerializedName("ind_closure_date")
    @Expose
    private String indClosureDate;
    @SerializedName("Approvedby")
    @Expose
    private String Approvedby;
    @SerializedName("SO_number")
    @Expose
    private String SONumber;
    @SerializedName("SO_Date")
    @Expose
    private String SODate;
    @SerializedName("SO_MailSent")
    @Expose
    private boolean SOMailSent;
    @SerializedName("Comments")
    @Expose
    private String Comments;
    @SerializedName("DispatchDate")
    @Expose
    private String DispatchDate;
    @SerializedName("IndentType")
    @Expose
    private String IndentType;
    @SerializedName("Division")
    @Expose
    private String Division;
    @SerializedName("SentMail")
    @Expose
    private boolean SentMail;
    @SerializedName("Tax")
    @Expose
    private String Tax;
    @SerializedName("AddlTax")
    @Expose
    private String AddlTax;
    @SerializedName("Count")
    @Expose
    private int Count;
    @SerializedName("PageNo")
    @Expose
    private int PageNo;
    public boolean isDelete;

    /**
     * 
     * @return
     *     The indentCode
     */
    public String getIndentCode() {
        return indentCode;
    }

    /**
     * 
     * @param indentCode
     *     The indent_code
     */
    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
    }

    /**
     * 
     * @return
     *     The dealerCode
     */
    public String getDealerCode() {
        return dealerCode;
    }

    /**
     * 
     * @param dealerCode
     *     The dealer_code
     */
    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    /**
     * 
     * @return
     *     The indentDate
     */
    public String getIndentDate() {
        return indentDate;
    }

    /**
     * 
     * @param indentDate
     *     The indent_date
     */
    public void setIndentDate(String indentDate) {
        this.indentDate = indentDate;
    }

    /**
     * 
     * @return
     *     The PONumber
     */
    public String getPONumber() {
        return PONumber;
    }

    /**
     * 
     * @param PONumber
     *     The PONumber
     */
    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
    }

    /**
     * 
     * @return
     *     The PODate
     */
    public String getPODate() {
        return PODate;
    }

    /**
     * 
     * @param PODate
     *     The PODate
     */
    public void setPODate(String PODate) {
        this.PODate = PODate;
    }

    /**
     * 
     * @return
     *     The CST
     */
    public String getCST() {
        return CST;
    }

    /**
     * 
     * @param CST
     *     The CST
     */
    public void setCST(String CST) {
        this.CST = CST;
    }

    /**
     * 
     * @return
     *     The ConsigneeCode
     */
    public String getConsigneeCode() {
        return ConsigneeCode;
    }

    /**
     * 
     * @param ConsigneeCode
     *     The ConsigneeCode
     */
    public void setConsigneeCode(String ConsigneeCode) {
        this.ConsigneeCode = ConsigneeCode;
    }

    /**
     * 
     * @return
     *     The ExciseDuty
     */
    public String getExciseDuty() {
        return ExciseDuty;
    }

    /**
     * 
     * @param ExciseDuty
     *     The Excise_Duty
     */
    public void setExciseDuty(String ExciseDuty) {
        this.ExciseDuty = ExciseDuty;
    }

    /**
     * 
     * @return
     *     The indApprvlStatus
     */
    public String getIndApprvlStatus() {
        return indApprvlStatus;
    }

    /**
     * 
     * @param indApprvlStatus
     *     The ind_apprvl_status
     */
    public void setIndApprvlStatus(String indApprvlStatus) {
        this.indApprvlStatus = indApprvlStatus;
    }

    /**
     * 
     * @return
     *     The SOType
     */
    public String getSOType() {
        return SOType;
    }

    /**
     * 
     * @param SOType
     *     The SO_Type
     */
    public void setSOType(String SOType) {
        this.SOType = SOType;
    }

    /**
     * 
     * @return
     *     The SapUpload
     */
    public int getSapUpload() {
        return SapUpload;
    }

    /**
     * 
     * @param SapUpload
     *     The Sap_Upload
     */
    public void setSapUpload(int SapUpload) {
        this.SapUpload = SapUpload;
    }

    /**
     * 
     * @return
     *     The indentStatus
     */
    public String getIndentStatus() {
        return indentStatus;
    }

    /**
     * 
     * @param indentStatus
     *     The indent_status
     */
    public void setIndentStatus(String indentStatus) {
        this.indentStatus = indentStatus;
    }

    /**
     * 
     * @return
     *     The StatusDate
     */
    public String getStatusDate() {
        return StatusDate;
    }

    /**
     * 
     * @param StatusDate
     *     The Status_date
     */
    public void setStatusDate(String StatusDate) {
        this.StatusDate = StatusDate;
    }

    /**
     * 
     * @return
     *     The VAT
     */
    public String getVAT() {
        return VAT;
    }

    /**
     * 
     * @param VAT
     *     The VAT
     */
    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    /**
     * 
     * @return
     *     The CreatedDate
     */
    public String getCreatedDate() {
        return CreatedDate;
    }

    /**
     * 
     * @param CreatedDate
     *     The CreatedDate
     */
    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    /**
     * 
     * @return
     *     The ModifiedDate
     */
    public Object getModifiedDate() {
        return ModifiedDate;
    }

    /**
     * 
     * @param ModifiedDate
     *     The ModifiedDate
     */
    public void setModifiedDate(Object ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    /**
     * 
     * @return
     *     The indClosureDate
     */
    public String getIndClosureDate() {
        return indClosureDate;
    }

    /**
     * 
     * @param indClosureDate
     *     The ind_closure_date
     */
    public void setIndClosureDate(String indClosureDate) {
        this.indClosureDate = indClosureDate;
    }

    /**
     * 
     * @return
     *     The Approvedby
     */
    public String getApprovedby() {
        return Approvedby;
    }

    /**
     * 
     * @param Approvedby
     *     The Approvedby
     */
    public void setApprovedby(String Approvedby) {
        this.Approvedby = Approvedby;
    }

    /**
     * 
     * @return
     *     The SONumber
     */
    public String getSONumber() {
        return SONumber;
    }

    /**
     * 
     * @param SONumber
     *     The SO_number
     */
    public void setSONumber(String SONumber) {
        this.SONumber = SONumber;
    }

    /**
     * 
     * @return
     *     The SODate
     */
    public String getSODate() {
        return SODate;
    }

    /**
     * 
     * @param SODate
     *     The SO_Date
     */
    public void setSODate(String SODate) {
        this.SODate = SODate;
    }

    /**
     * 
     * @return
     *     The SOMailSent
     */
    public boolean isSOMailSent() {
        return SOMailSent;
    }

    /**
     * 
     * @param SOMailSent
     *     The SO_MailSent
     */
    public void setSOMailSent(boolean SOMailSent) {
        this.SOMailSent = SOMailSent;
    }

    /**
     * 
     * @return
     *     The Comments
     */
    public String getComments() {
        return Comments;
    }

    /**
     * 
     * @param Comments
     *     The Comments
     */
    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    /**
     * 
     * @return
     *     The DispatchDate
     */
    public String getDispatchDate() {
        return DispatchDate;
    }

    /**
     * 
     * @param DispatchDate
     *     The DispatchDate
     */
    public void setDispatchDate(String DispatchDate) {
        this.DispatchDate = DispatchDate;
    }

    /**
     * 
     * @return
     *     The IndentType
     */
    public String getIndentType() {
        return IndentType;
    }

    /**
     * 
     * @param IndentType
     *     The IndentType
     */
    public void setIndentType(String IndentType) {
        this.IndentType = IndentType;
    }

    /**
     * 
     * @return
     *     The Division
     */
    public String getDivision() {
        return Division;
    }

    /**
     * 
     * @param Division
     *     The Division
     */
    public void setDivision(String Division) {
        this.Division = Division;
    }

    /**
     * 
     * @return
     *     The SentMail
     */
    public boolean isSentMail() {
        return SentMail;
    }

    /**
     * 
     * @param SentMail
     *     The SentMail
     */
    public void setSentMail(boolean SentMail) {
        this.SentMail = SentMail;
    }

    /**
     * 
     * @return
     *     The Tax
     */
    public String getTax() {
        return Tax;
    }

    /**
     * 
     * @param Tax
     *     The Tax
     */
    public void setTax(String Tax) {
        this.Tax = Tax;
    }

    /**
     * 
     * @return
     *     The AddlTax
     */
    public String getAddlTax() {
        return AddlTax;
    }

    /**
     * 
     * @param AddlTax
     *     The AddlTax
     */
    public void setAddlTax(String AddlTax) {
        this.AddlTax = AddlTax;
    }

    /**
     * 
     * @return
     *     The Count
     */
    public int getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

    /**
     * 
     * @return
     *     The PageNo
     */
    public int getPageNo() {
        return PageNo;
    }

    /**
     * 
     * @param PageNo
     *     The PageNo
     */
    public void setPageNo(int PageNo) {
        this.PageNo = PageNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.indentCode);
        dest.writeString(this.dealerCode);
        dest.writeString(this.indentDate);
        dest.writeString(this.PONumber);
        dest.writeString(this.PODate);
        dest.writeString(this.CST);
        dest.writeString(this.ConsigneeCode);
        dest.writeString(this.ExciseDuty);
        dest.writeString(this.indApprvlStatus);
        dest.writeString(this.SOType);
        dest.writeInt(this.SapUpload);
        dest.writeString(this.indentStatus);
        dest.writeString(this.StatusDate);
        dest.writeString(this.VAT);
        dest.writeString(this.CreatedDate);
        dest.writeParcelable((Parcelable) this.ModifiedDate, flags);
        dest.writeString(this.indClosureDate);
        dest.writeString(this.Approvedby);
        dest.writeString(this.SONumber);
        dest.writeString(this.SODate);
        dest.writeByte(this.SOMailSent ? (byte) 1 : (byte) 0);
        dest.writeString(this.Comments);
        dest.writeString(this.DispatchDate);
        dest.writeString(this.IndentType);
        dest.writeString(this.Division);
        dest.writeByte(this.SentMail ? (byte) 1 : (byte) 0);
        dest.writeString(this.Tax);
        dest.writeString(this.AddlTax);
        dest.writeInt(this.Count);
        dest.writeInt(this.PageNo);
    }

    public IndentModel() {
    }

    protected IndentModel(Parcel in) {
        this.indentCode = in.readString();
        this.dealerCode = in.readString();
        this.indentDate = in.readString();
        this.PONumber = in.readString();
        this.PODate = in.readString();
        this.CST = in.readString();
        this.ConsigneeCode = in.readString();
        this.ExciseDuty = in.readString();
        this.indApprvlStatus = in.readString();
        this.SOType = in.readString();
        this.SapUpload = in.readInt();
        this.indentStatus = in.readString();
        this.StatusDate = in.readString();
        this.VAT = in.readString();
        this.CreatedDate = in.readString();
        this.ModifiedDate = in.readParcelable(Object.class.getClassLoader());
        this.indClosureDate = in.readString();
        this.Approvedby = in.readString();
        this.SONumber = in.readString();
        this.SODate = in.readString();
        this.SOMailSent = in.readByte() != 0;
        this.Comments = in.readString();
        this.DispatchDate = in.readString();
        this.IndentType = in.readString();
        this.Division = in.readString();
        this.SentMail = in.readByte() != 0;
        this.Tax = in.readString();
        this.AddlTax = in.readString();
        this.Count = in.readInt();
        this.PageNo = in.readInt();
    }

    public static final Creator<IndentModel> CREATOR = new Creator<IndentModel>() {
        @Override
        public IndentModel createFromParcel(Parcel source) {
            return new IndentModel(source);
        }

        @Override
        public IndentModel[] newArray(int size) {
            return new IndentModel[size];
        }
    };

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean b) {

        this.isDelete = b;
    }


}
