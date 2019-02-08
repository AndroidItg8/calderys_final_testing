package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.ViewDetailsActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.ViewDraftAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.ViewDraftPresenterImp;
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

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewDraftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewDraftFragment extends Fragment implements IntentView.ViewDraftView, ViewDraftAdapter.OnItemClickedListner, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_EDIT = 234;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.rlNoData)
    RelativeLayout mRlNoData;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager layoutManager;
    private IntentView.ViewDraftPresenter presenter;
    private boolean isViewEnable = false;
    private PaginationModel model;
    private ViewDraftAdapter adapter;
    private boolean paginationLoading = false;
    private List<ViewDraftModel> viewDraftModelList = new ArrayList<>();
    private boolean isNoMore = false;
    private boolean isItemLoaded = false;
    private CommonInterface.ShowSettingMenu listner;
    private CommonInterface.hideShowFabListner fabListener;
    private Context context;
    private Parcelable rvState;


    public ViewDraftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewDraftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewDraftFragment newInstance(String param1, String param2) {
        ViewDraftFragment fragment = new ViewDraftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

        presenter = new ViewDraftPresenterImp(this);
         layoutManager = new LinearLayoutManager(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_draft, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        if (rvState == null)
            presenter.allViewAvailable(this);
        else
            restoreRv();

        initAll();
        return view;
    }


    private void initView() {
        createPagination();
        presenter.onLoadMoreItem(model);
    }

    private void createPagination() {
        model = new PaginationModel();
        model.setLimit(10);
        model.setPageNo(1);
        model.setTbleName(CommonMethod.TBL_ViewDRAFT);
        model.setParameter(Prefs.getString(CommonMethod.USER_ID));
    }

    private void setSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        if (isItemLoaded)
            swipeRefreshLayout.setRefreshing(false);
        else
            swipeRefreshLayout.setRefreshing(true);

    }

    @Override
    public void onItemClickedEdit(int position, ViewDraftModel datum) {
        callActivity(datum);


    }

    private void callActivity(ViewDraftModel datum) {
        Intent intent = new Intent(getActivity(), CreateIndentNewActivity.class);
        intent.putExtra(CommonMethod.FROM_VIEWDRAFT, datum);
        startActivityForResult(intent, RC_EDIT);
    }


    @Override
    public void onItemClickedDelete(int position, ViewDraftModel datum) {


        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        datum.setDelete(true);
                        presenter.onCancelViewDraft(datum);
                        adapter.notifyDataSetChanged();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        dialog.dismiss();
                        break;
                }
            }
        };

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to delete this draft Indent?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


    }

    private void restoreRv() {
        if (rvState != null) {
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.onRestoreInstanceState(rvState);
        }
    }

    private void initRecyclerView() {
        showHideView(mRecyclerView, mRlNoData);

        if (rvState == null) {
            mRecyclerView.setLayoutManager(layoutManager);
            adapter = new ViewDraftAdapter(getActivity(), Collections.emptyList(), this);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager));
        } else {
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager));

        }

    }




    private void initAll() {
        if (isViewEnable) {
            initRecyclerView();
            initView();
            if (viewDraftModelList.size() > 0) {
                showHideView(mRecyclerView, mRlNoData);

            } else
                showHideView(mRlNoData, mRecyclerView);


        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.ShowSettingMenu) this.context;
        fabListener = (CommonInterface.hideShowFabListner) this.context;

    }

    @Override
    public void onResume() {
        super.onResume();
//        setSwipeRefresh();

        listner.onShowSettingMenuForAdmin();
        fabListener.onFabHideListner();


    }

    @Override
    public void onPause() {
        super.onPause();
        listner.onShowSettingMenuForAdmin();
        fabListener.onFabHideListner();

    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null)
            fabListener.onFabHideListner();

        listner.onShowSettingMenuForAdmin();
    }

    @Override
    public void onStop() {
        super.onStop();
        fabListener.onFabHideListner();
        listner.onShowSettingMenuForAdmin();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_EDIT) {
            if (resultCode == RESULT_OK) {
                initView();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        isViewEnable = false;

        presenter.onDestroy();
        rvState = layoutManager.onSaveInstanceState();

    }


    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {

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
                    createPagination();


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
    public void setSwipeForPage(int pageNo, boolean b) {
        if (isViewEnable) {
            if (pageNo == 1)
                setSwipeRefresh();
            else
                addFooter(b);
        }
    }

    @Override
    public void onShowPaginationLoading(boolean show) {
        addFooter(show);
    }

    private void addFooter(boolean show) {
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
    public void onGetViewDraftListAvailable(List<ViewDraftModel> o) {
        if (isViewEnable) {
            stopSwipe();
            if (o.size() > 0) {
                showHideView(mRecyclerView, mRlNoData);
                viewDraftModelList.addAll(o);
                adapter.addItems(o);
            }
        }
    }

    public void stopSwipe() {
        isItemLoaded = true;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onSuccesDelete(ViewDraftModel modell) {
        if (isViewEnable) {
            modell.setDelete(false);
            adapter.removeModel(modell);
            adapter.notifyDataSetChanged();

            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, modell.getTax(), new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    createPagination();
                    presenter.onLoadMore(model);


                }
            });
        }
    }

    @Override
    public void onSuccess(ViewDraftModel modell) {
        if (isViewEnable) {
            modell.setDelete(false);
            adapter.notifyDataSetChanged();

            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, modell.getTax(), new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    createPagination();
                    presenter.onLoadMore(model);


                }
            });
        }

    }


    private void showHideView(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
    }


    @Override
    public void onNoMoreList() {
        isNoMore = true;
        stopSwipe();
        if (viewDraftModelList.size() > 0)
            showHideView(mRecyclerView, mRlNoData);
        else
            showHideView(mRlNoData, mRecyclerView);

    }

    public void setPaginationLoading(boolean paginationLoading) {
        this.paginationLoading = paginationLoading;
    }


    @Override
    public void onRefresh() {
        initView();
    }
}
