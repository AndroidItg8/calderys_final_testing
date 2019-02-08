package com.itg.calderysapp.caldConnect.gallery;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.gallery.mvp.GalleryMVP;
import com.itg.calderysapp.caldConnect.gallery.mvp.GalleryPresenterImp;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.model.GalleryData;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.itg.calderysapp.common.CommonMethod.FROM_GALLERY;
import static com.itg.calderysapp.common.CommonMethod.FROM_GALLERY_DATA;
import static com.itg.calderysapp.common.CommonMethod.FROM_GALLERY_LIST;

public class GalleryDetailsActivity extends AppCompatActivity implements ViewPagerImageAdapter.ImageClickedListener, View.OnClickListener, GalleryMVP.GalleryView {

    private static final String TAG = "GalleryDetailsActivity";
    private static final int RC_EDIT = 67;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lbl_place_name)
    TextView lblPlaceName;
    @BindView(R.id.img_pager_item)
    ImageView imgPagerItem;
    @BindView(R.id.txt_description_edit)
    TextView txtDescriptionEdit;
    @BindView(R.id.img_delete)
    ImageView imgDelete;
    @BindView(R.id.img_edit)
    ImageView imgEdit;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.frm)
    FrameLayout frm;
    @BindView(R.id.rl_edit)
    RelativeLayout rlEdit;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private boolean isViewEnable = false;
    private BottomSheetBehavior bottomSheet = null;
    private GalleryData data = null;
    private GalleryPresenterImp presenter;
    private List<GalleryData> listGallery = new ArrayList<>();
    private boolean isFromHome = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        toolbar.setTitle(getString(R.string.photo_gallery));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setTitle("Manage photo Gallery");
        isViewEnable = true;
        presenter = new GalleryPresenterImp(this);
//        bottomSheet = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        setOnClickedListener();
        checkIntent();


    }

    private void descriptionShowHide(GalleryData data) {
        if (MyApplication.getInstance().isCommercialUser()) {
            llBottom.setVisibility(View.GONE);
        } else {

            if (data == null || TextUtils.isEmpty(data.getDiscription())) {
                txtDescriptionEdit.setVisibility(View.GONE);
            } else {
                txtDescriptionEdit.setVisibility(View.VISIBLE);
                setDescription(data);
            }

        }
    }


    private void setDescription(GalleryData data) {
        if (!TextUtils.isEmpty(data.getDiscription())) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                txtDescriptionEdit.setText(Html.fromHtml(data.getDiscription(), Html.FROM_HTML_MODE_COMPACT));
            } else {
                txtDescriptionEdit.setText(Html.fromHtml(data.getDiscription()));
            }
//
        }
    }

    private void setOnClickedListener() {
        imgDelete.setOnClickListener(this);
       imgEdit.setOnClickListener(this);
//        mImgSwipe.setOnClickListener(this);
    }

