// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.gallery;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
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

public class GalleryDetailsActivity_ViewBinding implements Unbinder {
  private GalleryDetailsActivity target;

  @UiThread
  public GalleryDetailsActivity_ViewBinding(GalleryDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GalleryDetailsActivity_ViewBinding(GalleryDetailsActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.lblPlaceName = Utils.findRequiredViewAsType(source, R.id.lbl_place_name, "field 'lblPlaceName'", TextView.class);
    target.imgPagerItem = Utils.findRequiredViewAsType(source, R.id.img_pager_item, "field 'imgPagerItem'", ImageView.class);
    target.txtDescriptionEdit = Utils.findRequiredViewAsType(source, R.id.txt_description_edit, "field 'txtDescriptionEdit'", TextView.class);
    target.imgDelete = Utils.findRequiredViewAsType(source, R.id.img_delete, "field 'imgDelete'", ImageView.class);
    target.imgEdit = Utils.findRequiredViewAsType(source, R.id.img_edit, "field 'imgEdit'", ImageView.class);
    target.llBottom = Utils.findRequiredViewAsType(source, R.id.ll_bottom, "field 'llBottom'", LinearLayout.class);
    target.progress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progress'", ProgressBar.class);
    target.frm = Utils.findRequiredViewAsType(source, R.id.frm, "field 'frm'", FrameLayout.class);
    target.rlEdit = Utils.findRequiredViewAsType(source, R.id.rl_edit, "field 'rlEdit'", RelativeLayout.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GalleryDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.lblPlaceName = null;
    target.imgPagerItem = null;
    target.txtDescriptionEdit = null;
    target.imgDelete = null;
    target.imgEdit = null;
    target.llBottom = null;
    target.progress = null;
    target.frm = null;
    target.rlEdit = null;
    target.fab = null;
  }
}
