package com.itg.calderysapp.caldNet.newIndent.createIntent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IndentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Product_;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.MaterailAddActivity;
import com.itg.calderysapp.caldNet.newIndent.consignee.ConsingeeAddActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.GenericSpinnerAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.adapter.MaterialIntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.IntentLocalModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvp.CreateIntentMVP;
import com.itg.calderysapp.caldNet.newIndent.createIntent.mvp.CreateIntentPresenterImp;
import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftEditModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.SpinnerItemSelect;
import com.itg.calderysapp.common.TextSetWatcher;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.DIVISION;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.INDENTTYPE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.PROCESSCODE;

;


public class CreateIntentActivity extends AppCompatActivity implements View.OnClickListener, CreateIntentMVP.CreatIntentView, MaterialIntentAdapter.OnItemClickedListner {
    HashMap<String, AdapterStringModel> hashMap = new HashMap<>();

    private static final String TAG = "CreateIntentActivity";
    private static final int RC_EDIT = 234;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.headerItemText)
    TextView mHeaderItemText;
    @BindView(R.id.lbl_dealer_name)
    TextView mLblDealerName;
    @BindView(R.id.editDealerName)
    EditText mEditDealerName;
    @BindView(R.id.lbl_Po_Number)
    TextView mLblPoNumber;
    @BindView(R.id.edtPoNumber)
    EditText mEdtPoNumber;
    @BindView(R.id.strut)
    View mStrut;
    @BindView(R.id.lbl_igst)
    TextView mLblIgst;
    @BindView(R.id.edt_igst)
    Spinner mEdtIgstSpinner;
    @BindView(R.id.lbl_sgst_cgst)
    TextView mLblSgstCgst;
    @BindView(R.id.edt_sgst_cgst)
    Spinner mEdtSgstCgstSpinner;
    @BindView(R.id.lbl_intent_type)
    TextView mLblIntentType;
    @BindView(R.id.edtIntentTypeSpinner)
    Spinner mEdtIntentTypeSpinner;
    @BindView(R.id.lbl_plant_code)
    TextView mLblPlantCode;
    @BindView(R.id.edtPlantCodeSpinner)
    Spinner mEdtPlantCodeSpinner;
    @BindView(R.id.lbl_constite_code)
    TextView mLblConstiteCode;
    @BindView(R.id.lbl_name_consingee)
    TextView mLblNameConsingee;
    @BindView(R.id.edtConsingee)
    EditText mEdtConsingee;
    @BindView(R.id.edtAddConsingee)
    EditText mEdtAddConsingee;
    @BindView(R.id.lbl_tax_info)
    TextView mLblTaxInfo;
    @BindView(R.id.edtTaxInfo)
    EditText mEdtTaxInfo;
    @BindView(R.id.lbl_po_date)
    TextView mLblPoDate;
    @BindView(R.id.edtPODate)
    EditText mEdtPODate;
    @BindView(R.id.lbl_delivery_date)
    TextView mLblDeliveryDate;
    @BindView(R.id.edtDeliveryDate)
    EditText mEdtDeliveryDate;
    @BindView(R.id.lbl_division)
    TextView mLblDivision;
    @BindView(R.id.edtDivision)
    Spinner mEdtDivisionSpinner;
    @BindView(R.id.lbl_consingee_name)
    TextView mLblConsingeeName;
    @BindView(R.id.edtConsingeeName)
    EditText mEdtConsingeeName;
    @BindView(R.id.lbl_cc_email_id)
    TextView mLblCcEmailId;
    @BindView(R.id.edtCCEMailId)
    EditText mEdtCCEMailId;
    @BindView(R.id.btnSubmit)
    Button mBtnSubmit;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressEdit)
    ProgressBar mProgressEdit;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.ll_edit)
    LinearLayout mLlEdit;
    @BindView(R.id.btnApprove)
    Button btnApprove;
    @BindView(R.id.btnReject)
    Button btnReject;
    @BindView(R.id.llApproveReject)
    LinearLayout llApproveReject;
    @BindView(R.id.btn_add_consignee)
    Button mBtnAddConsignee;
    @BindView(R.id.btn_add_material)
    Button mBtnAddMaterial;


    private CommonInterface.SearchDataListener attachedSearchListener;
    private LinearLayoutManager layoutManager;
    private TextSetWatcher textSetWatcher;
    private boolean isViewEnable = false;
    private IntentLocalModel intentModel;
    private Calendar selectedDate = Calendar.getInstance();
    private GenericSpinnerAdapter genericSpinnerAdapter;

    private Spinner[] allSpinners;
    //,mEditMaterialCodeSpinner,mEdtIgstSpinner,   mEdtSgstCgstSpinner


    private String[] allXmlFileName;
    private String[] iGST;
    private String[] sCGST;


    private SpinnerGenericModel spinnerGenericModel;
    private CreateIntentMVP.CreateIntentPresenter presenter;


    ViewDraftEditModel completeModel;
    IntentLocalModel indentModelLocal;
    private ViewDraftEditModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_intent);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        isViewEnable = true;

        allSpinners = new Spinner[]{mEdtDivisionSpinner, mEdtIntentTypeSpinner, mEdtPlantCodeSpinner};
        allXmlFileName = new String[]{DIVISION, INDENTTYPE, PROCESSCODE};
        iGST = new String[]{"IGST"};
        sCGST = new String[]{"SCGST +SGST"};

        init();

    }

    private void init() {
        setAllUnitAdapter();
        intentModel = new IntentLocalModel();
        presenter = new CreateIntentPresenterImp(this);

        checkIntentData();
        setAllSpinnerByArr();


        onClickedListener();
        setAllData();

    }

    private void setAllUnitAdapter() {
        setIGSTAdapter(iGST, mEdtIgstSpinner);
        setIGSTAdapter(sCGST, mEdtSgstCgstSpinner);

    }

    private void setIGSTAdapter(String[] iGST, Spinner mEdtIgstSpinner) {
        SpinnerGenericModel spinnerGenericModel = new SpinnerGenericModel();
        List<SpinnerGenericModel> list = new ArrayList<>();
        for (int i = 0; i < iGST.length; i++) {
            spinnerGenericModel.setValue(iGST[i]);
            spinnerGenericModel.setId(iGST[i]);
            list.add(spinnerGenericModel);

        }
        setAllAdapter(mEdtIgstSpinner, list);
    }

    private void setAllSpinnerByArr() {
        for (int i = 0; i < allSpinners.length; i++) {
            setAllSpinner(allXmlFileName[i], allSpinners[i]);
        }

    }

    private void setSelectListener() {
        mEdtDivisionSpinner.setOnItemSelectedListener(new SpinnerItemSelect(indentModelLocal.division));
        mEdtIntentTypeSpinner.setOnItemSelectedListener(new SpinnerItemSelect(indentModelLocal.intentType));
        mEdtIgstSpinner.setOnItemSelectedListener(new SpinnerItemSelect(indentModelLocal.igst));
        mEdtSgstCgstSpinner.setOnItemSelectedListener(new SpinnerItemSelect(indentModelLocal.sgst));


//        mEdtPlantCodeSpinner.setOnItemSelectedListener(new SpinnerItemSelect(indentModel.indentModel));
    }


    private void checkIntentData() {
//        if (getIntent().hasExtra(CommonMethod.FROM_VIEWDRAFT)) {
//            ViewDraftModel viewDraftModel = getIntent().getParcelableExtra(CommonMethod.FROM_VIEWDRAFT);
//            presenter.onEditViewDraftData(viewDraftModel);
//        } else if (getIntent().hasExtra(CommonMethod.FROM_PLANT)) {
//            IndentModel model = getIntent().getParcelableExtra(CommonMethod.FROM_PLANT);
//            presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
//        } else if (getIntent().hasExtra(CommonMethod.FROM_APPROVED_INDENT)) {
//            IndentModel model = getIntent().getParcelableExtra(CommonMethod.FROM_APPROVED_INDENT);
//            setButtonsForRejectApproved();
//            presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
//        }

        if(getIntent().hasExtra(CommonMethod.FROM_DETAILS)){
            IntentDetailModel model = getIntent().getParcelableExtra(CommonMethod.FROM_DETAILS);
             presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
//            setAllDataTOModel(model);

        }
    }

    private void setAllDataTOModel(IndentDetailModel model) {
//        setAllViewDraftData(model);

    }

    private void setButtonsForRejectApproved() {
        llApproveReject.setVisibility(View.VISIBLE);
        mBtnSubmit.setVisibility(View.GONE);
        setApproveRejectListner();
    }

    private void setApproveRejectListner() {
        mEdtAddConsingee.setOnClickListener(null);
        btnApprove.setOnClickListener(this);
        btnReject.setOnClickListener(this);
        mBtnAddMaterial.setOnClickListener(this);
        mBtnAddConsignee.setOnClickListener(this);

    }

    private void setButtons() {

    }

