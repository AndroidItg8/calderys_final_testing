// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DealerCodeAdapter$DealerCodeHolder_ViewBinding implements Unbinder {
  private DealerCodeAdapter.DealerCodeHolder target;

  @UiThread
  public DealerCodeAdapter$DealerCodeHolder_ViewBinding(DealerCodeAdapter.DealerCodeHolder target,
      View source) {
    this.target = target;

    target.mLblDealerCode = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_code, "field 'mLblDealerCode'", TextView.class);
    target.mTxtDealerCode = Utils.findRequiredViewAsType(source, R.id.txt_dealerCode, "field 'mTxtDealerCode'", TextView.class);
    target.mLblDealerName = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_name, "field 'mLblDealerName'", TextView.class);
    target.mTxtDealerName = Utils.findRequiredViewAsType(source, R.id.txt_dealerName, "field 'mTxtDealerName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DealerCodeAdapter.DealerCodeHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLblDealerCode = null;
    target.mTxtDealerCode = null;
    target.mLblDealerName = null;
    target.mTxtDealerName = null;
  }
}
