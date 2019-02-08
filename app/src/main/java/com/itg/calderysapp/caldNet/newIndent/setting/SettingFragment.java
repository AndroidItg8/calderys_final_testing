package com.itg.calderysapp.caldNet.newIndent.setting;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetMVP;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.setting.adapter.StoriesAdapter;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment implements HomeCalderysNetMVP.HomeCalderysNetView, RadioGroup.OnCheckedChangeListener, StoriesAdapter.OnItemClickedListner, CommonInterface.BackpressListner, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_EDIT = 234;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.rd_success_stories)
    RadioButton mRdSuccessStories;
    @BindView(R.id.rd_important_message)
    RadioButton mRdImportantMessage;
    @BindView(R.id.rdCalderysGroup)
    RadioGroup mRdCalderysGroup;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    private static final String TAG = "SettingFragment";
    @BindView(R.id.lbl_create)
    Button mLblCreate;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private HomeCalderysNetMVP.HomeCalderysNetPresenter presener;
    private boolean isViewEnable = false;
    private AdapterStringModel modelTitle;
    private Context context;
    private CommonInterface.hideShowFabListner listner;
    private StoriesAdapter adapter;
    private int from= 1;
    private LinearLayoutManager layoutManager;


    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
        presener = new HomeCalderysNetPresenterImp(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        unbinder = ButterKnife.bind(this, view);
        presener.onViewAvail(this);

        initView(true);

        return view;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rd_important_message:
                presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.INACTIVE);
                mLblCreate.setText(null);
                mLblCreate.setText("Create Important Message");
                from = 1;
                break;
            case R.id.rd_success_stories:
                presener.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES, CommonMethod.INACTIVE);
                mLblCreate.setText(null);
                mLblCreate.setText("Create Success Stories");
                from = 2;
                break;
        }

    }

    private void initView(boolean b) {
        isViewEnable = b;
        setOnClickedListner();
        presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE,  CommonMethod.INACTIVE);




    }

    private void setOnClickedListner() {
if(isViewEnable) {
    mRdCalderysGroup.setOnCheckedChangeListener(this);
    mLblCreate.setOnClickListener(this);
}
    }


    @Override
    public void onItemClickedEdit(int position, AdapterStringModel model) {
        callActivity(model);

    }

    private void callActivity(AdapterStringModel model) {
        Intent intent = new Intent(getActivity(), AddSetting.class);
        intent.putExtra(CommonMethod.FROM_SETTING, model);
        intent.putExtra(CommonMethod.FROM,from );
        startActivityForResult(intent, RC_EDIT);
    }

    @Override
    public void onItemEnableClicked(int position, AdapterStringModel model) {
        if (model.isActive()) {
            model.setActive(false);
        } else {
            model.setActive(true);
        }
        model.setShowProgress(true);
        if (presener != null)
            presener.onEditUploadedSetting(model);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemDeleteClicked(int position, AdapterStringModel model) {
        model.setShowProgress(true);
        if (presener != null)
            presener.onDeleteSetting(model);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onGetImportantMessagesListAvailable(List<MessageModel> o) {

        List<AdapterStringModel> list = new ArrayList<>();
        for (MessageModel model : o
                ) {

            modelTitle = new AdapterStringModel();
            modelTitle.setTitle(model.getDescription());
            modelTitle.setActive(model.isActive());
            modelTitle.setId(model.getIMID());
            modelTitle.setDate(model.getUpdatedOn());
            modelTitle.setFrom(CommonMethod.FROM_MESSAGE);

            list.add(modelTitle);
        }

        setDataAdapter(list);

    }

    @Override
    public void onGetSuccessStoriesListAvailable(List<StroiesModel> o) {
        setListAndViewPager(o);

    }

    private void setListAndViewPager(List<StroiesModel> o) {

        List<AdapterStringModel> list = new ArrayList<>();
        for (StroiesModel model : o
                ) {
            modelTitle = new AdapterStringModel();
            modelTitle.setTitle(model.getDescription());
            modelTitle.setActive(model.isActive());
            modelTitle.setId(model.getSSID());
            modelTitle.setDate(model.getUpdatedOn());
            modelTitle.setFrom(CommonMethod.FROM_MESSAGE);
            list.add(modelTitle);
        }

        setDataAdapter(list);


    }

    private void setDataAdapter(List<AdapterStringModel> list) {
        layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new StoriesAdapter(getActivity(), list, this);
        mRecyclerView.setAdapter(adapter);

    }


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        isViewEnable = false;
        presener.onDestroy();
        super.onDestroyView();

    }

    @Override
    public void onNoMoreList() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;


    }

    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            if (modelTitle != null) {
                modelTitle.setShowProgress(false);
                UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                    @Override
                    public void onRetryClicked() {
                        presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.INACTIVE);
                    }
                });
            }
        }

    }

    @Override
    public void onSuccess(Object object) {
        if (isViewEnable) {
            if (object instanceof AdapterStringModel) {
                AdapterStringModel model = (AdapterStringModel) object;
                model.setShowProgress(false);

                UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, model.getTitle(), new UtilSnackbar.OnSnackbarActionClickListener() {
                    @Override
                    public void onRetryClicked() {
                        if (model.getFrom().equalsIgnoreCase(CommonMethod.FROM_MESSAGE))
                            presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE,  CommonMethod.INACTIVE);
//                        else
//                            presener.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES);

//                        adapter.notifyDataSetChanged();


                    }
                });
            }
        }

    }


    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            if (modelTitle != null) {
                modelTitle.setShowProgress(false);

                UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mRecyclerView, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                            @Override
                            public void onRetryClicked() {
                                presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE,  CommonMethod.INACTIVE);
                            }
                        }

                );
            }
        }

    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            if (modelTitle != null) {
                modelTitle.setShowProgress(false);

                UtilSnackbar.showSnakbarTypeFail(mRecyclerView, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                    @Override
                    public void onRetryClicked() {
                        presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.INACTIVE);

                    }
                });
            }
        }

    }


    @Override
    public void showProgress() {
//        if (isViewEnable) {
//            mProgress.setVisibility(View.VISIBLE);
//            mRecyclerView.setVisibility(View.GONE);
//        }

    }

    @Override
    public void hideProgress() {
//        if (isViewEnable) {
//            mProgress.setVisibility(View.GONE);
//            mRecyclerView.setVisibility(View.VISIBLE);
//        }

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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_EDIT) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra(CommonMethod.FROM_CHECK)) {

                    AdapterStringModel from = data.getParcelableExtra(CommonMethod.FROM_CHECK);
                    if (from != null) {
                        if (from.getFrom().equalsIgnoreCase(CommonMethod.FROM_MESSAGE))
                            presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.INACTIVE);
                        else
                            presener.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES, CommonMethod.INACTIVE);
                    }
                    presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE, CommonMethod.INACTIVE);

                }
            }

        }
    }

    @Override
    public void onBackPressListener() {
        Log.d(TAG, "onBackPressListener: onBackPress");
//        if(from.equalsIgnoreCase(CommonMethod.FROM_MESSAGE))
//            presener.onDownloadImportantMesage(CommonMethod.TBL_IMPORTANT_MESSAGE);
//        else
//            presener.onDownloadSuccessStories(CommonMethod.TBL_SUCCESS_STORIES);

    }

    @Override
    public void onClick(View v) {
        if(v ==mLblCreate){
            Intent intent = new Intent(getActivity(), AddSetting.class);
            intent.putExtra(CommonMethod.FROM,from );
            startActivityForResult(intent, RC_EDIT);
        }

    }
}