//    @Override
//    public void onGetEditDraft(ViewDraftEditModel model) {
//        this.model = model;
//        if (model != null) {
//            setAllSpinnerByArr();
//
//            setAllViewDraftData(model);
//            initRecyclerView(model);
//
//            Log.d(TAG, "onGetEditDraft: ViewDraftModel model" + new Gson().toJson(model));
//        }
//
//    }

//    private void setAllViewDraftData(IndentDetailModel viewDraftModel) {
//
//        Log.d(TAG, "setAllViewDraftData: " + new Gson().toJson(viewDraftModel));
//
//        if (viewDraftModel == null  )
//            //viewDraftModel.getIndentInfo().getIndents() == null
//            return;
//        com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents model = viewDraftModel.getIndentInfo().getIndents();
//        mEditDealerName.setText(model.getDealerCode());
//        mEdtPoNumber.setText(model.getPONumber());
////        mEdtConsingeeName.setText(model.getConsignee().getConsignee().getConsigneeName());
//        mEdtConsingee.setText(model.getConsigneeCode());
//        mEdtConsingeeName.setText(model.getConsigneeCode());
//        mEdtPODate.setText(model.getPODate());
//        mEdtDeliveryDate.setText(model.getDispatchDate());
//        mEdtTaxInfo.setText(model.getAddlTax());
//        mEdtCCEMailId.setVisibility(View.GONE);
//
////        setAllSelectedSpinner(model);
//
//    }
//
//    private void setAllSelectedSpinner(Indents viewDraftModel) {
//        setSelectedIndentType(viewDraftModel.getIndentType(), mEdtIntentTypeSpinner);
//        setSelectedIndentType(viewDraftModel.getDivision(), mEdtDivisionSpinner);
//        setSelectedIndentType(viewDraftModel.getPlant().getPlant().getPlantCode(), mEdtPlantCodeSpinner);
//        if (viewDraftModel.getCST() != null) {
//            setSelectedIndentType(viewDraftModel.getVAT(), mEdtSgstCgstSpinner);
//
//
//        } else {
//            setSelectedIndentType(viewDraftModel.getCST(), mEdtIgstSpinner);
//
//        }
//
//    }

    private void setSelectedIndentType(String indentType, Spinner mEdtIntentTypeSpinner) {

        genericSpinnerAdapter = (GenericSpinnerAdapter) mEdtIntentTypeSpinner.getAdapter();
        if (genericSpinnerAdapter != null) {
            if (!indentType.isEmpty())
                mEdtIntentTypeSpinner.setSelection(genericSpinnerAdapter.findItemPosition(indentType));


        }

    }

    private void setAllSpinner(String fileName, Spinner spinner) {
        List<SpinnerGenericModel> list = CommonMethod.parseXML(this, fileName);
        Log.d(TAG, "setAllSpinner: c " + new Gson().toJson(list) + " + FileName :" + fileName + "SpinnerName" + spinner);
        setAllAdapter(spinner, list);

    }

    private void setAllAdapter(Spinner spinner, List<SpinnerGenericModel> list) {
        if (list != null && list.size() > 0) {
            genericSpinnerAdapter = new GenericSpinnerAdapter(getApplicationContext(), list);
            spinner.setAdapter(genericSpinnerAdapter);
        }
    }

    private void setAllData() {
        if (isViewEnable) {
//            mEditDealerName.addTextChangedListener(new TextSetWatcher(mEditDealerName.toString()));
//
//            mEdtCCEMailId.addTextChangedListener(new TextSetWatcher(mEdtCCEMailId.toString()));
//            mEdtPoNumber.addTextChangedListener(new TextSetWatcher(mEdtPoNumber.toString()));
//            mEdtTaxInfo.addTextChangedListener(new TextSetWatcher(mEdtTaxInfo.toString()));
//            mEdtConsingeeName.addTextChangedListener(new TextSetWatcher(mEdtConsingeeName.toString()));
//            mEdtAddConsingee.addTextChangedListener(new TextSetWatcher(mEdtAddConsingee.toString()));
            mEdtPODate.setOnClickListener(this);
            mEdtDeliveryDate.setOnClickListener(this);

//            setSelectListener();
            setAllDataToModel();

        }

    }

    private void setAllDataToModel() {
        intentModel = new IntentLocalModel();
        intentModel.setDealerName(mEditDealerName.getText().toString());
        intentModel.setPoNumber(mEdtPoNumber.getText().toString());
        intentModel.setAddTaxInfo(mEdtTaxInfo.getText().toString());
        intentModel.setDeliveryDate(mEdtDeliveryDate.getText().toString());
        intentModel.setPoDate(mEdtPODate.getText().toString());
        intentModel.setCcEmailId(mEdtCCEMailId.getText().toString());


    }

    private void onClickedListener() {
        mBtnAddConsignee.setOnClickListener(this);
        mBtnAddMaterial.setOnClickListener(this);
        mLblConstiteCode.setOnClickListener(this);
        mFab.setOnClickListener(this);


//        SpinnerItemSelect spinnerItemSelect  = new SpinnerItemSelect(mEdtUnitSpinner);


    }

    private void initRecyclerView(ViewDraftEditModel model) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_add_consignee:
                callActivity();
                break;
            case R.id.btn_add_material:
                callActivityAddMatarial();
                break;
            case R.id.edtPODate:
                openCalender(mEdtPODate);
                break;
            case R.id.edtDeliveryDate:
                openCalender(mEdtDeliveryDate);
                break;
            case R.id.btnApprove:
                break;
            case R.id.btnReject:
                break;
        }
    }

    private void callActivityAddMatarial() {
        Log.d(TAG, "onItemClicked: "+new Gson().toJson(indentModelLocal));

        Intent indent = new Intent(this, MaterailAddActivity.class);
        indent.putExtra(CommonMethod.FROM_MATERIAL , indentModelLocal);
        startActivityForResult(indent, RC_EDIT);
    }


    private void callActivity() {
        Intent intent = new Intent(this, ConsingeeAddActivity.class);
        startActivity(intent);
    }


    private void openCalender(EditText mEdtStartDate) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(CreateIntentActivity.this, new DatePickerDialog.OnDateSetListener() {
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

                String getSelectedDateFromCalander = CommonMethod.getDDMMYYYYfromDate(calendar);
                mEdtStartDate.setText(getSelectedDateFromCalander);
            }
        }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setTitle("SELECT DATE");
        datePickerDialog.show();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onShowPaginationLoading(boolean show) {

    }


    @Override
    public void createNotification(String status) {

    }

    @Override
    public void showSnackbar(String model) {

    }

    @Override
    public void setSAPModel(IntentDetailModel model) {

    }

    @Override
    public void onEqpAvail(List<SpinnerGenericModel> models) {
//        do i change here



    }

    @Override
    public void onSuccess(String message, String status) {

    }

    @Override
    public void onNoMoreList() {

    }

    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mLlEdit, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {

                        }
                    }

            );
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mLlEdit, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {

                        }
                    }

            );
        }

    }


    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mLlEdit, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {


                }
            });
        }

    }

    @Override
    public void showProgress() {
        showHideView(mProgressEdit, mLlEdit);

    }

    private void showHideView(View show, View hide) {

        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        showHideView(mLlEdit, mProgressEdit);


    }

    @Override
    public void onItemClicked(int position, Product_ datum) {

    }

    @Override
    public void onGetEditDraft(Indents model) {
        setAllIndentEdtText(model);

    }

    private void setAllIndentEdtText(Indents model) {
        TextView[] variables = new TextView[]{mEditDealerName,mEdtPoNumber, mEdtPODate, mEdtDeliveryDate,
                mEdtPoNumber, mEdtTaxInfo, mEdtCCEMailId, mEdtConsingee, mEdtAddConsingee};
        String[] values = new String[]{
//                checkNull(model.getConsignee().getConsignee().getConsigneeName()),
                checkNull(model.getPONumber()),
                checkNull(model.getPODate()),
                checkNull(model.getDispatchDate()),
                checkNull(model.getPONumber()),
                checkNull(model.getAddlTax()),
                checkNull(model.getComments()),
//                checkNull(model.getConsignee().getConsignee().getConsigneeCode()),
//                checkNull(model.getConsignee().getConsignee().getConsigneeName()),
            };


        setTextViewData(variables, values);
//        setAllSelectedSpinner(model);

    }

    private void setTextViewData(TextView[] variables, String[] values) {
        for (int i = 0; i <= variables.length - 1; i++) {
            variables[i].setText(values[i]);
        }
    }

    private String checkNull(String consigneeName) {
        return TextUtils.isEmpty(consigneeName)?"":consigneeName;
    }

    @Override
    public String getParner() {
        return null;
    }

    @Override
    public String getApprovedeject() {
        return null;
    }

    @Override
    public void onInvalideApproveReject(String empty) {

    }

    @Override
    public void onInvalidePartner(String empty) {

    }

//    @Override
//    public void onItemClicked(int position, ProductItem item) {
//        Log.d(TAG, "onItemClicked: item" + new Gson().toJson(item));
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);

        return true;

    }




}
