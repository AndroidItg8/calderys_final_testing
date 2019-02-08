package com.itg.calderysapp.caldConnect.gallery;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.gallery.mvp.GalleryAddPresenterImp;
import com.itg.calderysapp.caldConnect.gallery.mvp.GalleryMVP;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.widget.CircularProgressView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class GalleryActivity extends AppCompatActivity implements GalleryMVP.AddGalleryView, View.OnClickListener, EasyPermissions.PermissionCallbacks {

    public static final String MIME_TYPE_IMAGE = "image/*";
    public static final String MIME_TYPE_IMAGE_JPG = "image/jpeg";
    public static final String MIME_TYPE_IMAGE_PNG = "image/png";
    private static final String MIME_TYPE_IMAGES = ".im";
    private static final int READ_REQUEST_CODE = 234;
    private static final String TAG = GalleryActivity.class.getSimpleName();
    private static final int RC_CAMERAWITHSTORAGE = 987;
    private static final int REQUEST_TAKE_PHOTO = 561;
    private static final int RC_STORAGE = 123;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    //    @BindView(R.id.img)
//    CircularImageView mImg;
    @BindView(R.id.img_display)
    ImageView mImgDisplay;
    @BindView(R.id.img_cross)
    ImageView mImgCross;
    @BindView(R.id.rl_img_display_edit)
    RelativeLayout mRlImgDisplayEdit;
    @BindView(R.id.frame_display)
    FrameLayout mFrameDisplay;
    @BindView(R.id.frm)
    FrameLayout mFrm;
    @BindView(R.id.edtProductTitle)
    TextInputEditText mEdtProductTitle;
    @BindView(R.id.input_layout_product)
    TextInputLayout mInputLayoutProduct;
    @BindView(R.id.edt_ProductDescription)
    TextInputEditText mEdtProductDescription;
    @BindView(R.id.input_layout_detail)
    TextInputLayout mInputLayoutDetail;
    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    //    @BindView(R.id.fab)
//    FloatingActionButton mFab;
//    @BindView(R.id.progressFab)
//    ProgressBar mProgressFab;
    @BindView(R.id.txt_fileName)
    TextView mTxtFileName;
    @BindView(R.id.edtProductDate)
    TextInputEditText mEdtProductDate;
    @BindView(R.id.input_layout_date)
    TextInputLayout mInputLayoutDate;
    @BindView(R.id.fab_file)
    FloatingActionButton mFabFile;
    @BindView(R.id.txt_percentage)
    TextView mTxtPercentage;
    @BindView(R.id.progress_fab)
    CircularProgressView mProgressFab;
    @BindView(R.id.rl_image)
    FrameLayout mRlImage;
    @BindView(R.id.ll_img_upload)
    LinearLayout mLlImgUpload;
    @BindView(R.id.txt_fileNames)
    TextView mTxtFileNames;
    private String absolutePath = null;
    private View view;
    private Calendar selectedDate = Calendar.getInstance();


    private GalleryMVP.AddGalleryPresenter presenter;
    private String[] permissions;
    private boolean canAccessCamera;
    private boolean canStorage;
    private String[] value = {
            "Camera",
            "Gallery"
    };
    private String mCurrentPhotoPath = null;
    private boolean isViewEnable=false;
    private GalleryData data;

    public static String getMimetypeFromUri(Uri uri, ContentResolver cr) {
        String mimeType = null;
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            mimeType = cr.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return mimeType;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        isViewEnable = true;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(getString(R.string.photo_gallery));
        getSupportActionBar().setHomeButtonEnabled(true);
        presenter = new GalleryAddPresenterImp(this, this);
        mBtnAdd.setOnClickListener(this);
        mFabFile.setOnClickListener(this);
        mImgCross.setOnClickListener(this);
        mEdtProductDate.setOnClickListener(this);
        checkEveryPermissions();
        checkIntent();


    }

    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_GALLERY_DETAIL)) {
          data = getIntent().getParcelableExtra(CommonMethod.FROM_GALLERY_DETAIL);
            setFromEditView(data);
        }
    }

    private void setFromEditView(GalleryData data) {
//        /storage/emulated/0/Android/data/com.itg.calderysapp/files/Pictures/Caldreys App/JPEG_20181026_183234_3002050152925682630.jpg

if(isViewEnable && data!=null ) {
    mEdtProductTitle.setText(data.getTitle());
    mEdtProductDate.setText(data.getDate());
    mEdtProductDescription.setText(data.getDiscription());
    if (data.getFile() != null && !TextUtils.isEmpty(data.getFile())) {
//        String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN + CommonMethod.FILDER_IMAGES + "/" + data.getFile().replaceAll(" ", "%20");
        String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN + "files/"+CommonMethod.FILDER_IMAGES + "/" + data.getFile().replaceAll(" ", "%20");
        mainPath = mainPath.replaceAll(" ", "%20");
//                Log.d(TAG, "instantiateItem: " + mainPath);
        String finalMainPath = mainPath;
        Picasso.get()
                .load(mainPath)
                .resize(300, 200)
                .placeholder(R.drawable.calderys)
                .error(R.drawable.calderys)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(mImgDisplay, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                        Picasso.get()
                                .load(finalMainPath)
                                .resize(300, 200)
                                .into(mImgDisplay, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        Picasso.get()
                                                .load(R.drawable.calderys)
                                                .into((mImgDisplay));
                                    }
                                });

                    }
                });
        mLlImgUpload.setVisibility(View.GONE);
        mTxtFileNames.setText(data.getFile());

        mFrameDisplay.setVisibility(View.VISIBLE);
        mTxtFileNames.setVisibility(View.VISIBLE);
        mImgDisplay.setVisibility(View.VISIBLE);
        mImgCross.setVisibility(View.VISIBLE);
        mImgCross.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_close_black_24dp));

