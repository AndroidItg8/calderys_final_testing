package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentTransportListBindingImpl extends ContentTransportListBinding  {

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

    public ContentTransportListBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private ContentTransportListBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
        if (BR.transportModel == variableId) {
            setTransportModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setTransportModel(@Nullable com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel TransportModel) {
        updateRegistration(1, TransportModel);
        this.mTransportModel = TransportModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.transportModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTransportModelTransportModels((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel>) object, fieldId);
            case 1 :
                return onChangeTransportModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTransportModelTransportModels(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel> TransportModelTransportModels, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeTransportModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel TransportModel, int fieldId) {
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
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel> transportModelTransportModels = null;
        com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel transportModel = mTransportModel;
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.OnItemClickListner transportModelListner = null;
        android.support.v7.widget.RecyclerView.OnScrollListener transportModelScrollListener = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (transportModel != null) {
                    // read transportModel.transportModels
                    transportModelTransportModels = transportModel.transportModels;
                    // read transportModel.listner
                    transportModelListner = transportModel.listner;
                }
                updateRegistration(0, transportModelTransportModels);
            if ((dirtyFlags & 0x6L) != 0) {

                    if (transportModel != null) {
                        // read transportModel.scrollListener
                        transportModelScrollListener = transportModel.scrollListener;
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.customEntries(this.mboundView0, transportModelScrollListener);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel.customEntries(this.mboundView0, transportModelTransportModels, transportModelListner);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): transportModel.transportModels
        flag 1 (0x2L): transportModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}