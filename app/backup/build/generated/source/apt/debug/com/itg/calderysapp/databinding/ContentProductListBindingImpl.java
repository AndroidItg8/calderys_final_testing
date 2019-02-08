package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentProductListBindingImpl extends ContentProductListBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.v7.widget.RecyclerView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ContentProductListBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private ContentProductListBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            );
        this.mboundView0 = (android.support.v7.widget.RecyclerView) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.productListModel == variableId) {
            setProductListModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProductListModel(@Nullable com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel ProductListModel) {
        updateRegistration(1, ProductListModel);
        this.mProductListModel = ProductListModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.productListModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeProductListModelTransportModels((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel>) object, fieldId);
            case 1 :
                return onChangeProductListModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeProductListModelTransportModels(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel> ProductListModelTransportModels, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeProductListModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel ProductListModel, int fieldId) {
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
        android.support.v7.widget.RecyclerView.OnScrollListener productListModelScrollListener = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel> productListModelTransportModels = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel productListModel = mProductListModel;
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.OnItemClickListner productListModelListner = null;

        if ((dirtyFlags & 0x7L) != 0) {


            if ((dirtyFlags & 0x6L) != 0) {

                    if (productListModel != null) {
                        // read productListModel.scrollListener
                        productListModelScrollListener = productListModel.scrollListener;
                    }
            }

                if (productListModel != null) {
                    // read productListModel.transportModels
                    productListModelTransportModels = productListModel.transportModels;
                    // read productListModel.listner
                    productListModelListner = productListModel.listner;
                }
                updateRegistration(0, productListModelTransportModels);
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.customEntries(this.mboundView0, productListModelScrollListener);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.ProductListViewModel.customEntries(this.mboundView0, productListModelTransportModels, productListModelListner);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): productListModel.transportModels
        flag 1 (0x2L): productListModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}