// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent;

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

public class ApproveIntentFragment_ViewBinding implements Unbinder {
  private ApproveIntentFragment target;

  @UiThread
  public ApproveIntentFragment_ViewBinding(ApproveIntentFragment target, View source) {
    this.target = target;

    target.mScrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'mScrollView'", NestedScrollView.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mEdtStartDate = Utils.findRequiredViewAsType(source, R.id.edtStartDate, "field 'mEdtStartDate'", TextInputEditText.class);
    target.mInputLayoutStartDate = Utils.findRequiredViewAsType(source, R.id.input_layout_start_date, "field 'mInputLayoutStartDate'", TextInputLayout.class);
    target.mEdtEndDate = Utils.findRequiredViewAsType(source, R.id.edtEndDate, "field 'mEdtEndDate'", TextInputEditText.class);
    target.mInputLayoutEndDate = Utils.findRequiredViewAsType(source, R.id.input_layout_end_date, "field 'mInputLayoutEndDate'", TextInputLayout.class);
    target.mLlDate = Utils.findRequiredViewAsType(source, R.id.ll_date, "field 'mLlDate'", LinearLayout.class);
    target.mBtnAdd = Utils.findRequiredViewAsType(source, R.id.btn_add, "field 'mBtnAdd'", Button.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mLlInput = Utils.findRequiredViewAsType(source, R.id.ll_input, "field 'mLlInput'", RelativeLayout.class);
    target.mEdtSendMail = Utils.findRequiredViewAsType(source, R.id.edt_send_mail, "field 'mEdtSendMail'", TextInputEditText.class);
    target.mInputLayoutSendMail = Utils.findRequiredViewAsType(source, R.id.input_layout_send_mail, "field 'mInputLayoutSendMail'", TextInputLayout.class);
    target.mImgSend = Utils.findRequiredViewAsType(source, R.id.img_send, "field 'mImgSend'", ImageView.class);
    target.mTxtIntentCode = Utils.findRequiredViewAsType(source, R.id.txt_intent_code, "field 'mTxtIntentCode'", TextView.class);
    target.mImgIntent = Utils.findRequiredViewAsType(source, R.id.img_intent, "field 'mImgIntent'", ImageView.class);
    target.mRlIntent = Utils.findRequiredViewAsType(source, R.id.rl_intent, "field 'mRlIntent'", CardView.class);
    target.mTxtDelearCode = Utils.findRequiredViewAsType(source, R.id.txt_delear_code, "field 'mTxtDelearCode'", TextView.class);
    target.mImgDelear = Utils.findRequiredViewAsType(source, R.id.img_delear, "field 'mImgDelear'", ImageView.class);
    target.mCardDealer = Utils.findRequiredViewAsType(source, R.id.card_dealer, "field 'mCardDealer'", CardView.class);
    target.mCardDate = Utils.findRequiredViewAsType(source, R.id.card_date, "field 'mCardDate'", CardView.class);
    target.mLblIntentName = Utils.findRequiredViewAsType(source, R.id.lbl_intent_name, "field 'mLblIntentName'", TextView.class);
    target.mLblDealerName = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_name, "field 'mLblDealerName'", TextView.class);
    target.imgNo = Utils.findRequiredViewAsType(source, R.id.img_no, "field 'imgNo'", ImageView.class);
    target.txtNoData = Utils.findRequiredViewAsType(source, R.id.txt_no_data, "field 'txtNoData'", TextView.class);
    target.rlNoData = Utils.findRequiredViewAsType(source, R.id.rlNoData, "field 'rlNoData'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ApproveIntentFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mScrollView = null;
    target.mRecyclerView = null;
    target.mEdtStartDate = null;
    target.mInputLayoutStartDate = null;
    target.mEdtEndDate = null;
    target.mInputLayoutEndDate = null;
    target.mLlDate = null;
    target.mBtnAdd = null;
    target.mProgress = null;
    target.mLlInput = null;
    target.mEdtSendMail = null;
    target.mInputLayoutSendMail = null;
    target.mImgSend = null;
    target.mTxtIntentCode = null;
    target.mImgIntent = null;
    target.mRlIntent = null;
    target.mTxtDelearCode = null;
    target.mImgDelear = null;
    target.mCardDealer = null;
    target.mCardDate = null;
    target.mLblIntentName = null;
    target.mLblDealerName = null;
    target.imgNo = null;
    target.txtNoData = null;
    target.rlNoData = null;
  }
}
