package com.itg.calderysapp.caldConnect.gallery;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.itg.calderysapp.R;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.widget.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GelleryDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GelleryDetailsFragment extends Fragment implements ViewPagerImageAdapter.ImageClickedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    @BindView(R.id.view_pager)
    AutoScrollViewPager mViewPager;
    Unbinder unbinder;
    @BindView(R.id.img_delete)
    ImageView mImgDelete;
    @BindView(R.id.img_edit)
    ImageView mImgEdit;

    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<GalleryData> list;
    private boolean isViewEnable = false;
    private int position;
    private GalleryData data;
    private ViewPagerImageAdapter mAdapter;


    public GelleryDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1   Parameter 1.
     * @param position
     * @return A new instance of fragment GelleryDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GelleryDetailsFragment newInstance(List<GalleryData> param1, int position) {
        GelleryDetailsFragment fragment = new GelleryDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, (ArrayList<? extends Parcelable>) param1);
        args.putInt(ARG_PARAM2, position);
        fragment.setArguments(args);
        return fragment;
    }

    public static GelleryDetailsFragment newInstance(GalleryData param1, int position) {
        GelleryDetailsFragment fragment = new GelleryDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM3, param1);
        args.putInt(ARG_PARAM2, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            list = getArguments().getParcelableArrayList(ARG_PARAM1);
            data = getArguments().getParcelable(ARG_PARAM3);
            position = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gellery_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        isViewEnable = true;

        setView();
        return view;
    }

    private void setView() {
        if (isViewEnable) {
            if (list != null&& list.size()>0)
                mAdapter = new ViewPagerImageAdapter(getActivity(), list, this);
            else
                mAdapter = new ViewPagerImageAdapter(getActivity(), data, this);

//            mViewPager.setCurrentItem(position, true);

//            mAdapter.setItem(position);
            mViewPager.setAdapter(mAdapter);


            mViewPager.startAutoScroll(15000);
        }




}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        isViewEnable = false;

    }

    @Override
    public void onItemClicked(int position, GalleryData datum) {
        mLlBottom.setVisibility(View.VISIBLE);

    }
}
