package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentCreateIntentBindingImpl extends ContentCreateIntentBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_edit, 20);
        sViewsWithIds.put(R.id.headerItemText, 21);
        sViewsWithIds.put(R.id.lbl_dealer_name, 22);
        sViewsWithIds.put(R.id.lbl_Po_Number, 23);
        sViewsWithIds.put(R.id.strut, 24);
        sViewsWithIds.put(R.id.lbl_igst, 25);
        sViewsWithIds.put(R.id.lbl_sgst_cgst, 26);
        sViewsWithIds.put(R.id.lbl_intent_type, 27);
        sViewsWithIds.put(R.id.lbl_plant_code, 28);
        sViewsWithIds.put(R.id.lbl_constite_code, 29);
        sViewsWithIds.put(R.id.lbl_name_consingee, 30);
        sViewsWithIds.put(R.id.lbl_tax_info, 31);
        sViewsWithIds.put(R.id.lbl_po_date, 32);
        sViewsWithIds.put(R.id.lbl_delivery_date, 33);
        sViewsWithIds.put(R.id.lbl_division, 34);
        sViewsWithIds.put(R.id.lbl_consingee_name, 35);
        sViewsWithIds.put(R.id.edtConsingeeName, 36);
        sViewsWithIds.put(R.id.lbl_cc_email_id, 37);
        sViewsWithIds.put(R.id.edtCCEMailId, 38);
        sViewsWithIds.put(R.id.totalValue, 39);
        sViewsWithIds.put(R.id.ll_btn, 40);
        sViewsWithIds.put(R.id.llApproveReject, 41);
        sViewsWithIds.put(R.id.btnApprove, 42);
        sViewsWithIds.put(R.id.btnReject, 43);
        sViewsWithIds.put(R.id.progressEdit, 44);
    }
    // views
    @NonNull
    private final android.support.v4.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mCreateIndentModelOnSumitClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mCreateIndentModelConsigneeOpenAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mCreateIndentModelOnCreateConsigneeAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mCreateIndentModelDeliveryDateAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mCreateIndentModelOnSaveClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mCreateIndentModelOnResetClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl6 mCreateIndentModelPodateAndroidViewViewOnClickListener;
    private OnClickListenerImpl7 mCreateIndentModelAddMaterialClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener edtTaxInfoandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of CreateIndentViewModel.model.addlTax
            //         is CreateIndentViewModel.model.setAddlTax((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edtTaxInfo);
            // localize variables for thread safety
            // CreateIndentViewModel.model
            com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel createIndentModelModel = null;
            // CreateIndentViewModel.model.addlTax
            java.lang.String createIndentModelModelAddlTax = null;
            // CreateIndentViewModel.model
            com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel createIndentViewModelModel = null;
            // createIndentModel
            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel createIndentModel = mCreateIndentModel;
            // CreateIndentViewModel.model != null
            boolean createIndentViewModelModelJavaLangObjectNull = false;



            createIndentViewModelModel = com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel.getModel();

            createIndentViewModelModelJavaLangObjectNull = (createIndentViewModelModel) != (null);
            if (createIndentViewModelModelJavaLangObjectNull) {




                createIndentViewModelModel.setAddlTax(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public ContentCreateIntentBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 45, sIncludes, sViewsWithIds));
    }
    private ContentCreateIntentBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 12
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[14]
            , (android.widget.Button) bindings[42]
            , (android.widget.Button) bindings[43]
            , (android.widget.Button) bindings[19]
            , (android.widget.Button) bindings[18]
            , (android.widget.Button) bindings[17]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[38]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[36]
            , (android.widget.EditText) bindings[12]
            , (android.widget.Spinner) bindings[13]
            , (android.widget.Spinner) bindings[3]
            , (android.widget.Spinner) bindings[5]
            , (android.widget.EditText) bindings[11]
            , (android.widget.Spinner) bindings[6]
            , (android.widget.EditText) bindings[2]
            , (android.widget.Spinner) bindings[4]
            , (android.widget.EditText) bindings[10]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[37]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[31]
            , (android.widget.LinearLayout) bindings[41]
            , (android.widget.LinearLayout) bindings[40]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.ProgressBar) bindings[44]
            , (android.support.v7.widget.RecyclerView) bindings[15]
            , (android.view.View) bindings[24]
            , (android.widget.TextView) bindings[39]
            , (android.widget.TextView) bindings[16]
            );
        this.btnAddConsignee.setTag(null);
        this.btnAddMaterial.setTag(null);
        this.btnReset.setTag(null);
        this.btnSave.setTag(null);
        this.btnSubmit.setTag(null);
        this.editDealerName.setTag(null);
        this.edtAddConsingee.setTag(null);
        this.edtConsingee.setTag(null);
        this.edtDeliveryDate.setTag(null);
        this.edtDivision.setTag(null);
        this.edtIgst.setTag(null);
        this.edtIntentTypeSpinner.setTag(null);
        this.edtPODate.setTag(null);
        this.edtPlantCodeSpinner.setTag(null);
        this.edtPoNumber.setTag(null);
        this.edtSgstCgst.setTag(null);
        this.edtTaxInfo.setTag(null);
        this.mboundView0 = (android.support.v4.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.recyclerView.setTag(null);
        this.totalValueActual.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x400000L;
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
        if (BR.createIndentModel == variableId) {
            setCreateIndentModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel) variable);
        }
        else if (BR.spinnerModel == variableId) {
            setSpinnerModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCreateIndentModel(@Nullable com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel CreateIndentModel) {
        updateRegistration(2, CreateIndentModel);
        this.mCreateIndentModel = CreateIndentModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.createIndentModel);
        super.requestRebind();
    }
    public void setSpinnerModel(@Nullable com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel SpinnerModel) {
        updateRegistration(7, SpinnerModel);
        this.mSpinnerModel = SpinnerModel;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.spinnerModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSpinnerModelSgst((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel>) object, fieldId);
            case 1 :
                return onChangeSpinnerModelDivision((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeCreateIndentModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel) object, fieldId);
            case 3 :
                return onChangeSpinnerModelModel((com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel) object, fieldId);
            case 4 :
                return onChangeCreateIndentModelDealerName((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeCreateIndentModelModel((com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel) object, fieldId);
            case 6 :
                return onChangeSpinnerModelIgst((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel>) object, fieldId);
            case 7 :
                return onChangeSpinnerModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel) object, fieldId);
            case 8 :
                return onChangeSpinnerModelPlantcode((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel>) object, fieldId);
            case 9 :
                return onChangeSpinnerModelIndentType((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeCreateIndentModelTotalValue((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeCreateIndentModelMateriaList((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSpinnerModelSgst(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> SpinnerModelSgst, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModelDivision(android.databinding.ObservableField<java.lang.String> SpinnerModelDivision, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCreateIndentModel(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel CreateIndentModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.model) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModelModel(com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel SpinnerModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.cST) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        else if (fieldId == BR.vAT) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        else if (fieldId == BR.indentType) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        else if (fieldId == BR.plantCode) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        else if (fieldId == BR.division) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCreateIndentModelDealerName(android.databinding.ObservableField<java.lang.String> CreateIndentModelDealerName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCreateIndentModelModel(com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel CreateIndentModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.pONumber) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        else if (fieldId == BR.consigneeCode) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
            }
            return true;
        }
        else if (fieldId == BR.consigneeName) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000L;
            }
            return true;
        }
        else if (fieldId == BR.pODate) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000L;
            }
            return true;
        }
        else if (fieldId == BR.dispatchDate) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModelIgst(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> SpinnerModelIgst, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModel(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel SpinnerModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        else if (fieldId == BR.model) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModelPlantcode(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> SpinnerModelPlantcode, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModelIndentType(android.databinding.ObservableField<java.lang.String> SpinnerModelIndentType, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCreateIndentModelTotalValue(android.databinding.ObservableField<java.lang.String> CreateIndentModelTotalValue, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeCreateIndentModelMateriaList(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel> CreateIndentModelMateriaList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
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
        java.lang.String spinnerModelModelPlantCode = null;
        android.view.View.OnClickListener createIndentModelOnSumitClickAndroidViewViewOnClickListener = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> spinnerModelSgst = null;
        java.lang.String spinnerModelIndentTypeGet = null;
        android.databinding.ObservableField<java.lang.String> spinnerModelDivision = null;
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.OnItemClickListner createIndentModelMyListener = null;
        android.view.View.OnClickListener createIndentModelConsigneeOpenAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener createIndentModelOnCreateConsigneeAndroidViewViewOnClickListener = null;
        java.lang.String createIndentModelModelConsigneeName = null;
        com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel createIndentModel = mCreateIndentModel;
        java.lang.String spinnerModelModelIndentType = null;
        android.view.View.OnClickListener createIndentModelDeliveryDateAndroidViewViewOnClickListener = null;
        java.lang.String createIndentModelDealerNameGet = null;
        java.lang.String createIndentModelTotalValueGet = null;
        java.lang.String spinnerModelModelVAT = null;
        com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel spinnerModelModel = null;
        java.lang.String createIndentModelModelAddlTax = null;
        android.view.View.OnClickListener createIndentModelOnSaveClickAndroidViewViewOnClickListener = null;
        java.lang.String createIndentModelModelDispatchDate = null;
        android.databinding.ObservableField<java.lang.String> createIndentModelDealerName = null;
        com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel createIndentModelModel = null;
        java.lang.String spinnerModelDivisionGet = null;
        java.lang.String createIndentModelModelPODate = null;
        java.lang.String createIndentModelModelConsigneeCode = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> spinnerModelIgst = null;
        android.view.View.OnClickListener createIndentModelOnResetClickAndroidViewViewOnClickListener = null;
        java.lang.String createIndentModelModelPONumber = null;
        com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel spinnerModel = mSpinnerModel;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> spinnerModelPlantcode = null;
        android.databinding.ObservableField<java.lang.String> spinnerModelIndentType = null;
        android.view.View.OnClickListener createIndentModelPodateAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> createIndentModelTotalValue = null;
        java.lang.String spinnerModelModelCST = null;
        java.lang.String spinnerModelModelDivision = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel> createIndentModelMateriaList = null;
        android.view.View.OnClickListener createIndentModelAddMaterialClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x400c14L) != 0) {


            if ((dirtyFlags & 0x400004L) != 0) {

                    if (createIndentModel != null) {
                        // read createIndentModel::onSumitClick
                        createIndentModelOnSumitClickAndroidViewViewOnClickListener = (((mCreateIndentModelOnSumitClickAndroidViewViewOnClickListener == null) ? (mCreateIndentModelOnSumitClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mCreateIndentModelOnSumitClickAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::consigneeOpen
                        createIndentModelConsigneeOpenAndroidViewViewOnClickListener = (((mCreateIndentModelConsigneeOpenAndroidViewViewOnClickListener == null) ? (mCreateIndentModelConsigneeOpenAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mCreateIndentModelConsigneeOpenAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::onCreateConsignee
                        createIndentModelOnCreateConsigneeAndroidViewViewOnClickListener = (((mCreateIndentModelOnCreateConsigneeAndroidViewViewOnClickListener == null) ? (mCreateIndentModelOnCreateConsigneeAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mCreateIndentModelOnCreateConsigneeAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::deliveryDate
                        createIndentModelDeliveryDateAndroidViewViewOnClickListener = (((mCreateIndentModelDeliveryDateAndroidViewViewOnClickListener == null) ? (mCreateIndentModelDeliveryDateAndroidViewViewOnClickListener = new OnClickListenerImpl3()) : mCreateIndentModelDeliveryDateAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::onSaveClick
                        createIndentModelOnSaveClickAndroidViewViewOnClickListener = (((mCreateIndentModelOnSaveClickAndroidViewViewOnClickListener == null) ? (mCreateIndentModelOnSaveClickAndroidViewViewOnClickListener = new OnClickListenerImpl4()) : mCreateIndentModelOnSaveClickAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::onResetClick
                        createIndentModelOnResetClickAndroidViewViewOnClickListener = (((mCreateIndentModelOnResetClickAndroidViewViewOnClickListener == null) ? (mCreateIndentModelOnResetClickAndroidViewViewOnClickListener = new OnClickListenerImpl5()) : mCreateIndentModelOnResetClickAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::podate
                        createIndentModelPodateAndroidViewViewOnClickListener = (((mCreateIndentModelPodateAndroidViewViewOnClickListener == null) ? (mCreateIndentModelPodateAndroidViewViewOnClickListener = new OnClickListenerImpl6()) : mCreateIndentModelPodateAndroidViewViewOnClickListener).setValue(createIndentModel));
                        // read createIndentModel::addMaterialClicked
                        createIndentModelAddMaterialClickedAndroidViewViewOnClickListener = (((mCreateIndentModelAddMaterialClickedAndroidViewViewOnClickListener == null) ? (mCreateIndentModelAddMaterialClickedAndroidViewViewOnClickListener = new OnClickListenerImpl7()) : mCreateIndentModelAddMaterialClickedAndroidViewViewOnClickListener).setValue(createIndentModel));
                    }
            }
            if ((dirtyFlags & 0x400804L) != 0) {

                    if (createIndentModel != null) {
                        // read createIndentModel.myListener
                        createIndentModelMyListener = createIndentModel.myListener;
                        // read createIndentModel.materiaList
                        createIndentModelMateriaList = createIndentModel.materiaList;
                    }
                    updateRegistration(11, createIndentModelMateriaList);
            }
            if ((dirtyFlags & 0x400014L) != 0) {

                    if (createIndentModel != null) {
                        // read createIndentModel.dealerName
                        createIndentModelDealerName = createIndentModel.dealerName;
                    }
                    updateRegistration(4, createIndentModelDealerName);


                    if (createIndentModelDealerName != null) {
                        // read createIndentModel.dealerName.get()
                        createIndentModelDealerNameGet = createIndentModelDealerName.get();
                    }
            }
            if ((dirtyFlags & 0x400404L) != 0) {

                    if (createIndentModel != null) {
                        // read createIndentModel.totalValue
                        createIndentModelTotalValue = createIndentModel.totalValue;
                    }
                    updateRegistration(10, createIndentModelTotalValue);


                    if (createIndentModelTotalValue != null) {
                        // read createIndentModel.totalValue.get()
                        createIndentModelTotalValueGet = createIndentModelTotalValue.get();
                    }
            }
        }
        if ((dirtyFlags & 0x7e0020L) != 0) {

                // read CreateIndentViewModel.model
                createIndentModelModel = com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel.getModel();
                updateRegistration(5, createIndentModelModel);

            if ((dirtyFlags & 0x480020L) != 0) {

                    if (createIndentModelModel != null) {
                        // read CreateIndentViewModel.model.consigneeName
                        createIndentModelModelConsigneeName = createIndentModelModel.getConsigneeName();
                    }
            }
            if ((dirtyFlags & 0x400020L) != 0) {

                    if (createIndentModelModel != null) {
                        // read CreateIndentViewModel.model.addlTax
                        createIndentModelModelAddlTax = createIndentModelModel.getAddlTax();
                    }
            }
            if ((dirtyFlags & 0x600020L) != 0) {

                    if (createIndentModelModel != null) {
                        // read CreateIndentViewModel.model.dispatchDate
                        createIndentModelModelDispatchDate = createIndentModelModel.getDispatchDate();
                    }
            }
            if ((dirtyFlags & 0x500020L) != 0) {

                    if (createIndentModelModel != null) {
                        // read CreateIndentViewModel.model.pODate
                        createIndentModelModelPODate = createIndentModelModel.getPODate();
                    }
            }
            if ((dirtyFlags & 0x440020L) != 0) {

                    if (createIndentModelModel != null) {
                        // read CreateIndentViewModel.model.consigneeCode
                        createIndentModelModelConsigneeCode = createIndentModelModel.getConsigneeCode();
                    }
            }
            if ((dirtyFlags & 0x420020L) != 0) {

                    if (createIndentModelModel != null) {
                        // read CreateIndentViewModel.model.pONumber
                        createIndentModelModelPONumber = createIndentModelModel.getPONumber();
                    }
            }
        }
        if ((dirtyFlags & 0x41f3cbL) != 0) {


            if ((dirtyFlags & 0x402089L) != 0) {

                    if (spinnerModel != null) {
                        // read spinnerModel.sgst
                        spinnerModelSgst = spinnerModel.sgst;
                    }
                    updateRegistration(0, spinnerModelSgst);
            }
            if ((dirtyFlags & 0x41008aL) != 0) {

                    if (spinnerModel != null) {
                        // read spinnerModel.division
                        spinnerModelDivision = spinnerModel.division;
                    }
                    updateRegistration(1, spinnerModelDivision);


                    if (spinnerModelDivision != null) {
                        // read spinnerModel.division.get()
                        spinnerModelDivisionGet = spinnerModelDivision.get();
                    }
            }

                if (spinnerModel != null) {
                    // read spinnerModel.model
                    spinnerModelModel = spinnerModel.getModel();
                }
                updateRegistration(3, spinnerModelModel);

            if ((dirtyFlags & 0x408188L) != 0) {

                    if (spinnerModelModel != null) {
                        // read spinnerModel.model.plantCode
                        spinnerModelModelPlantCode = spinnerModelModel.getPlantCode();
                    }
            }
            if ((dirtyFlags & 0x404288L) != 0) {

                    if (spinnerModelModel != null) {
                        // read spinnerModel.model.indentType
                        spinnerModelModelIndentType = spinnerModelModel.getIndentType();
                    }
            }
            if ((dirtyFlags & 0x402089L) != 0) {

                    if (spinnerModelModel != null) {
                        // read spinnerModel.model.vAT
                        spinnerModelModelVAT = spinnerModelModel.getVAT();
                    }
            }
            if ((dirtyFlags & 0x4010c8L) != 0) {

                    if (spinnerModelModel != null) {
                        // read spinnerModel.model.cST
                        spinnerModelModelCST = spinnerModelModel.getCST();
                    }
            }
            if ((dirtyFlags & 0x41008aL) != 0) {

                    if (spinnerModelModel != null) {
                        // read spinnerModel.model.division
                        spinnerModelModelDivision = spinnerModelModel.getDivision();
                    }
            }
            if ((dirtyFlags & 0x4010c8L) != 0) {

                    if (spinnerModel != null) {
                        // read spinnerModel.igst
                        spinnerModelIgst = spinnerModel.igst;
                    }
                    updateRegistration(6, spinnerModelIgst);
            }
            if ((dirtyFlags & 0x408188L) != 0) {

                    if (spinnerModel != null) {
                        // read spinnerModel.plantcode
                        spinnerModelPlantcode = spinnerModel.plantcode;
                    }
                    updateRegistration(8, spinnerModelPlantcode);
            }
            if ((dirtyFlags & 0x404288L) != 0) {

                    if (spinnerModel != null) {
                        // read spinnerModel.indentType
                        spinnerModelIndentType = spinnerModel.indentType;
                    }
                    updateRegistration(9, spinnerModelIndentType);


                    if (spinnerModelIndentType != null) {
                        // read spinnerModel.indentType.get()
                        spinnerModelIndentTypeGet = spinnerModelIndentType.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x400004L) != 0) {
            // api target 1

            this.btnAddConsignee.setOnClickListener(createIndentModelOnCreateConsigneeAndroidViewViewOnClickListener);
            this.btnAddMaterial.setOnClickListener(createIndentModelAddMaterialClickedAndroidViewViewOnClickListener);
            this.btnReset.setOnClickListener(createIndentModelOnResetClickAndroidViewViewOnClickListener);
            this.btnSave.setOnClickListener(createIndentModelOnSaveClickAndroidViewViewOnClickListener);
            this.btnSubmit.setOnClickListener(createIndentModelOnSumitClickAndroidViewViewOnClickListener);
            this.edtAddConsingee.setOnClickListener(createIndentModelConsigneeOpenAndroidViewViewOnClickListener);
            this.edtConsingee.setOnClickListener(createIndentModelConsigneeOpenAndroidViewViewOnClickListener);
            this.edtDeliveryDate.setOnClickListener(createIndentModelDeliveryDateAndroidViewViewOnClickListener);
            this.edtPODate.setOnClickListener(createIndentModelPodateAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x400014L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editDealerName, createIndentModelDealerNameGet);
        }
        if ((dirtyFlags & 0x480020L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtAddConsingee, createIndentModelModelConsigneeName);
        }
        if ((dirtyFlags & 0x440020L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtConsingee, createIndentModelModelConsigneeCode);
        }
        if ((dirtyFlags & 0x600020L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtDeliveryDate, createIndentModelModelDispatchDate);
        }
        if ((dirtyFlags & 0x41008aL) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel.bindCityAdapter(this.edtDivision, spinnerModelDivisionGet, "division", spinnerModelModel, spinnerModelModelDivision);
        }
        if ((dirtyFlags & 0x4010c8L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel.staticAdapter(this.edtIgst, spinnerModelIgst, "cST", spinnerModelModel, spinnerModelModelCST);
        }
        if ((dirtyFlags & 0x404288L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel.bindCityAdapter(this.edtIntentTypeSpinner, spinnerModelIndentTypeGet, "indentType", spinnerModelModel, spinnerModelModelIndentType);
        }
        if ((dirtyFlags & 0x500020L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtPODate, createIndentModelModelPODate);
        }
        if ((dirtyFlags & 0x408188L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel.staticAdapter(this.edtPlantCodeSpinner, spinnerModelPlantcode, "plantCode", spinnerModelModel, spinnerModelModelPlantCode);
        }
        if ((dirtyFlags & 0x420020L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtPoNumber, createIndentModelModelPONumber);
        }
        if ((dirtyFlags & 0x400000L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel.bindTextWatcherToEditText(this.edtPoNumber, "pONumber");
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtTaxInfo, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtTaxInfoandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x402089L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel.staticAdapter(this.edtSgstCgst, spinnerModelSgst, "vAT", spinnerModelModel, spinnerModelModelVAT);
        }
        if ((dirtyFlags & 0x400020L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtTaxInfo, createIndentModelModelAddlTax);
        }
        if ((dirtyFlags & 0x400804L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel.productRecyclerview(this.recyclerView, createIndentModelMateriaList, createIndentModelMyListener);
        }
        if ((dirtyFlags & 0x400404L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.totalValueActual, createIndentModelTotalValueGet);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onSumitClick(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl1 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.consigneeOpen(arg0); 
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl2 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onCreateConsignee(arg0); 
        }
    }
    public static class OnClickListenerImpl3 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl3 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.deliveryDate(arg0); 
        }
    }
    public static class OnClickListenerImpl4 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl4 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onSaveClick(arg0); 
        }
    }
    public static class OnClickListenerImpl5 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl5 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onResetClick(arg0); 
        }
    }
    public static class OnClickListenerImpl6 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl6 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.podate(arg0); 
        }
    }
    public static class OnClickListenerImpl7 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value;
        public OnClickListenerImpl7 setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.addMaterialClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): spinnerModel.sgst
        flag 1 (0x2L): spinnerModel.division
        flag 2 (0x3L): createIndentModel
        flag 3 (0x4L): spinnerModel.model
        flag 4 (0x5L): createIndentModel.dealerName
        flag 5 (0x6L): CreateIndentViewModel.model
        flag 6 (0x7L): spinnerModel.igst
        flag 7 (0x8L): spinnerModel
        flag 8 (0x9L): spinnerModel.plantcode
        flag 9 (0xaL): spinnerModel.indentType
        flag 10 (0xbL): createIndentModel.totalValue
        flag 11 (0xcL): createIndentModel.materiaList
        flag 12 (0xdL): spinnerModel.model.cST
        flag 13 (0xeL): spinnerModel.model.vAT
        flag 14 (0xfL): spinnerModel.model.indentType
        flag 15 (0x10L): spinnerModel.model.plantCode
        flag 16 (0x11L): spinnerModel.model.division
        flag 17 (0x12L): CreateIndentViewModel.model.pONumber
        flag 18 (0x13L): CreateIndentViewModel.model.consigneeCode
        flag 19 (0x14L): CreateIndentViewModel.model.consigneeName
        flag 20 (0x15L): CreateIndentViewModel.model.pODate
        flag 21 (0x16L): CreateIndentViewModel.model.dispatchDate
        flag 22 (0x17L): null
    flag mapping end*/
    //end
}