// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.update;

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

public class UpdateAdapter$UpdateViewHolder_ViewBinding implements Unbinder {
  private UpdateAdapter.UpdateViewHolder target;

  @UiThread
  public UpdateAdapter$UpdateViewHolder_ViewBinding(UpdateAdapter.UpdateViewHolder target,
      View source) {
    this.target = target;

    target.mTxtTitles = Utils.findRequiredViewAsType(source, R.id.txt_titles, "field 'mTxtTitles'", TextView.class);
    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.mTxtYear = Utils.findRequiredViewAsType(source, R.id.txt_year, "field 'mTxtYear'", TextView.class);
    target.mImg = Utils.findRequiredViewAsType(source, R.id.img, "field 'mImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateAdapter.UpdateViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtTitles = null;
    target.mTxtDate = null;
    target.mTxtYear = null;
    target.mImg = null;
  }
}