//            if (!oFile.exists()) {


//                this.absolutePath = filePath;


//            }else{
//                Bitmap myBitmap = BitmapFactory.decodeFile(filePath);
//                mImgDisplay.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.calderys));
//                mTxtFileNames.setText(data.getFile());
//                mTxtFileNames.setText("Image is  not Available");


//            }
//            Log.d(TAG, "setFromEditView: Newfile" + newFilePath);
//            mImg.setVisibility(View.GONE);
//            mFab.hide();
//            mProgressFab.setVisibility(View.GONE);


    } else {

//            mImg.setVisibility(View.VISIBLE);
//            mFab.show();
//            mProgressFab.setVisibility(View.VISIBLE);
        mLlImgUpload.setVisibility(View.VISIBLE);

        mFrameDisplay.setVisibility(View.GONE);
        mTxtFileNames.setVisibility(View.GONE);
        mTxtFileNames.setText(data.getFile());
        mImgCross.setVisibility(View.GONE);
        mImgDisplay.setVisibility(View.GONE);
    }
}
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onSuccessFile(String message) {

        String[] split = message.split("/");
        String s;// = split[2];
        s=split[split.length-1];


        mTxtFileName.setVisibility(View.VISIBLE);
        mTxtFileName.setError(null);
        mTxtFileName.setText(s);
        presenter.onAddGalleryClicked(this,s,isFromEdit());
    }

    @Override
    public void onProgressGallery(int prrogress) {
        if(isViewEnable) {
            mProgressFab.setVisibility(View.VISIBLE);
            mTxtPercentage.setVisibility(View.VISIBLE);

            mProgressFab.setProgress(prrogress);
            mTxtPercentage.setText(String.valueOf(prrogress));
        }
    }

    @Override
    public void failedFileUpload() {
        if(isViewEnable) {
            mProgressFab.setProgress(0);
            mTxtPercentage.setText("0");
            mProgressFab.setVisibility(View.VISIBLE);


            mTxtPercentage.setVisibility(View.VISIBLE);
            mFabFile.setImageDrawable(null);
//        mProgressFab.setTotalTextView(mTxtPercentage);

            UtilSnackbar.showSnakbarRedColor(mBtnAdd, "File Uploaded");
            UtilSnackbar.showSnakbarRedColor(mBtnAdd, "File Uploaded");
        }

    }

    @Override
    public void onFinishedFileUpload() {
        if(isViewEnable) {
            UtilSnackbar.showSnakbarRedColor(mBtnAdd, "Failed to UploadFile");
            mProgressFab.setVisibility(View.VISIBLE);
            mProgressFab.setProgress(100);
            mTxtPercentage.setVisibility(View.VISIBLE);
            mFabFile.setImageDrawable(null);
            mTxtPercentage.setText("100");
        }

    }

    @Override
    public void onShowHideView() {
        if(isViewEnable) {
            mFabFile.setImageDrawable(null);
            showHideView();
        }

    }

    @Override
    public void onClick(View v) {
        this.view = v;
        switch (v.getId()) {
            case R.id.fab_file:
                showDialogToAddDocument();
                break;
            case R.id.btn_add:
                btnAddClicked(v);
                break;
            case R.id.img_cross:
                showHideView();
                break;
            case R.id.edtProductDate:
                openCalender();
                break;
        }

    }

    private void btnAddClicked(View v) {
        if(isViewEnable) {
            if (data != null) {
                //this means its from edit. We have to check whether absolutePath is null or not. if its
                //null means user not edited file when submit. And if absoluteth is avail that means file has
                //changed and need to upload it first
                if (absolutePath != null) {
                    presenter.onFileUpload(absolutePath, v);
                } else {
                    presenter.onAddGalleryClicked(this, data.getFile(), isFromEdit());
                }
            } else {
                presenter.onFileUpload(absolutePath, v);
            }
        }



//        mTxtPercentage.setVisibility(View.VISIBLE);
//        mProgressFab.setVisibility(View.VISIBLE);
//        mFabFile.setImageDrawable(null);
    }

    private void openCalender() {
        if(isViewEnable) {

            DatePickerDialog datePickerDialog = new DatePickerDialog(GalleryActivity.this, new DatePickerDialog.OnDateSetListener() {
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
                    mEdtProductDate.setText(getSelectedDateFromCalander);
                }
            }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.setTitle("SELECT DATE");
            datePickerDialog.show();
        }


    }

    private void showHideView() {
//        mImg.setVisibility(View.VISIBLE);
//        mFab.show();
        if(isViewEnable) {
            mLlImgUpload.setVisibility(View.VISIBLE);
            mProgressFab.setVisibility(View.GONE);

            mFrameDisplay.setVisibility(View.GONE);
            mImgDisplay.setVisibility(View.GONE);

            mImgCross.setVisibility(View.GONE);
            mRlImgDisplayEdit.setVisibility(View.GONE);
            mImgDisplay.setImageBitmap(null);
        }
    }

    private boolean isFromEdit() {
            return data != null;
    }

    private void showDialogToAddDocument() {
        if (isViewEnable) {
            AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(GalleryActivity.this);
            alertdialogbuilder.setTitle("Select Document Type ");
            alertdialogbuilder.setItems(value, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        if (canAccessCamera)
                            showCamera();
                        else {
                            checkCameraPerm();

                        }
                    } else if (which == 1) {
                        if (canStorage)
                            showFileManager();
                        else
                            checkStoragePerm();
                    }


//
                }
            });

            AlertDialog dialog = alertdialogbuilder.create();

            dialog.show();

        }
    }

    private void checkEveryPermissions() {
        if(isViewEnable) {

            canAccessCamera = hasCameraPermission();
            canStorage = hasStoragePermission();
        }
    }

    @AfterPermissionGranted(RC_STORAGE)
    private void checkStoragePerm() {
        permissions = getStoragePermission();
        if (!hasStoragePermission()) {
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_no_permission), RC_STORAGE, permissions);
        }
    }

    @AfterPermissionGranted(RC_CAMERAWITHSTORAGE)
    private void checkCameraPerm() {
        permissions = getCameraPermission();
        if (!hasCameraPermission()) {
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_no_permission), RC_CAMERAWITHSTORAGE, permissions);
        }
    }

    private boolean hasCameraPermission() {
        if (EasyPermissions.hasPermissions(this, getCameraPermission()))
            canAccessCamera = true;
        return canAccessCamera;
    }

    private boolean hasStoragePermission() {
        if (EasyPermissions.hasPermissions(this, getStoragePermission())) {
            canStorage = true;
        }
        return canStorage;
    }

    @NonNull
    private String[] getCameraPermission() {
        return new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        checkPrems(perms, true);
    }

    private void checkPrems(List<String> perms, boolean isGranted) {
        if (perms.contains(Manifest.permission.READ_EXTERNAL_STORAGE)
                || perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            canStorage = isGranted;
            if (isGranted && Arrays.equals(permissions, getStoragePermission())) showFileManager();
        }

        if (perms.contains(Manifest.permission.CAMERA)) {
            canAccessCamera = isGranted;

            if (isGranted && Arrays.equals(permissions, getCameraPermission())) {
                Log.d(TAG, "checkPrems: ShowCamera");
                showCamera();
            }


        }


    }

    private String[] getStoragePermission() {
        return new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        checkPrems(perms, false);
    }

    @Override
    public String getDescription() {
            return mEdtProductDescription.getText().toString();
    }

    @Override
    public String getTitles() {
            return mEdtProductTitle.getText().toString();

    }

    @Override
    public String getID() {

            return data != null ? data.getId() : null;

    }

    @Override
    public String getFilePath() {

            return mTxtFileNames.getText().toString();

    }

    @Override
    public void onSuccess(String message) {
        if(isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(mBtnAdd, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    setResult(RESULT_OK);
                    onBackPressed();


                }
            });
