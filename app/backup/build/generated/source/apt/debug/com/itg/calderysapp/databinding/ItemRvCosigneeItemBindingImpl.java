package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemRvCosigneeItemBindingImpl extends ItemRvCosigneeItemBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lbl_consignee_code, 7);
        sViewsWithIds.put(R.id.lbl_consignee_model, 8);
        sViewsWithIds.put(R.id.lbl_consignee_address, 9);
        sViewsWithIds.put(R.id.lbl_consignee_eccno, 10);
        sViewsWithIds.put(R.id.lbl_consignee_cstNo, 11);
        sViewsWithIds.put(R.id.lbl_consignee_TinNo, 12);
    }
    // views
    @NonNull
    private final android.support.v7.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mConsigneeModelItemClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemRvCosigneeItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ItemRvCosigneeItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[6]
            );
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.txtConsigneeAddress.setTag(null);
        this.txtConsigneeCode.setTag(null);
        this.txtConsigneeCstNo.setTag(null);
        this.txtConsigneeEccNo.setTag(null);
        this.txtConsigneeModel.setTag(null);
        this.txtConsigneeTinNo.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setConsigneeModel((com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setConsigneeModel(@Nullable com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel ConsigneeModel) {
        updateRegistration(1, ConsigneeModel);
        this.mConsigneeModel = ConsigneeModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.consigneeModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeConsigneeModelModel((com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel) object, fieldId);
            case 1 :
                return onChangeConsigneeModel((com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeConsigneeModelModel(com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel ConsigneeModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConsigneeModel(com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel ConsigneeModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.model) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel consigneeModelModel = null;
        java.lang.String consigneeModelModelConsigneeECCNo = null;
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel consigneeModel = mConsigneeModel;
        java.lang.String consigneeModelModelConsigneeTINNo = null;
        java.lang.String consigneeModelModelConsigneeCSTNo = null;
        java.lang.String consigneeModelModelConsigneeAddress = null;
        java.lang.String consigneeModelModelConsigneeName = null;
        java.lang.String consigneeModelModelConsigneeCode = null;
        android.view.View.OnClickListener consigneeModelItemClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (consigneeModel != null) {
                    // read consigneeModel.model
                    consigneeModelModel = consigneeModel.getModel();
                }
                updateRegistration(0, consigneeModelModel);


                if (consigneeModelModel != null) {
                    // read consigneeModel.model.consigneeECCNo
                    consigneeModelModelConsigneeECCNo = consigneeModelModel.getConsigneeECCNo();
                    // read consigneeModel.model.consigneeTINNo
                    consigneeModelModelConsigneeTINNo = consigneeModelModel.getConsigneeTINNo();
                    // read consigneeModel.model.consigneeCSTNo
                    consigneeModelModelConsigneeCSTNo = consigneeModelModel.getConsigneeCSTNo();
                    // read consigneeModel.model.consigneeAddress
                    consigneeModelModelConsigneeAddress = consigneeModelModel.getConsigneeAddress();
                    // read consigneeModel.model.consigneeName
                    consigneeModelModelConsigneeName = consigneeModelModel.getConsigneeName();
                    // read consigneeModel.model.consigneeCode
                    consigneeModelModelConsigneeCode = consigneeModelModel.getConsigneeCode();
                }
            if ((dirtyFlags & 0x6L) != 0) {

                    if (consigneeModel != null) {
                        // read consigneeModel::itemClicked
                        consigneeModelItemClickedAndroidViewViewOnClickListener = (((mConsigneeModelItemClickedAndroidViewViewOnClickListener == null) ? (mConsigneeModelItemClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mConsigneeModelItemClickedAndroidViewViewOnClickListener).setValue(consigneeModel));
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(consigneeModelItemClickedAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtConsigneeAddress, consigneeModelModelConsigneeAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtConsigneeCode, consigneeModelModelConsigneeCode);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtConsigneeCstNo, consigneeModelModelConsigneeCSTNo);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtConsigneeEccNo, consigneeModelModelConsigneeECCNo);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtConsigneeModel, consigneeModelModelConsigneeName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtConsigneeTinNo, consigneeModelModelConsigneeTINNo);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.itemClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): consigneeModel.model
        flag 1 (0x2L): consigneeModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}