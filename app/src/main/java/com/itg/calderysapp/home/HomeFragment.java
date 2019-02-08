package com.itg.calderysapp.home;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.gallery.GalleryDetailsActivity;
import com.itg.calderysapp.caldConnect.gallery.GalleryFragment;
import com.itg.calderysapp.caldConnect.pds.PDSFragment;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.UpdateDetailFragment;
import com.itg.calderysapp.caldConnect.update.UpdateFragment;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.home.mvp.HomeMVP;
import com.itg.calderysapp.home.mvp.HomePresenterImp;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.widget.AutoScrollViewPager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements ViewPagerAdapter.ImageClickedListener, ViewPagerUpdateLinkAdapter.ImageClickedListener, HomeMVP.HomeView, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    @BindView(R.id.view_pager)
    AutoScrollViewPager viewPager;
    Unbinder unbinder;

    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.view_pager_title)
    AutoScrollViewPager viewPagerTitle;

    @BindView(R.id.btn_view_all_links)
    Button mBtnViewAllLinks;

    @BindView(R.id.txt_descriptions)
    TextView mTxtDescriptions;
    @BindView(R.id.scrollView)
    ScrollView mScrollView;
    @BindView(R.id.rl_layout)
    RelativeLayout mRlLayout;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    @BindView(R.id.btn_all_images)
    Button mBtnAllImages;
    @BindView(R.id.img_left_iamges)
    ImageView mImgLeftIamges;
    @BindView(R.id.img_right_images)
    ImageView mImgRightImages;
    @BindView(R.id.card)
    CardView mCard;
    @BindView(R.id.img_left)
    ImageView mImgLeft;
    @BindView(R.id.img_right)
    ImageView mImgRight;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    // TODO: Rename and change types of parameters

    private ViewPagerAdapter mAdapter;
    private HomeMVP.HomePresenter presenter;
    private FragmentManager fm;
    private List<GalleryData> listGallery;


    private ViewPagerUpdateLinkAdapter adapter;
    private boolean isViewEnable = false;
    private List<Datum> linkList;
    private Context context;
    private CommonInterface.hideFabListener listner;
    private Message message;
    private CommonInterface.ShowSearchMenu searchListner;

    private static final String TAG = "HomeFragment";
    private boolean isItemLoaded = false;
    private boolean isItemList = false;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public static Fragment newInstance(Message message) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM3, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message = getArguments().getParcelable(ARG_PARAM3);
        }
        try {
            checkIntent();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        setSwipeRefresh();

        initViewAll();
        return view;
    }

    private void initViewAll() {
        presenterCall();

        onClickedListener();
        setViewDataForViewPager();
        setViewDataForLinkViewPager();
    }

    private void presenterCall() {
        presenter = new HomePresenterImp(this);
        presenter.setAllViewAvailable(this);

        presenter.onDownloadImages(CommonMethod.TBL_IMAGES);

    }

    private void checkIntent() throws JSONException {

        if (message != null) {
            if (message.getCondition().getData() != null) {
                if (message.getCondition().getData().contains("title")) {
                    JSONObject jsonObject = new JSONObject(message.getCondition().getData());
                    if (jsonObject.has("type")) {
                        int type = jsonObject.getInt("type");
                        if (type == CommonMethod.GALLERY_ITEM) {
                            ((HomeActivity) getActivity()).setNavigationSelected(0);
                            if (fm == null)
                                fm = getActivity().getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.frame_container, GalleryFragment.newInstance("", ""), GalleryFragment.class.getSimpleName());
                            ft.addToBackStack(null);
                            ft.commit();
                        } else if (type == CommonMethod.UPDATE_ITEM) {
                            Datum datum = new Gson().fromJson(message.getCondition().getData(), Datum.class);
                            ((HomeActivity) getActivity()).setNavigationSelected(0);
                            if (fm == null)
                                fm = getActivity().getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.frame_container, UpdateFragment.newInstance(datum), UpdateFragment.class.getSimpleName());
                            ft.addToBackStack(null);
                            ft.commit();
                        }
                    }

                } else {

                    Data datum = new Gson().fromJson(message.getCondition().getData(), Data.class);

                    ((HomeActivity) getActivity()).setNavigationSelected(0);
                    if (fm == null)
                        fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.replace(R.id.frame_container, PDSFragment.newInstance(datum), PDSFragment.class.getSimpleName());
                    ft.addToBackStack(PDSFragment.class.getSimpleName());
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }


        }

    }

    private void setViewDataForLinkViewPager() {
        viewPagerTitle.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                viewPagerLinkPosition(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.hideFabListener) this.context;
        searchListner = (CommonInterface.ShowSearchMenu) this.context;


    }

    private void viewPagerLinkPosition(int position) {
        if (isViewEnable) {
            if (position == 0) {
                mImgLeft.setVisibility(View.INVISIBLE);
            } else {
                mImgLeft.setVisibility(View.VISIBLE);

            }
            if (position == linkList.size() - 1) {

                mImgRight.setVisibility(View.INVISIBLE);
            } else {
                mImgRight.setVisibility(View.VISIBLE);

            }
        }
    }

    private void setViewDataForViewPager() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        });

    }

    private void viewPagerPosition(int position) {
        if (isViewEnable) {
            if (position == 0) {
                mImgLeftIamges.setVisibility(View.INVISIBLE);
            } else {
                mImgLeftIamges.setVisibility(View.VISIBLE);

            }
            if (position == listGallery.size() - 1) {

                mImgRightImages.setVisibility(View.INVISIBLE);
            } else {
                mImgRightImages.setVisibility(View.VISIBLE);

            }
        }
    }

    private void onClickedListener() {
        mBtnAllImages.setOnClickListener(this);
        mBtnViewAllLinks.setOnClickListener(this);
        mImgRightImages.setOnClickListener(this);
        mImgLeftIamges.setOnClickListener(this);
        mImgLeft.setOnClickListener(this);
        mImgRight.setOnClickListener(this);

    }


    @Override
    public void onSuccessImages(List<GalleryData> model) {
        if (isViewEnable) {
            getItemStopRefresh();

            listGallery = model;
            mAdapter = new ViewPagerAdapter(getActivity(), model, this);
            viewPager.setAdapter(mAdapter);
            viewPager.startAutoScroll(15000);
            setViewDataForViewPager();
            ///called here next web api ....

            presenter.onLoadMoreItem();


        }
    }


    private int getItem(int i) {
        if (isViewEnable)
            return viewPagerTitle.getCurrentItem() + i;
        else return 0;

    }


    @Override
    public void onGetListAvailable(List<Datum> o) {
        if (isViewEnable) {
            isItemList = true;
            swipeRefreshLayout.setRefreshing(false);

            this.linkList = o;
            viewPagerTitle.stopAutoScroll();
            adapter = new ViewPagerUpdateLinkAdapter((getActivity()), o, this);
            viewPagerTitle.setAdapter(adapter);
            setViewDataForLinkViewPager();

        }

    }

    private void getItemStopRefresh() {
        isItemLoaded = true;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        isViewEnable = false;
        isItemList = false;
        isItemLoaded = false;
        presenter.onDestroy();
        if (getActivity() != null)
            ((HomeActivity) getActivity()).mFabHome.hide();
//        ((HomeActivity) getActivity()).searchMenuItem.setVisible(false);
        searchListner.onHideShowSearchMenu();
        super.onDestroyView();

    }

    @Override
    public void onNoMoreList() {

    }


    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mTxtDescriptions, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onLoadMore();
                    presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
                }
            });
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        setSwipeRefresh();

        if (getActivity() != null) {
            ((HomeActivity) getActivity()).setNavigationSelected(0);
            searchListner.onHideShowSearchMenu();
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mTxtDescriptions, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            presenter.onLoadMore();
                            presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
                        }
                    }

            );
        }

    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mTxtDescriptions, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
                    presenter.onLoadMore();

                }
            });
        }

    }


    @Override
    public void showProgress() {
        if (isViewEnable) {
            mProgress.setVisibility(View.VISIBLE);
            mRlLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public void hideProgress() {
        if (isViewEnable) {
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
    public void onClick(View v) {
        if (isViewEnable) {
            switch (v.getId()) {

                case R.id.btn_all_images:
                    callFragment(GalleryFragment.newInstance(listGallery));
                    break;
                case R.id.btn_view_all_links:
                    callFragment(UpdateFragment.newInstance("", ""));
                    break;
                case R.id.img_left_iamges:
                    MovePreviousViewPager();
                    break;
                case R.id.img_right_images:
                    MoveNextViewPager();
                    break;

                case R.id.img_left:
                    MovePreviousLinkViewPager();
                    break;

                case R.id.img_right:
                    MoveNextLinkViewPager();
                    break;


            }
        }
    }


//    private int getPrevItemPos(int position) {
//        if(isViewEnable){
//            return position-1<0?0 :position-1;
//        }
//    }

    private void MovePreviousLinkViewPager() {
        int position = adapter.getItemPosition();
        if (isViewEnable) {
            viewPagerTitle.setCurrentItem(viewPagerTitle.getCurrentItem() - 1, true);
//            viewPagerTitle.setCurrentItem(getPrevItemPos(position), true);
        }
    }

    private void MoveNextLinkViewPager() {
        int position = adapter.getItemPosition();
        if (isViewEnable)
            viewPagerTitle.setCurrentItem(viewPagerTitle.getCurrentItem() + 1, true);
    }

    private int getNextItem(int position) {
        return position + 1;
    }

    private void MovePreviousViewPager() {
        int position = mAdapter.getItemPosition();
        if (isViewEnable) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - position, true);
        }
    }

    private void MoveNextViewPager() {
        int position = mAdapter.getItemPosition();
        if (isViewEnable) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + position, true);
        }
    }

    private void callFragment(Fragment fragment) {
        if (isViewEnable) {
            if (fm == null)
                fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm
                    .beginTransaction();
            ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
            ft.addToBackStack(fragment.getClass().getSimpleName());
            ft.commit();
        }
    }


    @Override
    public void onItemClicked(int position, GalleryData datum) {

        if (isViewEnable) {
//                    if (fm == null)
//                        fm = getActivity().getSupportFragmentManager();
//                    FragmentTransaction ft = fm
//                            .beginTransaction();
//                    ft.replace(R.id.frame_container, GelleryDetailsFragment.newInstance(datum, position), GelleryDetailsFragment.class.getSimpleName());
////            ft.addToBackStack(fragment.getClass().getSimpleName());
//                    ft.commit();

            Intent intent = new Intent(getActivity(), GalleryDetailsActivity.class);
            intent.putExtra(CommonMethod.FROM_GALLERY_HOME, "");
            intent.putExtra(CommonMethod.FROM_GALLERY_DATA, datum);
            intent.putExtra(CommonMethod.FROM_GALLERY_POSITION, position);
            Log.d(TAG, "onItemClicked: position" + position);
            startActivity(intent);
        }


    }

    @Override
    public void onItemClicked(int position, Datum datum) {

        if (isViewEnable) {
            ((HomeActivity) getActivity()).setMenuItem();

            if (fm == null)
                fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm
                    .beginTransaction();
            ft.replace(R.id.frame_container, UpdateDetailFragment.newInstance(datum), UpdateDetailFragment.class.getSimpleName());
            ft.addToBackStack("HomeFragment");
            ft.commit();
        }


    }

    private void setSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        if (isItemLoaded && isItemList)
            swipeRefreshLayout.setRefreshing(false);
        else
            swipeRefreshLayout.setRefreshing(true);

    }

    @Override
    public void onRefresh() {
        initViewAll();


    }
}
