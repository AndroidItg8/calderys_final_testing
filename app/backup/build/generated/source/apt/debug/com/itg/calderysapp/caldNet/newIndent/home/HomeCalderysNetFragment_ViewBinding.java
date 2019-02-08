// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.caldNet.newIndent.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.itg.calderysapp.R;
import com.itg.calderysapp.widget.AutoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeCalderysNetFragment_ViewBinding implements Unbinder {
  private HomeCalderysNetFragment target;

  @UiThread
  public HomeCalderysNetFragment_ViewBinding(HomeCalderysNetFragment target, View source) {
    this.target = target;

    target.mImgCalderysNet = Utils.findRequiredViewAsType(source, R.id.img_calderys_net, "field 'mImgCalderysNet'", ImageView.class);
    target.mTxtImptMessage = Utils.findRequiredViewAsType(source, R.id.txt_impt_message, "field 'mTxtImptMessage'", TextView.class);
    target.mViewPagerTitle = Utils.findRequiredViewAsType(source, R.id.view_pager_title, "field 'mViewPagerTitle'", AutoScrollViewPager.class);
    target.mImgLeft = Utils.findRequiredViewAsType(source, R.id.img_left, "field 'mImgLeft'", ImageView.class);
    target.mImgRight = Utils.findRequiredViewAsType(source, R.id.img_right, "field 'mImgRight'", ImageView.class);
    target.mBtnViewAllLinks = Utils.findRequiredViewAsType(source, R.id.btn_view_all_links, "field 'mBtnViewAllLinks'", Button.class);
    target.mCard = Utils.findRequiredViewAsType(source, R.id.card, "field 'mCard'", CardView.class);
    target.mTxtSuccessItems = Utils.findRequiredViewAsType(source, R.id.txt_success_items, "field 'mTxtSuccessItems'", TextView.class);
    target.mViewPagerSuccessTitle = Utils.findRequiredViewAsType(source, R.id.view_pagerSuccess_title, "field 'mViewPagerSuccessTitle'", AutoScrollViewPager.class);
    target.mImgLeftSuccess = Utils.findRequiredViewAsType(source, R.id.img_left_success, "field 'mImgLeftSuccess'", ImageView.class);
    target.mImgRightSuccess = Utils.findRequiredViewAsType(source, R.id.img_right_success, "field 'mImgRightSuccess'", ImageView.class);
    target.mCardScreen = Utils.findRequiredViewAsType(source, R.id.card_screen, "field 'mCardScreen'", CardView.class);
    target.mRlLayout = Utils.findRequiredViewAsType(source, R.id.rl_layout, "field 'mRlLayout'", RelativeLayout.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mScrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'mScrollView'", ScrollView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeCalderysNetFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImgCalderysNet = null;
    target.mTxtImptMessage = null;
    target.mViewPagerTitle = null;
    target.mImgLeft = null;
    target.mImgRight = null;
    target.mBtnViewAllLinks = null;
    target.mCard = null;
    target.mTxtSuccessItems = null;
    target.mViewPagerSuccessTitle = null;
    target.mImgLeftSuccess = null;
    target.mImgRightSuccess = null;
    target.mCardScreen = null;
    target.mRlLayout = null;
    target.mProgress = null;
    target.mScrollView = null;
    target.swipeRefreshLayout = null;
  }
}
