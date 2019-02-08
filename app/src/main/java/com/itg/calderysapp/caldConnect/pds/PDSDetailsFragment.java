package com.itg.calderysapp.caldConnect.pds;


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
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSMVP;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSModifiedPresenterImp;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.FileDownloadService;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.EasyPermissions;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PDSDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PDSDetailsFragment extends Fragment implements View.OnClickListener, PDSMVP.PDSDeleteViw,  CommonInterface.DownloadServiceBindListner {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RC_EDIT = 76;
    @BindView(R.id.img_delete)
    ImageView mImgDelete;
    @BindView(R.id.img_edit)
    ImageView mImgEdit;
    @BindView(R.id.txt_date)
    TextView mTxtDate;
    @BindView(R.id.txt_share)
    TextView mTxtShare;
    @BindView(R.id.views)
    View mViews;
    @BindView(R.id.txt_titles)
    TextView mTxtTitles;
    @BindView(R.id.txt_descriptions)
    TextView mTxtDescriptions;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.lbl_productType)
    TextView mLblProductType;
    @BindView(R.id.txt_productType)
    TextView mTxtProductType;
    @BindView(R.id.lbl_familyGroup)
    TextView mLblFamilyGroup;
    @BindView(R.id.txt_familyGroup)
    TextView mTxtFamilyGroup;
    @BindView(R.id.btn_fileName)
    Button mBtnFileName;
    Unbinder unbinder;
    @BindView(R.id.card)
    MaterialCardView card;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    FileDownloadService serviceFile ;
    boolean isBounded = false;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Data data;
    private PDSMVP.PDSDeletePresenter presneter;
    private boolean isDownloaded = false;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            data = intent.getParcelableExtra(CommonMethod.FILE_DOWNLOAD);
            hideDownloadProgress("Download Successful", data);
