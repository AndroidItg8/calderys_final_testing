package com.itg.calderysapp.caldConnect.pds;

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
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.CompleteResultModel;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSAddPresenterImp;
import com.itg.calderysapp.caldConnect.pds.mvp.PDSMVP;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.db.DatabaseCallback;
import com.itg.calderysapp.db.FamilyGroupRepository;
import com.itg.calderysapp.db.ProductTypeRepository;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;
import com.itg.calderysapp.widget.CircularProgressView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class PDSActivity extends AppCompatActivity implements PDSMVP.PDSAddView, View.OnClickListener, RadioGroup.OnCheckedChangeListener, EasyPermissions.PermissionCallbacks, AdapterView.OnItemSelectedListener {

    public static final String MIME_TYPE_PDF = "application/pdf";
    private static final String TAG = PDSActivity.class.getSimpleName();
    private static final int READ_REQUEST_CODE = 234;
    private static final int RC_STORAGE = 890;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_fileName)
    TextView txtFileName;
    @BindView(R.id.fab_file)
    FloatingActionButton fabFile;
    @BindView(R.id.txt_percentage)
    TextView txtPercentage;
    @BindView(R.id.progress_fab)
    CircularProgressView progressFab;
    @BindView(R.id.rl_image)
    FrameLayout rlImage;
    @BindView(R.id.lbl_pds)
    TextView lblPds;
    @BindView(R.id.edtProductTitle)
    TextInputEditText edtProductTitle;
    @BindView(R.id.input_layout_product)
    TextInputLayout inputLayoutProduct;
    @BindView(R.id.SearchableSpinner)
    Spinner SearchableSpinner;
    @BindView(R.id.SearchableSpinnerFamilyGroup)
    Spinner SearchableSpinnerFamilyGroup;
    @BindView(R.id.rd_public)
    RadioButton rdPublic;
    @BindView(R.id.rd_crendtail)
    RadioButton rdCrendtail;
    @BindView(R.id.rdFileGroup)
    RadioGroup rdFileGroup;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.progress)
    ProgressBar progress;

    private PDSMVP.PDSAddPresenter presenter;
    private List<TblFamilyGroup> listFamily;
    private List<TblProductType> listProduct;
    private TblProductType productType = null;
    private TblFamilyGroup FamilyGruop = null;
    private String fileType = "Public";
    private String absolutePath = null;

    private CustomArrayFamilyAdapter adapter;
    private CustomArrayProductAdapter adapterProduct;
    private boolean canStorage = false;
    private String[] permissions;
    private Data data;
    private boolean isItemProductSelect = false;
    private boolean isFamilyItemSelected = false;

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
        setContentView(R.layout.activity_pds);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.title_pds));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setDrawable();
        SearchableSpinner.setOnItemSelectedListener(this);
        SearchableSpinnerFamilyGroup.setOnItemSelectedListener(this);

        getProductTypeFromDatabase();
        getFamilyGroupFromDatabase();
        checkEveryPermissions();
        init();
        if (isFamilyItemSelected) {
            SearchableSpinnerFamilyGroup.setSelection(0, false);
            SearchableSpinnerFamilyGroup.setSelection(0);
            SearchableSpinnerFamilyGroup.setOnItemSelectedListener(this);
        }

        if (isItemProductSelect) {
            SearchableSpinner.setSelection(0, false);
            SearchableSpinner.setSelection(0);
            SearchableSpinner.setOnItemSelectedListener(this);
        }


    }

    private void setDrawable() {
        CommonMethod.setBackgroundDrawable(SearchableSpinner, R.drawable.bg_cus_spinner,0);
        CommonMethod.setBackgroundDrawable(SearchableSpinnerFamilyGroup, R.drawable.bg_cus_spinner,0);
    }

    @Override
    public void onSuccessFamilyGroupe(List<TblFamilyGroup> message) {
        listFamily =message;
        adapter.updateList(listFamily);
        if(data!=null)
            setFamilyGroupForEdit(data);

    }

    private void init() {

        presenter = new PDSAddPresenterImp(this, this);
        presenter.onDownloadSpinner();

//        setFileTypeSpinner();

        rdFileGroup.setOnCheckedChangeListener(this);
        progressFab.setProgressColor(ContextCompat.getColor(this, R.color.colorAccent));
        btnAdd.setOnClickListener(this);
        fabFile.setOnClickListener(this);
        checkIntent();

    }

    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_EDIT)) {
            data = getIntent().getParcelableExtra(CommonMethod.FROM_EDIT);
            setView(data);
        } else if (getIntent().hasExtra(CommonMethod.FROM_NOTIFICATION_PDS)) {
            data = getIntent().getParcelableExtra(CommonMethod.FROM_NOTIFICATION_PDS);
            setView(data);

        }
    }

    private void setView(Data data) {
        edtProductTitle.setText(data.getProductName());
        if (data.getShare().equalsIgnoreCase("public")) {
            rdPublic.setChecked(true);
        } else {
            rdCrendtail.setChecked(true);
        }


        if (data.getFile() != null && !TextUtils.isEmpty(data.getFile())) {
            String filePath = Environment.getExternalStorageDirectory() + "/" + "Caldreys App" + "/" + data.getFile();
            if (!TextUtils.isEmpty(filePath))
                createDocumentFile(filePath);
        }


    }


    private void setProductTypeForEdit(Data data) {
        SearchableSpinner.setOnItemSelectedListener(this);
        int itemPosition = adapterProduct.getItemPosition(data.getProductType(), SearchableSpinner);
        Log.d(TAG, "setView:  iTem" + itemPosition);
        if (itemPosition > 0) {
            SearchableSpinner.setSelection(itemPosition);
            productType = adapterProduct.getItem(itemPosition);
            isItemProductSelect = true;
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

    private void setFileTypeSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Public");
        data.add("Credentail");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        data); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
//        spinnerFileType.setAdapter(spinnerArrayAdapter);
//        spinnerFileType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////                fileType = spinnerArrayAdapter.getItem(position);
//               long ids=  spinnerArrayAdapter.getItemId(position);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    private void getFamilyGroupFromDatabase() {
        if (listFamily != null && listFamily.size() > 0) {
            setSpinnerDataForFamilyGroup(listFamily);

        } else {
            FamilyGroupRepository familyGroupRepository = new FamilyGroupRepository(MyApplication.getInstance());
            familyGroupRepository.getFamilyGroup(new DatabaseCallback.FamilyDatabaseCallback() {


                @Override
                public void onFamilyGroup(List<TblFamilyGroup> users) {
//                    setSpinnerDataForFamilyGroup(users);
                    if (users != null) {
                        adapter = new CustomArrayFamilyAdapter(PDSActivity.this, users);
                        SearchableSpinnerFamilyGroup.setAdapter(adapter);
                        if (data != null)
                            setFamilyGroupForEdit(data);
                    }

                }
            });

//            if(isFamilyItemSelected) {
//                SearchableSpinnerFamilyGroup.setSelection(0, false);
//                SearchableSpinnerFamilyGroup.setSelection(0);
//                SearchableSpinnerFamilyGroup.setOnItemSelectedListener(this);
//            }


        }


    }

    private void setFamilyGroupForEdit(Data data) {
        SearchableSpinnerFamilyGroup.setOnItemSelectedListener(this);


        int itemPosition = adapter.getItemPosition(data.getFamilyGroup(), SearchableSpinnerFamilyGroup);
//        Log.d(TAG, "setView: adater iTem" + adapter.getItem(itemPosition));
        if (itemPosition > 0) {
            SearchableSpinnerFamilyGroup.setSelection(itemPosition);
            FamilyGruop = adapter.getItem(itemPosition);
            isFamilyItemSelected = true;
        }


//        adapter.getItem(itemPosition);


    }

    private synchronized void getProductTypeFromDatabase() {
        if (listProduct != null && listProduct.size() > 0) {
            //setSpinnerDataForProductType(listProduct);

        } else {

            ProductTypeRepository repository = new ProductTypeRepository(MyApplication.getInstance());
            repository.getProductType(new DatabaseCallback.ProductDatabaseCallback() {
                @Override
                public void onProductType(List<TblProductType> users) {
                    if (users != null) {
                        adapterProduct = new CustomArrayProductAdapter(getApplicationContext(), users);
                        SearchableSpinner.setAdapter(adapterProduct);
                        if (data != null)
                            setProductTypeForEdit(data);
                    }
                }
            });


//            viewModel = new ProductTypeViewModel(MyApplication.getInstance());
//            if (viewModel.getAllProductType() != null) {
//                adapterProduct = new SpinnerTypeListAdapter(this, viewModel.getAllProductType());
//                searchableSpinner.setAdapter(adapterProduct);
//                 if (data != null)
//                    setProductTypeForEdit(data);
//
////            setSpinnerDataForProductType(viewModel.getAllProductType());
//            }


        }


    }

    private void setSpinnerDataForProductType(List<TblProductType> data) {
        adapterProduct = new CustomArrayProductAdapter(getApplicationContext(), data);


//        SearchableSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(View view, int position, long id) {
////            Toast.makeText(this, "Item on position " + position + " : " + adapter.getItem(position) + " Selected", Toast.LENGTH_SHORT).show();
//                Toast.makeText(PDSActivity.this, " Item on position \" + position" + adapterProduct.getItem(position), Toast.LENGTH_SHORT).show();
////                String productType = adapter.getItem(position);
//                Object obj = adapterProduct.getItem(position);
//
//            }
//
//            @Override
//            public void onNothingSelected() {
//                Toast.makeText(PDSActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
////            Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
//            }
//        });
//        SearchableSpinner.setStatusListener(new IStatusListener() {
//            @Override
//            public void spinnerIsOpening() {
//                SearchableSpinner.hideEdit();
//            }
//
//            @Override
//            public void spinnerIsClosing() {
//
//            }
//        });

        SearchableSpinner.setAdapter(adapterProduct);


//        SearchableSpinner.setSelection(false);


    }


    @Override
    public String getProductName() {
        return edtProductTitle.getText().toString();
    }

    @Override
    public String getFileType() {
        return fileType;
    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        btnAdd.setVisibility(View.GONE);


    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
        btnAdd.setVisibility(View.VISIBLE);


    }

    @Override
    public String getFamilyGroup() {
        return FamilyGruop != null ? FamilyGruop.getGroupName() : null;
    }

    @Override
    public String getProductType() {
        return productType != null ? productType.getProductType() : null;
    }

    @Override
    public void onSuccess(List<TblProductType> message) {


        //        Log.d(TAG, "onSuccess: " + new Gson().toJson(model));
//

        /**
         * Changed it now  due to error of 500 internal server error cused two api called  contuine
         */

//

        listProduct = message;

//        Log.d(TAG, "onSuccess: " + new Gson().toJson(listFamily));
//        Log.d(TAG, "onSuccess: " + new Gson().toJson(listProduct));
//        setSpinnerDataForFamilyGroup(listFamily);
//        setSpinnerDataForProductType(listProduct);
        adapterProduct.updateList(listProduct);

        if (data != null) {
            setProductTypeForEdit(data);
        }
        presenter.onDownloadFamily();


//        getProductTypeFromDatabase();
//        getFamilyGroupFromDatabase();

    }

    private void setSpinnerDataForFamilyGroup(List<TblFamilyGroup> list) {
        adapter = new CustomArrayFamilyAdapter(PDSActivity.this, list);
        SearchableSpinnerFamilyGroup.setAdapter(adapter);
        }

    @Override
    public void onFail(String message) {
        UtilSnackbar.showSnakbarTypeFail(btnAdd, message, new UtilSnackbar.OnSnackbarActionClickListener() {
            @Override
            public void onRetryClicked() {
                presenter.onDownloadSpinner();
            }
        });


    }

    @Override
    public void onError(Object t) {
        UtilSnackbar.showSnakbarTypeTwo(btnAdd, t.toString());
    }

    @Override
    public void onProductNameInvalid(String err) {
        edtProductTitle.setError(err);

    }

    @Override
    public void onProductTypeInvalid(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onProductFamilyGroupInvalid(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onProductFileTypeInvalid(String err) {
        txtFileName.setError(err);


    }

    @Override
    public void showFabProgress() {
        progressFab.setVisibility(View.VISIBLE);

    }

    @Override
    public void onFileInvalid(String invalid_file_path) {
        txtFileName.setError(invalid_file_path);


    }

    @Override
    public void setData(Data message) {
        this.data = message;
    }

    @Override
    public String getFilePath() {
        return txtFileName.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if (data != null) {
                    //this means its from edit. We have to check whether absolutePath is null or not. if its
                    //null means user not edited file when submit. And if absoluteth is avail that means file has
                    //changed and need to upload it first
                    if (absolutePath != null) {
                        presenter.onFileUpload(absolutePath, v);
                    } else {
                        presenter.onSubmitbtnClicked(this);
                    }
                } else {
                    if (absolutePath != null)
                        presenter.onFileUpload(absolutePath, v);

                    else
                        presenter.onSubmitbtnClicked(this);
                }

//                if (datum != null) {
//                    if (absolutePath != null) {
//                        presenter.onFileUpload(absolutePath, v);
//                    }
//                    else {
//                        presenter.onAddUpdateClicked(this);
//                    }
//                } else {
//                    if(absolutePath!=null)
//                        presenter.onFileUpload(absolutePath, v);
//                    else
//                        presenter.onAddUpdateClicked(this);
//                }
                break;
            case R.id.fab_file:
                if (canStorage)
                    showFileManager();
                else
                    checkStoragePerm();
                break;
        }

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
        intent.setType("*/*");
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
        txtFileName.setVisibility(View.VISIBLE);
        if (!isFromEdit())
            this.absolutePath = absolutePath;
        txtFileName.setText(new File(absolutePath).getName());
//        mFabFile.setImageResource(R.drawable.ic_check_24dp);
//        mImgPdf.setImageResource(0);
//        mImgPdf.setBackgroundResource(R.drawable.ic_pdfs);
        txtFileName.setError(null);
        fabFile.show();
        fabFile.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_pdfs));
        txtPercentage.setVisibility(View.GONE);
