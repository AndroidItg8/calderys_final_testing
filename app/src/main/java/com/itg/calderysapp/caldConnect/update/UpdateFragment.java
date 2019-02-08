package com.itg.calderysapp.caldConnect.update;


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
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldConnect.update.mvp.UpdateListPresenterImp;
import com.itg.calderysapp.caldConnect.update.mvp.UpdateMVP;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class UpdateFragment extends Fragment implements UpdateMVP.UpdateView, UpdateAdapter.OnItemClickedListner, CommonInterface.BackpressListner, CommonInterface.SearchDataListener, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final int RC_BACK = 234;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    CommonInterface.hideShowFabListner listner;
    @BindView(R.id.lbl_result)
    TextView lblResult;
    @BindView(R.id.frame)
    FrameLayout frame;
    CommonInterface.SearchDataListener attachedSearchListener = null;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //    private GenericAdapter<String, UpdateViewHolder> genericAdapter;
    private Context context;
    private UpdateMVP.UpdatePresenter presenter;
    private LinearLayoutManager layoutManager;
    private UpdateAdapter adapter;
    private CommonInterface.BackpressListner backpressListner;
    private boolean isViewEnable = false;
    private Datum message;
    private FragmentManager fm;
    private boolean isFromSearch = false;
    private boolean isItemLoaded = false;
    private Parcelable rvSate;
    private String from;


    public UpdateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateFragment newInstance(String param1, String param2) {
        UpdateFragment fragment = new UpdateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance(Datum message) {
        UpdateFragment fragment = new UpdateFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM4, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            message = getArguments().getParcelable(ARG_PARAM4);
        }
        layoutManager = new LinearLayoutManager(getActivity());
        checkBundle();
        presenter = new UpdateListPresenterImp(this);


    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        setDrawableLeftRight();
        if (rvSate == null) {
            presenter.setViewAllAvailable(this);
        } else {
            restoreRv();
        }

        callPresenter();


        return view;
    }

    private void restoreRv() {
        if (rvSate != null) {
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.onRestoreInstanceState(rvSate);
        }
    }

    private void setDrawableLeftRight() {

        CommonMethod.setLeftRightDrawable(lblResult, 0, R.drawable.ic_search);

    }

    private void checkBundle() {
        if (message != null) {
            ((HomeActivity) getActivity()).setNavigationSelected(1);
//            Intent intent = new Intent(getActivity(), AddActivity.class);
//            intent.putExtra(CommonMethod.FROM_NOTIFICATION_ADD, message);
//            startActivityForResult(intent, RC_BACK);

            if (fm == null)
                fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_container, UpdateDetailFragment.newInstance(message), UpdateDetailFragment.class.getSimpleName());
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    private void initAll(String from) {
        if (isViewEnable) {
            this.from = from;
            presenter.onLoadMoreItem(from);

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.hideShowFabListner) this.context;
        ((HomeActivity) getActivity()).attachedListener(this);
        ((HomeActivity) getActivity()).attachedSearchListener(this);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        isViewEnable = false;
        isItemLoaded = false;
        presenter.onDestroy();
        rvSate = layoutManager.onSaveInstanceState();
    }

    private void setSwipeRefresh() {
        if (isViewEnable) {
            swipeRefreshLayout.setOnRefreshListener(this);
            swipeRefreshLayout.setColorSchemeColors(Color.RED);
            if (isItemLoaded && rvSate==null )
                swipeRefreshLayout.setRefreshing(false);
            else
                swipeRefreshLayout.setRefreshing(true);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        listner.onFabShowListner(1);
//        callPresenter();
    }

    private void callPresenter() {
        if (isViewEnable) {
            init();

            if (isFromSearch)
                initAll(CommonMethod.FROM_SEARCH);
            else
                initAll(CommonMethod.FROM_UPDATE);

            if (this.from != null)
                mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, from));

            if (rvSate == null)
                 setSwipeRefresh();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        listner.onFabHideListner();
        if ((HomeActivity) getActivity() != null)
            ((HomeActivity) getActivity()).searchMenuItem.setVisible(false);
//        presenter.onDestroy();
    }

    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onLoadMore(CommonMethod.FROM_UPDATE);
                }
            });
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onLoadMore(CommonMethod.FROM_UPDATE);
                }
            });
        }
    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mRecyclerView, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onLoadMore(CommonMethod.FROM_UPDATE);

                }
            });
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
    public void checkPageNo(int page, boolean show) {
        if (page == 1 && rvSate==null) {
            setSwipeRefresh();
        } else
            addFooter(show);


    }

    @Override
    public void onShowPaginationLoading(boolean show) {
        if (isViewEnable) {
            addFooter(show);
        }
    }

    private void addFooter(boolean show) {
        if (show) {
            mRecyclerView.post(new Runnable() {
                @Override
                public void run() {
                    adapter.addFooter();

                }
            });
        } else {
            adapter.removeFooter();
        }
    }

    private void showHideView(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
    }


    @Override
    public void onGetListAvailable(List<Datum> o) {
        if (isViewEnable) {
            isItemLoaded = true;
            swipeRefreshLayout.setRefreshing(false);
            showHideView(mRecyclerView, lblResult);
            adapter.addItems(o);
        }

    }

    @Override
    public void onNoMoreList() {

    }

    @Override
    public void onSearchDataAvaiable(List<Datum> message) {
        if (isViewEnable) {
//            isItemLoaded=true;
            showHideView(mRecyclerView, lblResult);
            adapter.serachItemAdd(message);
        }
    }

    @Override
    public void onNoItemFound() {
        if (isViewEnable) {
            adapter.removeFooter();
            showHideView(lblResult, mRecyclerView);
//            presenter.onLoadMoreItem();

        }
    }

    @Override
    public void clearListAdapter() {
        adapter.clearData();
        adapter.addFooter();
    }

    private void init() {
        if (rvSate == null) {
            mRecyclerView.setLayoutManager(layoutManager);
            adapter = new UpdateAdapter(getActivity(), this, this);
//        mRecyclerView.setAdapter(adapter);
//        DividerItemDecoration itemDecor = new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecor);
            mRecyclerView.setAdapter(adapter);
        } else {
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(adapter);
//            mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, from));
        }
//        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, from));


    }

    @Override
    public void onItemClicked(int position, Datum datum) {
        callFragment(datum);
    }

    private void callFragment(Datum datum) {
        FragmentManager fm = getFragmentManager();
        if (fm != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_container, UpdateDetailFragment.newInstance(datum), UpdateDetailFragment.class.getSimpleName());
            ft.addToBackStack(UpdateDetailFragment.class.getSimpleName());
            ft.commit();
        }


    }

    @Override
    public void onBackPressListener() {
//        presenter.onLoadMoreItem(CommonMethod.FROM_UPDATE);
    }


//    class UpdateViewHolder extends RecyclerView.ViewHolder {
//
//
//        public UpdateViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (isViewEnable) {

            menu.findItem(R.id.action_logout).setVisible(true);
            menu.findItem(R.id.action_search).setVisible(true);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_BACK) {
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
            isFromSearch = true;
            presenter.onLoadMore(CommonMethod.FROM_SEARCH);
        }
    }


    @Override
    public void onCloseSearch() {
        if (isViewEnable) {
//            adapter.clearData();
            isFromSearch = false;
            initAll(CommonMethod.FROM_SEARCH);
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
        isFromSearch = false;

        initAll(CommonMethod.FROM_SEARCH);
    }


    @Override
    public void onRefresh() {
        initAll(CommonMethod.FROM_UPDATE);
    }
}
