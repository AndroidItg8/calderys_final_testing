// Generated code from Butter Knife. Do not modify!
package com.itg.calderysapp.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
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

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  @UiThread
  public HomeFragment_ViewBinding(HomeFragment target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", AutoScrollViewPager.class);
    target.frame = Utils.findRequiredViewAsType(source, R.id.frame, "field 'frame'", FrameLayout.class);
    target.viewPagerTitle = Utils.findRequiredViewAsType(source, R.id.view_pager_title, "field 'viewPagerTitle'", AutoScrollViewPager.class);
    target.mBtnViewAllLinks = Utils.findRequiredViewAsType(source, R.id.btn_view_all_links, "field 'mBtnViewAllLinks'", Button.class);
    target.mTxtDescriptions = Utils.findRequiredViewAsType(source, R.id.txt_descriptions, "field 'mTxtDescriptions'", TextView.class);
    target.mScrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'mScrollView'", ScrollView.class);
    target.mRlLayout = Utils.findRequiredViewAsType(source, R.id.rl_layout, "field 'mRlLayout'", RelativeLayout.class);
    target.mProgress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'mProgress'", ProgressBar.class);
    target.mBtnAllImages = Utils.findRequiredViewAsType(source, R.id.btn_all_images, "field 'mBtnAllImages'", Button.class);
    target.mImgLeftIamges = Utils.findRequiredViewAsType(source, R.id.img_left_iamges, "field 'mImgLeftIamges'", ImageView.class);
    target.mImgRightImages = Utils.findRequiredViewAsType(source, R.id.img_right_images, "field 'mImgRightImages'", ImageView.class);
    target.mCard = Utils.findRequiredViewAsType(source, R.id.card, "field 'mCard'", CardView.class);
    target.mImgLeft = Utils.findRequiredViewAsType(source, R.id.img_left, "field 'mImgLeft'", ImageView.class);
    target.mImgRight = Utils.findRequiredViewAsType(source, R.id.img_right, "field 'mImgRight'", ImageView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.frame = null;
    target.viewPagerTitle = null;
    target.mBtnViewAllLinks = null;
    target.mTxtDescriptions = null;
    target.mScrollView = null;
    target.mRlLayout = null;
    target.mProgress = null;
    target.mBtnAllImages = null;
    target.mImgLeftIamges = null;
    target.mImgRightImages = null;
    target.mCard = null;
    target.mImgLeft = null;
    target.mImgRight = null;
    target.swipeRefreshLayout = null;
  }
}
