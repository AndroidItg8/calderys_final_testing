package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentMaterailAddBindingImpl extends ContentMaterailAddBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_material, 17);
        sViewsWithIds.put(R.id.lbl_material_name, 18);
        sViewsWithIds.put(R.id.lbl_material_code, 19);
        sViewsWithIds.put(R.id.lbl_product_remark, 20);
        sViewsWithIds.put(R.id.struts, 21);
        sViewsWithIds.put(R.id.lbl_quantity, 22);
        sViewsWithIds.put(R.id.lbl_unit, 23);
        sViewsWithIds.put(R.id.lbl_price_unit, 24);
        sViewsWithIds.put(R.id.lbl_total_price_after_discount, 25);
        sViewsWithIds.put(R.id.lbl_total_discount, 26);
        sViewsWithIds.put(R.id.edt_total_discount, 27);
        sViewsWithIds.put(R.id.lbl_open_discount, 28);
        sViewsWithIds.put(R.id.lbl_hidden_discount, 29);
        sViewsWithIds.put(R.id.lbl_dispatched_date, 30);
        sViewsWithIds.put(R.id.lbl_transport_code, 31);
        sViewsWithIds.put(R.id.lbl_transport_name, 32);
        sViewsWithIds.put(R.id.lbl_inspections, 33);
        sViewsWithIds.put(R.id.lbl_rl_required, 34);
        sViewsWithIds.put(R.id.lbl_tc_required, 35);
        sViewsWithIds.put(R.id.progress, 36);
    }
    // views
    @NonNull
    private final android.support.v4.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mMaterialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mMaterialAddViewModelOnTransportClickAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mMaterialAddViewModelOnSubmitAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mMaterialAddViewModelDispatchDatePickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener editProductRemarkandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of materialAddViewModel.model.productRemarks
            //         is materialAddViewModel.model.setProductRemarks((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editProductRemark);
            // localize variables for thread safety
            // materialAddViewModel.model.productRemarks
            java.lang.String materialAddViewModelModelProductRemarks = null;
            // materialAddViewModel
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;
            // materialAddViewModel.model
            com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel materialAddViewModelModel = null;
            // materialAddViewModel != null
            boolean materialAddViewModelJavaLangObjectNull = false;
            // materialAddViewModel.model != null
            boolean materialAddViewModelModelJavaLangObjectNull = false;



            materialAddViewModelJavaLangObjectNull = (materialAddViewModel) != (null);
            if (materialAddViewModelJavaLangObjectNull) {


                materialAddViewModelModel = materialAddViewModel.getModel();

                materialAddViewModelModelJavaLangObjectNull = (materialAddViewModelModel) != (null);
                if (materialAddViewModelModelJavaLangObjectNull) {




                    materialAddViewModelModel.setProductRemarks(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener edtHiddenDiscountandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of materialAddViewModel.model.hiddenDiscount
            //         is materialAddViewModel.model.setHiddenDiscount((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edtHiddenDiscount);
            // localize variables for thread safety
            // materialAddViewModel
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;
            // materialAddViewModel.model
            com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel materialAddViewModelModel = null;
            // materialAddViewModel != null
            boolean materialAddViewModelJavaLangObjectNull = false;
            // materialAddViewModel.model.hiddenDiscount
            java.lang.String materialAddViewModelModelHiddenDiscount = null;
            // materialAddViewModel.model != null
            boolean materialAddViewModelModelJavaLangObjectNull = false;



            materialAddViewModelJavaLangObjectNull = (materialAddViewModel) != (null);
            if (materialAddViewModelJavaLangObjectNull) {


                materialAddViewModelModel = materialAddViewModel.getModel();

                materialAddViewModelModelJavaLangObjectNull = (materialAddViewModelModel) != (null);
                if (materialAddViewModelModelJavaLangObjectNull) {




                    materialAddViewModelModel.setHiddenDiscount(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener edtOpenDiscountandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of materialAddViewModel.model.openDiscount
            //         is materialAddViewModel.model.setOpenDiscount((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edtOpenDiscount);
            // localize variables for thread safety
            // materialAddViewModel.model.openDiscount
            java.lang.String materialAddViewModelModelOpenDiscount = null;
            // materialAddViewModel
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;
            // materialAddViewModel.model
            com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel materialAddViewModelModel = null;
            // materialAddViewModel != null
            boolean materialAddViewModelJavaLangObjectNull = false;
            // materialAddViewModel.model != null
            boolean materialAddViewModelModelJavaLangObjectNull = false;



            materialAddViewModelJavaLangObjectNull = (materialAddViewModel) != (null);
            if (materialAddViewModelJavaLangObjectNull) {


                materialAddViewModelModel = materialAddViewModel.getModel();

                materialAddViewModelModelJavaLangObjectNull = (materialAddViewModelModel) != (null);
                if (materialAddViewModelModelJavaLangObjectNull) {




                    materialAddViewModelModel.setOpenDiscount(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener edtPriceUnitandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of materialAddViewModel.model.materialPricing
            //         is materialAddViewModel.model.setMaterialPricing((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edtPriceUnit);
            // localize variables for thread safety
            // materialAddViewModel.model.materialPricing
            java.lang.String materialAddViewModelModelMaterialPricing = null;
            // materialAddViewModel
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;
            // materialAddViewModel.model
            com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel materialAddViewModelModel = null;
            // materialAddViewModel != null
            boolean materialAddViewModelJavaLangObjectNull = false;
            // materialAddViewModel.model != null
            boolean materialAddViewModelModelJavaLangObjectNull = false;



            materialAddViewModelJavaLangObjectNull = (materialAddViewModel) != (null);
            if (materialAddViewModelJavaLangObjectNull) {


                materialAddViewModelModel = materialAddViewModel.getModel();

                materialAddViewModelModelJavaLangObjectNull = (materialAddViewModelModel) != (null);
                if (materialAddViewModelModelJavaLangObjectNull) {




                    materialAddViewModelModel.setMaterialPricing(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener edtQuantityandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of materialAddViewModel.model.quantity
            //         is materialAddViewModel.model.setQuantity((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(edtQuantity);
            // localize variables for thread safety
            // materialAddViewModel.model.quantity
            java.lang.String materialAddViewModelModelQuantity = null;
            // materialAddViewModel
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;
            // materialAddViewModel.model
            com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel materialAddViewModelModel = null;
            // materialAddViewModel != null
            boolean materialAddViewModelJavaLangObjectNull = false;
            // materialAddViewModel.model != null
            boolean materialAddViewModelModelJavaLangObjectNull = false;



            materialAddViewModelJavaLangObjectNull = (materialAddViewModel) != (null);
            if (materialAddViewModelJavaLangObjectNull) {


                materialAddViewModelModel = materialAddViewModel.getModel();

                materialAddViewModelModelJavaLangObjectNull = (materialAddViewModelModel) != (null);
                if (materialAddViewModelModelJavaLangObjectNull) {




                    materialAddViewModelModel.setQuantity(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ContentMaterailAddBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 37, sIncludes, sViewsWithIds));
    }
    private ContentMaterailAddBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.Button) bindings[16]
            , (android.widget.Spinner) bindings[13]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[4]
            , (android.widget.Spinner) bindings[14]
            , (android.widget.Spinner) bindings[15]
            , (android.widget.EditText) bindings[27]
            , (android.widget.EditText) bindings[7]
            , (android.widget.Spinner) bindings[5]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[23]
            , (android.widget.ProgressBar) bindings[36]
            , (android.widget.RelativeLayout) bindings[17]
            , (android.view.View) bindings[21]
            );
        this.btnSubmitMaterial.setTag(null);
        this.editInspectionsSpinner.setTag(null);
        this.editMaterialCodeSpinner.setTag(null);
        this.editMaterialNameSpinner.setTag(null);
        this.editProductRemark.setTag(null);
        this.editTransportCodeSpinner.setTag(null);
        this.editTransportNameSpinner.setTag(null);
        this.edtDispatchedDate.setTag(null);
        this.edtHiddenDiscount.setTag(null);
        this.edtOpenDiscount.setTag(null);
        this.edtPriceUnit.setTag(null);
        this.edtQuantity.setTag(null);
        this.edtRlRequiredSpinner.setTag(null);
        this.edtTcRequiredSpinner.setTag(null);
        this.edtTotalPriceAfterDiscount.setTag(null);
        this.edtUnitSpinner.setTag(null);
        this.mboundView0 = (android.support.v4.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1000L;
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
        if (BR.materialAddViewModel == variableId) {
            setMaterialAddViewModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMaterialAddViewModel(@Nullable com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel MaterialAddViewModel) {
        updateRegistration(2, MaterialAddViewModel);
        this.mMaterialAddViewModel = MaterialAddViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.materialAddViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMaterialAddViewModelUnits((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeMaterialAddViewModelModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel) object, fieldId);
            case 2 :
                return onChangeMaterialAddViewModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel) object, fieldId);
            case 3 :
                return onChangeMaterialAddViewModelYesNo((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel>) object, fieldId);
            case 4 :
                return onChangeMaterialAddViewModelUnitPosition((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMaterialAddViewModelUnits(android.databinding.ObservableField<java.lang.String> MaterialAddViewModelUnits, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMaterialAddViewModelModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel MaterialAddViewModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.materialName) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.productCode) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        else if (fieldId == BR.materialPricing) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        else if (fieldId == BR.totalPrice) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        else if (fieldId == BR.dispatchDate) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        else if (fieldId == BR.transporterCode) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        else if (fieldId == BR.transporterName) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMaterialAddViewModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel MaterialAddViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.model) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMaterialAddViewModelYesNo(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> MaterialAddViewModelYesNo, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMaterialAddViewModelUnitPosition(android.databinding.ObservableInt MaterialAddViewModelUnitPosition, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        java.lang.String materialAddViewModelModelDispatchDate = null;
        int materialAddViewModelUnitPositionGet = 0;
        java.lang.String materialAddViewModelModelTransporterCode = null;
        java.lang.String materialAddViewModelModelMaterialName = null;
        android.databinding.ObservableField<java.lang.String> materialAddViewModelUnits = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel materialAddViewModelModel = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;
        android.view.View.OnClickListener materialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener materialAddViewModelOnTransportClickAndroidViewViewOnClickListener = null;
        java.lang.String materialAddViewModelModelMaterialPricing = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel> materialAddViewModelYesNo = null;
        java.lang.String materialAddViewModelModelProductCode = null;
        java.lang.String materialAddViewModelModelQuantity = null;
        android.databinding.ObservableInt materialAddViewModelUnitPosition = null;
        java.lang.String materialAddViewModelModelOpenDiscount = null;
        java.lang.String materialAddViewModelModelProductRemarks = null;
        java.lang.String materialAddViewModelUnitsGet = null;
        java.lang.String materialAddViewModelModelHiddenDiscount = null;
        java.lang.String materialAddViewModelModelTransporterName = null;
        android.view.View.OnClickListener materialAddViewModelOnSubmitAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener materialAddViewModelDispatchDatePickAndroidViewViewOnClickListener = null;
        java.lang.String materialAddViewModelModelTotalPrice = null;

        if ((dirtyFlags & 0x1fffL) != 0) {


            if ((dirtyFlags & 0x1007L) != 0) {

                    if (materialAddViewModel != null) {
                        // read materialAddViewModel.units
                        materialAddViewModelUnits = materialAddViewModel.units;
                    }
                    updateRegistration(0, materialAddViewModelUnits);


                    if (materialAddViewModelUnits != null) {
                        // read materialAddViewModel.units.get()
                        materialAddViewModelUnitsGet = materialAddViewModelUnits.get();
                    }
            }
            if ((dirtyFlags & 0x1fefL) != 0) {

                    if (materialAddViewModel != null) {
                        // read materialAddViewModel.model
                        materialAddViewModelModel = materialAddViewModel.getModel();
                    }
                    updateRegistration(1, materialAddViewModelModel);

                if ((dirtyFlags & 0x1206L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.dispatchDate
                            materialAddViewModelModelDispatchDate = materialAddViewModelModel.getDispatchDate();
                        }
                }
                if ((dirtyFlags & 0x1406L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.transporterCode
                            materialAddViewModelModelTransporterCode = materialAddViewModelModel.getTransporterCode();
                        }
                }
                if ((dirtyFlags & 0x1026L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.materialName
                            materialAddViewModelModelMaterialName = materialAddViewModelModel.getMaterialName();
                        }
                }
                if ((dirtyFlags & 0x1007L) != 0) {
                }
                if ((dirtyFlags & 0x1086L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.materialPricing
                            materialAddViewModelModelMaterialPricing = materialAddViewModelModel.getMaterialPricing();
                        }
                }
                if ((dirtyFlags & 0x1046L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.productCode
                            materialAddViewModelModelProductCode = materialAddViewModelModel.getProductCode();
                        }
                }
                if ((dirtyFlags & 0x1006L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.quantity
                            materialAddViewModelModelQuantity = materialAddViewModelModel.getQuantity();
                            // read materialAddViewModel.model.openDiscount
                            materialAddViewModelModelOpenDiscount = materialAddViewModelModel.getOpenDiscount();
                            // read materialAddViewModel.model.productRemarks
                            materialAddViewModelModelProductRemarks = materialAddViewModelModel.getProductRemarks();
                            // read materialAddViewModel.model.hiddenDiscount
                            materialAddViewModelModelHiddenDiscount = materialAddViewModelModel.getHiddenDiscount();
                        }
                }
                if ((dirtyFlags & 0x1806L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.transporterName
                            materialAddViewModelModelTransporterName = materialAddViewModelModel.getTransporterName();
                        }
                }
                if ((dirtyFlags & 0x1106L) != 0) {

                        if (materialAddViewModelModel != null) {
                            // read materialAddViewModel.model.totalPrice
                            materialAddViewModelModelTotalPrice = materialAddViewModelModel.getTotalPrice();
                        }
                }
            }
            if ((dirtyFlags & 0x1004L) != 0) {

                    if (materialAddViewModel != null) {
                        // read materialAddViewModel::onMaterialListShow
                        materialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener = (((mMaterialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener == null) ? (mMaterialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mMaterialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener).setValue(materialAddViewModel));
                        // read materialAddViewModel::onTransportClick
                        materialAddViewModelOnTransportClickAndroidViewViewOnClickListener = (((mMaterialAddViewModelOnTransportClickAndroidViewViewOnClickListener == null) ? (mMaterialAddViewModelOnTransportClickAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mMaterialAddViewModelOnTransportClickAndroidViewViewOnClickListener).setValue(materialAddViewModel));
                        // read materialAddViewModel::onSubmit
                        materialAddViewModelOnSubmitAndroidViewViewOnClickListener = (((mMaterialAddViewModelOnSubmitAndroidViewViewOnClickListener == null) ? (mMaterialAddViewModelOnSubmitAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mMaterialAddViewModelOnSubmitAndroidViewViewOnClickListener).setValue(materialAddViewModel));
                        // read materialAddViewModel::dispatchDatePick
                        materialAddViewModelDispatchDatePickAndroidViewViewOnClickListener = (((mMaterialAddViewModelDispatchDatePickAndroidViewViewOnClickListener == null) ? (mMaterialAddViewModelDispatchDatePickAndroidViewViewOnClickListener = new OnClickListenerImpl3()) : mMaterialAddViewModelDispatchDatePickAndroidViewViewOnClickListener).setValue(materialAddViewModel));
                    }
            }
            if ((dirtyFlags & 0x100eL) != 0) {

                    if (materialAddViewModel != null) {
                        // read materialAddViewModel.yesNo
                        materialAddViewModelYesNo = materialAddViewModel.yesNo;
                    }
                    updateRegistration(3, materialAddViewModelYesNo);
            }
            if ((dirtyFlags & 0x1014L) != 0) {

                    if (materialAddViewModel != null) {
                        // read materialAddViewModel.unitPosition
                        materialAddViewModelUnitPosition = materialAddViewModel.unitPosition;
                    }
                    updateRegistration(4, materialAddViewModelUnitPosition);


                    if (materialAddViewModelUnitPosition != null) {
                        // read materialAddViewModel.unitPosition.get()
                        materialAddViewModelUnitPositionGet = materialAddViewModelUnitPosition.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1004L) != 0) {
            // api target 1

            this.btnSubmitMaterial.setOnClickListener(materialAddViewModelOnSubmitAndroidViewViewOnClickListener);
            this.editMaterialCodeSpinner.setOnClickListener(materialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener);
            this.editMaterialNameSpinner.setOnClickListener(materialAddViewModelOnMaterialListShowAndroidViewViewOnClickListener);
            this.editTransportCodeSpinner.setOnClickListener(materialAddViewModelOnTransportClickAndroidViewViewOnClickListener);
            this.editTransportNameSpinner.setOnClickListener(materialAddViewModelOnTransportClickAndroidViewViewOnClickListener);
            this.edtDispatchedDate.setOnClickListener(materialAddViewModelDispatchDatePickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x100eL) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.staticAdapter(this.editInspectionsSpinner, materialAddViewModelYesNo, "inspection", materialAddViewModelModel);
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.staticAdapter(this.edtRlRequiredSpinner, materialAddViewModelYesNo, "lrrequired", materialAddViewModelModel);
            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.staticAdapter(this.edtTcRequiredSpinner, materialAddViewModelYesNo, "tCrequired", materialAddViewModelModel);
        }
        if ((dirtyFlags & 0x1046L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editMaterialCodeSpinner, materialAddViewModelModelProductCode);
        }
        if ((dirtyFlags & 0x1026L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editMaterialNameSpinner, materialAddViewModelModelMaterialName);
        }
        if ((dirtyFlags & 0x1006L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editProductRemark, materialAddViewModelModelProductRemarks);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtHiddenDiscount, materialAddViewModelModelHiddenDiscount);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtOpenDiscount, materialAddViewModelModelOpenDiscount);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtQuantity, materialAddViewModelModelQuantity);
        }
        if ((dirtyFlags & 0x1000L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editProductRemark, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editProductRemarkandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtHiddenDiscount, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtHiddenDiscountandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtOpenDiscount, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtOpenDiscountandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtPriceUnit, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtPriceUnitandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtQuantity, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtQuantityandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1406L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editTransportCodeSpinner, materialAddViewModelModelTransporterCode);
        }
        if ((dirtyFlags & 0x1806L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editTransportNameSpinner, materialAddViewModelModelTransporterName);
        }
        if ((dirtyFlags & 0x1206L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtDispatchedDate, materialAddViewModelModelDispatchDate);
        }
        if ((dirtyFlags & 0x1086L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtPriceUnit, materialAddViewModelModelMaterialPricing);
        }
        if ((dirtyFlags & 0x1106L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.edtTotalPriceAfterDiscount, materialAddViewModelModelTotalPrice);
        }
        if ((dirtyFlags & 0x1014L) != 0) {
            // api target 1

            android.databinding.adapters.AdapterViewBindingAdapter.setSelectedItemPosition(this.edtUnitSpinner, materialAddViewModelUnitPositionGet);
        }
        if ((dirtyFlags & 0x1007L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel.bindCityAdapter(this.edtUnitSpinner, materialAddViewModelUnitsGet, "units", materialAddViewModelModel);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onMaterialListShow(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value;
        public OnClickListenerImpl1 setValue(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onTransportClick(arg0); 
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value;
        public OnClickListenerImpl2 setValue(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onSubmit(arg0); 
        }
    }
    public static class OnClickListenerImpl3 implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value;
        public OnClickListenerImpl3 setValue(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.dispatchDatePick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): materialAddViewModel.units
        flag 1 (0x2L): materialAddViewModel.model
        flag 2 (0x3L): materialAddViewModel
        flag 3 (0x4L): materialAddViewModel.yesNo
        flag 4 (0x5L): materialAddViewModel.unitPosition
        flag 5 (0x6L): materialAddViewModel.model.materialName
        flag 6 (0x7L): materialAddViewModel.model.productCode
        flag 7 (0x8L): materialAddViewModel.model.materialPricing
        flag 8 (0x9L): materialAddViewModel.model.totalPrice
        flag 9 (0xaL): materialAddViewModel.model.dispatchDate
        flag 10 (0xbL): materialAddViewModel.model.transporterCode
        flag 11 (0xcL): materialAddViewModel.model.transporterName
        flag 12 (0xdL): null
    flag mapping end*/
    //end
}