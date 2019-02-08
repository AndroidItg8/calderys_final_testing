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
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.SelectIntentCodeAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.MyIntentsPresenterImp;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntentsSelectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IntentsSelectionFragment extends Fragment implements CommonInterface.SearchDataListener, IntentView.MyIntentsView, SelectIntentCodeAdapter.OnItemClickedListner {


    private static final String TAG = "IntentsSelectionFragmen";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    private LinearLayoutManager layoutManager;
    private DealerModel dealerModel;
    private PaginationModel model;
    private boolean isViewEnable = false;
    private IntentView.MyIntentsPresenter presenter;
    private SelectIntentCodeAdapter adapter;
    private boolean paginationLoading = false;
    private String query;
    private CommonInterface.ShowSearchMenu listnerSearch;


    public IntentsSelectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment IntentsSelectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IntentsSelectionFragment newInstance(DealerModel model) {
        IntentsSelectionFragment fragment = new IntentsSelectionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, model);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dealerModel = getArguments().getParcelable(ARG_PARAM1);
        }
        presenter = new MyIntentsPresenterImp(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intents_selection, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable=true;
        presenter.allViewAvailable(this);
        initAll();
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        listnerSearch = (CommonInterface.ShowSearchMenu) context;
        ((IntentBaseActivity) getActivity()).attachedSearchListener(this);


    }
    @Override
    public void getPageItem(int pageNo, boolean b) {

    }



    @Override
    public void onSearchQuery(String s) {
        Log.d(TAG, "onSearchQuery: "+s);
        this.query=s;
        initAll();
//        initView();
    }

    @Override
    public void onSearchSubmit(String s) {
        this.query=s;
        initView();
    }

    @Override
    public void onCloseSearch() {
        this.query=null;
        initView();
    }

    @Override
    public void onSearchQueryForAll() {
        query=null;
        initView();
    }


    @Override
    public void onCollapsed() {

    }

    private void initView() {
        model = new PaginationModel();
        createPaginationModel(1,model);
        presenter.onLoadMoreItem(model);
    }

    @Override
    public void createPaginationModel(int pageNumber,PaginationModel model) {
        model.setLimit(10);
        model.setPageNo(pageNumber);
        model.setTbleName(CommonMethod.TBL_MYINDENT);
        model.setParameter(getDealerCode());
        model.setParameter2(getQuery());
    }

    private String getDealerCode() {
        if(dealerModel!=null){
            return dealerModel.getDealerCode();
        }
        return "";
    }

    @Override
    public String getQuery() {
        return query;
    }

    private void initRecyclerView() {


        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new SelectIntentCodeAdapter(getActivity(), Collections.emptyList(), dealerModel,this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, CommonMethod.TBL_MYINDENT));


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
        listnerSearch.onHideShowSearchMenu();
        initAll();



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
                    initView();
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
                   initView();
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
                   initView();

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
    public boolean isPaginationLoading() {
        return paginationLoading;
    }

    @Override
    public void onGetMyIntentsListAvailable(List<IndentModel> o) {
        if (isViewEnable) {
            adapter.addItems(o);
        }
    }


    @Override
    public void onSuccess(IndentModel message) {

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
    public void onItemClicked(int position, IndentModel datum) {
        if (getActivity() != null) {
            ((IntentBaseActivity) getActivity()).IndentModelClicked(datum);
        }
    }

}


