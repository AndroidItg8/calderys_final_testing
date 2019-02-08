// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.pds;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PDSAdapter$UpdateViewHolder_ViewBinding implements Unbinder {
  private PDSAdapter.UpdateViewHolder target;

  @UiThread
  public PDSAdapter$UpdateViewHolder_ViewBinding(PDSAdapter.UpdateViewHolder target, View source) {
    this.target = target;

    target.txtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'txtTitles'", TextView.class);
    target.imgAttach = Utils.findRequiredViewAsType(source, R.id.img_attach, "field 'imgAttach'", ImageView.class);
    target.txtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'txtDate'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PDSAdapter.UpdateViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtTitles = null;
    target.imgAttach = null;
    target.txtDate = null;
  }
}
