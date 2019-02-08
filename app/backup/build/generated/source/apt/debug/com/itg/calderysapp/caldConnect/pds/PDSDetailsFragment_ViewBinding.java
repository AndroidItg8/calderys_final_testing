// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.pds;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.card.MaterialCardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PDSDetailsFragment_ViewBinding implements Unbinder {
  private PDSDetailsFragment target;

  @UiThread
  public PDSDetailsFragment_ViewBinding(PDSDetailsFragment target, View source) {
    this.target = target;

    target.mImgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'mImgDelete'", ImageView.class);
    target.mImgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'mImgEdit'", ImageView.class);
    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.mTxtShare = Utils.findRequiredViewAsType(source, R.id.txt_share, "field 'mTxtShare'", TextView.class);
    target.mViews = Utils.findRequiredView(source, R.id.views, "field 'mViews'");
    target.mTxtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'mTxtTitles'", TextView.class);
    target.mTxtDescriptions = Utils.findRequiredViewAsType(source, R.id.txt_descriptions, "field 'mTxtDescriptions'", TextView.class);
    target.mView = Utils.findRequiredView(source, R.id.view, "field 'mView'");
    target.mLblProductType = Utils.findRequiredViewAsType(source, R.id.lbl_productType, "field 'mLblProductType'", TextView.class);
    target.mTxtProductType = Utils.findRequiredViewAsType(source, R.id.txt_productType, "field 'mTxtProductType'", TextView.class);
    target.mLblFamilyGroup = Utils.findRequiredViewAsType(source, R.id.lbl_familyGroup, "field 'mLblFamilyGroup'", TextView.class);
    target.mTxtFamilyGroup = Utils.findRequiredViewAsType(source, R.id.txt_familyGroup, "field 'mTxtFamilyGroup'", TextView.class);
    target.mBtnFileName = Utils.findRequiredViewAsType(source, R.id.btn_fileName, "field 'mBtnFileName'", Button.class);
    target.card = Utils.findRequiredViewAsType(source, R.id.card, "field 'card'", MaterialCardView.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PDSDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImgDelete = null;
    target.mImgEdit = null;
    target.mTxtDate = null;
    target.mTxtShare = null;
    target.mViews = null;
    target.mTxtTitles = null;
    target.mTxtDescriptions = null;
    target.mView = null;
    target.mLblProductType = null;
    target.mTxtProductType = null;
    target.mLblFamilyGroup = null;
    target.mTxtFamilyGroup = null;
    target.mBtnFileName = null;
    target.card = null;
    target.mProgress = null;
  }
}
