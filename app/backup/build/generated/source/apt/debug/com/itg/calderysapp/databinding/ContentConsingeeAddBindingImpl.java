package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentConsingeeAddBindingImpl extends ContentConsingeeAddBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.headerItemText, 17);
        sViewsWithIds.put(R.id.lbl_dealer_name, 18);
        sViewsWithIds.put(R.id.lbl_postal, 19);
        sViewsWithIds.put(R.id.strut, 20);
        sViewsWithIds.put(R.id.lbl_country, 21);
        sViewsWithIds.put(R.id.lbl_region, 22);
        sViewsWithIds.put(R.id.lbl_ecc_number, 23);
        sViewsWithIds.put(R.id.lbl_lst_no, 24);
        sViewsWithIds.put(R.id.lbl_tin_number, 25);
        sViewsWithIds.put(R.id.lbl_cst_no, 26);
        sViewsWithIds.put(R.id.lbl_mobile_number, 27);
        sViewsWithIds.put(R.id.lbl_email_address, 28);
        sViewsWithIds.put(R.id.lbl_consingee_address, 29);
        sViewsWithIds.put(R.id.lbl_lst_date, 30);
        sViewsWithIds.put(R.id.lbl_telephone_no, 31);
        sViewsWithIds.put(R.id.lbl_fax_no, 32);
        sViewsWithIds.put(R.id.lbl_contant_person, 33);
    }
    // views
    @NonNull
    private final android.support.v4.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mConsigneeModelOnDatePickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mConsigneeModelOnSubmitClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener edtLstDateandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ConsigneeViewModel.model.LSTDate
            //         is ConsigneeViewModel.model.setLSTDate((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edtLstDate);
            // localize variables for thread safety
            // ConsigneeViewModel.model
            com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel consigneeModelModel = null;
            // ConsigneeViewModel.model
            com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel consigneeViewModelModel = null;
            // ConsigneeViewModel.model != null
            boolean consigneeViewModelModelJavaLangObjectNull = false;
            // consigneeModel
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel consigneeModel = mConsigneeModel;
            // ConsigneeViewModel.model.LSTDate
            java.lang.String consigneeModelModelLSTDate = null;



            consigneeViewModelModel = com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.model;

            consigneeViewModelModelJavaLangObjectNull = (consigneeViewModelModel) != (null);
            if (consigneeViewModelModelJavaLangObjectNull) {




                consigneeViewModelModel.setLSTDate(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ContentConsingeeAddBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 34, sIncludes, sViewsWithIds));
    }
    private ContentConsingeeAddBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.Button) bindings[16]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[15]
            , (android.support.v7.widget.AppCompatSpinner) bindings[3]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[2]
            , (android.support.v7.widget.AppCompatSpinner) bindings[4]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[25]
            , (android.view.View) bindings[20]
            );
        this.btnSubmit.setTag(null);
        this.editDealerName.setTag(null);
        this.edtConsingeeAddress.setTag(null);
        this.edtContactPerson.setTag(null);
        this.edtCountry.setTag(null);
        this.edtCstNo.setTag(null);
        this.edtEccNumber.setTag(null);
        this.edtEmailAddress.setTag(null);
        this.edtFaxNo.setTag(null);
        this.edtLstDate.setTag(null);
        this.edtLstNo.setTag(null);
        this.edtMobileNumber.setTag(null);
        this.edtPostal.setTag(null);
        this.edtRegion.setTag(null);
        this.edtTelephoneNumber.setTag(null);
        this.edtTinNumber.setTag(null);
        this.mboundView0 = (android.support.v4.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.consigneeModel == variableId) {
            setConsigneeModel((com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setConsigneeModel(@Nullable com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel ConsigneeModel) {
        updateRegistration(2, ConsigneeModel);
        this.mConsigneeModel = ConsigneeModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.consigneeModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeConsigneeModelModel((com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel) object, fieldId);
            case 1 :
                return onChangeConsigneeModelAllReagions((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel>) object, fieldId);
            case 2 :
                return onChangeConsigneeModel((com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel) object, fieldId);
            case 3 :
                return onChangeConsigneeModelAllContriesObs((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeConsigneeModelModel(com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel ConsigneeModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.lSTDate) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConsigneeModelAllReagions(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> ConsigneeModelAllReagions, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConsigneeModel(com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel ConsigneeModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConsigneeModelAllContriesObs(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> ConsigneeModelAllContriesObs, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel consigneeModelModel = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> consigneeModelAllReagions = null;
        java.lang.String consigneeModelModelConsigneeAddress = null;
        java.lang.String consigneeModelModelMobile = null;
        java.lang.String consigneeModelModelEmail = null;
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel consigneeModel = mConsigneeModel;
        java.lang.String consigneeModelModelConsigneeName = null;
        java.lang.String consigneeModelModelCSTNo = null;
        java.lang.String consigneeModelModelEccNo = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> consigneeModelAllContriesObs = null;
        java.lang.String consigneeModelModelLSTNo = null;
        java.lang.String consigneeModelModelPhone = null;
        java.lang.String consigneeModelModelFaxNo = null;
        java.lang.String consigneeModelModelLSTDate = null;
        android.view.View.OnClickListener consigneeModelOnDatePickAndroidViewViewOnClickListener = null;
        java.lang.String consigneeModelModelPostalCode = null;
        java.lang.String consigneeModelModelTinNo = null;
        java.lang.String consigneeModelModelContactPerson = null;
        android.view.View.OnClickListener consigneeModelOnSubmitClickAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x31L) != 0) {

                // read ConsigneeViewModel.model
                consigneeModelModel = com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.model;
                updateRegistration(0, consigneeModelModel);

            if ((dirtyFlags & 0x21L) != 0) {

                    if (consigneeModelModel != null) {
                        // read ConsigneeViewModel.model.ConsigneeAddress
                        consigneeModelModelConsigneeAddress = consigneeModelModel.ConsigneeAddress;
                        // read ConsigneeViewModel.model.Mobile
                        consigneeModelModelMobile = consigneeModelModel.Mobile;
                        // read ConsigneeViewModel.model.Email
                        consigneeModelModelEmail = consigneeModelModel.Email;
                        // read ConsigneeViewModel.model.ConsigneeName
                        consigneeModelModelConsigneeName = consigneeModelModel.ConsigneeName;
                        // read ConsigneeViewModel.model.CSTNo
                        consigneeModelModelCSTNo = consigneeModelModel.CSTNo;
                        // read ConsigneeViewModel.model.EccNo
                        consigneeModelModelEccNo = consigneeModelModel.EccNo;
                        // read ConsigneeViewModel.model.LSTNo
                        consigneeModelModelLSTNo = consigneeModelModel.LSTNo;
                        // read ConsigneeViewModel.model.Phone
                        consigneeModelModelPhone = consigneeModelModel.Phone;
                        // read ConsigneeViewModel.model.FaxNo
                        consigneeModelModelFaxNo = consigneeModelModel.FaxNo;
                        // read ConsigneeViewModel.model.PostalCode
                        consigneeModelModelPostalCode = consigneeModelModel.PostalCode;
                        // read ConsigneeViewModel.model.TinNo
                        consigneeModelModelTinNo = consigneeModelModel.TinNo;
                        // read ConsigneeViewModel.model.ContactPerson
                        consigneeModelModelContactPerson = consigneeModelModel.ContactPerson;
                    }
            }

                if (consigneeModelModel != null) {
                    // read ConsigneeViewModel.model.LSTDate
                    consigneeModelModelLSTDate = consigneeModelModel.getLSTDate();
                }
        }
        if ((dirtyFlags & 0x22L) != 0) {

                // read ConsigneeViewModel.allReagions
                consigneeModelAllReagions = com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.allReagions;
                updateRegistration(1, consigneeModelAllReagions);
        }
        if ((dirtyFlags & 0x2cL) != 0) {



                if (consigneeModel != null) {
                    // read consigneeModel.allContriesObs
                    consigneeModelAllContriesObs = consigneeModel.allContriesObs;
                }
                updateRegistration(3, consigneeModelAllContriesObs);
            if ((dirtyFlags & 0x24L) != 0) {

                    if (consigneeModel != null) {
                        // read consigneeModel::onDatePick
                        consigneeModelOnDatePickAndroidViewViewOnClickListener = (((mConsigneeModelOnDatePickAndroidViewViewOnClickListener == null) ? (mConsigneeModelOnDatePickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mConsigneeModelOnDatePickAndroidViewViewOnClickListener).setValue(consigneeModel));
                        // read consigneeModel::onSubmitClick
                        consigneeModelOnSubmitClickAndroidViewViewOnClickListener = (((mConsigneeModelOnSubmitClickAndroidViewViewOnClickListener == null) ? (mConsigneeModelOnSubmitClickAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mConsigneeModelOnSubmitClickAndroidViewViewOnClickListener).setValue(consigneeModel));
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x24L) != 0) {
            // api target 1

            this.btnSubmit.setOnClickListener(consigneeModelOnSubmitClickAndroidViewViewOnClickListener);
            this.edtLstDate.setOnClickListener(consigneeModelOnDatePickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x21L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editDealerName, consigneeModelModelConsigneeName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtConsingeeAddress, consigneeModelModelConsigneeAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtContactPerson, consigneeModelModelContactPerson);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtCstNo, consigneeModelModelCSTNo);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtEccNumber, consigneeModelModelEccNo);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtEmailAddress, consigneeModelModelEmail);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtFaxNo, consigneeModelModelFaxNo);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtLstNo, consigneeModelModelLSTNo);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtMobileNumber, consigneeModelModelMobile);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtPostal, consigneeModelModelPostalCode);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtTelephoneNumber, consigneeModelModelPhone);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtTinNumber, consigneeModelModelTinNo);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.editDealerName, "ConsigneeName");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtConsingeeAddress, "ConsigneeAddress");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtContactPerson, "ContactPerson");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtCstNo, "CSTNo");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtEccNumber, "EccNo");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtEmailAddress, "Email");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtFaxNo, "FaxNo");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtLstDate, "LSTDate");
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtLstDate, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtLstDateandroidTextAttrChanged);
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtLstNo, "LSTNo");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtMobileNumber, "Mobile");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtPostal, "PostalCode");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtTelephoneNumber, "Phone");
            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindTextWatcherToEditText(this.edtTinNumber, "TinNo");
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindSpinnerAdapter(this.edtCountry, consigneeModelAllContriesObs);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtLstDate, consigneeModelModelLSTDate);
        }
        if ((dirtyFlags & 0x22L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel.bindCityAdapter(this.edtRegion, consigneeModelAllReagions);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onDatePick(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel value;
        public OnClickListenerImpl1 setValue(com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onSubmitClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ConsigneeViewModel.model
        flag 1 (0x2L): ConsigneeViewModel.allReagions
        flag 2 (0x3L): consigneeModel
        flag 3 (0x4L): consigneeModel.allContriesObs
        flag 4 (0x5L): ConsigneeViewModel.model.LSTDate
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}