// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.update;

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

public class UpdateDetailFragment_ViewBinding implements Unbinder {
  private UpdateDetailFragment target;

  @UiThread
  public UpdateDetailFragment_ViewBinding(UpdateDetailFragment target, View source) {
    this.target = target;

    target.mTxtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'mTxtTitles'", TextView.class);
    target.mTxtDescriptions = Utils.findRequiredViewAsType(source, R.id.txt_descriptions, "field 'mTxtDescriptions'", TextView.class);
    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.btnFileName = Utils.findRequiredViewAsType(source, R.id.btn_fileName, "field 'btnFileName'", Button.class);
    target.imgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'imgDelete'", ImageView.class);
    target.imgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'imgEdit'", ImageView.class);
    target.view = Utils.findRequiredView(source, R.id.view, "field 'view'");
    target.card = Utils.findRequiredViewAsType(source, R.id.card, "field 'card'", MaterialCardView.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtTitles = null;
    target.mTxtDescriptions = null;
    target.mTxtDate = null;
    target.btnFileName = null;
    target.imgDelete = null;
    target.imgEdit = null;
    target.view = null;
    target.card = null;
    target.mProgress = null;
  }
}
