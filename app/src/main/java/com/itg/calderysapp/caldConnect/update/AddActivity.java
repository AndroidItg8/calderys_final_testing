package com.itg.calderysapp.caldConnect.update;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldConnect.update.mvp.UpdateMVP;
import com.itg.calderysapp.caldConnect.update.mvp.UpdatePresenterImp;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.notification.NotificationModel.Message;
import com.itg.calderysapp.widget.CircularProgressView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class AddActivity extends AppCompatActivity implements OnClickListener, UpdateMVP.AddUpdateView, EasyPermissions.PermissionCallbacks {


    public static final String MIME_TYPE_PDF = "*/*";
    private static final String TAG = "AddActivity";
    private static final int READ_REQUEST_CODE = 234;
    private static final int RC_STORAGE = 987;
    public String absolutePath = null;
    public View view;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rl_image)
    FrameLayout mRlImage;
    @BindView(R.id.view)
    View mView;
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
    @BindView(R.id.progress_fab)
    CircularProgressView mProgressFab;
    @BindView(R.id.fab_file)
    FloatingActionButton mFabFile;
    @BindView(R.id.txt_fileName)
    TextView mTxtFileName;
    //    @BindView(R.id.imgPdf)
//    ImageView mImgPdf;
    @BindView(R.id.txt_percentage)
    TextView mTxtPercentage;


    private String[] permissions;
    private boolean canStorage;
    private UpdateMVP.AddUpdatePresenter presenter;
    private Datum datum;

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
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle(getString(R.string.title_Updates));

        init();
    }

    private void init() {
        setClickListener();
        checkIntent();
        presenter = new UpdatePresenterImp(this, this);
        checkEveryPermissions();
    }

    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_EDIT)) {
            datum = getIntent().getParcelableExtra(CommonMethod.FROM_EDIT);
            setData(datum);
        }else{
            if(getIntent().hasExtra(CommonMethod.FROM_NOTIFICATION_ADD)) {
                datum = getIntent().getParcelableExtra(CommonMethod.FROM_NOTIFICATION_ADD);
//            if (message.getCondition().getData()!= null) {
//                Datum  datum= new Gson().fromJson(message.getCondition().getData() , Datum.class);
                setData(datum);
//            }
            }


        }
    }

    private void setDataNotification(Message message) {
        mEdtProductTitle.setText(message.getCondition().getMessage());

            if(datum.getFile()!=null && !TextUtils.isEmpty(datum.getFile())) {
                mEdtProductDescription.setText(message.getCondition().getData());

                String filePath = Environment.getExternalStorageDirectory() + "/" + "Caldreys App" + "/" + datum.getFile();
                if (!TextUtils.isEmpty(filePath))
                    setFileData(filePath);
            }

    }

    private void setData(Datum datum) {
        mEdtProductTitle.setText(datum.getTitle());
        mEdtProductDescription.setText(datum.getDiscription());
        if (datum.getFile() != null && !TextUtils.isEmpty(datum.getFile())) {
            String filePath = Environment.getExternalStorageDirectory() + "/" + "Caldreys App" + "/" + datum.getFile();
            if (!TextUtils.isEmpty(filePath))
                setFileData(filePath);
        }
    }

    private void setClickListener() {
        mFabFile.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            mProgressFab.setProgress(0);
//        }

        mProgressFab.setProgressColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onSuccessFile(String message) {
        String[] split = message.split("/");
      String s ;//= split[4];

        s=split[split.length-1];
        mTxtFileName.setVisibility(View.VISIBLE);
        mTxtFileName.setText(s);
        presenter.onAddUpdateClicked(this);
    }

    @Override
    public void onProgressUpdate(int prrogress) {
//        mProgressFab.setTotalTextView(mTxtPercentage);
        mProgressFab.setProgress(prrogress);
        mTxtPercentage.setVisibility(View.VISIBLE);
        mTxtPercentage.setText(String.valueOf(prrogress));
        Log.d(TAG, "onProgressUpdate: progress" + prrogress);
        mFabFile.setImageDrawable(null);
    }

    @Override
    public void failedFileUpload() {
        mProgressFab.setProgress(0);
        mTxtPercentage.setText("0");


        mTxtPercentage.setVisibility(View.VISIBLE);
        mFabFile.setImageDrawable(null);
//        mProgressFab.setTotalTextView(mTxtPercentage);

        UtilSnackbar.showSnakbarRedColor(mBtnAdd, "File Uploaded");

    }

    @Override
    public void onFinishedFileUpload() {
        UtilSnackbar.showSnakbarRedColor(mBtnAdd, "Failed to UploadFile");
        mProgressFab.setProgress(100);
        mTxtPercentage.setVisibility(View.VISIBLE);
        mFabFile.setImageDrawable(null);
        mTxtPercentage.setText("100");

    }

    @Override
    public String getID() {
        return datum != null ? datum.getId() : null;
    }

    @Override
    public void onClick(View v) {
        this.view = v;
        switch (v.getId()) {
            case R.id.fab_file:
                if (canStorage) {
                    mTxtFileName.setVisibility(View.GONE);
                    showFileManager();
                } else
                    checkStoragePerm();
                break;


            case R.id.btn_add:
                checkFIleOnButtonClicked(v);
                break;
        }

    }

    private void checkFIleOnButtonClicked(View v) {
        if (datum != null) {
            if (absolutePath != null) {
                presenter.onFileUpload(absolutePath, v);
            }
            else {
                presenter.onAddUpdateClicked(this);
            }
        } else {
            if(absolutePath!=null)
                presenter.onFileUpload(absolutePath, v);
            else
                presenter.onAddUpdateClicked(this);
        }
    }

    private void checkEveryPermissions() {

        canStorage = hasStoragePermission();
    }

    @AfterPermissionGranted(RC_STORAGE)
    private void checkStoragePerm() {
        permissions = getStoragePermission();
        if (!hasStoragePermission()) {
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_no_permission), RC_STORAGE, permissions);
        }
    }


    private boolean hasStoragePermission() {
        if (EasyPermissions.hasPermissions(this, getStoragePermission())) {
            canStorage = true;
        }
        return canStorage;
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
    public String getFilePath() {
        return mTxtFileName.getText().toString();
    }

    @Override
    public void onSuccess(String message) {
        UtilSnackbar.showSnakbarTypeTwo(mBtnAdd, message);
        setResult(RESULT_OK);
        onBackPressed();

//        if(datum!=null)
//            EventBus.getDefault().post("Babu");
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void showFabProgress() {
        mProgressFab.setVisibility(View.VISIBLE);

    }

    @SuppressLint("RestrictedApi")
    @Override
    public void hideFabProgress() {
        mProgressFab.setVisibility(View.GONE);


    }

    @Override
    public void onTitleInvalid(String err) {
        mEdtProductTitle.setError(err);

    }

    @Override
    public void onDescriptionInvalid(String err) {
        mEdtProductDescription.setError(err);


    }

    @Override
    public void onFileInvalid(String err) {
        mTxtFileName.setError(err);


    }

    @Override
    public void onFail(String message) {
        UtilSnackbar.showSnakbarTypeFail(mBtnAdd, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.onFileUpload(absolutePath, view);

            }
        });

    }

    @Override
    public void onError(Object t) {
        UtilSnackbar.showSnakbarTypeFail(mBtnAdd, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.onFileUpload(absolutePath, view);
            }
        });

    }

    @Override
    public void onNoInternet() {
        UtilSnackbar.showSnakbarTypeFail(mBtnAdd, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.onFileUpload(absolutePath, view);

            }
        });

    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
        mBtnAdd.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
        mBtnAdd.setVisibility(View.VISIBLE);

    }

    private void showFileManager() {
        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)

        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType(MIME_TYPE_PDF);
