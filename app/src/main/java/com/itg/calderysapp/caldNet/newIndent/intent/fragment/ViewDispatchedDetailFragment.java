package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.DispachedAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.DispachedPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewDispatchedDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewDispatchedDetailFragment extends Fragment implements IntentView.DispachedView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.btn_download_file)
    Button mBtnDownloadFile;
    @BindView(R.id.img_no)
    ImageView imgNo;
    @BindView(R.id.txt_no_data)
    TextView txtNoData;
    @BindView(R.id.rlNoData)
    RelativeLayout mRlnoItem;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private IndentModel model;
    private int from;
    private PaginationModel modelPagination;
    private LinearLayoutManager layoutManager;
    private boolean isViewEnable = false;
    private IntentView.DispachedPresenter presenter;
    private DispachedAdapter adapter;
    private List<DispachedModel> list = null;
    private boolean isNoMoreList = false;


    public ViewDispatchedDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewDispatchedDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewDispatchedDetailFragment newInstance(IndentModel param1, int param2) {
        ViewDispatchedDetailFragment fragment = new ViewDispatchedDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            model = getArguments().getParcelable(ARG_PARAM1);
            from = getArguments().getInt(ARG_PARAM2);
        }
        presenter = new DispachedPresenterImp(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_dispatched_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.setViewAllAvailable(this);

        isViewEnable = true;
        initAll();
        return view;
    }


    private void initView() {
        modelPagination = new PaginationModel();
        modelPagination.setLimit(10);
        modelPagination.setPageNo(1);
        modelPagination.setTbleName(CommonMethod.TBL_DISPATCHED);
        modelPagination.setParameter(model.getSONumber());
        presenter.onLoadMoreItem(modelPagination);
    }

    private void initRecyclerView() {

        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new DispachedAdapter(getActivity(), Collections.emptyList());

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, model.getPONumber()));

    }


    private void initAll() {
        if (isViewEnable) {
            initRecyclerView();
            initView();

        }
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
                    model.setTbleName(CommonMethod.TBL_DISPATCHED);
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
                    model.setTbleName(CommonMethod.TBL_DISPATCHED);

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
                    model.setTbleName(CommonMethod.TBL_DISPATCHED);
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
    }

    @Override
    public void onGetDispachedList(List<DispachedModel> o) {
        if (isViewEnable) {
//            showHideView(mRecyclerView);
            this.list = o;
            adapter.addItems(o);
        }

    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onNoMoreList() {
        // show here no more
        isNoMoreList = true;
//        if (list != null && list.size() > 0) {
//            showHideView(mRlnoItem, mRecyclerView);
//        } else {
//            showHideView(mRecyclerView, mRlnoItem);
//        }

    }

    private void showHideView(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);

    }




}
