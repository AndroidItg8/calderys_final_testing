package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.IndentDetailFragment;
import com.itg.calderysapp.caldNet.newIndent.Deetails.ViewDetailsActivity;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.common.CommonMethod;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntentDispatchedDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IntentDispatchedDetailFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_EDIT = 22;
    @BindView(R.id.rd_indent_view)
    RadioButton rdIndentView;
    @BindView(R.id.rd_dispacthed)
    RadioButton rdDispacthed;
    @BindView(R.id.rdCalderysGroup)
    RadioGroup rdCalderysGroup;
    Unbinder unbinder;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private IndentModel indentModel;
    private int from = -1;
    private FragmentManager fm;


    public IntentDispatchedDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IntentDispatchedDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IntentDispatchedDetailFragment newInstance(IndentModel param1, int param2) {
        IntentDispatchedDetailFragment fragment = new IntentDispatchedDetailFragment();
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
            indentModel = getArguments().getParcelable(ARG_PARAM1);
            from = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intent_dispatched_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViewAll();
        return view;
    }

    private void initViewAll() {
        setOnClickedListner();
        checkConditionIndent();
    }

    private void
    checkConditionIndent() {
        if (indentModel != null) {
            if (indentModel.getIndApprvlStatus().equalsIgnoreCase(CommonMethod.PENDING) || indentModel.getIndApprvlStatus().equalsIgnoreCase(CommonMethod.CANCEL) || indentModel.getIndApprvlStatus().equalsIgnoreCase(CommonMethod.REJECT)) {
                setViewIndent();

            } else {
                rdCalderysGroup.setVisibility(View.VISIBLE);
                rdDispacthed.setVisibility(View.VISIBLE);
                rdIndentView.setVisibility(View.VISIBLE);

            }
           callFragment(IndentDetailFragment.newInstance(indentModel, CommonMethod.FROM_MYINTENTS));
        }
    }

    private void setViewIndent() {
        rdCalderysGroup.setVisibility(View.INVISIBLE);
        rdDispacthed.setVisibility(View.INVISIBLE);
        rdIndentView.setVisibility(View.INVISIBLE);

    }

    private void setViewToCenter(RadioButton view) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        view.setLayoutParams(lp);
    }

    private void setOnClickedListner() {
        rdCalderysGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rd_indent_view:
                callFragment(IndentDetailFragment.newInstance(indentModel, CommonMethod.FROM_MYINTENTS));

                break;
            case R.id.rd_dispacthed:
                callFragment(ViewDispatchedDetailFragment.newInstance(indentModel, from));
                break;
        }

    }

    private void callActivity() {
        if (indentModel != null) {
            Intent intent = new Intent(getActivity(), ViewDetailsActivity.class);
            intent.putExtra(CommonMethod.FROM_MYINTENTS, indentModel);
            startActivity(intent);
        }
    }

    public void callFragment(Fragment fragment) {
        if (getActivity() != null && fm == null)
            fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction();
        ft.replace(R.id.frame_dispached, fragment, fragment.getClass().getSimpleName());
//        ft.addToBackStack(fragment.getClass().getSimpleName());

        ft.commit();
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RC_EDIT) {
            if (resultCode == RESULT_OK) {
                checkConditionIndent();


            }
        }
    }



}