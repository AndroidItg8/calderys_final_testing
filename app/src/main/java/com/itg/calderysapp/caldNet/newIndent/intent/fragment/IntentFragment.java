package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.ViewPagerFragmentAdapter;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.ApproveIntentFragment;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UserType;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IntentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.viewpagerFragment)
    ViewPager mViewpagerFragment;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    CommonInterface.ShowSettingMenu listner;
    private CommonInterface.hideShowFabListner fabListener;


    public IntentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IntentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IntentFragment newInstance(String param1, String param2) {
        IntentFragment fragment = new IntentFragment();
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
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intent, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.ShowSettingMenu) this.context;
        fabListener = (CommonInterface.hideShowFabListner) this.context;

    }

    private void initView() {
        setupViewPager(mViewpagerFragment);
        mTabs.setupWithViewPager(mViewpagerFragment);
    }

    @Override
    public void onResume() {
        super.onResume();
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

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getChildFragmentManager());
        if(Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase(UserType.S.toString())) {
            adapter.addFragment( MyIntentFragment.newInstance("",""), "My Indents");
            adapter.addFragment( ViewDraftFragment.newInstance("",""), "View Draft");
            adapter.addFragment( ApproveIntentFragment.newInstance("",""), "Approve Indents");
            adapter.addFragment( ViewIntentFragment.newInstance("",""), "View Indents");
            adapter.addFragment( ViewPantIntentFragment.newInstance("",""), "View Plant Indents");
        }
        else if(Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase(UserType.P.toString())) {

            adapter.addFragment(new ViewPantIntentFragment(), "View Plant Indents");

        }    else if(Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase(UserType.D.toString())) {

            adapter.addFragment(new MyIntentFragment(), "My Indents");
            adapter.addFragment(new ViewDraftFragment(), "View Draft");

        }else if(Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase(UserType.C.toString())) {

            adapter.addFragment(new ApproveIntentFragment(), "Approve Indents");
            adapter.addFragment(new ViewIntentFragment(), "View Indents");

        }

        viewPager.setAdapter(adapter);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
