package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMaterailAddBindingImpl extends ActivityMaterailAddBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(4);
        sIncludes.setIncludes(0, 
            new String[] {"content_materail_add"},
            new int[] {1},
            new int[] {R.layout.content_materail_add});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.fab, 3);
    }
    // views
    @NonNull
    private final android.support.design.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMaterailAddBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityMaterailAddBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.itg.calderysapp.databinding.ContentMaterailAddBinding) bindings[1]
            , (android.support.design.widget.FloatingActionButton) bindings[3]
            , (android.support.v7.widget.Toolbar) bindings[2]
            );
        this.mboundView0 = (android.support.design.widget.CoordinatorLayout) bindings[0];
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
        content.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (content.hasPendingBindings()) {
            return true;
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
        updateRegistration(1, MaterialAddViewModel);
        this.mMaterialAddViewModel = MaterialAddViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.materialAddViewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        content.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContent((com.itg.calderysapp.databinding.ContentMaterailAddBinding) object, fieldId);
            case 1 :
                return onChangeMaterialAddViewModel((com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContent(com.itg.calderysapp.databinding.ContentMaterailAddBinding Content, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMaterialAddViewModel(com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel MaterialAddViewModel, int fieldId) {
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
        com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.MaterialAddViewModel materialAddViewModel = mMaterialAddViewModel;

        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.content.setMaterialAddViewModel(materialAddViewModel);
        }
        executeBindingsOn(content);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): content
        flag 1 (0x2L): materialAddViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}