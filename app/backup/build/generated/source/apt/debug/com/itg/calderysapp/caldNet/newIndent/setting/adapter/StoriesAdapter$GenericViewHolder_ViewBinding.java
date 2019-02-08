// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.setting.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StoriesAdapter$GenericViewHolder_ViewBinding implements Unbinder {
  private StoriesAdapter.GenericViewHolder target;

  @UiThread
  public StoriesAdapter$GenericViewHolder_ViewBinding(StoriesAdapter.GenericViewHolder target,
      View source) {
    this.target = target;

    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.mImgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'mImgEdit'", ImageView.class);
    target.mImgEnable = Utils.findRequiredViewAsType(source, R.id.img_enable, "field 'mImgEnable'", ImageView.class);
    target.mImgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'mImgDelete'", ImageView.class);
    target.mRl = Utils.findRequiredViewAsType(source, R.id.rl, "field 'mRl'", RelativeLayout.class);
    target.mView = Utils.findRequiredView(source, R.id.view, "field 'mView'");
    target.mLblDealerCode = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_code, "field 'mLblDealerCode'", TextView.class);
    target.mTxtDealerCode = Utils.findRequiredViewAsType(source, R.id.txt_dealerCode, "field 'mTxtDealerCode'", TextView.class);
    target.mLblDealerName = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_name, "field 'mLblDealerName'", TextView.class);
    target.mTxtDealerName = Utils.findRequiredViewAsType(source, R.id.txt_dealerName, "field 'mTxtDealerName'", TextView.class);
    target.mProgressEnable = Utils.findRequiredViewAsType(source, R.id.progressEnable, "field 'mProgressEnable'", ProgressBar.class);
    target.mProgressDelete = Utils.findRequiredViewAsType(source, R.id.progressDelete, "field 'mProgressDelete'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StoriesAdapter.GenericViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtDate = null;
    target.mImgEdit = null;
    target.mImgEnable = null;
    target.mImgDelete = null;
    target.mRl = null;
    target.mView = null;
    target.mLblDealerCode = null;
    target.mTxtDealerCode = null;
    target.mLblDealerName = null;
    target.mTxtDealerName = null;
    target.mProgressEnable = null;
    target.mProgressDelete = null;
  }
}
