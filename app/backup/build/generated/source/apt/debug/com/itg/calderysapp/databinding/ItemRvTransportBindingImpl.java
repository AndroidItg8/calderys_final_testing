package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemRvTransportBindingImpl extends ItemRvTransportBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lbl_dealer_code, 3);
        sViewsWithIds.put(R.id.lbl_dealer_name, 4);
    }
    // views
    @NonNull
    private final android.support.v7.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mTransportModelOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemRvTransportBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemRvTransportBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.txtDealerCode.setTag(null);
        this.txtDealerName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.transportModel == variableId) {
            setTransportModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setTransportModel(@Nullable com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel TransportModel) {
        updateRegistration(0, TransportModel);
        this.mTransportModel = TransportModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.transportModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTransportModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTransportModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel TransportModel, int fieldId) {
        if (fieldId == BR._all) {
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
        com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel transportModel = mTransportModel;
        android.view.View.OnClickListener transportModelOnClickAndroidViewViewOnClickListener = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel transportModelModel = null;
        java.lang.String transportModelModelTransporterCode = null;
        java.lang.String transportModelModelTransporterName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (transportModel != null) {
                    // read transportModel::onClick
                    transportModelOnClickAndroidViewViewOnClickListener = (((mTransportModelOnClickAndroidViewViewOnClickListener == null) ? (mTransportModelOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mTransportModelOnClickAndroidViewViewOnClickListener).setValue(transportModel));
                    // read transportModel.model
                    transportModelModel = transportModel.model;
                }


                if (transportModelModel != null) {
                    // read transportModel.model.transporterCode
                    transportModelModelTransporterCode = transportModelModel.getTransporterCode();
                    // read transportModel.model.transporterName
                    transportModelModelTransporterName = transportModelModel.getTransporterName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(transportModelOnClickAndroidViewViewOnClickListener);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtDealerCode, transportModelModelTransporterName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtDealerName, transportModelModelTransporterCode);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): transportModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}