//        mFabFile.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_check_24dp));
//        document.setFileActPath(absolutePath);
//        document.setFileName(new File(absolutePath).getName());
//        document.setFileExt(Helper.getFileExtFromName(document.getFileName()));


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
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File pdf = File.createTempFile(
                pdfFileName,  /* prefix */
                ext,         /* suffix */
                storageDir /* directory */
        );
        Log.d(TAG, "createDocumentTempFile: DocumentFile:" + pdf.getAbsolutePath());
        // Save a file: path for use with ACTION_VIEW intents
        return pdf;
    }

    @Override
    public void hideFabProgress() {
        progressFab.setVisibility(View.GONE);
        progressFab.setProgress(100);

    }

    @Override
    public void onSuccessSave(String s) {
        if (getID() != null) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(btnAdd, s, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    setResult(RESULT_OK);
                    onBackPressed();

                }
            });
        } else {
            presenter.getFirstPDSItem();
        }
        //    throw new IllegalStateException("Tesing snackbar flow comming direction");


    }

    @Override
    public String getID() {
        return data != null ? data.getId() : null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onSuccessFile(String message) {
        String[] split = message.split("/");
//        String s0 = split[0];
//        String s = split[2];
//        String s3 = split[3];

        String s; //= split[4];
        s=split[split.length-1];
//        String s1 = split[1];
        Log.d(TAG, "onSuccessFile: file"+message +" splite "+s);
        txtFileName.setVisibility(View.VISIBLE);
        txtFileName.setText(s);
        presenter.onSubmitbtnClicked(this);
    }

    private boolean isFromEdit() {
        return data != null;
    }


    @Override
    public void onProgressUpdate(int prrogress) {
//        progressFab.setTotalTextView(mTxtPercentage);
        progressFab.setProgress(prrogress);
        txtPercentage.setVisibility(View.VISIBLE);
        txtPercentage.setText(String.valueOf(prrogress));
        Log.d(TAG, "onProgressUpdate: progress" + prrogress);
        fabFile.setImageDrawable(null);
    }

    @Override
    public void failedFileUpload() {
        progressFab.setProgress(0);
        txtPercentage.setText("0");


        txtPercentage.setVisibility(View.VISIBLE);
        fabFile.setImageDrawable(null);
        txtPercentage.setText("100");
//        progressFab.setTotalTextView(txtPercentage);

        UtilSnackbar.showSnakbarRedColor(btnAdd, "File Uploaded");

    }

    @Override
    public void onFinishedFileUpload() {
        UtilSnackbar.showSnakbarRedColor(btnAdd, "Failed to UploadFile");
        progressFab.setProgress(100);
        txtPercentage.setVisibility(View.VISIBLE);
        fabFile.setImageDrawable(null);
        txtPercentage.setText("100");

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rd_public:
                fileType = "Public";
                break;
            case R.id.rd_crendtail:
                fileType = "Credential";

                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;


//        productType=new TblProductType();
//        FamilyGruop=new TblFamilyGroup();

        if (spinner.getId() == R.id.SearchableSpinner) {


            productType = (TblProductType) adapterProduct.getItem(position);
            //  Toast.makeText(PDSActivity.this, "onItemSelect" + new Gson().toJson(adapterProduct.getItem(position)), Toast.LENGTH_SHORT).show();

        } else if (spinner.getId() == R.id.SearchableSpinnerFamilyGroup) {
            FamilyGruop = (TblFamilyGroup) adapter.getItem(position);
            //  Toast.makeText(PDSActivity.this, "onItemSelect" + new Gson().toJson(FamilyGruop), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
