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

public class SelectIntentCodeAdapter$IntentCodeHolder_ViewBinding implements Unbinder {
  private SelectIntentCodeAdapter.IntentCodeHolder target;

  @UiThread
  public SelectIntentCodeAdapter$IntentCodeHolder_ViewBinding(
      SelectIntentCodeAdapter.IntentCodeHolder target, View source) {
    this.target = target;

    target.mTxtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'mTxtDate'", TextView.class);
    target.mLblDealerCode = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_code, "field 'mLblDealerCode'", TextView.class);
    target.mTxtDealerCode = Utils.findRequiredViewAsType(source, R.id.txt_dealerCode, "field 'mTxtDealerCode'", TextView.class);
    target.mLblDealerName = Utils.findRequiredViewAsType(source, R.id.lbl_dealer_name, "field 'mLblDealerName'", TextView.class);
    target.mTxtDealerName = Utils.findRequiredViewAsType(source, R.id.txt_dealerName, "field 'mTxtDealerName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectIntentCodeAdapter.IntentCodeHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTxtDate = null;
    target.mLblDealerCode = null;
    target.mTxtDealerCode = null;
    target.mLblDealerName = null;
    target.mTxtDealerName = null;
  }
}
