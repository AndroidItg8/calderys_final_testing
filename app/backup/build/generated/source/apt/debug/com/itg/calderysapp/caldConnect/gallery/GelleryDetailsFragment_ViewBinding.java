// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.gallery;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import com.itg.calderysapp.widget.AutoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GelleryDetailsFragment_ViewBinding implements Unbinder {
  private GelleryDetailsFragment target;

  @UiThread
  public GelleryDetailsFragment_ViewBinding(GelleryDetailsFragment target, View source) {
    this.target = target;

    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'mViewPager'", AutoScrollViewPager.class);
    target.mImgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'mImgDelete'", ImageView.class);
    target.mImgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'mImgEdit'", ImageView.class);
    target.mLlBottom = Utils.findRequiredViewAsType(source, R.id.ll_bottom, "field 'mLlBottom'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GelleryDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mViewPager = null;
    target.mImgDelete = null;
    target.mImgEdit = null;
    target.mLlBottom = null;
  }
}
