package com.itg.calderysapp.caldNet.newIndent.home;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.update.UpdateFragment;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetMVP;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.widget.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeCalderysNetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeCalderysNetFragment extends android.support.v4.app.Fragment implements HomeCalderysNetMVP.HomeCalderysNetView, ViewPager.OnPageChangeListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = "HomeCalderysNetFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int FROM_SUCCESS = 1;

    Unbinder unbinder;
    @BindView(R.id.img_calderys_net)
    ImageView mImgCalderysNet;
    @BindView(R.id.txt_impt_message)
    TextView mTxtImptMessage;
    @BindView(R.id.view_pager_title)
    AutoScrollViewPager mViewPagerTitle;
    @BindView(R.id.img_left)
    ImageView mImgLeft;
    @BindView(R.id.img_right)
    ImageView mImgRight;
    @BindView(R.id.btn_view_all_links)
    Button mBtnViewAllLinks;
    @BindView(R.id.card)
    CardView mCard;
    @BindView(R.id.txt_success_items)
    TextView mTxtSuccessItems;
    @BindView(R.id.view_pagerSuccess_title)
    AutoScrollViewPager mViewPagerSuccessTitle;
    @BindView(R.id.img_left_success)
    ImageView mImgLeftSuccess;
    @BindView(R.id.img_right_success)
    ImageView mImgRightSuccess;
    @BindView(R.id.card_screen)
    CardView mCardScreen;
    @BindView(R.id.rl_layout)
    RelativeLayout mRlLayout;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.scrollView)
    ScrollView mScrollView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private HomeCalderysNetMVP.HomeCalderysNetPresenter presenter;
    private boolean isViewEnable = false;
    private List<StroiesModel> suceessStories = new ArrayList<>();

    private GenericViewPagerAdapter madapter;
    private Context context;
    private CommonInterface.hideShowFabListner listner;
    private AdapterStringModel modelAdapter;
    private GenericViewPagerSuccesAdapter adapterSuccess;
    private CommonInterface.ShowSettingMenu listnerSetting;
    private boolean isItemLoaded=false;
    private Message message;
    private FragmentManager fm;


    public HomeCalderysNetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment HomeCalderysNetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeCalderysNetFragment newInstance(String params , String mParam2 ) {
        HomeCalderysNetFragment fragment = new HomeCalderysNetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, params);
        fragment.setArguments(args);
        return fragment;
    }

    public static HomeCalderysNetFragment newInstance(Message message) {
        HomeCalderysNetFragment fragment = new HomeCalderysNetFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM2, message);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle b=getArguments();
            message = getArguments().getParcelable(ARG_PARAM2);
        }
        presenter = new HomeCalderysNetPresenterImp(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_calderys_net, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        presenter.onViewAvail(HomeCalderysNetFragment.this);
        presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
        initView(true);
        checkIndent();
        setSwipeRefresh();
        return view;
    }

    private void checkIndent() {
        if (message != null) {
            if (message.getCondition().getData() != null) {
                if (message.getCondition().getData().contains("title")) {
                    ((HomeActivity) getActivity()).setNavigationSelected(0);
                    IndentsModel indentsModel = new Gson().fromJson(message.getCondition().getData(), IndentsModel.class);
                    Intent intent = new Intent(getActivity(), CreateIndentNewActivity.class);
                    intent.putExtra(CommonMethod.FROM_NOTIFICATION_CREATE, indentsModel);
                    getActivity().startActivity(intent);


                }
            }
        }
    }

    private void initView(boolean b) {
//        presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE);
//        presenter.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES);


        isViewEnable = b;
        mViewPagerTitle.startAutoScroll(500);
        mViewPagerSuccessTitle.startAutoScroll(500);

        setOnClickedListner();

    }

    private void setSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        if (isItemLoaded)
            swipeRefreshLayout.setRefreshing(false);
        else
            swipeRefreshLayout.setRefreshing(true);

    }

    private void setOnClickedListner() {
        mImgLeftSuccess.setOnClickListener(this);
        mImgRightSuccess.setOnClickListener(this);
        mImgLeft.setOnClickListener(this);
        mImgRight.setOnClickListener(this);
        mViewPagerTitle.addOnPageChangeListener(this);
        mViewPagerSuccessTitle.addOnPageChangeListener(this);


    }


    @Override
    public void onGetImportantMessagesListAvailable(List<MessageModel> o) {
        if (isViewEnable) {
            setStopeSwipe();

            List<AdapterStringModel> list = new ArrayList<>();
        for (MessageModel model : o
                ) {
//                 if(model.isActive()){
            modelAdapter = new AdapterStringModel();
            modelAdapter.setTitle(model.getDescription());
            list.add(modelAdapter);
//                 }

        }


            if (list.size() > 0) {
                madapter = new GenericViewPagerAdapter(getActivity(), list);
                if (mViewPagerTitle != null) {
                    mViewPagerTitle.setAdapter(madapter);
                }
            }
        }


    }

    private void setStopeSwipe() {
        isItemLoaded=true;
        swipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onGetSuccessStoriesListAvailable(List<StroiesModel> o) {
        suceessStories.addAll(o);
        setListAndViewPager(o);

    }

    private void setListAndViewPager(List<StroiesModel> o) {


        List<AdapterStringModel> list = new ArrayList<>();
        for (StroiesModel model : o
                ) {
            modelAdapter = new AdapterStringModel();
            modelAdapter.setTitle(model.getDescription());
            list.add(modelAdapter);
        }
        if (list.size() > 0)
            setDataOnViewPager(list);
    }

    private void setDataOnViewPager(List<AdapterStringModel> list) {
        if (isViewEnable) {
            if (list != null) {
                if (mViewPagerSuccessTitle != null) {
                    adapterSuccess = new GenericViewPagerSuccesAdapter(getActivity(), list);
                    mViewPagerSuccessTitle.setAdapter(adapterSuccess);

                }
            }

        }

    }


    private void viewPagerPosition(int position) {
        if (isViewEnable) {
            if (position == 0) {
                mImgLeft.setVisibility(View.INVISIBLE);
                mImgLeftSuccess.setVisibility(View.INVISIBLE);
            } else {
                mImgLeft.setVisibility(View.VISIBLE);
                mImgLeftSuccess.setVisibility(View.VISIBLE);

            }
            if (position == suceessStories.size() - 1) {

                mImgRight.setVisibility(View.INVISIBLE);
                mImgRightSuccess.setVisibility(View.INVISIBLE);
            } else {
                mImgRightSuccess.setVisibility(View.VISIBLE);
                mImgRight.setVisibility(View.VISIBLE);

            }
        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        isViewEnable = false;
        isItemLoaded=false;
        presenter.onDestroy();
        listner.onFabHideListner();
        super.onDestroyView();

    }

    @Override
    public void onNoMoreList() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.hideShowFabListner) this.context;
        listnerSetting = (CommonInterface.ShowSettingMenu) this.context;


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mCardScreen, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
//                    presenter.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES, CommonMethod.TYPE_ACTIVE);
                }
            });
        }

    }

    @Override
    public void onPause() {
        super.onPause();
//        listner.onFabHideListner();
        listner.onFabHideListner();
        listnerSetting.onShowSettingMenuForAdmin();


    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null)
            listner.onFabShowListner(0);

        listnerSetting.onShowSettingMenuForAdmin();
        setSwipeRefresh();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                presenter.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES, CommonMethod.TYPE_ACTIVE);
