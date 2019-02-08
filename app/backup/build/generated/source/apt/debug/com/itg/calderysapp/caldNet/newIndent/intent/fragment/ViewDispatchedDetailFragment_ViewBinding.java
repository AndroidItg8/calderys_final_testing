// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ViewDispatchedDetailFragment_ViewBinding implements Unbinder {
  private ViewDispatchedDetailFragment target;

  @UiThread
  public ViewDispatchedDetailFragment_ViewBinding(ViewDispatchedDetailFragment target,
      View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mBtnDownloadFile = Utils.findRequiredViewAsType(source, R.id.btn_download_file, "field 'mBtnDownloadFile'", Button.class);
    target.imgNo = Utils.findRequiredViewAsType(source, R.id.img_no, "field 'imgNo'", ImageView.class);
    target.txtNoData = Utils.findRequiredViewAsType(source, R.id.txt_no_data, "field 'txtNoData'", TextView.class);
    target.mRlnoItem = Utils.findRequiredViewAsType(source, R.id.rlNoData, "field 'mRlnoItem'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ViewDispatchedDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mBtnDownloadFile = null;
    target.imgNo = null;
    target.txtNoData = null;
    target.mRlnoItem = null;
  }
}
