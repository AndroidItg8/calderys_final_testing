// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldConnect.pds;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import com.itg.calderysapp.widget.CircularProgressView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PDSActivity_ViewBinding implements Unbinder {
  private PDSActivity target;

  @UiThread
  public PDSActivity_ViewBinding(PDSActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PDSActivity_ViewBinding(PDSActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.txtFileName = Utils.findRequiredViewAsType(source, R.id.txt_fileName, "field 'txtFileName'", TextView.class);
    target.fabFile = Utils.findRequiredViewAsType(source, R.id.fab_file, "field 'fabFile'", FloatingActionButton.class);
    target.txtPercentage = Utils.findRequiredViewAsType(source, R.id.txt_percentage, "field 'txtPercentage'", TextView.class);
    target.progressFab = Utils.findRequiredViewAsType(source, R.id.progress_fab, "field 'progressFab'", CircularProgressView.class);
    target.rlImage = Utils.findRequiredViewAsType(source, R.id.rl_image, "field 'rlImage'", FrameLayout.class);
    target.lblPds = Utils.findRequiredViewAsType(source, R.id.lbl_pds, "field 'lblPds'", TextView.class);
    target.edtProductTitle = Utils.findRequiredViewAsType(source, R.id.edtProductTitle, "field 'edtProductTitle'", TextInputEditText.class);
    target.inputLayoutProduct = Utils.findRequiredViewAsType(source, R.id.input_layout_product, "field 'inputLayoutProduct'", TextInputLayout.class);
    target.SearchableSpinner = Utils.findRequiredViewAsType(source, R.id.SearchableSpinner, "field 'SearchableSpinner'", Spinner.class);
    target.SearchableSpinnerFamilyGroup = Utils.findRequiredViewAsType(source, R.id.SearchableSpinnerFamilyGroup, "field 'SearchableSpinnerFamilyGroup'", Spinner.class);
    target.rdPublic = Utils.findRequiredViewAsType(source, R.id.rd_public, "field 'rdPublic'", RadioButton.class);
    target.rdCrendtail = Utils.findRequiredViewAsType(source, R.id.rd_crendtail, "field 'rdCrendtail'", RadioButton.class);
    target.rdFileGroup = Utils.findRequiredViewAsType(source, R.id.rdFileGroup, "field 'rdFileGroup'", RadioGroup.class);
    target.btnAdd = Utils.findRequiredViewAsType(source, R.id.btn_add, "field 'btnAdd'", Button.class);
    target.progress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PDSActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.txtFileName = null;
    target.fabFile = null;
    target.txtPercentage = null;
    target.progressFab = null;
    target.rlImage = null;
    target.lblPds = null;
    target.edtProductTitle = null;
    target.inputLayoutProduct = null;
    target.SearchableSpinner = null;
    target.SearchableSpinnerFamilyGroup = null;
    target.rdPublic = null;
    target.rdCrendtail = null;
    target.rdFileGroup = null;
    target.btnAdd = null;
    target.progress = null;
  }
}