//                presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
//            }
//        }, 100);



    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null)
            listner.onFabShowListner(0);

            listnerSetting.onShowSettingMenuForAdmin();
    }

    @Override
    public void onStop() {
        super.onStop();
        listner.onFabHideListner();
        listnerSetting.onShowSettingMenuForAdmin();

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mCardScreen, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
//                            presenter.onDownloadSuccessStories(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
                        }
                    }

            );
        }

    }


    @Override
    public void onSuccess(Object object) {

    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mCardScreen, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
//                    presenter.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES, CommonMethod.TYPE_ACTIVE);

                }
            });
        }

    }


    @Override
    public void showProgress() {
//        if (isViewEnable) {
//            mProgress.setVisibility(View.VISIBLE);
//            mRlLayout.setVisibility(View.GONE);
//        }

    }

    @Override
    public void hideProgress() {
        if (isViewEnable) {
            setStopeSwipe();

            mProgress.setVisibility(View.GONE);
            mRlLayout.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onShowPaginationLoading(boolean show) {
//        if (show) {
//            viewPager.post(new Runnable() {
//                @Override
//                public void run() {
//                    mAdapter.addFooter();
//
//                }
//            });
//        } else {
//            adapter.removeFooter();
//        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        viewPagerPosition(i);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left_success:
                MovePreviousSuccessViewPager();
                break;
            case R.id.img_right_success:
                MoveNextViewSuccessPager();
                break;

            case R.id.img_left:
                MovePreviousViewPager();
                break;

            case R.id.img_right:
                MoveNextViewPager();
                break;
        }
    }


    private void MovePreviousSuccessViewPager() {
        if (adapterSuccess != null && isViewEnable) {
            int position = adapterSuccess.getItemPosition();
            if (isViewEnable) {
                mViewPagerSuccessTitle.setCurrentItem(mViewPagerSuccessTitle.getCurrentItem() - 1, true);
//            viewPagerTitle.setCurrentItem(getPrevItemPos(position), true);
            }
        }
    }

    private void MoveNextViewSuccessPager() {
        if (adapterSuccess != null && isViewEnable) {
            int position = adapterSuccess.getItemPosition();
            if (isViewEnable)
                mViewPagerSuccessTitle.setCurrentItem(mViewPagerSuccessTitle.getCurrentItem() + position, true);
        }
    }

    private void MovePreviousViewPager() {
        if (madapter != null && isViewEnable) {
            int position = madapter.getItemPosition();
            if (isViewEnable) {
                mViewPagerTitle.setCurrentItem(mViewPagerTitle.getCurrentItem() - 1, true);
            }
        }
    }

    private void MoveNextViewPager() {
        if (madapter != null && isViewEnable) {
            int position = madapter.getItemPosition();
            if (isViewEnable) {
                mViewPagerTitle.setCurrentItem(mViewPagerTitle.getCurrentItem() + position, true);
            }
        }
    }

    @Override
    public void onRefresh() {
        presenter.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.TYPE_ACTIVE);
    }
}
