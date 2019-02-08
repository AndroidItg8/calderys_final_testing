package com.itg.calderysapp.caldConnect.update;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.design.card.MaterialCardView;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.PDSDetailsFragment;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSMVP;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSModifiedPresenterImp;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.FileDownloadService;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.UserType;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateDetailFragment extends Fragment implements View.OnClickListener, PDSMVP.PDSDeleteViw,  CommonInterface.DownloadServiceBindListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_EDIT = 67;
    @BindView(R.id.txt_titles)
    TextView mTxtTitles;
    @BindView(R.id.txt_descriptions)
    TextView mTxtDescriptions;
    @BindView(R.id.txt_date)
    TextView mTxtDate;

    @BindView(R.id.btn_fileName)
    Button btnFileName;
    Unbinder unbinder;
    @BindView(R.id.img_delete)
    ImageView imgDelete;
    @BindView(R.id.img_edit)
    ImageView imgEdit;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.card)
    MaterialCardView card;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Datum datum;
    private Context context;
    private PDSMVP.PDSDeletePresenter presenter;
    private boolean isDownloaded=false;
    private FileDownloadService serviceFile;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment UpdateDetailFragment.
     */
    // TODO: Rename and change types and number of parameters

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            datum = intent.getParcelableExtra(CommonMethod.FILE_DOWNLOAD);
            hideDownloadProgress("Download Successful", datum);
//            adapter.downloadSuccessfull(model);
//            adapter.notifyDataSetChanged();
            Log.d("receiver", "Got message: " + datum);
        }
    };

    private ServiceConnection mServiceConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            FileDownloadService.MyBinder binder= (FileDownloadService.MyBinder) service;
            serviceFile = binder.getService();
            serviceFile.bindListner=UpdateDetailFragment.this;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    public UpdateDetailFragment() {
        // Required empty public constructor
    }

    public static UpdateDetailFragment newInstance(Datum datum) {
        UpdateDetailFragment fragment = new UpdateDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, datum);
        fragment.setArguments(args);
        return fragment;
    }



    private void hideDownloadProgress(String download_successful, Datum datum) {
        setPdfImage();
        isDownloaded= true;
        this.datum = datum;

    }

    private void setPdfImage() {
        Drawable img = getContext().getResources().getDrawable(R.drawable.ic_pdf);
        img.setBounds(8, 8, 8, 8);
        btnFileName.setCompoundDrawables(img, null, null, null);
    }

    private void OpenPDF(Datum datum) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String filePath = Environment.getExternalStorageDirectory()+"/" +"Caldreys App"+"/"+datum.getFile();
//        String newFilePath = filePath.replaceAll("%20", " ");
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                intent.setDataAndType
                        (Uri.parse(filePath), "*/*");
            } else {
                Uri uri = Uri.parse(filePath);
                File file = new File(uri.getPath());
                if (file.exists()) {
                    uri = FileProvider.getUriForFile(getActivity(), "com.itg.calderysapp.provider", file);
                    intent = new Intent(Intent.ACTION_VIEW, uri);
//                    String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(CommonMethod.fileExt(getFile()).substring(1));
                    intent.setDataAndType(uri, "*/*");
//                    intent.setType("*/*");
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                }
            }
        } catch (Exception e) {
            Log.d(getActivity().getClass().getName(), String.valueOf(e));
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        getActivity().startActivity(intent);

//
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/example.pdf");

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            datum = getArguments().getParcelable(ARG_PARAM1);
        }

    }


    //    {