//            adapter.downloadSuccessfull(model);
//            adapter.notifyDataSetChanged();
            Log.d("receiver", "Got message: " + data);
        }
    };
    private ServiceConnection mServiceConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            FileDownloadService.MyBinder binder= (FileDownloadService.MyBinder) service;
            serviceFile = binder.getService();
            serviceFile.bindListner=PDSDetailsFragment.this;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public PDSDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PDSDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PDSDetailsFragment newInstance(Data param1) {
        PDSDetailsFragment fragment = new PDSDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    private void hideDownloadProgress(String download_successful, Data data) {
        hideProgress();
        setPdfImage();
        isDownloaded = true;
        this.data = data;
        OpenPDF(data);

    }

    private void setPdfImage() {
        Drawable img = getContext().getResources().getDrawable(R.drawable.ic_pdf);
        img.setBounds(8, 8, 8, 8);
        mBtnFileName.setCompoundDrawables(img, null, null, null);
    }

    private void OpenPDF(Data datum) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String filePath = Environment.getExternalStorageDirectory() + "/" + "Caldreys App" + "/" + datum.getFile();
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
                    intent.setDataAndType(uri, "*/*");
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
            data = getArguments().getParcelable(ARG_PARAM1);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pdsdetails, container, false);
        unbinder = ButterKnife.bind(this, view);
        presneter = new PDSModifiedPresenterImp(this);
        setDrawableLeftRight();
        startService();

        checkUserType();
        setView();
        return view;
    }

    private void setDrawableLeftRight() {
            CommonMethod.setLeftRightDrawable(mTxtDate,R.drawable.ic_date,0 );
            CommonMethod.setLeftRightDrawable(mBtnFileName,R.drawable.ic_file_download_black_24dp, 0);

    }

    private void checkUserType() {
        if(MyApplication.getInstance().isCommercialUser()){
            mImgDelete.setVisibility(View.GONE);
            mImgEdit.setVisibility(View.GONE);
        }else{
            mImgDelete.setVisibility(View.VISIBLE);
            mImgEdit.setVisibility(View.VISIBLE);
        }
    }

    private void setView() {
        mImgEdit.setOnClickListener(this);
        mImgDelete.setOnClickListener(this);
        mBtnFileName.setOnClickListener(this);
        mTxtDate.setText(data.getUploadedDate());
        mTxtDate.setText(data.getUploadedDate());
        mTxtProductType.setText(data.getProductType());
        mTxtFamilyGroup.setText(data.getFamilyGroup());
        mTxtShare.setText(data.getShare());
        mTxtTitles.setText(data.getProductName());
        mTxtDescriptions.setText(data.getIndustryApplicant());
        if (data.getFile() != null && !TextUtils.isEmpty(data.getFile() )) {
            if (data.getFile().equalsIgnoreCase("UPLOAD YOUR FILE")) {
                mBtnFileName.setVisibility(View.GONE);
            } else {
                mBtnFileName.setText(data.getFile());
                mBtnFileName.setVisibility(View.VISIBLE);
                checkFileAlreadyHave(data.getFile());
            }
        }

        else{
            mBtnFileName.setVisibility(View.GONE);
        }



    }

    private void checkFileAlreadyHave(String file) {
        File excelFile = new File(Environment.getExternalStorageDirectory() + "/" + "Caldreys App" + "/" + file);//File path
        if (excelFile.exists()) //Checking if the file exists or not
        {
            isDownloaded = true;
            setPdfImage();
        } else {
            mBtnFileName.setVisibility(View.VISIBLE);
//            Drawable img = getContext().getResources().getDrawable(R.drawable.ic_file_download_black_24dp);
//            img.setBounds(8, 8, 8, 8);
//            mBtnFileName.setCompoundDrawables(img, null, null, null);
            CommonMethod.setLeftRightDrawable(mBtnFileName,R.drawable.ic_file_download_black_24dp,0 );
        }
        mBtnFileName.setText(file);
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();

        unbinder.unbind();
        unBindServiec();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_delete:
                openDialogue();
                break;
            case R.id.img_edit:
                startPDSActivity();
                break;
            case R.id.btn_fileName:
                checkPermission();
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
                        presneter.deletePDS(CommonMethod.TBL_PDS, data.getId());
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
        builder.setMessage("Do you want to Delete the product data sheet?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }


    private void checkPermission() {
        ((HomeActivity)getActivity()).checkPermission(new CommonInterface.EasyPermissionListener() {
            @Override
            public void onGranted() {
                if (!isDownloaded)
                    serviceFile.startDownloadingFile(data);
                else
                    OpenPDF(data);
            }

            @Override
            public void onDenied() {
                Toast.makeText(getActivity(), "Permission is denied , Accept Permission to Storage", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();

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
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mMessageReceiver);
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    private void startService() {
        Intent intent = new Intent(getActivity(), FileDownloadService.class);
        intent.putExtra(CommonMethod.FILE_DOWNLOAD_SERVICE, data);
        getActivity().startService(intent);
        getActivity().bindService(intent,mServiceConnection,Context.BIND_AUTO_CREATE);
    }

    private void startPDSActivity() {
        Intent intent = new Intent(getActivity(), PDSActivity.class);
        intent.putExtra(CommonMethod.FROM_EDIT, data);
        startActivityForResult(intent, RC_EDIT);
    }

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
                presneter.deletePDS(CommonMethod.TBL_PDS, data.getId());
            }
        });

    }

    @Override
    public void onError(Object t) {
        UtilSnackbar.showSnakbarTypeFail(card, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presneter.deletePDS(CommonMethod.TBL_PDS, data.getId());

            }
        });

    }

    @Override
    public void onNoInternet() {
        UtilSnackbar.showSnakbarTypeFail(card, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presneter.deletePDS(CommonMethod.TBL_PDS, data.getId());


            }
        });

    }

    @Override
    public void showProgress() {


    }

    @Override
    public void hideProgress() {

    }

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

    @Override
    public void onDownloadStarted() {
        if(getActivity()!=null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgress.setVisibility(View.VISIBLE);
                    mBtnFileName.setVisibility(View.GONE);
                }
            });
        }

    }

    @Override
    public void onDownloadFinished() {
        if(getActivity()!=null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgress.setVisibility(View.GONE);
                    mBtnFileName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    mBtnFileName.setVisibility(View.VISIBLE);
                    isDownloaded=true;
                    if(data!=null)
                        OpenPDF(data);

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
        if(getActivity()!=null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                    mProgress.setVisibility(View.GONE);
                    mBtnFileName.setVisibility(View.VISIBLE);
                    isDownloaded=false;
                }
            });
        }

    }

    @Override
    public void onDownloadProgress(int progress) {
        if(getActivity()!=null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mProgress.setProgress(progress);

                }
            });

        }
    }
}
