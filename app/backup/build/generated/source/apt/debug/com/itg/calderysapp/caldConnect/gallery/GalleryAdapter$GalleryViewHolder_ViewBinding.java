// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.gallery;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GalleryAdapter$GalleryViewHolder_ViewBinding implements Unbinder {
  private GalleryAdapter.GalleryViewHolder target;

  @UiThread
  public GalleryAdapter$GalleryViewHolder_ViewBinding(GalleryAdapter.GalleryViewHolder target,
      View source) {
    this.target = target;

    target.mImg = Utils.findRequiredViewAsType(source, R.id.img, "field 'mImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GalleryAdapter.GalleryViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImg = null;
  }
}
