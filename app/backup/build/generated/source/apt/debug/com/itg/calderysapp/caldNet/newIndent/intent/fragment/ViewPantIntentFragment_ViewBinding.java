// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ViewPantIntentFragment_ViewBinding implements Unbinder {
  private ViewPantIntentFragment target;

  @UiThread
  public ViewPantIntentFragment_ViewBinding(ViewPantIntentFragment target, View source) {
    this.target = target;

    target.mEdtStartDate = Utils.findRequiredViewAsType(source, R.id.edtStartDate, "field 'mEdtStartDate'", TextInputEditText.class);
    target.mInputLayoutStartDate = Utils.findRequiredViewAsType(source, R.id.input_layout_start_date, "field 'mInputLayoutStartDate'", TextInputLayout.class);
    target.mEdtEndDate = Utils.findRequiredViewAsType(source, R.id.edtEndDate, "field 'mEdtEndDate'", TextInputEditText.class);
    target.mInputLayoutEndDate = Utils.findRequiredViewAsType(source, R.id.input_layout_end_date, "field 'mInputLayoutEndDate'", TextInputLayout.class);
    target.mBtnAdd = Utils.findRequiredViewAsType(source, R.id.btn_add, "field 'mBtnAdd'", Button.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mLlInput = Utils.findRequiredViewAsType(source, R.id.ll_input, "field 'mLlInput'", RelativeLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mEdtPlantName = Utils.findRequiredViewAsType(source, R.id.edtPlantName, "field 'mEdtPlantName'", TextInputEditText.class);
    target.mInputLayoutPlant = Utils.findRequiredViewAsType(source, R.id.input_layout_plant, "field 'mInputLayoutPlant'", TextInputLayout.class);
    target.mLl = Utils.findRequiredViewAsType(source, R.id.ll, "field 'mLl'", LinearLayout.class);
    target.mCardDate = Utils.findRequiredViewAsType(source, R.id.card_date, "field 'mCardDate'", CardView.class);
    target.mImgNo = Utils.findRequiredViewAsType(source, R.id.img_no, "field 'mImgNo'", ImageView.class);
    target.mTxtNoData = Utils.findRequiredViewAsType(source, R.id.txt_no_data, "field 'mTxtNoData'", TextView.class);
    target.mRlNoData = Utils.findRequiredViewAsType(source, R.id.rlNoData, "field 'mRlNoData'", RelativeLayout.class);
    target.mScrollView = Utils.findRequiredViewAsType(source, R.id.nestedScrolling, "field 'mScrollView'", NestedScrollView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ViewPantIntentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEdtStartDate = null;
    target.mInputLayoutStartDate = null;
    target.mEdtEndDate = null;
    target.mInputLayoutEndDate = null;
    target.mBtnAdd = null;
    target.mProgress = null;
    target.mLlInput = null;
    target.mRecyclerView = null;
    target.mEdtPlantName = null;
    target.mInputLayoutPlant = null;
    target.mLl = null;
    target.mCardDate = null;
    target.mImgNo = null;
    target.mTxtNoData = null;
    target.mRlNoData = null;
    target.mScrollView = null;
  }
}
