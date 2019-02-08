// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.gallery;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import com.itg.calderysapp.widget.CircularProgressView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GalleryActivity_ViewBinding implements Unbinder {
  private GalleryActivity target;

  @UiThread
  public GalleryActivity_ViewBinding(GalleryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GalleryActivity_ViewBinding(GalleryActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mImgDisplay = Utils.findRequiredViewAsType(source, R.id.img_display, "field 'mImgDisplay'", ImageView.class);
    target.mImgCross = Utils.findRequiredViewAsType(source, R.id.img_cross, "field 'mImgCross'", ImageView.class);
    target.mRlImgDisplayEdit = Utils.findRequiredViewAsType(source, R.id.rl_img_display_edit, "field 'mRlImgDisplayEdit'", RelativeLayout.class);
    target.mFrameDisplay = Utils.findRequiredViewAsType(source, R.id.frame_display, "field 'mFrameDisplay'", FrameLayout.class);
    target.mFrm = Utils.findRequiredViewAsType(source, R.id.frm, "field 'mFrm'", FrameLayout.class);
    target.mEdtProductTitle = Utils.findRequiredViewAsType(source, R.id.edtProductTitle, "field 'mEdtProductTitle'", TextInputEditText.class);
    target.mInputLayoutProduct = Utils.findRequiredViewAsType(source, R.id.input_layout_product, "field 'mInputLayoutProduct'", TextInputLayout.class);
    target.mEdtProductDescription = Utils.findRequiredViewAsType(source, R.id.edt_ProductDescription, "field 'mEdtProductDescription'", TextInputEditText.class);
    target.mInputLayoutDetail = Utils.findRequiredViewAsType(source, R.id.input_layout_detail, "field 'mInputLayoutDetail'", TextInputLayout.class);
    target.mBtnAdd = Utils.findRequiredViewAsType(source, R.id.btn_add, "field 'mBtnAdd'", Button.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mTxtFileName = Utils.findRequiredViewAsType(source, R.id.txt_fileName, "field 'mTxtFileName'", TextView.class);
    target.mEdtProductDate = Utils.findRequiredViewAsType(source, R.id.edtProductDate, "field 'mEdtProductDate'", TextInputEditText.class);
    target.mInputLayoutDate = Utils.findRequiredViewAsType(source, R.id.input_layout_date, "field 'mInputLayoutDate'", TextInputLayout.class);
    target.mFabFile = Utils.findRequiredViewAsType(source, R.id.fab_file, "field 'mFabFile'", FloatingActionButton.class);
    target.mTxtPercentage = Utils.findRequiredViewAsType(source, R.id.txt_percentage, "field 'mTxtPercentage'", TextView.class);
    target.mProgressFab = Utils.findRequiredViewAsType(source, R.id.progress_fab, "field 'mProgressFab'", CircularProgressView.class);
    target.mRlImage = Utils.findRequiredViewAsType(source, R.id.rl_image, "field 'mRlImage'", FrameLayout.class);
    target.mLlImgUpload = Utils.findRequiredViewAsType(source, R.id.ll_img_upload, "field 'mLlImgUpload'", LinearLayout.class);
    target.mTxtFileNames = Utils.findRequiredViewAsType(source, R.id.txt_fileNames, "field 'mTxtFileNames'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GalleryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mImgDisplay = null;
    target.mImgCross = null;
    target.mRlImgDisplayEdit = null;
    target.mFrameDisplay = null;
    target.mFrm = null;
    target.mEdtProductTitle = null;
    target.mInputLayoutProduct = null;
    target.mEdtProductDescription = null;
    target.mInputLayoutDetail = null;
    target.mBtnAdd = null;
    target.mProgress = null;
    target.mTxtFileName = null;
    target.mEdtProductDate = null;
    target.mInputLayoutDate = null;
    target.mFabFile = null;
    target.mTxtPercentage = null;
    target.mProgressFab = null;
    target.mRlImage = null;
    target.mLlImgUpload = null;
    target.mTxtFileNames = null;
  }
}
