// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntentDispatchedDetailFragment_ViewBinding implements Unbinder {
  private IntentDispatchedDetailFragment target;

  @UiThread
  public IntentDispatchedDetailFragment_ViewBinding(IntentDispatchedDetailFragment target,
      View source) {
    this.target = target;

    target.rdIndentView = Utils.findRequiredViewAsType(source, R.id.rd_indent_view, "field 'rdIndentView'", RadioButton.class);
    target.rdDispacthed = Utils.findRequiredViewAsType(source, R.id.rd_dispacthed, "field 'rdDispacthed'", RadioButton.class);
    target.rdCalderysGroup = Utils.findRequiredViewAsType(source, R.id.rdCalderysGroup, "field 'rdCalderysGroup'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntentDispatchedDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rdIndentView = null;
    target.rdDispacthed = null;
    target.rdCalderysGroup = null;
  }
}