//        onBackPressed();

        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void showFabProgress() {
        if(isViewEnable) {
            mProgressFab.setVisibility(View.GONE);
        }

    }

    @SuppressLint("RestrictedApi")
    @Override
    public void hideFabProgress() {
        if(isViewEnable)
        mProgressFab.setVisibility(View.GONE);


    }

    @Override
    public void onTitleInvalid(String err) {
        if(isViewEnable)
        mEdtProductTitle.setError(err);

    }

    @Override
    public String getEventDate() {
        return mEdtProductDate.getText().toString();
    }

    @Override
    public void onEventDateInvalid(String err) {
        if(isViewEnable)
        mEdtProductDate.setError(err);
    }

    @Override
    public void onDescriptionInvalid(String err) {
        if(isViewEnable)
            mEdtProductDescription.setError(err);


    }

    @Override
    public void onFileInvalid(String err) {
        if(isViewEnable) {
            if (mTxtFileName.getVisibility() == View.VISIBLE)
                mTxtFileName.setError(err);
            else
                mTxtFileNames.setError(err);
        }


    }

    @Override
    public void onFail(String message) {
        if(isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mBtnAdd, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onFileUpload(absolutePath, view);

                }
            });
        }

    }

    @Override
    public void onError(Object t) {
        if(isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mBtnAdd, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onFileUpload(absolutePath, view);
                }
            });
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        isViewEnable=false;

    }

    @Override
    public void onNoInternet() {
        if(isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mBtnAdd, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onFileUpload(absolutePath, view);

                }
            });
        }

    }

    @Override
    public void showProgress() {
        if(isViewEnable) {
            mProgress.setVisibility(View.VISIBLE);
            mBtnAdd.setVisibility(View.GONE);
        }

    }

    @Override
    public void hideProgress() {
        if(isViewEnable) {
            mProgress.setVisibility(View.GONE);
            mBtnAdd.setVisibility(View.VISIBLE);
        }

    }

    private void showFileManager() {
        if(isViewEnable) {
            // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
            // browser.


            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

            // Filter to only show results that can be "opened", such as a
            // file (as opposed to a list of contacts or timezones)

            intent.addCategory(Intent.CATEGORY_OPENABLE);

            // Filter to show only images, using the image MIME data type.
            // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
            // To search for all documents available via installed storage providers,
            // it would be "*/*".
            intent.setType(MIME_TYPE_IMAGE);
//        intent.putExtra(Intent.EXTRA_MIME_TYPES, MIME_TYPE_PDF);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), READ_REQUEST_CODE);
        }
    }

    private void showCamera() {
        if(isViewEnable) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Ensure that there's a camera activity to handle the intent
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    // Error occurred while creating the File
                    ex.printStackTrace();
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(this,
                            "com.itg.calderysapp.provider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                }
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = new File(Environment.getExternalStorageDirectory() + "/" + "Caldreys App");


        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        Log.d(TAG, "createImageFile: ImageFIe:" + mCurrentPhotoPath);

        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // The document selected by the user won't be returned in the intent.
                // Instead, a URI to that document will be contained in the return intent
                // provided to this method as a parameter.
                // Pull that URI using resultData.getData().
                Uri uri = null;

                if (data != null) {
                    uri = data.getData();
                    assert uri != null;
                    Log.i(TAG, "Uri: " + uri.toString());
                    String selectedMimeType = getMimetypeFromUri(uri, getContentResolver());
                    Log.d(TAG, "SelectedMimeType:" + selectedMimeType);
                    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    String newFileName = timeStamp + CommonMethod.getMimetypeFromFileName(selectedMimeType);

                    InputStream in = null;
                    try {
                        /** Here we keep it all in a try-catch in case, so we don't
                         * force-close if something doesn't go to plan.
                         *
                         * This finds the location of the device's local storage (don't
                         * assume that this will be /sdcard/!), and appends a hard-
                         *  coded string with a new subfolder, and gives the file that
                         *  we are going to create a name.
                         *
                         *  Note: You'll want to replace 'gdrive_image.jpg' with the
                         *  filename that you fetch from Drive if you want to preserve
                         *  the filename. That's out of the scope of this post. */


                        Log.d(TAG, "onActivityResult: FileName:" + newFileName);
//                        String output_path = createDocumentTempFile(newFileName).getAbsolutePath();

                        // Create the file in the location that we just defined.
//                        File oFile = new File(new File(Environment.getExternalStorageDirectory(), "Calderys"), newFileName);
                        File storageDir = getExternalFilesDir(Environment.getExternalStorageDirectory() + "/" + "Caldreys App" + "/" + newFileName);

                        File oFile = new File(new File(Environment.getExternalStorageDirectory(), "Caldreys App"), newFileName);
                        Log.d(TAG, "onActivityResult: new File" + oFile.getAbsolutePath());

                        /**   Create the file if it doesn't exist; be aware that if it
                         * does, we'll be overwriting it further down. */
                        if (!oFile.exists()) {
                            /**   Note that this isn't just mkdirs; that would make our
                             * file into a directory! The 'getParentFile()' bit ensures
                             * that the tail end remains a File. */
                            oFile.getParentFile().mkdirs();
                            try {
                                oFile.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        /**   The 'getActivity()' bit assumes that this is being run from
                         * within a Fragment, which it is of course. You wouldn't be
                         * working outside of current Android good practice would
                         * you?... */
                        InputStream iStream = getContentResolver()
                                .openInputStream(uri);

                        /**   Create a byte array to hold the content that exists at the
                         * Uri we're interested in; this preserves all of the data that
                         * exists within the file, including any JPEG meta data. If
                         * you punt this straight to a Bitmap object, you'll lose all
                         * of that.
                         *
                         * Note: This is reallt the main point of this entire post, as
                         * you're getting ALL OF THE DATA from the source file, as
                         * is. */
                        byte[] inputData = getBytes(iStream);

                        writeFile(inputData, String.valueOf(oFile.getAbsolutePath()));
                        createDocumentFile(oFile.getAbsolutePath());


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } else if (requestCode == REQUEST_TAKE_PHOTO) {
            if (resultCode == RESULT_OK) {

                createDocumentFile(mCurrentPhotoPath);
            }
        }
    }

    private String getFilenameFromMimetype(String selectedMimeType) {
        if (selectedMimeType.equalsIgnoreCase(MIME_TYPE_IMAGE)) {
            return ".images";
        }
        return null;
    }

    private void createDocumentFile(String absolutePath) {
        setFileData(absolutePath);

//        mFabFile.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_check_24dp));
//        document.setFileActPath(absolutePath);
//        document.setFileName(new File(absolutePath).getName());
//        document.setFileExt(Helper.getFileExtFromName(document.getFileName()));


    }

    private void setFileData(String absolutePath) {
        // /storage/emulated/0/Android/data/com.itg.calderysapp/files/Pictures/Caldreys App/JPEG_20181026_183234_3002050152925682630.jpg
//        if(!isFromEdit())
        if(isViewEnable) {
            this.absolutePath = absolutePath;


//        mImg.setVisibility(View.GONE);
//        mProgressFab.setVisibility(View.GONE);
//        mFab.hide();
            mLlImgUpload.setVisibility(View.GONE);

            mFrameDisplay.setVisibility(View.VISIBLE);
            mImgDisplay.setVisibility(View.VISIBLE);
            mTxtFileNames.setVisibility(View.VISIBLE);

            mRlImgDisplayEdit.setVisibility(View.VISIBLE);
            mImgCross.setVisibility(View.VISIBLE);
            mImgCross.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_close_black_24dp));
            mTxtFileNames.setVisibility(View.VISIBLE);


            mTxtFileNames.setText(absolutePath);
            Log.d(TAG, "setFileData: " + absolutePath);
            Bitmap myBitmap = BitmapFactory.decodeFile(absolutePath);


            mImgDisplay.setImageBitmap(myBitmap);
        }


    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    public void writeFile(byte[] data, String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName);
        out.write(data);
        out.close();
    }


    private File createDocumentTempFile(String fileName) throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String pdfFileName = fileName.split("\\.(?=[^\\.]+$)")[0];
        String ext = "." + MIME_TYPE_IMAGES;
        File storageDir = Environment.getExternalStorageDirectory();
        File pdf = File.createTempFile(
                timeStamp,  /* prefix */
                ext,         /* suffix */
                storageDir /* directory */
        );
        Log.d(TAG, "createDocumentTempFile: DocumentFile:" + pdf.getAbsolutePath());
        // Save a file: path for use with ACTION_VIEW intents
        return pdf;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }



}
