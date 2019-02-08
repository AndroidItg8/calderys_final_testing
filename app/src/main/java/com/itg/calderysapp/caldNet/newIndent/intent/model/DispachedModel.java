
package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DispachedModel implements Parcelable
{

    @SerializedName("PO_number")
    @Expose
    private String PONumber;
    @SerializedName("SO_number")
    @Expose
    private String SONumber;
    @SerializedName("SO_date")
    @Expose
    private String SODate;
    @SerializedName("Invoice_number")
    @Expose
    private String InvoiceNumber;
    @SerializedName("Invoice_date")
    @Expose
    private String InvoiceDate;
    @SerializedName("InvoiceAmount")
    @Expose
    private float InvoiceAmount;
    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("SO_quantity")
    @Expose
    private int SOQuantity;
    @SerializedName("Dispatch_quantity")
    @Expose
    private int DispatchQuantity;
    @SerializedName("Balance_quantity")
    @Expose
    private int BalanceQuantity;
    @SerializedName("Mail_Sent")
    @Expose
    private boolean MailSent;
    @SerializedName("TransporterName")
    @Expose
    private String TransporterName;
    @SerializedName("truckno")
    @Expose
    private String truckno;
    @SerializedName("LRDetails")
    @Expose
    private String LRDetails;
    @SerializedName("Count")
    @Expose
    private int Count;
    @SerializedName("PageNo")
    @Expose
    private int PageNo;
    protected final static Object NOT_FOUND_VALUE = new Object();
    public final static Parcelable.Creator<DispachedModel> CREATOR = new Creator<DispachedModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DispachedModel createFromParcel(Parcel in) {
            DispachedModel instance = new DispachedModel();
            instance.PONumber = ((String) in.readValue((String.class.getClassLoader())));
            instance.SONumber = ((String) in.readValue((String.class.getClassLoader())));
            instance.SODate = ((String) in.readValue((String.class.getClassLoader())));
            instance.InvoiceNumber = ((String) in.readValue((String.class.getClassLoader())));
            instance.InvoiceDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.InvoiceAmount = ((int) in.readValue((int.class.getClassLoader())));
            instance.productCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.SOQuantity = ((int) in.readValue((int.class.getClassLoader())));
            instance.DispatchQuantity = ((int) in.readValue((int.class.getClassLoader())));
            instance.BalanceQuantity = ((int) in.readValue((int.class.getClassLoader())));
            instance.MailSent = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.TransporterName = ((String) in.readValue((String.class.getClassLoader())));
            instance.truckno = ((String) in.readValue((String.class.getClassLoader())));
            instance.LRDetails = ((String) in.readValue((String.class.getClassLoader())));
            instance.Count = ((int) in.readValue((int.class.getClassLoader())));
            instance.PageNo = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public DispachedModel[] newArray(int size) {
            return (new DispachedModel[size]);
        }

    }
    ;

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
     *     The PO_number
     */
    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
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
     *     The SO_date
     */
    public void setSODate(String SODate) {
        this.SODate = SODate;
    }

    /**
     * 
     * @return
     *     The InvoiceNumber
     */
    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    /**
     * 
     * @param InvoiceNumber
     *     The Invoice_number
     */
    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    /**
     * 
     * @return
     *     The InvoiceDate
     */
    public String getInvoiceDate() {
        return InvoiceDate;
    }

    /**
     * 
     * @param InvoiceDate
     *     The Invoice_date
     */
    public void setInvoiceDate(String InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    /**
     * 
     * @return
     *     The InvoiceAmount
     */
    public Float getInvoiceAmount() {
        return InvoiceAmount;
    }

    /**
     * 
     * @param InvoiceAmount
     *     The InvoiceAmount
     */
    public void setInvoiceAmount(Float InvoiceAmount) {
        this.InvoiceAmount = InvoiceAmount;
    }

    /**
     * 
     * @return
     *     The productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 
     * @param productCode
     *     The product_code
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 
     * @return
     *     The SOQuantity
     */
    public int getSOQuantity() {
        return SOQuantity;
    }

    /**
     * 
     * @param SOQuantity
     *     The SO_quantity
     */
    public void setSOQuantity(int SOQuantity) {
        this.SOQuantity = SOQuantity;
    }

    /**
     * 
     * @return
     *     The DispatchQuantity
     */
    public int getDispatchQuantity() {
        return DispatchQuantity;
    }

    /**
     * 
     * @param DispatchQuantity
     *     The Dispatch_quantity
     */
    public void setDispatchQuantity(int DispatchQuantity) {
        this.DispatchQuantity = DispatchQuantity;
    }

    /**
     * 
     * @return
     *     The BalanceQuantity
     */
    public int getBalanceQuantity() {
        return BalanceQuantity;
    }

    /**
     * 
     * @param BalanceQuantity
     *     The Balance_quantity
     */
    public void setBalanceQuantity(int BalanceQuantity) {
        this.BalanceQuantity = BalanceQuantity;
    }

    /**
     * 
     * @return
     *     The MailSent
     */
    public boolean isMailSent() {
        return MailSent;
    }

    /**
     * 
     * @param MailSent
     *     The Mail_Sent
     */
    public void setMailSent(boolean MailSent) {
        this.MailSent = MailSent;
    }

    /**
     * 
     * @return
     *     The TransporterName
     */
    public String getTransporterName() {
        return TransporterName;
    }

    /**
     * 
     * @param TransporterName
     *     The TransporterName
     */
    public void setTransporterName(String TransporterName) {
        this.TransporterName = TransporterName;
    }

    /**
     * 
     * @return
     *     The truckno
     */
    public String getTruckno() {
        return truckno;
    }

    /**
     * 
     * @param truckno
     *     The truckno
     */
    public void setTruckno(String truckno) {
        this.truckno = truckno;
    }

    /**
     * 
     * @return
     *     The LRDetails
     */
    public String getLRDetails() {
        return LRDetails;
    }

    /**
     * 
     * @param LRDetails
     *     The LRDetails
     */
    public void setLRDetails(String LRDetails) {
        this.LRDetails = LRDetails;
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

    @SuppressWarnings({
        "unchecked"
    })
    protected boolean declaredProperty(String name, Object value) {
        if ("PO_number".equals(name)) {
            if (value instanceof String) {
                setPONumber(((String) value));
            } else {
                throw new IllegalArgumentException(("property \"PO_number\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
            }
            return true;
        } else {
            if ("SO_number".equals(name)) {
                if (value instanceof String) {
                    setSONumber(((String) value));
                } else {
                    throw new IllegalArgumentException(("property \"SO_number\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                }
                return true;
            } else {
                if ("SO_date".equals(name)) {
                    if (value instanceof String) {
                        setSODate(((String) value));
                    } else {
                        throw new IllegalArgumentException(("property \"SO_date\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                    }
                    return true;
                } else {
                    if ("Invoice_number".equals(name)) {
                        if (value instanceof String) {
                            setInvoiceNumber(((String) value));
                        } else {
                            throw new IllegalArgumentException(("property \"Invoice_number\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                        }
                        return true;
                    } else {
                        if ("Invoice_date".equals(name)) {
                            if (value instanceof String) {
                                setInvoiceDate(((String) value));
                            } else {
                                throw new IllegalArgumentException(("property \"Invoice_date\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                            }
                            return true;
                        } else {
                            if ("InvoiceAmount".equals(name)) {
                                if (value instanceof Float) {
                                    setInvoiceAmount(((Float) value));
                                } else {
                                    throw new IllegalArgumentException(("property \"InvoiceAmount\" is of type \"int\", but got "+ value.getClass().toString()));
                                }
                                return true;
                            } else {
                                if ("product_code".equals(name)) {
                                    if (value instanceof String) {
                                        setProductCode(((String) value));
                                    } else {
                                        throw new IllegalArgumentException(("property \"product_code\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                                    }
                                    return true;
                                } else {
                                    if ("SO_quantity".equals(name)) {
                                        if (value instanceof Integer) {
                                            setSOQuantity(((Integer) value));
                                        } else {
                                            throw new IllegalArgumentException(("property \"SO_quantity\" is of type \"int\", but got "+ value.getClass().toString()));
                                        }
                                        return true;
                                    } else {
                                        if ("Dispatch_quantity".equals(name)) {
                                            if (value instanceof Integer) {
                                                setDispatchQuantity(((Integer) value));
                                            } else {
                                                throw new IllegalArgumentException(("property \"Dispatch_quantity\" is of type \"int\", but got "+ value.getClass().toString()));
                                            }
                                            return true;
                                        } else {
                                            if ("Balance_quantity".equals(name)) {
                                                if (value instanceof Integer) {
                                                    setBalanceQuantity(((Integer) value));
                                                } else {
                                                    throw new IllegalArgumentException(("property \"Balance_quantity\" is of type \"int\", but got "+ value.getClass().toString()));
                                                }
                                                return true;
                                            } else {
                                                if ("Mail_Sent".equals(name)) {
                                                    if (value instanceof Boolean) {
                                                        setMailSent(((Boolean) value));
                                                    } else {
                                                        throw new IllegalArgumentException(("property \"Mail_Sent\" is of type \"boolean\", but got "+ value.getClass().toString()));
                                                    }
                                                    return true;
                                                } else {
                                                    if ("TransporterName".equals(name)) {
                                                        if (value instanceof String) {
                                                            setTransporterName(((String) value));
                                                        } else {
                                                            throw new IllegalArgumentException(("property \"TransporterName\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                                                        }
                                                        return true;
                                                    } else {
                                                        if ("truckno".equals(name)) {
                                                            if (value instanceof String) {
                                                                setTruckno(((String) value));
                                                            } else {
                                                                throw new IllegalArgumentException(("property \"truckno\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                                                            }
                                                            return true;
                                                        } else {
                                                            if ("LRDetails".equals(name)) {
                                                                if (value instanceof String) {
                                                                    setLRDetails(((String) value));
                                                                } else {
                                                                    throw new IllegalArgumentException(("property \"LRDetails\" is of type \"java.lang.String\", but got "+ value.getClass().toString()));
                                                                }
                                                                return true;
                                                            } else {
                                                                if ("Count".equals(name)) {
                                                                    if (value instanceof Integer) {
                                                                        setCount(((Integer) value));
                                                                    } else {
                                                                        throw new IllegalArgumentException(("property \"Count\" is of type \"int\", but got "+ value.getClass().toString()));
                                                                    }
                                                                    return true;
                                                                } else {
                                                                    if ("PageNo".equals(name)) {
                                                                        if (value instanceof Integer) {
                                                                            setPageNo(((Integer) value));
                                                                        } else {
                                                                            throw new IllegalArgumentException(("property \"PageNo\" is of type \"int\", but got "+ value.getClass().toString()));
                                                                        }
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected Object declaredPropertyOrNotFound(String name, Object notFoundValue) {
        if ("PO_number".equals(name)) {
            return getPONumber();
        } else {
            if ("SO_number".equals(name)) {
                return getSONumber();
            } else {
                if ("SO_date".equals(name)) {
                    return getSODate();
                } else {
                    if ("Invoice_number".equals(name)) {
                        return getInvoiceNumber();
                    } else {
                        if ("Invoice_date".equals(name)) {
                            return getInvoiceDate();
                        } else {
                            if ("InvoiceAmount".equals(name)) {
                                return getInvoiceAmount();
                            } else {
                                if ("product_code".equals(name)) {
                                    return getProductCode();
                                } else {
                                    if ("SO_quantity".equals(name)) {
                                        return getSOQuantity();
                                    } else {
                                        if ("Dispatch_quantity".equals(name)) {
                                            return getDispatchQuantity();
                                        } else {
                                            if ("Balance_quantity".equals(name)) {
                                                return getBalanceQuantity();
                                            } else {
                                                if ("Mail_Sent".equals(name)) {
                                                    return isMailSent();
                                                } else {
                                                    if ("TransporterName".equals(name)) {
                                                        return getTransporterName();
                                                    } else {
                                                        if ("truckno".equals(name)) {
                                                            return getTruckno();
                                                        } else {
                                                            if ("LRDetails".equals(name)) {
                                                                return getLRDetails();
                                                            } else {
                                                                if ("Count".equals(name)) {
                                                                    return getCount();
                                                                } else {
                                                                    if ("PageNo".equals(name)) {
                                                                        return getPageNo();
                                                                    } else {
                                                                        return notFoundValue;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public<T >T get(String name) {
        Object value = declaredPropertyOrNotFound(name, DispachedModel.NOT_FOUND_VALUE);
        if (DispachedModel.NOT_FOUND_VALUE!= value) {
            return ((T) value);
        } else {
            throw new IllegalArgumentException((("property \""+ name)+"\" is not defined"));
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public void set(String name, Object value) {
        if (!declaredProperty(name, value)) {
            throw new IllegalArgumentException((("property \""+ name)+"\" is not defined"));
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(PONumber);
        dest.writeValue(SONumber);
        dest.writeValue(SODate);
        dest.writeValue(InvoiceNumber);
        dest.writeValue(InvoiceDate);
        dest.writeValue(InvoiceAmount);
        dest.writeValue(productCode);
        dest.writeValue(SOQuantity);
        dest.writeValue(DispatchQuantity);
        dest.writeValue(BalanceQuantity);
        dest.writeValue(MailSent);
        dest.writeValue(TransporterName);
        dest.writeValue(truckno);
        dest.writeValue(LRDetails);
        dest.writeValue(Count);
        dest.writeValue(PageNo);
    }

    public int describeContents() {
        return  0;
    }

}
