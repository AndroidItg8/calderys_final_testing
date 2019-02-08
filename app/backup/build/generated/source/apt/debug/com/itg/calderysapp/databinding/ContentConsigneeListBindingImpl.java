package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentConsigneeListBindingImpl extends ContentConsigneeListBinding  {

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
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ContentConsigneeListBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ContentConsigneeListBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.support.v7.widget.RecyclerView) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rvConsigneeList.setTag(null);
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
        if (BR.consigneeListModel == variableId) {
            setConsigneeListModel((com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setConsigneeListModel(@Nullable com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel ConsigneeListModel) {
        updateRegistration(1, ConsigneeListModel);
        this.mConsigneeListModel = ConsigneeListModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.consigneeListModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeConsigneeListModelConsigneeListModels((android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel>) object, fieldId);
            case 1 :
                return onChangeConsigneeListModel((com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeConsigneeListModelConsigneeListModels(android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel> ConsigneeListModelConsigneeListModels, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConsigneeListModel(com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel ConsigneeListModel, int fieldId) {
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
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.OnItemClickListner consigneeListModelListner = null;
        android.databinding.ObservableArrayList<com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel> consigneeListModelConsigneeListModels = null;
        com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel consigneeListModel = mConsigneeListModel;
        android.support.v7.widget.RecyclerView.OnScrollListener consigneeListModelScrollListener = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (consigneeListModel != null) {
                    // read consigneeListModel.listner
                    consigneeListModelListner = consigneeListModel.listner;
                    // read consigneeListModel.consigneeListModels
                    consigneeListModelConsigneeListModels = consigneeListModel.consigneeListModels;
                }
                updateRegistration(0, consigneeListModelConsigneeListModels);
            if ((dirtyFlags & 0x6L) != 0) {

                    if (consigneeListModel != null) {
                        // read consigneeListModel.scrollListener
                        consigneeListModelScrollListener = consigneeListModel.scrollListener;
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.customEntries(this.rvConsigneeList, consigneeListModelScrollListener);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel.customEntries(this.rvConsigneeList, consigneeListModelConsigneeListModels, consigneeListModelListner);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): consigneeListModel.consigneeListModels
        flag 1 (0x2L): consigneeListModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}