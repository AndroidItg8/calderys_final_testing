package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.DealerCodeAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.IntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.DealerPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DealerCodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DealerCodeFragment extends Fragment implements CommonInterface.SearchDataListener, IntentView.DealertView, DealerCodeAdapter.OnItemClickedListner {
    // TODO: Rename parameter arguments, choose names that match

    private static final String TAG = "DealerCodeFragment";

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager layoutManager;
    private Context context;
    private IntentView.DealerPresenter presenter;
    private DealerCodeAdapter adapter;
    private PaginationModel model;
    private boolean isViewEnable = false;
    private boolean paginationLoading = false;
    private String query;
    private CommonInterface.ShowSearchMenu listnerSearch;


    public DealerCodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment DealerCodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DealerCodeFragment newInstance(String param1) {
        DealerCodeFragment fragment = new DealerCodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        presenter = new DealerPresenterImp(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dealer_code, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        presenter.setViewAllAvailable(this);

        initAll();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (getActivity() != null)
            ((IntentBaseActivity) getActivity()).attachedSearchListener(this);
        listnerSearch = (CommonInterface.ShowSearchMenu) context;


    }


    @Override
    public void onSearchQuery(String s) {
        Log.d(TAG, "onSearchQuery: " + s);
        this.query = s;
        initAll();
//        initView();
    }

    @Override
    public void onSearchSubmit(String s) {
        this.query = s;
        initView();
    }

    @Override
    public void onCloseSearch() {
        this.query = null;
        initView();
    }

    @Override
    public void onSearchQueryForAll() {
        query = null;
        initView();
    }

    @Override
    public void onCollapsed() {

    }

    private void initView() {
        model = new PaginationModel();
        model.setLimit(10);
        model.setPageNo(1);
        model.setTbleName(CommonMethod.TBL_DEALER);
        model.setParameter(getQuery());
        presenter.onLoadMoreItem(model);
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new DealerCodeAdapter(getActivity(), Collections.emptyList(), this);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, Prefs.getString(CommonMethod.USER_ID)));


    }


    private void initAll() {
        if (isViewEnable) {
            initRecyclerView();
            initView();


        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initAll();
        listnerSearch.onHideShowSearchMenu();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        isViewEnable = false;
        presenter.onDestroy();
    }


    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    PaginationModel model = new PaginationModel();
                    model.setLimit(10);
                    model.setPageNo(1);
                    model.setTbleName(CommonMethod.TBL_MYINDENT);
                    presenter.onLoadMore(model);
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
                    PaginationModel model = new PaginationModel();
                    model.setLimit(10);
                    model.setPageNo(1);
                    model.setTbleName(CommonMethod.TBL_MYINDENT);
                    model.setParameter(getQuery());
                    presenter.onLoadMore(model);

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
                    PaginationModel model = new PaginationModel();
                    model.setLimit(10);
                    model.setPageNo(1);
                    model.setTbleName(CommonMethod.TBL_MYINDENT);
                    model.setParameter(getQuery());
                    presenter.onLoadMore(model);

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
    public void onShowPaginationLoading(boolean show) {
        if (isViewEnable) {
            if (show) {
                setPaginationLoading(true);
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.addFooter();

                    }
                });
            } else {
                adapter.removeFooter();
                setPaginationLoading(false);
            }
        }
    }

    @Override
    public void onGetDealerList(List<DealerModel> o) {
        if (isViewEnable) {
//            showHideView(mRecyclerView);
            adapter.addItems(o);
        }
    }

    @Override
    public boolean isPaginationLoading() {
        return paginationLoading;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public void onSuccess(String message) {

    }

    private void showHideView(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
    }


    @Override
    public void onNoMoreList() {

    }

    public void setPaginationLoading(boolean paginationLoading) {
        this.paginationLoading = paginationLoading;
    }

    @Override
    public void onItemClicked(int position, DealerModel model) {
        if (getActivity() != null) {
            ((IntentBaseActivity) getActivity()).DealerItemClicked(model);
        }


    }
}