//        "Status": 1,
//            "Errorcode": 200,
//            "data": [
//        {
//            "id": "1",
//                "title": "Amendment in discount policy for Plastic products (ACCPLAST group)",
//                "Discription": "As per the latest amendment in discount policy, discounts for ACCPLAST product group (plastic refractory) is 8% for both E1 and Godown Sales. As per this amendment, all products under the ACCPLAST group will have a discount of 8% for both types of sale (i.e. E1 and Godown). We hope this move would be motivating for Channel Partners to grow sales of Plastic refractory products",
//                "upload_date": "10/28/2015 ",
//                "file": "",
//                "status": "0",
//                "email_sent": "0",
//                "date": "05/11/2015",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 22:59:31",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "2",
//                "title": "Superheat 40 & Superheat 50 launch exclusively for Distributors",
//                "Discription": "Dear Channel Partners,\r\n  We are pleased to launch Superheat 40 and Superheat 50 bricks exclusively for Distributors. Please contact your respective Distributor Managers for prices. Also product datasheets for these bricks have been uploaded on this portal.",
//                "upload_date": "05/25/2016 ",
//                "file": "",
//                "status": "1",
//                "email_sent": "1",
//                "date": "05/25/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 23:00:15",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "3",
//                "title": "ACCOAT 90 P product launch",
//                "Discription": "Dear Channel Partners, \r\n We are glad to launch ACCCOAT 90 P. this product is used for coating on the old refractory lining before building a new lining. becasue of this product the old lining need not be dismantled and its life of repaired lining is enhanced. So this is a cost effective and time saving solution for the customer \r\n For more information please contact your respective Distribution Manager and also refer to PDS and installation manual uploaded on this portal.",
//                "upload_date": "05/25/2016 ",
//                "file": "",
//                "status": "1",
//                "email_sent": "1",
//                "date": "05/25/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 23:00:10",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "7",
//                "title": "Total solution for Reheat Furnace with shaped items (Durablock RFA Cr, Durablock RFA Super, Superheat RHF Spl, Superheat RHW, Superheat P & Superheat S)",
//                "Discription": "We are pleased inform you that we are now offering a complete range of shaped products for Reheat Furnace.</p>\r\n<p>1. Recently we launched 2 new products for Hearth of Coal Fired Reheating Furnace</p>\r\n<p>a. Durablock RFA CR : It is PCPF Block for Hearth Area (PDS available on this portal)</p>\r\n<p>b. SUPERHEAT RHF SPL: It is a Brick for Hearth Area (PDS available on this portal)</p>\r\n<p>&nbsp;</p>\r\n<p>2. For Hearth of Oil Fired Reheating Furnace, Durablock RFA Super (PDS available on this portal)</p>\r\n<p>&nbsp;</p>\r\n<p>3. For Wall area of Reheat furnace, SUPERHEAT RHW (PDS available on this portal)</p>\r\n<p>&nbsp;</p>\r\n<p>4. For Roof area we have Hanger Shoulder Brick for Both Soaking and Preheating Zone</p>\r\n<p>a. SUPERHEAT P (PDS Enclosed): These are Hanger Shoulder Bricks for Preheating Zone</p>\r\n<p>b. SUPERHEAT S (PDS Enclosed): These are Hanger Shoulder Bricks for Soaking Zone</p>\r\n<p>&nbsp;</p>\r\n<p>Please contact your Distributor Managers should you have any technical or commercial or technical query about these products",
//                "upload_date": "06/03/2016",
//                "file": "",
//                "status": "1",
//                "email_sent": "1",
//                "date": "06/03/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 23:00:06",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "8",
//                "title": "New product launch for Hearth of Coal Fired Reheating Furnace: Durablock Cr & Superheat RHF Spl",
//                "Discription": "We have launched 2 new products for Hearth of Coal Fired Reheating Furnace.</p>\r\n<p>1. Durablock RFA CR : It is PCPF Block for Hearth Area (PDS available on this portal)</p>\r\n<p>2. SUPERHEAT RHF SPL: It is a Brick for Hearth Area&nbsp;(PDS available on this portal)",
//                "upload_date": "06/05/2016  ",
//                "file": "",
//                "status": "1",
//                "email_sent": "1",
//                "date": "06/03/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 23:00:00",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "9",
//                "title": "Benefits of ACCMON DAR BC in DRI Kilns (especially with South African Coal)",
//                "Discription": "ACCMON DAR BC can be an effective proposal for DRI kilns especially where use of South African coal is hampering performance of other products. With this product we can also prevent customers from switching over to LC -80 from competitors. This could be also beneficial for lining in pallet plants.\r\n\r\nFollowing are benefits of ACCMON DAR\r\n BC:\r\n\r\n<ul>\r\n<li>Heat saving due to lower thermal conductivity. Pay back of refractory in 18 months from coal saving</li>\r\n<li>Higher Abrasion resistance</li>\r\n<li>Lower Iron</li>\r\n<li>Same or better life</li>\r\n<li>Cost wise cheaper than LC 80</li>\r\n<li>Low BD leads to lesser consumption of castable</li>\r\n<li>Lower load in the kiln leads to lower power consumption</li>\r\n</ul>\r\n \r\n For technical and commercial queries please get in touch with respective distributor managers. Also please refer to the DRI Kiln heating schedule (uploaded on this portal) while application of this product. ",
//                "upload_date": "06/24/2016 ",
//                "file": "",
//                "status": "1",
//                "email_sent": "1",
//                "date": "06/24/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-12-02 18:54:16",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "10",
//                "title": "New Products launched",
//                "Discription": "Presentation shared on Goa &amp; Kolkata meet on new recent products lanuches.",
//                "upload_date": "09/07/2016  ",
//                "file": "New Products Launched_Goa and Kolkata Meet.pdf",
//                "status": "1",
//                "email_sent": "1",
//                "date": "09/07/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 22:59:50",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "12",
//                "title": "List of products available from Gujarat & information on freight subsidy from WRW",
//                "Discription": "Following document contains list of products from available from Gujarat (WRW and Merchandise)and information on freight subsidy from WRW",
//                "upload_date": "09/12/2016 ",
//                "file": "List of product from Gujarat & information on freight subsidy from WRW.pdf",
//                "status": "1",
//                "email_sent": "1",
//                "date": "09/12/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-09-12 22:59:45",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "13",
//                "title": "EIL approval for Calderys products",
//                "Discription": "EIL approval for Calderys products has been uploaded in Updates menu in media center",
//                "upload_date": "09/12/2016  ",
//                "file": "EIL Calderys.pdf",
//                "status": "1",
//                "email_sent": "1",
//                "date": "09/12/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-10-17 12:13:07",
//                "modified": "0000-00-00 00:00:00"
//        },
//        {
//            "id": "14",
//                "title": "3 Caldemitras have joined recently",
//                "Discription": "We take pleasure in informing you that recently 3 Caldemitras have joined the Calderys Channel Partner famiily. Mr. Chandan Nath, Mr. Naval Kaware and Mr. Sanjeev Singh (are working as Caldemitras with Amitraj Enterprises,Khemka Traders and Industrial Minerals respectively.\r\nFew other Distributors are interviewing candidates, and hence we are expecting more Caldemitras to join. We would like to see this number growing even further. Distributors who would like to employ a Caldemitra or who have a suitable candidate on their mind can contact their Distributor Manager for further process.",
//                "upload_date": "10/13/2016 ",
//                "file": "",
//                "status": "1",
//                "email_sent": "1",
//                "date": "10/13/2016",
//                "insertBy": "admin",
//                "ip": "203.163.103.14",
//                "created": "2016-10-17 12:12:45",
//                "modified": "0000-00-00 00:00:00"
//        }
//    ]
//    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new PDSModifiedPresenterImp(this);
        EventBus.getDefault().register(this);
        presenter.setViewAllAvailable(this);

        setDrawableLeftRight();
        setData();
        startService();
        checkUserType();
        setClickedListener();
        return view;
    }

    private void setDrawableLeftRight() {
        CommonMethod.setLeftRightDrawable(mTxtDate,R.drawable.ic_date,0);
        CommonMethod.setLeftRightDrawable(btnFileName,R.drawable.ic_file_download_black_24dp,0);
    }

    private void checkUserType() {
        if(MyApplication.getInstance().isCommercialUser()){
            imgDelete.setVisibility(View.GONE);
            imgEdit.setVisibility(View.GONE);
        }else{
            imgDelete.setVisibility(View.VISIBLE);
            imgEdit.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mMessageReceiver,
                new IntentFilter(CommonMethod.FROM_SERVICE));
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mMessageReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String event) {/* Do something */
    if(event!=null && event.equalsIgnoreCase("ssa")){
        try {
            if(getActivity()!=null)
                getActivity().getSupportFragmentManager().popBackStackImmediate();
        } catch (IllegalStateException ignored) {
            // There's no way to avoid getting this if saveInstanceState has already been called.
        }
    }
    };

    private void setData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mTxtDescriptions.setText(Html.fromHtml(datum.getDiscription(), Html.FROM_HTML_MODE_COMPACT));
            mTxtTitles.setText(Html.fromHtml(datum.getTitle(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            mTxtDescriptions.setText(Html.fromHtml(datum.getDiscription()));
            mTxtTitles.setText(Html.fromHtml(datum.getTitle()));
        }
        mTxtDate.setText(datum.getUploadDate());

        if (datum.getFile() != null && !TextUtils.isEmpty(datum.getFile()) ) {
       if(datum.getFile().equalsIgnoreCase("UPLOAD YOUR FILE")) {
                btnFileName.setVisibility(View.GONE);
            }else {
           btnFileName.setOnClickListener(this);
           btnFileName.setText(datum.getFile());
           File files = new File(new File(Environment.getExternalStorageDirectory(), "Caldreys App"), datum.getFile());
           if (files.exists()) {
               setPdfImage();
               isDownloaded = true;
//             OpenPDF(datum);

           }
       }
            }

        else{
            btnFileName.setVisibility(View.GONE);
        }







    }

    private void setClickedListener() {
        imgDelete.setOnClickListener(this);
        imgEdit.setOnClickListener(this);
        mTxtDescriptions.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        if(presenter !=null)
            presenter.onDestroy();
        unbinder.unbind();
        unBindServiec();

    }


    private void showHide(View show, View hide) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.GONE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_fileName:

                checkPermission();
                break;
            case R.id.img_delete:
                openDialogue();
                break;
            case R.id.img_edit:
                startUpdateActivity();
                break;


        }
    }

    private void openDialogue() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        presenter.deletePDS(CommonMethod.TBL_UPDATE_DELETE, datum.getId());

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
        builder.setMessage("Do you want to Delete the product?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }


    private void checkPermission() {

            ((HomeActivity)getActivity()).checkPermission(new CommonInterface.EasyPermissionListener() {
                @Override
                public void onGranted() {
                    if (!isDownloaded)
                        serviceFile.startDownloadingFile(datum);
                    else
                        OpenPDF(datum);
                }

                @Override
                public void onDenied() {
                    Toast.makeText(getActivity(), "Permission is denied , Accept Permission to Storage", Toast.LENGTH_SHORT).show();
                }
            });

    }


    private void startUpdateActivity() {
        Intent intent = new Intent(getActivity(), AddActivity.class);
        intent.putExtra(CommonMethod.FROM_EDIT, datum);
        startActivityForResult(intent, RC_EDIT);
    }



    private void startService() {
        Intent intent = new Intent(getActivity(), FileDownloadService.class);
        intent.putExtra(CommonMethod.FILE_DOWNLOAD_SERVICE, datum);
        getActivity().startService(intent);
        getActivity().bindService(intent,mServiceConnection,Context.BIND_AUTO_CREATE);
    }


//    @Override
//    public void onSuccessFile(Object model) {
//        if(model instanceof Datum){
//            isDownloaded=true;
//            Datum mo = (Datum) model;
//            OpenPDF(mo);
//
//
//        }
//
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
         if(requestCode==RC_EDIT)
         {
             if(resultCode==RESULT_OK ){
                 if(getActivity()!=null)
                    getActivity().onBackPressed();
             }
         }


    }

