package com.itg.calderysapp.caldConnect.gallery;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.gallery.mvp.GalleryMVP;
import com.itg.calderysapp.caldConnect.gallery.mvp.GalleryPresenterImp;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.UtilSnackbar;
import com.itg.calderysapp.home.HomeActivity;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.widget.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment implements ItemViewHolder.onItemClickedLisner, GalleryMVP.GalleryView, CommonInterface.BackpressListner, SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private static final String TAG = "GalleryFragment";
    private static final int RC_EDIT = 65;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    HashMap<String, List<GalleryData>> listHashMap = new HashMap<>();
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<GalleryData> listGallery;
    private boolean isViewEnable = false;
    private GalleryMVP.GalleryPresenter presenter;
    private FragmentManager fm;
    private Context context;
    private CommonInterface.hideShowFabListner listner;
    private CommonInterface.BackpressListner backpressListner;
    private SectionedRecyclerViewAdapter sectionAdapter;
    CommonInterface.ShowSearchMenu searchListner;
    private boolean isItemLoaded = false;


    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(List<GalleryData> param1) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, (ArrayList<? extends Parcelable>) param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static GalleryFragment newInstance(String s, String s1) {
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listGallery = getArguments().getParcelableArrayList(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        presenter = new GalleryPresenterImp(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        unbinder = ButterKnife.bind(this, view);
        setSwipeRefresh();
        return view;
    }

    private void setSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        if (isItemLoaded)
            swipeRefreshLayout.setRefreshing(false);
        else
            swipeRefreshLayout.setRefreshing(true);

    }

    private void initAll() {
        presenter.setAllViewAvailable(this);
        presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
        isViewEnable = true;
        getArrangeData();
    }

    private void getArrangeData() {

        if (listGallery != null && listGallery.size() > 0) {
            listHashMap.clear();
            for (GalleryData data : listGallery
                    ) {
                if (!listHashMap.containsKey(data.getUploadDate())) {
                    listHashMap.put(data.getUploadDate(), new ArrayList<>());
                }
                listHashMap.get(data.getUploadDate()).add(data);
            }
        }

        Log.d(TAG, "getArrangeData: hashmapList" + new Gson().toJson(listHashMap));
        if (listHashMap != null && listHashMap.size() > 0)
            setRecyclerview(listHashMap);


    }

    private void setRecyclerview(HashMap<String, List<GalleryData>> listHashMap) {
        sectionAdapter = new SectionedRecyclerViewAdapter();
        for (Map.Entry<String, List<GalleryData>> entry : listHashMap.entrySet()) {
            String key = entry.getKey();
            List<GalleryData> value = entry.getValue();

            // do what you have to do here
            // In your case, another loop.

            sectionAdapter.addSection(new GallerySection(key, value, getActivity(), sectionAdapter, this));
        }


        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (sectionAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 2;
                    default:
                        return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(sectionAdapter);


    }

    private String getDataKey(HashMap<String, List<GalleryData>> galleryData) {
        for (Map.Entry<String, List<GalleryData>> entry : galleryData.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            return entry.getKey();
        }

        return null;
    }


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        isViewEnable = false;
        isItemLoaded = false;
        super.onDestroyView();
        presenter.onDestroy();


    }


    @Override
    public void onItemClicked(int position, GalleryData list) {
        callFragment(list, position);
    }

    @Override
    public void onDeleteSucess(String message) {
        if (isViewEnable)
            presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
    }

    private void callFragment(GalleryData list, int position) {
//        Log.d(TAG, "callFragment: list"+new Gson().toJson(list));


////        if (fm == null)
////            fm = getActivity().getSupportFragmentManager();
////        FragmentTransaction ft = fm
////                .beginTransaction();
////        ft.replace(R.id.frame_container, GelleryDetailsFragment.newInstance(list, position), GelleryDetailsFragment.class.getSimpleName());
////        ft.addToBackStack(GelleryDetailsFragment.class.getSimpleName());
////        ft.commit();

        Intent intent = new Intent(getActivity(), GalleryDetailsActivity.class);
        intent.putExtra(CommonMethod.FROM_GALLERY, "");
        intent.putExtra(CommonMethod.FROM_GALLERY_LIST, list);
        intent.putExtra(CommonMethod.FROM_GALLERY_POSITION, position);
        startActivityForResult(intent, RC_EDIT);
    }

    private List<GalleryData> getDataValue(HashMap<String, List<GalleryData>> galleryData) {
        for (Map.Entry<String, List<GalleryData>> entry : galleryData.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            return entry.getValue();
        }
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        listner = (CommonInterface.hideShowFabListner) this.context;
        searchListner = (CommonInterface.ShowSearchMenu) this.context;
        ((HomeActivity) getActivity()).attachedListener(backpressListner);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            ((HomeActivity) getActivity()).menuSearchHideShow();
            listner.onFabShowListner(3);
            setSwipeRefresh();
            initAll();
        }


    }

    @Override
    public void onPause() {
        super.onPause();
        listner.onFabHideListner();
        isItemLoaded = false;


    }


    @Override
    public void onSuccessImages(List<GalleryData> model) {
        if (isViewEnable) {
            listGallery = model;
            isItemLoaded = true;
            swipeRefreshLayout.setRefreshing(false);



            if (listGallery != null && listGallery.size() > 0) {

                getArrangeData();


            }


        }
    }

    @Override
    public void onFail(String message) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mRecyclerView, message, new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
                }
            });
        }

    }

    @Override
    public void onError(Object t) {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mRecyclerView, t.toString(), new UtilSnackbar.OnSnackbarActionClickListener() {
                        @Override
                        public void onRetryClicked() {
                            presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
                        }
                    }

            );
        }

    }

    @Override
    public void onNoInternet() {
        if (isViewEnable) {
            UtilSnackbar.showSnakbarTypeFail(mRecyclerView, "No InternetConnect", new UtilSnackbar.OnSnackbarActionClickListener() {
                @Override
                public void onRetryClicked() {
                    presenter.onDownloadImages(CommonMethod.TBL_IMAGES);

                }
            });
        }

    }


    @Override
    public void showProgress() {
        if (isViewEnable) {
            mProgress.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }

    }

    @Override
    public void hideProgress() {
        if (isViewEnable) {
            mProgress.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (RC_EDIT == requestCode) {
            if (resultCode == RESULT_OK) {
                presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
            }
        }
    }

    @Override
    public void onBackPressListener() {
        presenter.onDownloadImages(CommonMethod.TBL_IMAGES);
    }

    @Override
    public void hideLlBottom() {

    }

    @Override
    public void showLlBottom() {

    }

    @Override
    public void onRefresh() {

        initAll();
    }
}
