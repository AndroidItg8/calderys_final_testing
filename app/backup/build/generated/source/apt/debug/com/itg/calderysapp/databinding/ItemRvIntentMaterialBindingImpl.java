package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemRvIntentMaterialBindingImpl extends ItemRvIntentMaterialBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lbl_materialName, 8);
        sViewsWithIds.put(R.id.txt_unit, 9);
        sViewsWithIds.put(R.id.lbl_kg_tag, 10);
        sViewsWithIds.put(R.id.lbl_material_code, 11);
        sViewsWithIds.put(R.id.lbl_product_remark, 12);
        sViewsWithIds.put(R.id.lbl_quantity, 13);
        sViewsWithIds.put(R.id.lbl_plant_code, 14);
        sViewsWithIds.put(R.id.lbl_units, 15);
        sViewsWithIds.put(R.id.lbl_price_unit, 16);
    }
    // views
    @NonNull
    private final android.support.v7.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mModelOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemRvIntentMaterialBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ItemRvIntentMaterialBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[6]
            );
        this.lblMaterialRemark.setTag(null);
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.txtMaterialCode.setTag(null);
        this.txtMaterialName.setTag(null);
        this.txtPlantCode.setTag(null);
        this.txtPriceUnit.setTag(null);
        this.txtQuantity.setTag(null);
        this.txtUnits.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.model == variableId) {
            setModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel Model) {
        updateRegistration(1, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModelModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel) object, fieldId);
            case 1 :
                return onChangeModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModelModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel ModelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.materialName) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.productCode) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.units) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.totalPrice) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModel(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel Model, int fieldId) {
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
        java.lang.String modelModelMaterialName = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel modelModel = null;
        android.view.View.OnClickListener modelOnClickAndroidViewViewOnClickListener = null;
        java.lang.String modelModelTotalPrice = null;
        java.lang.String modelModelUnits = null;
        com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel model = mModel;
        java.lang.String modelModelProductCode = null;
        java.lang.String modelModelProductRemarks = null;
        java.lang.String modelModelQuantity = null;
        java.lang.String modelModelPlantCode = null;

        if ((dirtyFlags & 0x7fL) != 0) {



                if (model != null) {
                    // read model.model
                    modelModel = model.model;
                }
                updateRegistration(0, modelModel);

            if ((dirtyFlags & 0x47L) != 0) {

                    if (modelModel != null) {
                        // read model.model.materialName
                        modelModelMaterialName = modelModel.getMaterialName();
                    }
            }
            if ((dirtyFlags & 0x63L) != 0) {

                    if (modelModel != null) {
                        // read model.model.totalPrice
                        modelModelTotalPrice = modelModel.getTotalPrice();
                    }
            }
            if ((dirtyFlags & 0x53L) != 0) {

                    if (modelModel != null) {
                        // read model.model.units
                        modelModelUnits = modelModel.getUnits();
                    }
            }
            if ((dirtyFlags & 0x4bL) != 0) {

                    if (modelModel != null) {
                        // read model.model.productCode
                        modelModelProductCode = modelModel.getProductCode();
                    }
            }
            if ((dirtyFlags & 0x43L) != 0) {

                    if (modelModel != null) {
                        // read model.model.productRemarks
                        modelModelProductRemarks = modelModel.getProductRemarks();
                        // read model.model.quantity
                        modelModelQuantity = modelModel.getQuantity();
                        // read model.model.plantCode
                        modelModelPlantCode = modelModel.getPlantCode();
                    }
            }
            if ((dirtyFlags & 0x42L) != 0) {

                    if (model != null) {
                        // read model::onClick
                        modelOnClickAndroidViewViewOnClickListener = (((mModelOnClickAndroidViewViewOnClickListener == null) ? (mModelOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mModelOnClickAndroidViewViewOnClickListener).setValue(model));
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x43L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.lblMaterialRemark, modelModelProductRemarks);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPlantCode, modelModelPlantCode);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtQuantity, modelModelQuantity);
        }
        if ((dirtyFlags & 0x42L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(modelOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x4bL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtMaterialCode, modelModelProductCode);
        }
        if ((dirtyFlags & 0x47L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtMaterialName, modelModelMaterialName);
        }
        if ((dirtyFlags & 0x63L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtPriceUnit, modelModelTotalPrice);
        }
        if ((dirtyFlags & 0x53L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.txtUnits, modelModelUnits);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel value;
        public OnClickListenerImpl setValue(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.MaterialItemViewModel value) {
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
        flag 0 (0x1L): model.model
        flag 1 (0x2L): model
        flag 2 (0x3L): model.model.materialName
        flag 3 (0x4L): model.model.productCode
        flag 4 (0x5L): model.model.units
        flag 5 (0x6L): model.model.totalPrice
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}