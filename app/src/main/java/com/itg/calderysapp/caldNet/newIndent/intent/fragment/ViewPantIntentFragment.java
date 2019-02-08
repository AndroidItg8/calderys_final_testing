package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
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
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.IntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.ViewPlantIntentPresenterImp;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPantIntentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPantIntentFragment extends Fragment implements View.OnClickListener, IntentAdapter.OnItemClickedListner, IntentView.ViewPlantIntentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_INDENT = 23;
    @BindView(R.id.edtStartDate)
    TextInputEditText mEdtStartDate;
    @BindView(R.id.input_layout_start_date)
    TextInputLayout mInputLayoutStartDate;
    @BindView(R.id.edtEndDate)
    TextInputEditText mEdtEndDate;
    @BindView(R.id.input_layout_end_date)
    TextInputLayout mInputLayoutEndDate;
    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.ll_input)
    RelativeLayout mLlInput;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.edtPlantName)
    TextInputEditText mEdtPlantName;
    @BindView(R.id.input_layout_plant)
    TextInputLayout mInputLayoutPlant;
    @BindView(R.id.ll)
    LinearLayout mLl;
    //    @BindView(R.id.edt_send_mail)
//    TextInputEditText mEdtSendMail;
//    @BindView(R.id.input_layout_send_mail)
//    TextInputLayout mInputLayoutSendMail;
//    @BindView(R.id.img_send)
//    ImageView mImgSend;

    @BindView(R.id.img_no)
    ImageView mImgNo;
    @BindView(R.id.txt_no_data)
    TextView mTxtNoData;
    @BindView(R.id.rlNoData)
    RelativeLayout mRlNoData;
    @BindView(R.id.nestedScrolling)
    NestedScrollView mScrollView;

    @BindView(R.id.card_date)
    CardView cardDate;
    @BindView(R.id.lbl_plant_name)
    TextView lblPlantName;
    @BindView(R.id.txt_plant_name)
    TextView txtPlantName;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager layoutManager;
    private Calendar selectedDate = Calendar.getInstance();
    private static final String TAG = "ViewPantIntentFragment";
    private IntentView.ViewPlantIntentPresenter presenter;
    private boolean isViewEnable = false;
    private PaginationModel model;
    private IntentAdapter adapter;
    private boolean noMoreList = false;
    private FragmentManager fm;
    private List<IndentModel> list = null;
    private View v;
    private Parcelable rvState;

    public ViewPantIntentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewPantIntentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPantIntentFragment newInstance(String param1, String param2) {
        ViewPantIntentFragment fragment = new ViewPantIntentFragment();
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
        presenter = new ViewPlantIntentPresenterImp(this);
         layoutManager = new LinearLayoutManager(getActivity());
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pant_intent, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        if(rvState==null)
            presenter.setViewAllAvailable(this);
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



    @Override
    public void onStartDateInvalid(String err) {
        mInputLayoutStartDate.setError(err);

    }

    @Override
    public void onEndDateInvalid(String err) {
        mInputLayoutEndDate.setError(err);


    }

    @Override
    public String getStartDate() {

        return mEdtStartDate.getText().toString();
    }

    @Override
    public String getEndDate() {
        return mEdtEndDate.getText().toString();

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

            case R.id.btn_add:
                presenter.onSubmitApproved(v, Prefs.getString(CommonMethod.USER_TYPE));
                break;

        }

    }

    private void initView() {
        if(MyApplication.getInstance().isP())
        {
            lblPlantName.setVisibility(View.VISIBLE);
            txtPlantName.setVisibility(View.VISIBLE);
            txtPlantName.setText(Prefs.getString(CommonMethod.USER_ID));
        }else{
            lblPlantName.setVisibility(View.GONE);
            txtPlantName.setVisibility(View.GONE);
        }
        setDate(Calendar.getInstance(), mEdtEndDate);
        setDate(Calendar.getInstance(), mEdtStartDate);

    }

    private void setDate(Calendar calendar, TextInputEditText mEdtDate) {
        String getSelectedDateFromCalander = CommonMethod.getDDMMYYYYfromDate(calendar);
        mEdtDate.setText(getSelectedDateFromCalander);
    }


    private void openCalender(TextInputEditText mEdtStartDate) {

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

//                String getSelectedDateFromCalander = CommonMethod.getDDMMYYYYfromDate(calendar);
//                mEdtStartDate.setText(getSelectedDateFromCalander);
                setDate(calendar, mEdtStartDate);
            }
        }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setTitle("SELECT DATE");
        datePickerDialog.show();


    }


    private void initRecyclerView() {
if(rvState==null){
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);
        adapter = new IntentAdapter(getActivity(), Collections.emptyList(), CommonMethod.FROM_VIEW_PLANT_INTENT, this);
        mRecyclerView.setAdapter(adapter);

    }else{
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
//        mRecyclerView.addOnScrollListener(presenter.scrollListener(layoutManager, Prefs.getString(CommonMethod.USER_ID)));


    }


    private void initAll() {
        if (isViewEnable) {
            initRecyclerView();
            setClickedListner();
            initView();


        }
    }

    private void setClickedListner() {
        mEdtStartDate.setOnClickListener(this);
        mEdtEndDate.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();



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
        rvState = layoutManager.onSaveInstanceState();
    }


    @Override
    public void onFail(PaginationModel message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, message.getTbleName(), new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    int pageNo = message.getPageNo();
                    String startDate = message.getParameter();
                    String endDate = message.getParameter2();
                    presenter.onLoadMore(new PaginationModel(Prefs.getString(CommonMethod.USER_TYPE), pageNo, 10, startDate, endDate));
                }
            });
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mRecyclerView, t.toString(), new
                    UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            if (isViewEnable) {
                                initView();
//                                presenter.onSubmitApproved(v, Prefs.getString(CommonMethod.USER_TYPE));
                            }
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
                    if (isViewEnable) {
                        initView();

                    }
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
    public void onGetAllViewPlantIntentList(List<IndentModel> o) {
        if (isViewEnable) {
            showHideView(mRecyclerView, mRlNoData);
            adapter.addItems(o);
            list = o;
        }

    }

    private void showHideView(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
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
                    model.setPageNo(1);
                    presenter.onLoadMore(model);

                }
            });
        }

    }

    @Override
    public void addScrollListener() {
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
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
        });
    }


    @Override
    public void onNoMoreList() {

        noMoreList = true;

//        if(list!=null){
//            showHideView(mRlNoData, mRecyclerView);
//
//        }else{
//            showHideView( mRecyclerView,mRlNoData);
//        }

    }


    @Override
    public void onItemClicked(int position, IndentModel model, int from) {
        Intent intent = new Intent(getActivity(), ViewDetailsActivity.class);
        intent.putExtra(CommonMethod.FROM_PLANT, model);
        intent.putExtra(CommonMethod.FROM, from);
        startActivityForResult(intent, RC_INDENT);

    }

    @Override
    public void onItemClickedDispatched(int position, IndentModel model, int from) {

        callFragment(ViewDispatchedDetailFragment.newInstance(model, from));

    }

    private void callFragment(Fragment fragment) {

        if (getActivity() != null && fm == null)
            fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction();
        ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
//        ft.addToBackStack(fragment.getClass().getSimpleName());

        ft.commit();
    }

    @Override
    public void onItemCancel(int adapterPosition, IndentModel indentModel, int from) {


        indentModel.setDelete(true);
        presenter.onCancelMyIntent(indentModel);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemEdit(int adapterPosition, IndentModel indentModel, int from) {
        IndentsModel model = new Gson().fromJson(new Gson().toJson(indentModel), IndentsModel.class);
        Intent intent = new Intent(getActivity(), CreateIndentNewActivity.class);
        intent.putExtra(CommonMethod.FROM_VIEW_PLANT_INTENTS, model);
        startActivity(intent);
    }


}
