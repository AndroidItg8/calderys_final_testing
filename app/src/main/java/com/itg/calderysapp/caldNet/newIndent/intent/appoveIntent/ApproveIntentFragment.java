package com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.ViewDetailsActivity;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.IntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.mvp.ApprovedIntentPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.IntentBaseActivity;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ApproveIntentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApproveIntentFragment extends Fragment implements View.OnClickListener, IntentAdapter
        .OnItemClickedListner, IntentView.ApprovedIntentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ApproveIntentFragment";
    private static final int RC_CODE = 345;
    private static final String BUNDLE_RECYCLER_LAYOUT = "BUNDLE_RECYCLER_LAYOUT";
    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.edtStartDate)
    TextInputEditText mEdtStartDate;
    @BindView(R.id.input_layout_start_date)
    TextInputLayout mInputLayoutStartDate;
    @BindView(R.id.edtEndDate)
    TextInputEditText mEdtEndDate;
    @BindView(R.id.input_layout_end_date)
    TextInputLayout mInputLayoutEndDate;
    @BindView(R.id.ll_date)
    LinearLayout mLlDate;
    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.ll_input)
    RelativeLayout mLlInput;
    @BindView(R.id.edt_send_mail)
    TextInputEditText mEdtSendMail;
    @BindView(R.id.input_layout_send_mail)
    TextInputLayout mInputLayoutSendMail;
    @BindView(R.id.img_send)
    ImageView mImgSend;
    @BindView(R.id.txt_intent_code)
    TextView mTxtIntentCode;
    @BindView(R.id.img_intent)
    ImageView mImgIntent;
    @BindView(R.id.rl_intent)
    CardView mRlIntent;
    @BindView(R.id.txt_delear_code)
    TextView mTxtDelearCode;
    @BindView(R.id.img_delear)
    ImageView mImgDelear;
    @BindView(R.id.card_dealer)
    CardView mCardDealer;
    @BindView(R.id.card_date)
    CardView mCardDate;
    @BindView(R.id.lbl_intent_name)
    TextView mLblIntentName;
    @BindView(R.id.lbl_dealer_name)
    TextView mLblDealerName;
    @BindView(R.id.img_no)
    ImageView imgNo;
    @BindView(R.id.txt_no_data)
    TextView txtNoData;
    @BindView(R.id.rlNoData)
    RelativeLayout rlNoData;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager layoutManager;
    private Calendar selectedDate = Calendar.getInstance();
    private FragmentManager fm;
    private DealerModel modelDealer;
    private IntentView.ApprovedIntentPresenter presenter;
    private IndentModel mo;
    private boolean isViewEnable = false;
    private PaginationModel model;
    private ApproveIndentAdapter adapter;
    private boolean noMoreList = false;
    private List<IndentModel> list = new ArrayList<>();
    private Context context;
    private Parcelable savedRecyclerLayoutState;
    public static int index = -1;
    public static int top = -1;
    private int lastFirstVisiblePosition = -1;
    private View v;
    private Parcelable rvState;

    public ApproveIntentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApproveIntentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ApproveIntentFragment newInstance(String param1, String param2) {
        ApproveIntentFragment fragment = new ApproveIntentFragment();
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
//        setRetainInstance(true);
        presenter = new ApprovedIntentPresenterImp(this);
        layoutManager = new LinearLayoutManager(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_material_status, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;

        if (rvState == null)
            presenter.allViewAvailable(this);
        else
            restoreRv();


        initAll();




        return view;
    }


    private void restoreRv() {

        if (rvState != null) {
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.onRestoreInstanceState(rvState);
        }
    }


//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT,  layoutManager.onSaveInstanceState());
//        lastFirstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();
//        super.onSaveInstanceState(outState);
//    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if(savedInstanceState != null)
//        {
//            savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
//            layoutManager.onRestoreInstanceState(savedRecyclerLayoutState);
//        }

    }


    private void clickedListenr() {
        mEdtStartDate.setOnClickListener(this);
        mEdtEndDate.setOnClickListener(this);
        mCardDealer.setOnClickListener(this);
        mImgDelear.setOnClickListener(this);
        mRlIntent.setOnClickListener(this);
        mImgIntent.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
    }


    @Override
    public String getDealerCode() {
        if (modelDealer != null)
            return String.valueOf(modelDealer.getDealerCode());
        return "";
    }

    @Override
    public String getIndentCode() {
        if (mo != null)
            return String.valueOf(mo.getIndentCode());
        return "";
    }

    @Override
    public void onDealerCodeInvalid(String err) {
        mTxtDelearCode.setError(err);

    }

    @Override
    public void onIndentCodeInvalid(String err) {
        mTxtIntentCode.setError(err);


    }

    @Override
    public void onStartDateInvalid(String err) {
        mEdtStartDate
                .setError(err);

    }

    @Override
    public void onEndDateInvalid(String err) {

        mEdtEndDate.setError(err);


    }


    @Override
    public String getStartDate() {
        if (isViewEnable)
            return mEdtStartDate.getText().toString();
        else
            return null;
    }

    @Override
    public String getEndDate() {
        if (isViewEnable)
            return mEdtEndDate.getText().toString();
        else
            return null;

    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public void onStatusCodeInvalid(String string) {

    }

    @Override
    public void addScrollListener() {
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (isViewEnable) {
                    if (noMoreList)
                        return;
                    if (isViewEnable) {
                        View view = (View) mScrollView.getChildAt(mScrollView.getChildCount() - 1);
                        int diff = (view.getBottom() - (mScrollView.getHeight() + mScrollView
                                .getScrollY()));

                        if (diff == 0) {
                            presenter.loadMore();
                        }
                    }
                }
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        this.v = v;
        switch (v.getId()) {
            case R.id.edtStartDate:
                openCalender(mEdtStartDate);
                break;
            case R.id.edtEndDate:
                openCalender(mEdtEndDate);
                break;

            case R.id.card_dealer:
//                    callFragment(DealerCodeFragment.newInstance("",""));

                callActivity(CommonMethod.FROM_DEALER);
                break;
            case R.id.rl_intent:
//                if (modelDealer != null) {
                callActivity(CommonMethod.FROM_INTENT);
//                } else {
//
//                    UtilSnackbar.showSnakbarRedColor(mRecyclerView, "Please Select Dealer First");
//                }

//                    callFragment(IntentFragment.newInstance("",""));
                break;
            case R.id.img_delear:
                break;
            case R.id.img_intent:
                break;
            case R.id.btn_add:
                presenter.onSubmitApproved(v, CommonMethod.FROM_APPROVED);
                break;

        }

    }

    private void callActivity(String from) {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), IntentBaseActivity.class);
            intent.putExtra(CommonMethod.FROM, "");
            intent.putExtra(from, from);
            if (modelDealer != null)
                intent.putExtra(CommonMethod.DEALER_DATA, modelDealer);
            startActivityForResult(intent, RC_CODE);
        }
    }


    private void openCalender(final TextInputEditText mEdtDate) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Log.d(TAG, "onDateSet: " + Calendar.getInstance().getTimeInMillis() + " - " + calendar.getTimeInMillis());