//    @Override
//    public void onProgressShow() {
//        btnFileName.setVisibility(View.GONE);
//        progress.setVisibility(View.VISIBLE);
//
//    }
//
//    private void publishProgress(int i) {
////        mBuilder.setProgress(100, i[0], false);
//    }
//
//    @Override
//    public void onDownloadFiled(String message) {
////        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//        UtilSnackbar.showSnakbarTypeFail(card, message, new UtilSnackbar.OnSnackbarActionClickListener() {
//            @Override
//            public void onRetryClicked() {
//                getActivity().onBackPressed();
//            }
//        });
//
//
//    }
//
//    @Override
//    public void onProgressHide() {
//        progress.setVisibility(View.GONE);
//        btnFileName.setVisibility(View.VISIBLE);
//
//
//    }
//
//    @Override
//    public void startDownload() {
//        progress.setVisibility(View.VISIBLE);
//        btnFileName.setVisibility(View.GONE);
//
//    }

    @Override
    public void onDeleteSucess(String message) {
        UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(card, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                getActivity().onBackPressed();
            }
        });



    }

    @Override
    public void onDownloadFileSucess(String message) {


    }

    @Override
    public void onFail(String message) {
        UtilSnackbar.showSnakbarTypeFail(card, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.deletePDS(CommonMethod.TBL_UPDATE_DELETE, datum.getId());
            }
        });

    }

    @Override
    public void onError(Object t) {
        UtilSnackbar.showSnakbarTypeFail(card, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.deletePDS(CommonMethod.TBL_UPDATE_DELETE, datum.getId());
            }
        });

    }

    @Override
    public void onNoInternet() {
        UtilSnackbar.showSnakbarTypeFail(card, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {

            }
        });

    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
        btnFileName.setVisibility(View.GONE);


    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
        btnFileName.setVisibility(View.VISIBLE);

        }


    @Override
    public void onDetach() {
        super.onDetach();



    }


    @Override
    public void onDownloadStarted() {
        if(getActivity()!=null)
        {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgress.setVisibility(View.VISIBLE);
                    btnFileName.setVisibility(View.GONE);
                }
            });


        }


    }

    @Override
    public void onDownloadFinished() {
        if(getActivity()!=null)
        {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgress.setVisibility(View.GONE);
                    btnFileName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    btnFileName.setVisibility(View.VISIBLE);
                    isDownloaded=true;
                    if(datum!=null)
                        OpenPDF(datum);

                }
            });


        }



    }

    private void unBindServiec() {
        if(getActivity()!=null)
            getActivity().unbindService(mServiceConnection);
    }

    @Override
    public void onDownloadFailed(String error) {
        if(getActivity()!=null)
        {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgress.setVisibility(View.GONE);
                    btnFileName.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

    @Override
    public void onDownloadProgress(int progress) {
        if(getActivity()!=null)
        {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
               mProgress.setProgress(progress);


                }
            });


        }


    }
}
