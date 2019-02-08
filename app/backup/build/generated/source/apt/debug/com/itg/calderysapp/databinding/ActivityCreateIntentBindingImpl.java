package com.itg.calderysapp.databinding;
import com.itg.calderysapp.R;
import com.itg.calderysapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateIntentBindingImpl extends ActivityCreateIntentBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(4);
        sIncludes.setIncludes(0, 
            new String[] {"content_create_intent"},
            new int[] {1},
            new int[] {R.layout.content_create_intent});
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

    public ActivityCreateIntentBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityCreateIntentBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.itg.calderysapp.databinding.ContentCreateIntentBinding) bindings[1]
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
                mDirtyFlags = 0x8L;
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
        if (BR.spinnerModel == variableId) {
            setSpinnerModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel) variable);
        }
        else if (BR.createIndentModel == variableId) {
            setCreateIndentModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSpinnerModel(@Nullable com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel SpinnerModel) {
        updateRegistration(1, SpinnerModel);
        this.mSpinnerModel = SpinnerModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.spinnerModel);
        super.requestRebind();
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

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        content.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContent((com.itg.calderysapp.databinding.ContentCreateIntentBinding) object, fieldId);
            case 1 :
                return onChangeSpinnerModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel) object, fieldId);
            case 2 :
                return onChangeCreateIndentModel((com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContent(com.itg.calderysapp.databinding.ContentCreateIntentBinding Content, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSpinnerModel(com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel SpinnerModel, int fieldId) {
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
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.SpinnerViewModel spinnerModel = mSpinnerModel;
        com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm.CreateIndentViewModel createIndentModel = mCreateIndentModel;

        if ((dirtyFlags & 0xaL) != 0) {
        }
        if ((dirtyFlags & 0xcL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.content.setCreateIndentModel(createIndentModel);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.content.setSpinnerModel(spinnerModel);
        }
        executeBindingsOn(content);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): content
        flag 1 (0x2L): spinnerModel
        flag 2 (0x3L): createIndentModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}