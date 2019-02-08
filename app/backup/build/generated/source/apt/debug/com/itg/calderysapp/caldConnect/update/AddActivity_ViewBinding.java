// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.update;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import com.itg.calderysapp.widget.CircularProgressView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddActivity_ViewBinding implements Unbinder {
  private AddActivity target;

  @UiThread
  public AddActivity_ViewBinding(AddActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddActivity_ViewBinding(AddActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mRlImage = Utils.findRequiredViewAsType(source, R.id.rl_image, "field 'mRlImage'", FrameLayout.class);
    target.mView = Utils.findRequiredView(source, R.id.view, "field 'mView'");
    target.mEdtProductTitle = Utils.findRequiredViewAsType(source, R.id.edtProductTitle, "field 'mEdtProductTitle'", TextInputEditText.class);
    target.mInputLayoutProduct = Utils.findRequiredViewAsType(source, R.id.input_layout_product, "field 'mInputLayoutProduct'", TextInputLayout.class);
    target.mEdtProductDescription = Utils.findRequiredViewAsType(source, R.id.edt_ProductDescription, "field 'mEdtProductDescription'", TextInputEditText.class);
    target.mInputLayoutDetail = Utils.findRequiredViewAsType(source, R.id.input_layout_detail, "field 'mInputLayoutDetail'", TextInputLayout.class);
    target.mBtnAdd = Utils.findRequiredViewAsType(source, R.id.btn_add, "field 'mBtnAdd'", Button.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mProgressFab = Utils.findRequiredViewAsType(source, R.id.progress_fab, "field 'mProgressFab'", CircularProgressView.class);
    target.mFabFile = Utils.findRequiredViewAsType(source, R.id.fab_file, "field 'mFabFile'", FloatingActionButton.class);
    target.mTxtFileName = Utils.findRequiredViewAsType(source, R.id.txt_fileName, "field 'mTxtFileName'", TextView.class);
    target.mTxtPercentage = Utils.findRequiredViewAsType(source, R.id.txt_percentage, "field 'mTxtPercentage'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mRlImage = null;
    target.mView = null;
    target.mEdtProductTitle = null;
    target.mInputLayoutProduct = null;
    target.mEdtProductDescription = null;
    target.mInputLayoutDetail = null;
    target.mBtnAdd = null;
    target.mProgress = null;
    target.mProgressFab = null;
    target.mFabFile = null;
    target.mTxtFileName = null;
    target.mTxtPercentage = null;
  }
}
