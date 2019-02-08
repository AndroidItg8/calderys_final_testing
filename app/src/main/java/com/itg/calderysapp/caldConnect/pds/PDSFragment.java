package com.itg.calderysapp.caldConnect.pds;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSMVP;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSPresenterImp;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.GenericAdapter;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PDSFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PDSFragment extends Fragment implements PDSMVP.PDSView, PDSAdapter.OnItemClickedListner, CommonInterface.BackpressListner, CommonInterface.SearchDataListener, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final int RC_PDS = 345;


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.lbl_result)
    TextView mLblResult;
    @BindView(R.id.frame)
    FrameLayout mFrame;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GenericAdapter<String, PDSViewHolder> genericAdapter;
    private Context context;
    private CommonInterface.hideShowFabListner listner;
    private PDSMVP.PDSPresenter presenter;
    private LinearLayoutManager layoutManager;
    private PDSAdapter adapter;
    private CommonInterface.BackpressListner backPressListener;
    private boolean isViewEnable = false;
    private boolean isFromSearch = false;
    private Data data;
    private FragmentManager fm;
    private boolean isItemLoaded = false;
    private Parcelable rvState;


    public PDSFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PDSFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PDSFragment newInstance(String param1, String param2) {
        PDSFragment fragment = new PDSFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static PDSFragment newInstance(Data datum) {
        PDSFragment fragment = new PDSFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM3, datum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            data = getArguments().getParcelable(ARG_PARAM3);
        }
        layoutManager = new LinearLayoutManager(getActivity());

        checkIntent();
        presenter = new PDSPresenterImp(this, getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pd, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        if (rvState == null)
            presenter.allViewAvailable(this);
        else
            restoreRv();

        callPresenter();

        return view;
    }

    private void restoreRv() {
        if (rvState != null) {
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.onRestoreInstanceState(rvState);
        }
    }

    private void checkIntent() {
        if (data != null) {
//            Intent intent = new Intent(getActivity(), PDSActivity.class);
//            intent.putExtra(CommonMethod.FROM_NOTIFICATION_PDS, data);
//            startActivityForResult(intent, RC_PDS);

            ((HomeActivity) getActivity()).setNavigationSelected(2);
            if (fm == null)
                fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_container, PDSDetailsFragment.newInstance(data), PDSDetailsFragment.class.getSimpleName());
            ft.addToBackStack(PDSDetailsFragment.class.getSimpleName());
            ft.addToBackStack(null);
            ft.commit();
        }

    }

    private void setSwipeRefresh() {
        if (isViewEnable) {
            swipeRefreshLayout.setOnRefreshListener(this);
            swipeRefreshLayout.setColorSchemeColors(Color.RED);
            if (isItemLoaded && rvState==null)
                swipeRefreshLayout.setRefreshing(false);
            else
                swipeRefreshLayout.setRefreshing(true);
        }

    }

    private void initAllItems(String from) {
        presenter.onLoadMoreItem(from);
        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, from));


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_PDS) {
            if (resultCode == RESULT_OK) {

                if (getActivity() != null)
                    ((HomeActivity) getActivity()).setNavigationSelected(0);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                // this will clear the back stack and displays no animation on the screen
                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);


            }
        }
    }

    @Override
    public void onItemDownloadFileClicked(int position, Data datum) {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.hideShowFabListner) this.context;
        ((HomeActivity) getActivity()).attachedListener(backPressListener);
        ((HomeActivity) getActivity()).attachedSearchListener(this);


    }

    @Override
    public void onResume() {
        super.onResume();
        isViewEnable = true;
        if (isViewEnable) {
            listner.onFabShowListner(2);
//            callPresenter();
        }

    }

    private void callPresenter() {
        if (isViewEnable) {
            init();

            if (isFromSearch)
                initAllItems(CommonMethod.FROM_SEARCH);
            else
                initAllItems(CommonMethod.FROM_PDS);

            if (rvState == null)
                setSwipeRefresh();

        }

    }

    @Override
    public void onPause() {
        super.onPause();
        listner.onFabHideListner();
//        presenter.onDestroy();
        isViewEnable = false;
        if ( getActivity() != null  && ((HomeActivity) getActivity()).searchMenuItem !=null)
            ((HomeActivity) getActivity()).searchMenuItem.setVisible(false);



    }

    @Override
    public void onGetListAvailable(List<Data> o) {
        if (isViewEnable) {
            isItemLoaded = true;
            swipeRefreshLayout.setRefreshing(false);
            showHideView(mRecyclerView, mLblResult);
            adapter.addItems(o);

        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        isViewEnable = false;
        isItemLoaded = false;
        if (presenter != null)
            presenter.onDestroy();
//        if ((HomeActivity) getActivity() != null &&  ((HomeActivity) getActivity()).searchMenuItem != null  )
//            ((HomeActivity) getActivity()).searchMenuItem.setVisible(false);
        rvState = layoutManager.onSaveInstanceState();
        super.onDestroyView();


    }


    @Override
    public void onFail(String message) {
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                if (isViewEnable)
                    presenter.onLoadMore(CommonMethod.FROM_PDS);

            }
        });

    }

    @Override
    public void onError(Object t) {
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                if (isViewEnable)
                    presenter.onLoadMore(CommonMethod.FROM_PDS);
            }
        });

    }

    private void init() {
        if (isViewEnable) {

            if (rvState == null) {
                mRecyclerView.setLayoutManager(layoutManager);
                adapter = new PDSAdapter(getActivity(), this, this);
//        mRecyclerView.setAdapter(adapter);
//        DividerItemDecoration itemDecor = new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecor);
                mRecyclerView.setAdapter(adapter);
            } else {
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(adapter);
            }
        }
    }


    @Override
    public void onNoInternet() {
        UtilSnackbar.showSnakbarTypeFail(mRecyclerView, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                if (isViewEnable)
                    presenter.onLoadMore(CommonMethod.FROM_PDS);


            }
        });

    }

    @Override
    public void getPageNo(int page, boolean b) {
        if (page == 1) {
            setSwipeRefresh();
        } else {
            setPageFooter(b);

        }
    }

    @Override
    public void onShowPaginationLoading(boolean show) {
        if (isViewEnable) {
            setPageFooter(show);
        }
    }

    private void setPageFooter(boolean show) {
        if (show) {
            mRecyclerView.post(new Runnable() {
                @Override
                public void run() {
//                    adapter.notifyItemInserted();
                    adapter.addFooter();

                }
            });
        } else {
            adapter.removeFooter();
        }
    }

    @Override
    public void showProgress() {
//        mProgress.setVisibility(View.VISIBLE);
//        mRecyclerView.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
//        mProgress.setVisibility(View.GONE);
//        mRecyclerView.setVisibility(View.VISIBLE);

    }


    @Override
    public void onNoMoreList() {

    }


    @Override
    public void onItemClicked(int position, Data datum) {
        if (isViewEnable)
            callFragment(datum);
    }

    private void callFragment(Data datum) {
        FragmentManager fm = getFragmentManager();
        if (fm != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_container, PDSDetailsFragment.newInstance(datum), PDSDetailsFragment.class.getSimpleName());
            ft.addToBackStack(PDSFragment.class.getSimpleName());
            ft.commit();
        }


    }

    @Override
    public void onBackPressListener() {
//        presenter.onLoadMoreItem(CommonMethod.FROM_PDS);
    }


    @Override
    public void onSearchQuery(String s) {
        if (!TextUtils.isEmpty(s) && s.length() > 2) {
            isFromSearch = true;
            presenter.onSearchQuery(s);
//            new Runnable() {
//                @Override
//                public void run() {
////                    adapter.clearData();
//
//                }
//            }.run();

        }

    }

    @Override
    public void onSearchQueryForAll() {
        if (isViewEnable) {
//            adapter.clearData();
            presenter.onLoadMore(CommonMethod.FROM_SEARCH);
        }
    }


    @Override
    public void onCloseSearch() {
        if (isViewEnable) {
//            adapter.clearData();
            presenter.onLoadMoreItem(CommonMethod.FROM_SEARCH);
        }
    }


    @Override
    public void onSearchSubmit(String s) {
        if (isViewEnable) {
            if (!TextUtils.isEmpty(s)) {
                isFromSearch = true;
//                adapter.clearData();
                presenter.onSearchQuery(s);
            }
        }

    }


    @Override
    public void onCollapsed() {
//        adapter.clearData();
        if (isViewEnable) {
            isFromSearch = false;
            initAllItems(CommonMethod.FROM_PDS);
        }

    }

    @Override
    public void onSearchDataAvaiable(List<Data> message) {
        if (isViewEnable) {
            showHideView(mRecyclerView, mLblResult);
            adapter.serachItemAdd(message);

        }
    }

    private void showHideView(View show, View hide) {
        if (isViewEnable) {
            show.setVisibility(View.VISIBLE);
            hide.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNoItemFound() {
        if (isViewEnable) {
            adapter.removeFooter();
            showHideView(mLblResult, mRecyclerView);
//            presenter.onLoadMoreItem();

        }
    }

    @Override
    public void clearListAdapter() {
        if (isViewEnable) {
            adapter.clearData();
            adapter.addFooter();
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        menu.findItem(R.id.action_logout).setVisible(true);
        menu.findItem(R.id.action_search).setVisible(true);


    }

    @Override
    public void onRefresh() {
        initAllItems(CommonMethod.FROM_PDS);
    }

    public class PDSViewHolder extends RecyclerView.ViewHolder {
        public PDSViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
