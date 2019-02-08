
package com.itg.calderysapp.caldNet.newIndent.home.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageModel implements Parcelable
{

    @SerializedName("Type")
    @Expose
    private Object Type;
    @SerializedName("IMID")
    @Expose
    private int IMID;
    @SerializedName("Description")
    @Expose
    private String Description;
    @SerializedName("CreatedBy")
    @Expose
    private String CreatedBy;
    @SerializedName("CreatedOn")
    @Expose
    private String CreatedOn;
    @SerializedName("UpdatedBy")
    @Expose
    private String UpdatedBy;
    @SerializedName("UpdatedOn")
    @Expose
    private String UpdatedOn;
    @SerializedName("Active")
    @Expose
    private boolean Active;
    @SerializedName("Status")
    @Expose
    private int Status;
    @SerializedName("Message")
    @Expose
    private Object Message;
    public final static Parcelable.Creator<MessageModel> CREATOR = new Creator<MessageModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MessageModel createFromParcel(Parcel in) {
            MessageModel instance = new MessageModel();
            instance.Type = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.IMID = ((int) in.readValue((int.class.getClassLoader())));
            instance.Description = ((String) in.readValue((String.class.getClassLoader())));
            instance.CreatedBy = ((String) in.readValue((String.class.getClassLoader())));
            instance.CreatedOn = ((String) in.readValue((String.class.getClassLoader())));
            instance.UpdatedBy = ((String) in.readValue((String.class.getClassLoader())));
            instance.UpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
            instance.Active = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.Status = ((int) in.readValue((int.class.getClassLoader())));
            instance.Message = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public MessageModel[] newArray(int size) {
            return (new MessageModel[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The Type
     */
    public Object getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The Type
     */
    public void setType(Object Type) {
        this.Type = Type;
    }

    /**
     * 
     * @return
     *     The IMID
     */
    public int getIMID() {
        return IMID;
    }

    /**
     * 
     * @param IMID
     *     The IMID
     */
    public void setIMID(int IMID) {
        this.IMID = IMID;
    }

    /**
     * 
     * @return
     *     The Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * 
     * @param Description
     *     The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * 
     * @return
     *     The CreatedBy
     */
    public String getCreatedBy() {
        return CreatedBy;
    }

    /**
     * 
     * @param CreatedBy
     *     The CreatedBy
     */
    public void setCreatedBy(String CreatedBy) {
        this.CreatedBy = CreatedBy;
    }

    /**
     * 
     * @return
     *     The CreatedOn
     */
    public String getCreatedOn() {
        return CreatedOn;
    }

    /**
     * 
     * @param CreatedOn
     *     The CreatedOn
     */
    public void setCreatedOn(String CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    /**
     * 
     * @return
     *     The UpdatedBy
     */
    public String getUpdatedBy() {
        return UpdatedBy;
    }

    /**
     * 
     * @param UpdatedBy
     *     The UpdatedBy
     */
    public void setUpdatedBy(String UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    /**
     * 
     * @return
     *     The UpdatedOn
     */
    public String getUpdatedOn() {
        return UpdatedOn;
    }

    /**
     * 
     * @param UpdatedOn
     *     The UpdatedOn
     */
    public void setUpdatedOn(String UpdatedOn) {
        this.UpdatedOn = UpdatedOn;
    }

    /**
     * 
     * @return
     *     The Active
     */
    public boolean isActive() {
        return Active;
    }

    /**
     * 
     * @param Active
     *     The Active
     */
    public void setActive(boolean Active) {
        this.Active = Active;
    }

    /**
     * 
     * @return
     *     The Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * 
     * @param Status
     *     The Status
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * 
     * @return
     *     The Message
     */
    public Object getMessage() {
        return Message;
    }

    /**
     * 
     * @param Message
     *     The Message
     */
    public void setMessage(Object Message) {
        this.Message = Message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(Type);
        dest.writeValue(IMID);
        dest.writeValue(Description);
        dest.writeValue(CreatedBy);
        dest.writeValue(CreatedOn);
        dest.writeValue(UpdatedBy);
        dest.writeValue(UpdatedOn);
        dest.writeValue(Active);
        dest.writeValue(Status);
        dest.writeValue(Message);
    }

    public int describeContents() {
        return  0;
    }

}
