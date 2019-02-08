package com.itg.calderysapp.caldNet.newIndent.Deetails;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product_;
import com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model.AID;
import com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model.PtItem;
import com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model.SAPModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.GenericSpinnerAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.MaterialIntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvp.CreateIntentMVP;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvp.CreateIntentPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.SpinnerItemSelect;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.notification.NotificationModel.Data;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.notification.controller.FirebaseMessageController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.DIVISION;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.EQUIPMENTCODE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.INDENTTYPE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.PROCESSCODE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SALESGROUP;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SALESOFFICES;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SALESPACKAGE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SOTYPE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SPECIALPROCESSINDICATORS;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.USAGEINDICATOR;

/**
 * Use the {@link IndentDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndentDetailFragment extends Fragment implements MaterialIntentAdapter.OnItemClickedListner, CreateIntentMVP.CreatIntentView, View.OnClickListener, ViewDetailsActivity.SAPApprovedListner, ViewDetailsActivity.OnBackPressedListener {

    private static final String TAG = "ViewDetailsActivity";
    private static final int RC_EDIT = 23;
    private static final String ARG_PARAM3 = "ARG_PARAM3";
    private static final String ARG_PARAM4 = "ARG_PARAM4";
    private static final String APPROVED = "S";
    private static final String REJECT = "R";


    Unbinder unbinder;
    @BindView(R.id.lbl_intents_details)
    TextView lblIntentsDetails;
    @BindView(R.id.lbl_indent_code)
    TextView lblIndentCode;
    @BindView(R.id.txt_indent_code)
    TextView txtIndentCode;
    @BindView(R.id.tbl_row_product)
    TableRow tblRowProduct;
    @BindView(R.id.lbl_indent_status)
    TextView lblIndentStatus;
    @BindView(R.id.txt_indent_status)
    TextView txtIndentStatus;
    @BindView(R.id.lbl_dealer_name)
    TextView lblDealerName;
    @BindView(R.id.txt_dealer_name)
    TextView txtDealerName;
    @BindView(R.id.txt_consignee_code)
    TextView txtConsigneeCode;
    @BindView(R.id.lbl_indent_date)
    TextView lblIndentDate;
    @BindView(R.id.txt_indent_date)
    TextView txtIndentDate;
    @BindView(R.id.lbl_po_number)
    TextView lblPoNumber;
    @BindView(R.id.txt_po_number)
    TextView txtPoNumber;
    @BindView(R.id.lbl_po_date)
    TextView lblPoDate;
    @BindView(R.id.txt_po_date)
    TextView txtPoDate;
    @BindView(R.id.lbl_igst)
    TextView lblIgst;
    @BindView(R.id.txt_igst)
    TextView txtIgst;
    @BindView(R.id.lbl_sgst)
    TextView lblSgst;
    @BindView(R.id.txt_sgst)
    TextView txtSgst;
    @BindView(R.id.lbl_consignee_name)
    TextView lblConsigneeName;
    @BindView(R.id.txt_consignee_name)
    TextView txtConsigneeName;
    @BindView(R.id.lbl_Delivery_date)
    TextView lblDeliveryDate;
    @BindView(R.id.txt_delivery_date)
    TextView txtDeliveryDate;
    @BindView(R.id.lbl_add_tax_info)
    TextView lblAddTaxInfo;
    @BindView(R.id.txt_add_tax_info)
    TextView txtAddTaxInfo;
    @BindView(R.id.simpleTableLayout)
    TableLayout simpleTableLayout;
    @BindView(R.id.rl_indents)
    RelativeLayout rlIndents;
    @BindView(R.id.lbl_product_details)
    TextView lblProductDetails;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.rl_material)
    RelativeLayout rlMaterial;
    @BindView(R.id.lbl_so_details)
    TextView lblSoDetails;
    @BindView(R.id.struts)
    View struts;
    @BindView(R.id.lbl_so_type)
    TextView lblSoType;
    @BindView(R.id.so_type_spinner)
    Spinner soTypeSpinner;
    @BindView(R.id.lbl_sales_office)
    TextView lblSalesOffice;
    @BindView(R.id.sales_spinner)
    Spinner salesSpinner;
    @BindView(R.id.lbl_distribution_channel)
    TextView lblDistributionChannel;
    @BindView(R.id.edt_destribution_channel)
    EditText edtDestributionChannel;
    @BindView(R.id.lbl_usage_indicator)
    TextView lblUsageIndicator;
    @BindView(R.id.usaga_spinner)
    Spinner usagaSpinner;
    @BindView(R.id.lbl_process_code)
    TextView lblProcessCode;
    @BindView(R.id.process_code_spinner)
    Spinner processCodeSpinner;
    @BindView(R.id.lbl_devision)
    TextView lblDevision;
    @BindView(R.id.edt_devision)
    EditText edtDevision;
    @BindView(R.id.lbl_sales_organization)
    TextView lblSalesOrganization;
    @BindView(R.id.edt_sales_organization)
    EditText edtSalesOrganization;
    @BindView(R.id.lbl_equipment)
    TextView lblEquipment;
    @BindView(R.id.equipment_spinner)
    Spinner equipmentSpinner;
    @BindView(R.id.lbl_spl_process_indicator)
    TextView lblSplProcessIndicator;
    @BindView(R.id.spl_process_indicator_spinner)
    Spinner splProcessIndicatorSpinner;
    @BindView(R.id.lbl_partner)
    TextView lblPartner;
    @BindView(R.id.edt_partner)
    EditText edtPartner;
    @BindView(R.id.lbl_sales_grp)
    TextView lblSalesGrp;
    @BindView(R.id.sales_group_spinner)
    Spinner salesGroupSpinner;
    @BindView(R.id.lbl_sales_package)
    TextView lblSalesPackage;
    @BindView(R.id.sales_package_spinner)
    Spinner salesPackageSpinner;
    @BindView(R.id.lbl_approve_reject)
    TextView lblApproveReject;
    @BindView(R.id.lbl_comment_for_approved)
    TextView lblCommentForApproved;
    @BindView(R.id.edt_approved_reject)
    EditText edtApprovedReject;
    @BindView(R.id.btnApprove)
    Button btnApprove;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.btnReject)
    Button btnReject;
    @BindView(R.id.rl_approved_reject)
    RelativeLayout rlApprovedReject;
    @BindView(R.id.nestedScrolling)
    NestedScrollView nestedScrolling;
    private LinearLayoutManager layoutManager;
    private GenericSpinnerAdapter genericSpinnerAdapter = null;
    private SpinnerGenericModel genericModel;

    private CreateIntentMVP.CreateIntentPresenter presenter;
    private boolean isViewEnable = false;
    private IntentDetailModel model;
    List<Product_> product_list = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private IndentModel indentModel;
    private String from = null;
    private ViewDraftModel viewDraftMdel;
    private String fromViewDraft = null;
    private Indents indentsModel;
    private Context context;
    private ViewDetailsActivity.SAPApprovedListner listner;
    private View view;
    private boolean isSoGenerated = false;
    private boolean isSavedApprovesStatus = false;
    private String soNumber = null;


    public IndentDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment IndentDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndentDetailFragment newInstance(IndentModel param1, String param2) {
        IndentDetailFragment fragment = new IndentDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static IndentDetailFragment newInstance(ViewDraftModel viewDraftModel, String fromViewDraft) {
        IndentDetailFragment fragment = new IndentDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM3, viewDraftModel);
        args.putString(ARG_PARAM4, fromViewDraft);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            indentModel = getArguments().getParcelable(ARG_PARAM1);
            from = getArguments().getString(ARG_PARAM2);

            viewDraftMdel = getArguments().getParcelable(ARG_PARAM3);
            fromViewDraft = getArguments().getString(ARG_PARAM4);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_indent_detail2, container, false);
        unbinder = ButterKnife.bind(this, view);

        presenter = new CreateIntentPresenterImp(this);
        isViewEnable = true;
        presenter.setViewAllAvailable(this);

        initView();
        setDrawableLeftRight();


        return view;
    }

    private void setDrawableLeftRight() {
        CommonMethod.setLeftRightDrawable(salesPackageSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(usagaSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(processCodeSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(equipmentSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(splProcessIndicatorSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(salesGroupSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(salesPackageSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
        CommonMethod.setLeftRightDrawable(soTypeSpinner, 0, R.drawable.ic_arrow_drop_down_black_24dp);
    }

    private void initView() {
        model = new IntentDetailModel();
        checkIndent();
        btnClickedListner();
        parseXMlLForSpinner();
        setSpinnerClickedLisneter();


    }


    private void btnClickedListner() {
        btnApprove.setOnClickListener(this);
        btnReject.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (getActivity() != null) {

            if (getActivity() instanceof ViewDetailsActivity)
                ((ViewDetailsActivity) getActivity()).attachedBackPress(this);
        }


    }

    private void setSpinnerClickedLisneter() {
        soTypeSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "soType"));
        salesSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "salesOffice"));
        usagaSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "usaguageIndicator"));
        processCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerGenericModel model= (SpinnerGenericModel) view.getTag();
                presenter.downloadEqpCode(model.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        splProcessIndicatorSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "splProcessIndicator"));
        equipmentSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "equipmentCode"));
        salesGroupSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "salesGroup"));
        salesPackageSpinner.setOnItemSelectedListener(new SpinnerItemSelect(model, "salesPackage"));


    }

    private void parseXMlLForSpinner() {
        Spinner[] allSpinners = new Spinner[]{soTypeSpinner, salesSpinner, usagaSpinner,
                processCodeSpinner, splProcessIndicatorSpinner,
                equipmentSpinner, salesGroupSpinner, salesPackageSpinner};
        String[] allXmlFileName = new String[]{SOTYPE, SALESOFFICES, USAGEINDICATOR, PROCESSCODE,
                SPECIALPROCESSINDICATORS, EQUIPMENTCODE, SALESGROUP, SALESPACKAGE};
        setAllSpinnerToXMl(allSpinners, allXmlFileName);

    }

    private void setAllSpinnerToXMl(Spinner[] allSpinners, String[] allXmlFileName) {
        for (int i = 0; i < allSpinners.length; i++) {
            setAllSpinner(allXmlFileName[i], allSpinners[i]);
        }
    }

    private void setAllSpinner(String fileName, Spinner spinner) {
        List<SpinnerGenericModel> list = CommonMethod.parseXML(getActivity(), fileName);
        Log.d(TAG, "setAllSpinner: c " + new Gson().toJson(list) + " + FileName :" + fileName + "SpinnerName" + spinner);
        setAllAdapter(spinner, list);

    }

    private void setAllAdapter(Spinner spinner, List<SpinnerGenericModel> list) {
        if (spinner != null && list.size() > 0) {
            genericSpinnerAdapter = new GenericSpinnerAdapter(getActivity(), list);
            spinner.setAdapter(genericSpinnerAdapter);
        }
    }

    private void checkIndent() {
        if (fromViewDraft != null && !TextUtils.isEmpty(fromViewDraft)) {
            if (fromViewDraft.equalsIgnoreCase(CommonMethod.FROM_VIEWDRAFT)) {
                if (viewDraftMdel != null) {
                    model.setIndentCode(viewDraftMdel.getIndentCode());
                    model.setIndentDate(viewDraftMdel.getIndentDate());
                    presenter.onEditViewDraftData(viewDraftMdel);
                }
            }
        }

        if (from != null && !TextUtils.isEmpty(from)) {
            if (indentModel != null) {
                if (from.equalsIgnoreCase(CommonMethod.FROM_PLANT)) {
                    setIndentCode(indentModel);
                    presenter.onEditViewDraftData(new ViewDraftModel(indentModel.getIndentCode(), indentModel.getIndentDate()));

                } else if (from.equalsIgnoreCase(CommonMethod.FROM_APPROVED_INDENT)) {
                    setIndentCode(indentModel);
                    setButtonsForRejectApproved();
                    presenter.onEditViewDraftData(new ViewDraftModel(indentModel.getIndentCode(), indentModel.getIndentDate()));

                } else if (from.equalsIgnoreCase(CommonMethod.FROM_MYINTENTS)) {
                    setIndentCode(indentModel);
                    presenter.onEditViewDraftData(new ViewDraftModel(indentModel.getIndentCode(), indentModel.getIndentDate()));

                } else if (from.equalsIgnoreCase(CommonMethod.FROM_VIEW_INTENTS)) {
                    setIndentCode(indentModel);
                    presenter.onEditViewDraftData(new ViewDraftModel(indentModel.getIndentCode(), indentModel.getIndentDate()));

                }
            }
        }

    }

    private void setIndentCode(IndentModel model) {
        this.model.setIndentCode(model.getIndentCode());
        this.model.setIndentDate(model.getIndentDate());
    }

    private void setButtonsForRejectApproved() {
        btnApprove.setVisibility(View.VISIBLE);
        btnReject.setVisibility(View.VISIBLE);
        rlApprovedReject.setVisibility(View.VISIBLE);
    }

    private void initSetAllIndent(Indents model) {
        this.indentsModel = model;
        setAllIndentEdtText(model);
        initRecyclerView(model);


    }


    private void setSelectedIndentType(String indentType, Spinner mEdtIntentTypeSpinner) {

        genericSpinnerAdapter = (GenericSpinnerAdapter) mEdtIntentTypeSpinner.getAdapter();
        if (genericSpinnerAdapter != null) {
            if (!indentType.isEmpty())
                mEdtIntentTypeSpinner.setSelection(genericSpinnerAdapter.findItemPosition(indentType));


        }

    }

    private void setAllIndentEdtText(Indents model) {
        TextView[] variables = new TextView[]{
                txtIndentCode,
                txtIndentStatus,
                txtDealerName,
                txtConsigneeCode,
                txtIndentDate,
                txtPoNumber,
                txtPoDate,
                txtIgst,
                txtSgst,
                txtAddTaxInfo,
                edtDevision,
                edtDestributionChannel,
                edtSalesOrganization};
        String status = null;
        if (model.getIndApprvlStatus().equalsIgnoreCase("P"))
            status = "Pending";
        else if (model.getIndApprvlStatus().equalsIgnoreCase("R"))
            status = "Reject";
        else if (model.getIndApprvlStatus().equalsIgnoreCase("C"))
            status = "Cancel";
        else if (model.getIndApprvlStatus().equalsIgnoreCase("S"))
            status = "Approved";


        String[] values = new String[]{
                checkNull(model.getIndentCode()),
                checkNull(status),
                checkNull(model.getConsigneeName()),
                checkNull(model.getConsigneeCode()),
                checkNull(model.getIndentDate()),
                checkNull(model.getPONumber()),
                checkNull(model.getPODate()),
                checkNull(model.getCST()),
                checkNull(model.getVAT()),
                checkNull(model.getAddlTax()),
                checkNull(CommonMethod.getItemValueFromXMLFile(DIVISION, model.getDivision())),
                checkNull(CommonMethod.getItemValueFromXMLFile(INDENTTYPE, model.getIndentType())),
                checkNull(model.getPlantName()),


        };


        setTextViewData(variables, values);
        this.model.setDistributionChannel(model.getIndentType());
        this.model.setDivision(model.getDivision());
        this.model.setDispatchDate(model.getDispatchDate());
        this.model.setIndentCode(model.getIndentCode());
        this.model.setIndentStatus(model.getIndApprvlStatus());
        this.model.setDealerCode(model.getDealerCode());
        this.model.setPoNumber(model.getPONumber());
        this.model.setPoDate(model.getPODate());
        this.model.setConsigneeCode(model.getConsigneeCode());
        this.model.setIndentType(model.getIndentType());


        if ((Product) model.getProduct() != null) {
            Log.d(TAG, "setAllIndentEdtText: " + model.getProduct().toString());

            if (((Product) model.getProduct()).getProduct().size() > 0) {

                product_list.addAll(((Product) model.getProduct()).getProduct());
                this.model.setPartner(product_list.get(0).getTransporterCode());
                this.model.setSalesOrganization(product_list.get(0).getPlantCode());
                edtPartner.setText(product_list.get(0).getTransporterCode());
                this.model.setProductList(product_list);
                this.model.setTransportName(product_list.get(0).getTransporterName());
                txtConsigneeName.setText(product_list.get(0).getTransporterName());
                txtDeliveryDate.setText(product_list.get(0).getDispatchDate());


            }
        }


//        this.model.setApprovalType(model.getIndApprvlStatus());


    }

//    private String setConsigneeName(Indents model) {
//        if (model.getConsignee() != null)
//            if (model.getConsignee().getConsignee() != null)
//                if (model.getConsignee().getConsignee().getConsigneeName() != null)
//                    return model.getConsignee().getConsignee().getConsigneeName();
//        return "";
//    }

    //    private String setConsignee(Indents model) {
//        if (model.getConsignee() != null)
//            if (model.getConsignee().getConsignee() != null)
//                if (model.getConsignee().getConsignee().getConsigneeCode() != null)
//                    return model.getConsignee().getConsignee().getConsigneeCode();
//        return "";
//    }
//
//    private String setPlantCode(Indents model) {
//        if (model.getPlant() != null)
//            if (model.getPlant().getPlant() != null)
//                if (model.getPlant().getPlant().getPlantCode() != null)
//                    return model.getPlant().getPlant().getPlantCode();
//        return "";
//    }
//
//    private String setPlantCodeName(Indents model) {
//        if (model.getPlant() != null)
//            if (model.getPlant().getPlant() != null)
//                if (model.getPlant().getPlant().getPlantName() != null)
//                    return model.getPlant().getPlant().getPlantName();
//        return "";
//    }
//
//    private String setTransportName(Indents model) {
//        if (model.getProduct() != null)
//            if (model.getProduct().getProduct() != null)
//                if (model.getProduct().getProduct().size() > 0)
//                    if (model.getProduct().getProduct().get(0).getTransportMaster() != null)
//                        if (model.getProduct().getProduct().get(0).getTransportMaster().getTransportMaster() != null)
//                            if (model.getProduct().getProduct().get(0).getTransportMaster().getTransportMaster().getTransporterName() != null)
//                                return model.getProduct().getProduct().get(0).getTransportMaster().getTransportMaster().getTransporterName();
//
//        return "";
//    }

    private String checkNull(String indentCode) {
        return indentCode != null ? indentCode : "";
    }

    private void setTextViewData(TextView[] variables, String[] values) {
        for (int i = 0; i < variables.length; i++) {
            variables[i].setText(values[i]);
        }
    }

    private void initRecyclerView(Indents model) {

        if ((Product) model.getProduct() != null) {
            lblProductDetails.setVisibility(View.VISIBLE);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            MaterialIntentAdapter adapter = new MaterialIntentAdapter(getActivity(), (Product) model.getProduct(), this);
//        adapter.addItems(list);
            recyclerView.setAdapter(adapter);
        } else
            lblProductDetails.setVisibility(View.GONE);

    }


    @Override
    public void onItemClicked(int position, Product_ datum) {
        Log.d(TAG, "onItemClicked: onItemClicked" + new Gson().toJson(datum));
//        callFragment(ProductDetailFragment.newInstance(datum));
        callActivity(datum);


    }

    private void callActivity(Product_ datum) {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        intent.putExtra(CommonMethod.FROM_PRODUCT, datum);
        startActivity(intent);
    }

//    private void callFragment(Fragment fragment) {
//        FragmentManager fm = getActivity().getSupportFragmentManager();
//        if (fm != null) {
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.replace(R.id.frame_display, fragment, fragment.getClass().getSimpleName());
//            ft.addToBackStack(UpdateDetailFragment.class.getSimpleName());
//            ft.commit();
//        }
//    }


    @Override
    public void onShowPaginationLoading(boolean show) {

    }

    @Override
    public void createNotification(String status) {
        sendNotification(status);

    }

    @Override
    public void showSnackbar(String model) {

        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnApprove, "Please Select " + model, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {


            }
        });


    }

    @Override
    public void onSuccess(String message, String status) {

        if (isViewEnable) {
            if (status.equalsIgnoreCase(APPROVED))
                isSavedApprovesStatus = true;
            else
                isSavedApprovesStatus = false;


            if (soNumber != null)
                message = "SO Number Generated Successfully " + soNumber;

            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnApprove, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    if (getActivity() != null)
                        ((ViewDetailsActivity) getActivity()).finish();
                }
            });

        }
    }

    private void sendNotification(String status) {
        FirebaseMessageController controller = new FirebaseMessageController();
        controller.sendNotification(createNotificationData(indentModel, status));
    }

    private Message createNotificationData(IndentModel model, String status) {
        if (model != null) {
            Log.d(TAG, "createNotificationData: IndenstModel" + new Gson().toJson(model));
            Data data = new Data();
            model.setIndApprvlStatus(status);
            data.setClasstype(CommonMethod.INDENT_STATUS);
            data.setData(new Gson().toJson(model));
            if (status.equalsIgnoreCase("S")) {
                status = "Approve";

            } else if (status.equalsIgnoreCase("R")) {
                status = "Reject";
            }

            data.setTitle("Indent Code : is " + status + " on CaldNet");
            data.setMessage(" Indent Code: " + model.getIndentCode() + status + " on CaldNet");
            Message msg = new Message();
            msg.setData(data);
            msg.setTo("/topics/" + AppType.getAppType());
            return msg;
        }
        return null;
    }


    @Override
    public void onNoMoreList() {

    }


    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnApprove, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {

//                    presenter.saveApprove(model);
                }
            });
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnReject, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
//                    PaginationModel model = new PaginationModel();
//                    model.setLimit(10);
//                    model.setPageNo(1);
//                    model.setTbleName(CommonMethod.TBL_DISPATCHED);
//
//                    presenter.onLoadMore(model);

                }
            });
        }
    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(btnApprove, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
//                    PaginationModel model = new PaginationModel();
//                    model.setLimit(10);
//                    model.setPageNo(1);
//                    model.setTbleName(CommonMethod.TBL_DISPATCHED);
//                    presenter.onLoadMore(model);

                }
            });
        }
    }


    @Override
    public void onGetEditDraft(Indents model) {
        if (isViewEnable)
            initSetAllIndent(model);


    }


    @Override
    public void showProgress() {
        if (isViewEnable) {
            btnReject.setVisibility(View.GONE);
            btnApprove.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (isViewEnable) {
            btnReject.setVisibility(View.VISIBLE);
            btnApprove.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        this.view = view;
        switch (view.getId()) {
            case R.id.btnApprove:
                setAllParameterForApprovd(view, CommonMethod.FROM_APPROVED);
                break;
            case R.id.btnReject:
                openDialogue(view);
                break;
        }
    }

    @Override
    public String getParner() {
        return edtPartner.getText().toString();
    }

    @Override
    public String getApprovedeject() {
        return edtApprovedReject.getText().toString();
    }

    @Override
    public void onInvalideApproveReject(String empty) {
//        edtPartner.setError(empty);
    }

    @Override
    public void onInvalidePartner(String empty) {
        edtApprovedReject.setError(empty);

    }

    /**
     * This is on appove button click
     *
     * @param view
     * @param from
     */
    private void setAllParameterForApprovd(View view, int from) {
        model.setUserType(Prefs.getString(CommonMethod.USER_TYPE));
        model.setApprovedBy(Prefs.getString(CommonMethod.EMAIL_ID));
        model.setCommentsForAppovedReject(edtApprovedReject.getText().toString());
        model.setApprovalType("Y");
        model.setIsRejection("false");
        presenter.sendAllApproved(model, view, from);


//        if (getActivity() != null)
//            setSAPModel(model);

//            ((ViewDetailsActivity) getActivity()).setSAPModel(model);


        Log.d(TAG, "onClick: Model" + new Gson().toJson(model));


    }

    @Override
    public void setSAPModel(IntentDetailModel model) {
        if (model != null) {


            if (model.getProductList() != null && model.getProductList().size() > 0) {

                SAPModel sapModel = new SAPModel();
                sapModel.setDealerCode(model.getDealerCode());
                sapModel.setPONumber(model.getPoNumber());
                sapModel.setConsigneeCode(model.getConsigneeCode());
                sapModel.setPODate(CommonMethod.getYYYYMMDDforSAP(model.getPoDate()));
                sapModel.setSOType(model.getSoType());
                sapModel.setDispatchDate(CommonMethod.getYYYYMMDDforSAP(model.getDispatchDate()));
                sapModel.setDivision(model.getDivision());
                sapModel.setDistChannel(model.getIndentType());


                Log.d(TAG, "setAllIndentEdtText: " + model.getProductList().toString());

                if (model.getProductList().size() > 0) {
                    // sapModel.setDispatchDate(model.getProductList().get(0).getDispatchDate());


                    List<PtItem> ptItemList = new ArrayList<>();
                    for (Product_ products : model.getProductList()
                            ) {
                        PtItem ptItem = new PtItem();
                        ptItem.setProductCode(products.getProductCode());
                        ptItem.setPlantCode(products.getPlantCode());
                        ptItem.setQuantity(products.getQuantity());

                        ptItemList.add(ptItem);


                    }

                    if (ptItemList.size() > 0)
                        sapModel.setPt(ptItemList);
                }
                AID aid = new AID();


                aid.setPartner(model.getPartner());
                aid.setEquipmentCode(model.getEquipmentCode());
                aid.setProcessCode(model.getProcessCode());
                aid.setSalesOrg("ACCR");
                aid.setSpecialProcIndicator(model.getSplProcessIndicator());
                aid.setUsageIndicator(model.getUsaguageIndicator());
                aid.setSalesPackage(model.getSalesPackage());
                sapModel.setAID(aid);

                Log.d(TAG, "setSAPModel: " + new Gson().toJson(sapModel));

                callSAPServer(sapModel);

            } else {

                showSnackbarOkButton("No product in this order.");


            }


        }


    }

    private void showSnackbarOkButton(String err) {
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnApprove, err, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                ((ViewDetailsActivity) getActivity()).onBackPressed();

            }
        });

    }


    private void callSAPServer(SAPModel model) {
        new NetworkUtility.NetworkBuilder().setHeader().build().setSAPAPPROVED(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                String oNumber = (String) message;
                if (TextUtils.isDigitsOnly(oNumber)) {
                    IndentDetailFragment.this.model.setSoNumber(message.toString());

                    soNumber = message.toString();
                    soNumberGenrated(IndentDetailFragment.this.model);
                } else {
                    UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnApprove, "SO Number Not Generated. Send Log", new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"app.itechgalaxy@gmail.com"});
                            i.putExtra(Intent.EXTRA_SUBJECT, "Reg: SAP ERROR");
                            i.putExtra(Intent.EXTRA_TEXT, "SAP REQ: " + new Gson().toJson(model));
                            try {
                                startActivity(Intent.createChooser(i, "Send mail..."));
                            } catch (android.content.ActivityNotFoundException ex) {
                            }

                        }
                    });

                }
            }

            @Override
            public void onFailure(Object err) {
                failedtoDownloadSONUmber(err.toString());


            }

            @Override
            public void onSomethingWrong(Object e) {
                failedtoDownloadSONUmber(e.toString());


            }
        });
    }


    private void calCreateActivity() {
        if (model != null) {
            Intent intent = new Intent(getActivity(), CreateIndentNewActivity.class);
            intent.putExtra(CommonMethod.FROM_DETAILS, model);
            startActivityForResult(intent, RC_EDIT);
        }
    }

    private void openDialogue(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        setAllParameterForApprovd(view, CommonMethod.FROM_REJECT);

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
        builder.setMessage("Are you sure to reject the indent?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }


    private void callPresenterToSaveAll() {
        Log.d(TAG, "onClick: Model" + new Gson().toJson(model));

    }


    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        super.onDestroyView();
        isViewEnable = false;
        unbinder.unbind();
    }

    @Override
    public void onGetSONumber(IntentDetailModel message) {
    }

    private void soNumberGenrated(IntentDetailModel message) {
        isSoGenerated = false;
        presenter.sendAllApprovedDatabase(message, view, CommonMethod.FROM_APPROVED);
    }

    @Override
    public void onFailed(String message) {


    }

    private void failedtoDownloadSONUmber(String message) {

        UtilSnackbar.showSnakbarTypeFail(btnApprove, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
//                if (getActivity() != null)

                /**
                 * Comments Now for test
                 */
//                    callSAPServer(model);
            }
        });

    }


    @Override
    public void doBack() {
        if (getActivity() != null && isViewEnable) {
            if (isSavedApprovesStatus && isSoGenerated) {

                if (getActivity().getSupportFragmentManager() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }


            } else if (!isSoGenerated && isSavedApprovesStatus) {
                UtilSnackbar.showSnakbarTypeFail(btnApprove, "Approved Indent have to generate SO Number", new UtilSnackbar.OnSnackbarActionClickListener() {
                    @Override
                    public void onRetryClicked() {
                        if (getActivity() != null && isViewEnable)
                            ((ViewDetailsActivity) getActivity()).setSAPModel(model);
                    }
                });


            } else {
                UtilSnackbar.showSnakbarTypeFail(btnApprove, "Retry to Saved  Indent Satatus", new UtilSnackbar.OnSnackbarActionClickListener() {
                    @Override
                    public void onRetryClicked() {
                        if (isViewEnable)
                            presenter.sendAllApproved(model, view, CommonMethod.FROM_APPROVED);

                    }
                });

            }

        }

    }
}


