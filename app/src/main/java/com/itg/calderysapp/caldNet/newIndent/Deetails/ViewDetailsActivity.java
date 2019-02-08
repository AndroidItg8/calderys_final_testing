package com.itg.calderysapp.caldNet.newIndent.Deetails;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.update.UpdateDetailFragment;
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
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.SpinnerItemSelect;
import com.itg.calderysapp.common.UtilSnackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.EQUIPMENTCODE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.PROCESSCODE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SALESGROUP;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SALESOFFICES;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SALESPACKAGE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SOTYPE;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.SPECIALPROCESSINDICATORS;
import static com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerFileName.USAGEINDICATOR;

public class ViewDetailsActivity extends AppCompatActivity {
//            implements MaterialIntentAdapter.OnItemClickedListner, CreateIntentMVP.CreatIntentView, View.OnClickListener

    private static final String TAG = "ViewDetailsActivity";
    private static final int RC_EDIT = 23;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;


    private LinearLayoutManager layoutManager;
    private GenericSpinnerAdapter genericSpinnerAdapter = null;
    private SpinnerGenericModel genericModel;

    private CreateIntentMVP.CreateIntentPresenter presenter;
    private boolean isViewEnable = false;
    private IntentDetailModel model;
    SAPApprovedListner listnerl;
    OnBackPressedListener backPressedListener;
    private boolean isError = false;
    private boolean isSetSAP=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        isViewEnable = true;
//        presenter = new CreateIntentPresenterImp(this);
//        setDrawableLeftRight();

        initView();


    }

    private void initView() {
        model = new IntentDetailModel();
        checkIndent();
    }

    private void checkIndent() {
        if (getIntent().hasExtra(CommonMethod.FROM_VIEWDRAFT)) {
            ViewDraftModel viewDraftModel = getIntent().getParcelableExtra(CommonMethod.FROM_VIEWDRAFT);
            callFragment(IndentDetailFragment.newInstance(viewDraftModel, CommonMethod.FROM_VIEWDRAFT));

//            model.setIndentCode(viewDraftModel.getIndentCode());
//            model.setIndentDate(viewDraftModel.getIndentDate());
//            presenter.onEditViewDraftData(viewDraftModel);
        } else if (getIntent().hasExtra(CommonMethod.FROM_PLANT)) {
            IndentModel model = getIntent().getParcelableExtra(CommonMethod.FROM_PLANT);
//            setIndentCode(model);
//            presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
            callFragment(IndentDetailFragment.newInstance(model, CommonMethod.FROM_PLANT));

        } else if (getIntent().hasExtra(CommonMethod.FROM_APPROVED_INDENT)) {
            IndentModel model = getIntent().getParcelableExtra(CommonMethod.FROM_APPROVED_INDENT);
            callFragment(IndentDetailFragment.newInstance(model, CommonMethod.FROM_APPROVED_INDENT));
//            setIndentCode(model);
//            setButtonsForRejectApproved();
//            presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
        } else if (getIntent().hasExtra(CommonMethod.FROM_MYINTENTS)) {
            IndentModel model = getIntent().getParcelableExtra(CommonMethod.FROM_MYINTENTS);
            callFragment(IndentDetailFragment.newInstance(model, CommonMethod.FROM_MYINTENTS));

//            setIndentCode(model);
//            presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
        } else if (getIntent().hasExtra(CommonMethod.FROM_VIEW_INTENTS)) {
            IndentModel model = getIntent().getParcelableExtra(CommonMethod.FROM_VIEW_INTENTS);
            callFragment(IndentDetailFragment.newInstance(model, CommonMethod.FROM_VIEW_INTENTS));

//            setIndentCode(model);
//            presenter.onEditViewDraftData(new ViewDraftModel(model.getIndentCode(), model.getIndentDate()));
        }

    }


    private void callFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
//            ft.addToBackStack(UpdateDetailFragment.class.getSimpleName());
            ft.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

//    {
//        "dealer_code":"1000000005",
//            "PONumber":"34",
//            "ConsigneeCode":"1000000005",
//            "PODate":"2017-08-11 00:00:00.000",
//            "SO_Type":"",
//            "DispatchDate":"2017-08-11 00:00:00.000",
//            "Division":"SH",
//            "DistChannel":"SS",
//            "pt":[{
//        "product_code":"000005000000006441",
//                "quantity":"2",
//                "PlantCode":"WRW"
//
//    },
//        {
//            "product_code":"000005000000005217",
//                "quantity":"3",
//                "PlantCode":"WRW"
//
//        }],
//        "AID": {
//        "ProcessCode":"AL-001",
//                "EquipmentCode":"AL0101",
//                "Sales_Org":"ACCR",
//                "UsageIndicator":"ACC",
//                "SpecialProcIndicator":"ZOTH",
//                "Partner":"0000000001",
//                "SalesPackage":"ZONLY_PROD"
//    }
//    }

    public void setSAPModel(IntentDetailModel model) {
        if (model != null) {
            isSetSAP= true;

            if (model.getProductList() != null && model.getProductList().size() > 0) {

                SAPModel sapModel = new SAPModel();
                sapModel.setDealerCode(model.getDealerCode());
                sapModel.setPONumber(model.getPoNumber());
                sapModel.setConsigneeCode(model.getConsigneeCode());
                sapModel.setPODate(model.getPoDate());
                sapModel.setSOType(model.getSoType());
                sapModel.setDispatchDate(model.getDispatchDate());
                sapModel.setDivision(model.getDivision());
                sapModel.setDistChannel(model.getIndentType());


                    Log.d(TAG, "setAllIndentEdtText: " + model.getProductList().toString());

                    if (model.getProductList().size() > 0) {
                        sapModel.setDispatchDate(model.getProductList().get(0).getDispatchDate());


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
                    aid.setSalesOrg(model.getSalesOrganization());
                    aid.setSpecialProcIndicator(model.getSplProcessIndicator());
                    aid.setUsageIndicator(model.getUsaguageIndicator());
                    aid.setSalesPackage(model.getSalesPackage());
                    sapModel.setAID(aid);

                    Log.d(TAG, "setSAPModel: " + new Gson().toJson(sapModel));
                if (listnerl != null)
                    listnerl.onGetSONumber(model);
                    //  callSAPServer(model);

            } else {

                showSnackbarOkButton("No product in this order.");


            }


        }


    }



    private void showSnackbar(String err) {
        UtilSnackbar.showSnakbarTypeFail(frameContainer, err, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {

            }
        });

    }

    private void showSnackbarOkButton(String err) {
        isError = true;
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(frameContainer, err, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                finish();

            }
        });

    }

    public void attachedSAPListener(SAPApprovedListner listener1) {
        this.listnerl = listener1;
    }

    public void attachedBackPress(OnBackPressedListener listener) {
        this.backPressedListener = listener;
    }

    public interface SAPApprovedListner {
        void onGetSONumber(IntentDetailModel message);

        void onFailed(String message);


    }

    public interface OnBackPressedListener {
        public void doBack();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        }



    @Override
    protected void onDestroy() {
        super.onDestroy();
         isSetSAP=false;
         isError=false;
         isViewEnable=false;
    }
}
