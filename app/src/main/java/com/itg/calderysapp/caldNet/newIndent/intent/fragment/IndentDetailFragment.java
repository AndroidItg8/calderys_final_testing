package com.itg.calderysapp.caldNet.newIndent.intent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.common.CommonMethod;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndentDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndentDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.img_delete)
    ImageView mImgDelete;
    @BindView(R.id.img_edit)
    ImageView mImgEdit;
    @BindView(R.id.txt_date)
    TextView mTxtDate;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.txt_indentDetail)
    TextView mTxtIndentDetail;
    @BindView(R.id.view2)
    View mView2;
    @BindView(R.id.lbl_indent_code)
    TextView mLblIndentCode;
    @BindView(R.id.txt_indentCode)
    TextView mTxtIndentCode;
    @BindView(R.id.lbl_dealer_code)
    TextView mLblDealerCode;
    @BindView(R.id.txt_dealer_code)
    TextView mTxtDealerCode;
    @BindView(R.id.lbl_consingee_code)
    TextView mLblConsingeeCode;
    @BindView(R.id.txt_consignee_code)
    TextView mTxtConsigneeCode;
    @BindView(R.id.lbl_so_type)
    TextView mLblSoType;
    @BindView(R.id.txt_so_type)
    TextView mTxtSoType;
    @BindView(R.id.lbl_po_number)
    TextView mLblPoNumber;
    @BindView(R.id.txt_po_number)
    TextView mTxtPoNumber;
    @BindView(R.id.lbl_indent_type)
    TextView mLblIndentType;
    @BindView(R.id.txt_intent_type)
    TextView mTxtIntentType;
    @BindView(R.id.lbl_division)
    TextView mLblDivision;
    @BindView(R.id.txt_division)
    TextView mTxtDivision;
    @BindView(R.id.lbl_approved_by)
    TextView mLblApprovedBy;
    @BindView(R.id.txt_approved_by)
    TextView mTxtApprovedBy;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private IndentModel model;
    private int from;
    private boolean isViewEnable=false;


    public IndentDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndentDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndentDetailFragment newInstance(IndentModel param1, int param2) {
        IndentDetailFragment fragment = new IndentDetailFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_indent_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;
        CommonMethod.setLeftRightDrawable(mTxtDate, R.drawable.ic_date, 0);

         intView();
        return view;
    }

    private void intView() {
        if(isViewEnable){
             mTxtDate.setText(model.getIndentDate());
             mTxtIndentCode.setText(model.getIndentCode());
             mTxtDealerCode.setText(model.getDealerCode());
             mTxtIndentCode.setText(model.getIndentStatus());
             mTxtApprovedBy.setText(model.getApprovedby());
             mTxtConsigneeCode.setText(model.getConsigneeCode());
             mTxtDivision.setText(model.getDivision());
             mTxtIntentType.setText(model.getIndentType());
             mTxtSoType.setText(model.getSOType());
             mTxtPoNumber.setText(model.getPONumber());
             mTxtSoType.setText(model.getSOType());




        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
         isViewEnable =false;
    }
}