//

    private void checkIntent() {
        if (getIntent().hasExtra(FROM_GALLERY)) {
            this.listGallery.clear();

            data = getIntent().getParcelableExtra(FROM_GALLERY_LIST);
            int position = getIntent().getIntExtra(CommonMethod.FROM_GALLERY_POSITION, 0);
//            this.listGallery.addAll(list);
            setView(data, position, isFromHome);
        } else if (getIntent().hasExtra(CommonMethod.FROM_GALLERY_HOME)) {
            this.listGallery.clear();
            data = getIntent().getParcelableExtra(FROM_GALLERY_DATA);
            int position = getIntent().getIntExtra(CommonMethod.FROM_GALLERY_POSITION, 0);
            this.listGallery.add(data);
            setView(data, 0, isFromHome);

        }


    }


    private void setView(GalleryData list, int position, boolean isFromHome) {

        if (isViewEnable) {
          rlEdit.setVisibility(View.VISIBLE);


//            showHideBottomSheet(list);
            descriptionShowHide(list);
            setImageItem(list, position);


            ViewPagerImageAdapter mAdapter = new ViewPagerImageAdapter(this, list, this);

//            mAdapter.setItem(position);
//            mViewPager.setAdapter(mAdapter);
//            mViewPager.setCurrentItem(position, true);


//            mViewPager.stopAutoScroll();
//            mTxtDescriptionEdit.setText(null);
//            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                public void onPageScrollStateChanged(int state) {
//                    Log.d(TAG, "onPageScrollStateChanged: " + state);
//
//
//                }
//
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                    Log.d(TAG, "onPageScrolled: " + position);
//                    data = mAdapter.getItemValue(position);
//                    descriptionShowHide(data);
//
//
//
//
//                }
//
//
//                public void onPageSelected(int position) {
//                    // Check if this is the page you want.
//                    Log.d(TAG, "onPageScrolled: " + position);
//                }
//            });


        }
    }

    private void setImageItem(GalleryData list, int position) {
        lblPlaceName.setText(list.getTitle());
        Log.d(TAG, "setImageItem: " + new Gson().toJson(list));
//        http://192.168.1.56/calderyapp/files/Advertisement/download33.jpg
//        String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN + CommonMethod.FILDER_IMAGES + "/" + list.getFile().replaceAll(" ", "%20");
        String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN +"files/"+ CommonMethod.FILDER_IMAGES + "/" + list.getFile().replaceAll(" ", "%20");
        mainPath = mainPath.replaceAll(" ", "%20");
        Log.d(TAG, "instantiateItem: " + mainPath);
        String finalMainPath = mainPath;
        Picasso.get()
                .load(mainPath)
                .placeholder(R.drawable.calderys)
                .fit()
                .error(R.drawable.calderys)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imgPagerItem, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                        Picasso.get()
                                .load(finalMainPath)
                               .fit()
                                .into(imgPagerItem, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        Picasso.get()
                                                .load(R.drawable.calderys)
                                                .into((imgPagerItem));
                                    }
                                });

                    }
                });
    }

    @Override
    protected void onStop() {
//        if (mViewPager != null)
//            mViewPager.stopAutoScroll();
        super.onStop();
    }

    private void showHideBottomSheet(GalleryData data) {

        if (data.getDiscription() != null && !TextUtils.isEmpty(data.getDiscription())) {
           txtDescriptionEdit.setVisibility(View.VISIBLE);


        } else {
           txtDescriptionEdit.setVisibility(View.VISIBLE);

        }


    }


    @Override
    public void onItemClicked(int position, GalleryData datum) {
        if (isViewEnable)
           llBottom.setVisibility(View.VISIBLE);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.img_delete:
                presenter.deleteGallery(CommonMethod.TBL_IMAGES, data.getId());
                break;
            case R.id.img_edit:
                startGalleryActivity();
                break;
//                case R.id.img_swipe:
//                    checkBottomSheetStatus();
//                    break;
        }

    }

    private void checkBottomSheetStatus() {
        if (bottomSheet.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            bottomSheet.setPeekHeight(100);

        } else if (bottomSheet.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheet.setPeekHeight(40);

        }
    }

    private void startGalleryActivity() {
        if (isViewEnable) {
            Intent intent = new Intent(this, GalleryActivity.class);
            intent.putExtra(CommonMethod.FROM_GALLERY_DETAIL, data);
            startActivityForResult(intent, RC_EDIT);
        }
    }

    @Override
    public void onSuccessImages(List<GalleryData> model) {
//        if (isViewEnable)
//            setView(model, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RC_EDIT == requestCode) {
            if (resultCode == RESULT_OK) {
//                presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
                onBackPressed();
            }
        }
    }

    @Override
    public void onDeleteSucess(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeSuccessForCallPresnter(imgPagerItem, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    onBackPressed();
                    setResult(RESULT_OK);

                }
            });
        }
    }


    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(imgPagerItem, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.deleteGallery(CommonMethod.TBL_IMAGES, data.getId());

                }
            });
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(imgPagerItem, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            presenter.deleteGallery(CommonMethod.TBL_IMAGES, data.getId());
                        }
                    }

            );
        }

    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(imgPagerItem, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.deleteGallery(CommonMethod.TBL_IMAGES, data.getId());

                }
            });
        }

    }


    @Override
    public void showProgress() {
        if (isViewEnable) {
            progress.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void hideProgress() {
        if (isViewEnable) {
            progress.setVisibility(View.GONE);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void showLlBottom() {
        llBottom.setVisibility(View.VISIBLE);
    }

    public void hideLlBottom() {
        llBottom.setVisibility(View.GONE);
    }
}