//        intent.putExtra(Intent.EXTRA_MIME_TYPES, MIME_TYPE_PDF);
        startActivityForResult(intent, READ_REQUEST_CODE);
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
                    String newFileName = timeStamp + getFilenameFromMimetype(selectedMimeType);

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
                        File oFile = new File(new File(Environment.getExternalStorageDirectory(), "Caldreys App"), newFileName);

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
        }
    }

    private String getFilenameFromMimetype(String selectedMimeType) {
        if (selectedMimeType.equalsIgnoreCase(MIME_TYPE_PDF)) {
            return ".pdf";
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

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK);
        super.onBackPressed();

    }

    private void setFileData(String absolutePath) {
        mTxtFileName.setVisibility(View.VISIBLE);
        if (datum == null)
            this.absolutePath = absolutePath;
        mTxtFileName.setText(new File(absolutePath).getName());
//        mFabFile.setImageResource(R.drawable.ic_check_24dp);
//        mImgPdf.setImageResource(0);
//        mImgPdf.setBackgroundResource(R.drawable.ic_pdfs);
        mTxtFileName.setError(null);
        mFabFile.show();
        mFabFile.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pdfs));
        mTxtPercentage.setVisibility(View.GONE);

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
        String ext = "." + MIME_TYPE_PDF;
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
