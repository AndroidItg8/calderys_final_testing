package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemRvProductBindingImpl extends ItemRvProductBinding  {

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
    private OnClickListenerImpl mMaterialModelOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemRvProductBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemRvProductBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
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
        if (BR.materialModel == variableId) {
            setMaterialModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMaterialModel(@Nullable com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel MaterialModel) {
        updateRegistration(1, MaterialModel);
        this.mMaterialModel = MaterialModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.materialModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMaterialModelModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel) object, fieldId);
            case 1 :
                return onChangeMaterialModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMaterialModelModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel MaterialModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMaterialModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel MaterialModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        java.lang.String materialModelModelProductName = null;
        java.lang.String materialModelModelProductCode = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel materialModelModel = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel materialModel = mMaterialModel;
        android.view.View.OnClickListener materialModelOnClickAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (materialModel != null) {
                    // read materialModel.model
                    materialModelModel = materialModel.model;
                }
                updateRegistration(0, materialModelModel);


                if (materialModelModel != null) {
                    // read materialModel.model.productName
                    materialModelModelProductName = materialModelModel.getProductName();
                    // read materialModel.model.productCode
                    materialModelModelProductCode = materialModelModel.getProductCode();
                }
            if ((dirtyFlags & 0x6L) != 0) {

                    if (materialModel != null) {
                        // read materialModel::onClick
                        materialModelOnClickAndroidViewViewOnClickListener = (((mMaterialModelOnClickAndroidViewViewOnClickListener == null) ? (mMaterialModelOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mMaterialModelOnClickAndroidViewViewOnClickListener).setValue(materialModel));
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(materialModelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtDealerCode, materialModelModelProductName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtDealerName, materialModelModelProductCode);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductItemViewModel value) {
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
        flag 0 (0x1L): materialModel.model
        flag 1 (0x2L): materialModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}