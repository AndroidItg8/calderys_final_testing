package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.ViewDetailsActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.IntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.MyIntentsPresenterImp;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyIntentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyIntentFragment extends Fragment implements IntentView.MyIntentsView, IntentAdapter.OnItemClickedListner, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_EDIT = 98;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.img_no)
    ImageView mImgNo;
    @BindView(R.id.txt_no_data)
    TextView mTxtNoData;
    @BindView(R.id.rlNoData)
    RelativeLayout mRlNoData;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager layoutManager;
    private IntentView.MyIntentsPresenter presenter;
    private PaginationModel model;
    private boolean isViewEnable = false;
    private IntentAdapter adapter;
    private FragmentManager fm;
    private boolean paginationLoading;
    private List<IndentModel> indentModel = null;
    private Context context;
    private CommonInterface.ShowSettingMenu listner;
    private boolean isNoMoreList = false;
    private boolean isItemLoaded=false;
    private CommonInterface.hideShowFabListner fabListener;
    private Parcelable rvState;


    public MyIntentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyIntentFragment.
     */
    // TODO: Rename and change types and number of parameters
    private static final String TAG = "MyIntentFragment";

    public static MyIntentFragment newInstance(String param1, String param2) {
        MyIntentFragment fragment = new MyIntentFragment();
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
        presenter = new MyIntentsPresenterImp(this);
        layoutManager = new LinearLayoutManager(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_intent, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        if (rvState == null)
            presenter.allViewAvailable(this);
        else
            restoreRv();


        initAll();
        return view;
    }


    @Override
    public void onItemClickedDispatched(int position, IndentModel model, int from) {
        Log.d(TAG, "onItemClickedDispatched: "+new Gson().toJson(model));
        callFragment(ViewDispatchedDetailFragment.newInstance(model, from));
    }

    private void initView() {
        model = new PaginationModel();
        model.setLimit(10);
        model.setPageNo(1);
        model.setTbleName(CommonMethod.TBL_MYINDENT);
//        model.setParameter(Prefs.getString(CommonMethod.USER_ID));
        presenter.onLoadMoreItem(model);

    }


    private void initRecyclerView() {
        if(rvState==null){
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new IntentAdapter(getActivity(), new ArrayList<>(), CommonMethod.FROM_MYINTENT, this);

        mRecyclerView.setAdapter(adapter);
    }else{
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
//            mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, Prefs.getString(CommonMethod.USER_ID)));

        }
        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, Prefs.getString(CommonMethod.USER_ID)));


    }
    private void restoreRv() {
        if (rvState != null) {
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.onRestoreInstanceState(rvState);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.ShowSettingMenu) this.context;
        fabListener = (CommonInterface.hideShowFabListner) this.context;
    }

    private void setSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        if (isItemLoaded)
            swipeRefreshLayout.setRefreshing(false);
        else
            swipeRefreshLayout.setRefreshing(true);

    }


    private void initAll() {
        if (isViewEnable) {
            initViewRecycler();
            if (indentModel == null) {
                showHideView(mRlNoData, mRecyclerView);
            } else {
                showHideView(mRecyclerView, mRlNoData);

            }
            setSwipeRefresh();


        }
    }

    private void initViewRecycler() {
        initRecyclerView();
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        listner.onShowSettingMenuForAdmin();
        fabListener.onFabHideListner();
        isViewEnable = true;


    }

    @Override
    public void onPause() {
        super.onPause();
        isViewEnable = false;
        listner.onShowSettingMenuForAdmin();
        fabListener.onFabHideListner();

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
    public void getPageItem(int pageNo, boolean b) {
        if(isViewEnable) {
            if (pageNo == 1) {
                    setSwipeRefresh();
            } else {
                setAddFooter(b);

            }
        }
    }

    @Override
    public void onShowPaginationLoading(boolean show) {
        if (isViewEnable) {
            setAddFooter(show);
        }
    }

    private void setAddFooter(boolean show) {
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

    @Override
    public boolean isPaginationLoading() {
        return paginationLoading;
    }

    @Override
    public void onGetMyIntentsListAvailable(List<IndentModel> o) {
        if (isViewEnable) {
            isItemLoaded=true;
            swipeRefreshLayout.setRefreshing(false);
            showHideView(mRecyclerView, mRlNoData);
            this.indentModel = o;
            adapter.addItems(o);
        }

    }

    @Override
    public void onSuccess(IndentModel message) {
        if (isViewEnable) {
            message.setDelete(false);
            adapter.removeItem(message);
            adapter.notifyDataSetChanged();
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, "Indent Delete Successfully", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    initView();

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
        showHideView(mRlNoData, mRecyclerView);
        swipeRefreshLayout.setRefreshing(false);
        isNoMoreList = true;
        isItemLoaded=false;


    }

    @Override
    public void createPaginationModel(int pageNumber, PaginationModel model) {


    }

    @Override
    public String getQuery() {
        return null;
    }

    public void setPaginationLoading(boolean paginationLoading) {
        this.paginationLoading = paginationLoading;
    }

    @Override
    public void onItemClicked(int position, IndentModel model, int from) {
        Log.d(TAG, "onItemClicked: "+new Gson().toJson(model));
        if (model.getIndApprvlStatus().equalsIgnoreCase(CommonMethod.PENDING) || model.getIndApprvlStatus().equalsIgnoreCase(CommonMethod.CANCEL) || model.getIndApprvlStatus().equalsIgnoreCase(CommonMethod.REJECT)) {
            Intent intent = new Intent(getActivity(), ViewDetailsActivity.class);
            intent.putExtra(CommonMethod.FROM_MYINTENTS, model);
            startActivity(intent);
        } else {
            if(getActivity()!=null)
             ((HomeActivity) getActivity()).callFragment(IntentDispatchedDetailFragment.newInstance(model, from));
        }
    }

    public void callFragment(Fragment fragment) {
        if (getActivity() != null && fm == null)
            fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
        ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commit();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean getPaginationLoading() {
        return paginationLoading;
    }

    @Override
    public void onItemCancel(int adapterPosition, IndentModel indentModel, int from) {

        openDialogue(indentModel);
    }

    private void openDialogue(IndentModel indentModel) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        cancelIndentItem(indentModel);
                        dialog.dismiss();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        dialog.dismiss();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure to cancel indent?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    private void cancelIndentItem(IndentModel indentModel) {
//        indentModel.setIndentDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
//        indentModel.setCreatedDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
//        indentModel.setPODate(CommonMethod.getDDMMYYYYfromDateServer(indentModel.getPODate()));
//        indentModel.setStatusDate(CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()));
//        indentModel.setDispatchDate(CommonMethod.getDDMMYYYYfromDateServer(indentModel.getDispatchDate()));
//        indentModel.setIndApprvlStatus("C");
//        Log.d(TAG, "onSumitClick: "+new Gson().toJson(indentModel));


        indentModel.setDelete(true);
        presenter.onCancelMyIntent(indentModel);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onItemEdit(int adapterPosition, IndentModel indentModel, int from) {
        IndentsModel model = new Gson().fromJson(new Gson().toJson(indentModel), IndentsModel.class);
        Intent intent = new Intent(getActivity(), CreateIndentNewActivity.class);
        intent.putExtra(CommonMethod.INDENT, model);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        initAll();

    }
}