//                    if (calendar.getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) {
//                        UtilSnackbar.showSnakbarTypeTwo(mBtnAdd,"Date cannot be less than today");
//                        return;
//                    }

                setDate(calendar, mEdtDate);
            }
        }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setTitle("SELECT DATE");
        datePickerDialog.show();
    }

    private void setDate(Calendar calendar, TextInputEditText mEdtDate) {
        String getSelectedDateFromCalander = CommonMethod.getDDMMYYYYfromDate(calendar);
        mEdtDate.setText(getSelectedDateFromCalander);
    }

    @Override
    public void onItemClicked(int position, IndentModel model, int from) {
        Intent intent = new Intent(getActivity(), ViewDetailsActivity.class);
        intent.putExtra(CommonMethod.FROM_APPROVED_INDENT, model);
        startActivity(intent);
    }

    @Override
    public void onItemClickedDispatched(int position, IndentModel model, int from) {

    }

    @Override
    public void onItemCancel(int adapterPosition, IndentModel indentModel, int from) {

    }

    @Override
    public void onItemEdit(int adapterPosition, IndentModel indentModel, int from) {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//    super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_CODE) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra(CommonMethod.DEALER)) {
                    if (data.getParcelableExtra(CommonMethod.DEALER) instanceof DealerModel) {
                        modelDealer = data.getParcelableExtra(CommonMethod.DEALER);
                        setData(modelDealer);
                    }
                } else if (data.hasExtra(CommonMethod.INDENT)) {
                    mo = data.getParcelableExtra(CommonMethod.INDENT);
                    setIndentData(mo);
                }
            }
        }
    }

    private void setIndentData(IndentModel mo) {
        mTxtIntentCode.setVisibility(View.VISIBLE);
        mTxtIntentCode.setText(mo.getIndentCode());
        mLblIntentName.setText("Indent Code");
    }

    private void setData(DealerModel model) {
        mTxtDelearCode.setVisibility(View.VISIBLE);
        mTxtDelearCode.setText(model.getDealerCode());
        mLblDealerName.setText("Dealer Code");

    }


    private void initView() {
//        model = new PaginationModel();
//        createPaginationModel(1,model);
//        presenter.onLoadMoreItem(model);


        setDate(Calendar.getInstance(), mEdtEndDate);
        setDate(Calendar.getInstance(), mEdtStartDate);
        clickedListenr();


    }

    @Override
    public void createPaginationModel(int pageNumber, @NonNull PaginationModel model) {
        model.setLimit(10);
        model.setPageNo(pageNumber);
        model.setTbleName(CommonMethod.TBL_MYINDENT);
        model.setParameter(getIndentCode());
        model.setParameter2(getDealerCode());
        model.setParameter3(getStartDate());
        model.setParameter4(getEndDate());
        model.setParameter5(null);
    }

    private void initRecyclerView() {
        if(isViewEnable) {
            if (rvState == null) {
                mRecyclerView.setLayoutManager(layoutManager);
                adapter = new ApproveIndentAdapter(new ArrayList<>(), this);
                mRecyclerView.setAdapter(adapter);
            } else {
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(adapter);
            }

            //    mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager));
        }

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
        isViewEnable = true;
        //set recyclerview position
//        setOnResumeStorePosition();
//         presenter.onLoadMoreItem(model);


    }

    private void setOnResumeStorePosition() {
        if (index != -1) {
            layoutManager.scrollToPositionWithOffset(index, top);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isViewEnable = false;
        onStrorePostion();
    }


    private void onStrorePostion() {
        index = layoutManager.findFirstVisibleItemPosition();
        View startView = mRecyclerView.getChildAt(0);
        top = (startView == null) ? 0 : (startView.getTop() - mRecyclerView.getPaddingTop());
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
                    PaginationModel model = new PaginationModel();
                    createPaginationModel(1, model);
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
                    createPaginationModel(1, model);
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
                    createPaginationModel(1, model);
                    presenter.onLoadMore(model);

                }
            });
        }
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
        mBtnAdd.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
        mBtnAdd.setVisibility(View.VISIBLE);

    }

    @Override
    public void onShowPaginationLoading(boolean show) {
        if (isViewEnable) {
            if (show) {
//                setPaginationLoading(true);
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.addFooter();

                    }
                });
            } else {
                adapter.removeFooter();
//                setPaginationLoading(false);
            }
        }
    }

    @Override
    public void onGetAllApprovedIntent(List<IndentModel> o) {
        if (isViewEnable) {

            showHideView(mRecyclerView, rlNoData);
            list.addAll(o);
            adapter.addItems(o);
            mRecyclerView.getLayoutManager().onRestoreInstanceState(savedRecyclerLayoutState);
            Log.d(TAG, "onGetAllApprovedIntent: lits" + new Gson().toJson(o));

        }
    }

    @Override
    public void onSuccess(IndentModel message) {

    }

    @Override
    public void onNoMoreList() {
        noMoreList = true;
        if (list.size() == 0)
            showHideView(rlNoData, mRecyclerView);
        else
            showHideView(mRecyclerView, rlNoData);


//        mScrollView.getViewTreeObserver().addOnScrollChangedListener(null);
    }

    private void showHideView(View show, View hide) {

        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
    }


}

