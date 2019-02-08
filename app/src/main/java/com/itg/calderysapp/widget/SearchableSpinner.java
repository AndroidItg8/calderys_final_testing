package com.itg.calderysapp.widget;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.widget.interfaces.ISpinnerSelectedView;
import com.itg.calderysapp.widget.interfaces.IStatusListener;
import com.itg.calderysapp.widget.interfaces.OnItemSelectedListener;

/**
 * Created by michael on 1/8/17.
 */

public class SearchableSpinner extends RelativeLayout implements View.OnClickListener {

    private static final int DefaultElevation = 16;
    private static final int DefaultAnimationDuration = 400;
    private ViewState mViewState = ViewState.ShowingRevealedLayout;
    private IStatusListener mStatusListener;
    private CardView mRevealContainerCardView;
    private LinearLayout mRevealItem;
    private ImageView mStartSearchImageView;

    private CardView mContainerCardView;
    private AppCompatEditText mSearchEditText;
    private ImageView mDoneSearchImageView;
    private LinearLayout mSpinnerListContainer;
    private PopupWindow mPopupWindow;
    private ListView mSpinnerListView;
    private TextView mEmptyTextView;

    private Context mContext;
    private OnItemSelectedListener mOnItemSelected;
    private SelectedView mCurrSelectedView;
    private int mScreenHeightPixels;
    private int mScreenWidthPixels;

    /* Attributes */
    private @ColorInt int mRevealViewBackgroundColor;
    private @ColorInt int mStartEditTintColor;
    private @ColorInt int mEditViewBackgroundColor;
    private @ColorInt int mEditViewTextColor;
    private @ColorInt int mDoneEditTintColor;
    private @ColorInt int mBoarderColor;
    private Drawable mListItemDivider;
    private @Px int mBordersSize;
    private @Px int mExpandSize;
    private @Px int mListDividerSize;
    private boolean mShowBorders;
    private boolean mKeepLastSearch;
    private String mRevealEmptyText;
    private String mSearchHintText;
    private String mNoItemsFoundText;
    private int mAnimDuration;

    public enum ViewState {
        ShowingRevealedLayout,
        ShowingEditLayout,
        ShowingAnimation
    }

//    static {
//        Iconify.with(new MaterialModule());
//    }
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchableSpinner(@NonNull Context context) {
        this(context, null);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchableSpinner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchableSpinner(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SearchableSpinner(@NonNull Context context, @Nullable AttributeSet attrs,
                             @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        getAttributeSet(attrs, defStyleAttr, defStyleRes);

        final LayoutInflater factory = LayoutInflater.from(context);
        factory.inflate(R.layout.view_searchable_spinner, this, true);

        mSpinnerListContainer = (LinearLayout) factory.inflate(R.layout.view_spinner_list, this, false);
        mSpinnerListView = (ListView) mSpinnerListContainer.findViewById(R.id.LstVw_SpinnerListView);
        if (mListItemDivider != null) {
            mSpinnerListView.setDivider(mListItemDivider);
            mSpinnerListView.setDividerHeight(mListDividerSize);
        }
        mEmptyTextView = (TextView) mSpinnerListContainer.findViewById(R.id.TxtVw_EmptyText);
        mSpinnerListView.setEmptyView(mEmptyTextView);
    }

    private void getAttributeSet(@Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        if (attrs != null) {
            try {
                TypedArray attributes = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.SearchableSpinner, defStyleAttr, defStyleRes);
                mRevealViewBackgroundColor = attributes.getColor(R.styleable.SearchableSpinner_RevealViewBackgroundColor, Color.WHITE);
                mStartEditTintColor = attributes.getColor(R.styleable.SearchableSpinner_StartSearchTintColor, Color.GRAY);
                mEditViewBackgroundColor = attributes.getColor(R.styleable.SearchableSpinner_SearchViewBackgroundColor, Color.WHITE);
                mEditViewTextColor = attributes.getColor(R.styleable.SearchableSpinner_SearchViewTextColor, Color.BLACK);
                mDoneEditTintColor = attributes.getColor(R.styleable.SearchableSpinner_DoneSearchTintColor, Color.GRAY);
                mBordersSize = attributes.getDimensionPixelSize(R.styleable.SearchableSpinner_BordersSize, 1);
                mExpandSize = attributes.getDimensionPixelSize(R.styleable.SearchableSpinner_SpinnerExpandHeight, 0);
                mShowBorders = attributes.getBoolean(R.styleable.SearchableSpinner_ShowBorders, false);
                mBoarderColor = attributes.getColor(R.styleable.SearchableSpinner_BoarderColor, Color.GRAY);
                mAnimDuration = attributes.getColor(R.styleable.SearchableSpinner_AnimDuration, DefaultAnimationDuration);
                mKeepLastSearch = attributes.getBoolean(R.styleable.SearchableSpinner_KeepLastSearch, false);
                mRevealEmptyText = attributes.getString(R.styleable.SearchableSpinner_RevealEmptyText);
                mSearchHintText = attributes.getString(R.styleable.SearchableSpinner_SearchHintText);
                mNoItemsFoundText = attributes.getString(R.styleable.SearchableSpinner_NoItemsFoundText);
                mListItemDivider = attributes.getDrawable(R.styleable.SearchableSpinner_ItemsDivider);
                mListDividerSize = attributes.getDimensionPixelSize(R.styleable.SearchableSpinner_DividerHeight, 0);
            } catch (UnsupportedOperationException e) {
                Log.e("SearchableSpinner", "getAttributeSet --> " + e.getLocalizedMessage());
            }
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mRevealContainerCardView = (CardView) findViewById(R.id.CrdVw_RevealContainer);
        mRevealContainerCardView.setOnClickListener(mOnRevelViewClickListener);
        mRevealItem = (LinearLayout) findViewById(R.id.FrmLt_SelectedItem);
        mStartSearchImageView = (ImageView) findViewById(R.id.ImgVw_StartSearch);

        mContainerCardView = (CardView) findViewById(R.id.CrdVw_Container);
        mSearchEditText = (AppCompatEditText) findViewById(R.id.EdtTxt_SearchEditText);
        mDoneSearchImageView = (ImageView) findViewById(R.id.ImgVw_DoneSearch);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        getScreenSize();
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (mShowBorders) {     // + 4 because of card layout_margin in the view_searchable_spinner.xml
            width -= CommonMethod.dpToPx(mContext, (mBordersSize + 4));
        } else {
            width -= CommonMethod.dpToPx(mContext, 8);
        }
        mPopupWindow.setWidth(width);
        if (mExpandSize <= 0) {
            mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        } else{
            mPopupWindow.setHeight(heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        requestLayout();
        super.onScrollChanged(l, t, oldl, oldt);
    }

    private void init() {
        setupColors();
        setupList();
        mSearchEditText.setImeOptions(EditorInfo.IME_ACTION_DONE | EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        mStartSearchImageView.setOnClickListener(this);
        mDoneSearchImageView.setOnClickListener(this);
        mSearchEditText.addTextChangedListener(mTextWatcher);

        mPopupWindow = new PopupWindow(mContext);
        mPopupWindow.setContentView(mSpinnerListContainer);
        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                hideEdit();
            }
        });
        mPopupWindow.setFocusable(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPopupWindow.setElevation(DefaultElevation);
        }
        mPopupWindow.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_arrow_drop_down_black_24dp));

        mSpinnerListView.setOnItemClickListener(mOnItemSelectedListener);
        if (mCurrSelectedView == null) {
            if (!TextUtils.isEmpty(mSearchHintText)) {
                mSearchEditText.setHint(mSearchHintText);
            }
            if (!TextUtils.isEmpty(mNoItemsFoundText)) {
                mEmptyTextView.setText(mNoItemsFoundText);
            }
            if (mCurrSelectedView == null && !TextUtils.isEmpty(mRevealEmptyText)) {
                TextView textView = new TextView(mContext);
                textView.setText(mRevealEmptyText);
                mCurrSelectedView = new SelectedView(textView, -1, 0);
                mRevealItem.addView(textView);
            }
        } else {
            mSpinnerListView.performItemClick(mCurrSelectedView.getView(), mCurrSelectedView.getPosition(), mCurrSelectedView.getId());
        }
        clearAnimation();
        clearFocus();
    }

    private AdapterView.OnItemClickListener mOnItemSelectedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (mCurrSelectedView == null) {
                Adapter adapter = parent.getAdapter();
                if (adapter instanceof ISpinnerSelectedView) {
                    View selectedView = ((ISpinnerSelectedView) adapter).getSelectedView(position);
                    mCurrSelectedView = new SelectedView(selectedView, position, selectedView.getId());
                } else {
                    mCurrSelectedView = new SelectedView(view, position, id);
                }
                mSpinnerListView.setSelection(position);
            } else {
                Adapter adapter = parent.getAdapter();
                if (adapter instanceof ISpinnerSelectedView) {
                    View selectedView = ((ISpinnerSelectedView) adapter).getSelectedView(position);
                    mCurrSelectedView = new SelectedView(selectedView, position, selectedView.getId());
                } else {
                    mCurrSelectedView.setView(view);
                    mCurrSelectedView.setPosition(position);
                    mCurrSelectedView.setId(id);
                }
                mSpinnerListView.setSelection(position);
            }
            if (mCurrSelectedView == null) {
                if (mOnItemSelected != null)
                    mOnItemSelected.onNothingSelected();
            } else if (mCurrSelectedView != null) {
                mRevealItem.removeAllViews();
                mSpinnerListView.removeViewInLayout(mCurrSelectedView.getView());
                mRevealItem.addView(mCurrSelectedView.getView());
                ((BaseAdapter) mSpinnerListView.getAdapter()).notifyDataSetChanged();
                if (mOnItemSelected != null)
                    mOnItemSelected.onItemSelected(mCurrSelectedView.getView(), mCurrSelectedView.getPosition(), mCurrSelectedView.getId());
            }
            hideEdit();
        }
    };

    public Object getSelectedItem() {
        if (mCurrSelectedView != null) {
            int position = mCurrSelectedView.getPosition();
            Adapter adapter = mSpinnerListView.getAdapter();
            if (adapter != null && adapter.getCount() > 0 && position >= 0) {
                return adapter.getItem(position);
            } else {
                return null;
            }
        }
        return null;
    }

    public void setSelectedItem(int position) {
        Adapter adapter = mSpinnerListView.getAdapter();
        if (adapter instanceof ISpinnerSelectedView) {
            View selectedView = ((ISpinnerSelectedView) adapter).getSelectedView(position);
            mCurrSelectedView = new SelectedView(selectedView, position, selectedView.getId());
            mSpinnerListView.setSelection(position);
        } else {
            TextView textView = new TextView(mContext);
            textView.setText(mRevealEmptyText);
            mCurrSelectedView = new SelectedView(textView, -1, 0);
            mRevealItem.addView(textView);
        }
        if (mCurrSelectedView == null) {
            if (mOnItemSelected != null)
                mOnItemSelected.onNothingSelected();
        } else if (mCurrSelectedView != null) {
            mRevealItem.removeAllViews();
            mSpinnerListView.removeViewInLayout(mCurrSelectedView.getView());
            mRevealItem.addView(mCurrSelectedView.getView());
//            ((BaseAdapter) mSpinnerListView.getAdapter()).notifyDataSetChanged();
//            mSpinnerListView.getAdapter().
            //ChangedNow
            if (mOnItemSelected != null)
                mOnItemSelected.onItemSelected(mCurrSelectedView.getView(), mCurrSelectedView.getPosition(), mCurrSelectedView.getId());
        }
        hideEdit();
    }

    public int getItemPosition(Object item) {
        if (item == null)
            return -1;
        Adapter adapter = mSpinnerListView.getAdapter();
        if (adapter != null) {
            for (int i = 0; i < adapter.getCount(); i++) {
                Object adpItem = adapter.getItem(i);
                if (adpItem != null && adpItem.equals(item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void setSelectedItem(Object item) {
        int itemPosition = getItemPosition(item);
        if (itemPosition >= 0) {
            setSelectedItem(itemPosition);
            mSpinnerListView.setSelection(itemPosition);
        }
    }

    public int getSelectedPosition() {
        if (mCurrSelectedView != null) {
            return mCurrSelectedView.getPosition();
        }
        return -1;
    }

    private OnClickListener mOnRevelViewClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mViewState == ViewState.ShowingRevealedLayout) {
                revealEditView();
            } else if (mViewState == ViewState.ShowingEditLayout) {
                hideEditView();
            }
        }
    };

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Filterable filterable =  (Filterable) mSpinnerListView.getAdapter();
            if (filterable != null)
                filterable.getFilter().filter(s);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void setupColors() {
        mRevealContainerCardView.setBackgroundColor(mRevealViewBackgroundColor);
        mRevealItem.setBackgroundColor(mRevealViewBackgroundColor);
//        mStartSearchImageView.setBackgroundColor(mRevealViewBackgroundColor);
//        mStartSearchImageView.setTextColor(mStartEditTintColor);

        mContainerCardView.setBackgroundColor(mEditViewBackgroundColor);
        mSearchEditText.setBackgroundColor(mEditViewBackgroundColor);
        mSearchEditText.setTextColor(mEditViewTextColor);
        mSearchEditText.setHintTextColor(mStartEditTintColor);
//        EditCursorColor.setCursorColor(mSearchEditText, mEditViewTextColor);
//        mDoneSearchImageView.setBackgroundColor(mEditViewBackgroundColor);
//        mDoneSearchImageView.setTextColor(mDoneEditTintColor);
    }

    private void setupList() {
        MarginLayoutParams spinnerListViewLayoutParams = (MarginLayoutParams) mSpinnerListView.getLayoutParams();
        ViewGroup.LayoutParams spinnerListContainerLayoutParams = mSpinnerListContainer.getLayoutParams();
        LinearLayout.LayoutParams listLayoutParams = (LinearLayout.LayoutParams) mSpinnerListView.getLayoutParams();

        spinnerListContainerLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        if (mExpandSize <= 0) {
            listLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            listLayoutParams.height = mExpandSize;
        }
        mSpinnerListContainer.setBackgroundColor(mBoarderColor);
        if (mShowBorders && mBordersSize > 0) {
            spinnerListViewLayoutParams.setMargins(mBordersSize, mBordersSize, mBordersSize, mBordersSize);
        } else {
            spinnerListViewLayoutParams.setMargins(0, 0, 0, 0);
        }
    }

    public void setAdapter(ListAdapter adapter) {
        if (!(adapter instanceof Filterable))
            throw new IllegalArgumentException("Adapter should implement the Filterable interface");
        mSpinnerListView.setAdapter(adapter);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        mOnItemSelected = onItemSelectedListener;
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        hideEdit();
        getScreenSize();
    }

    private void getScreenSize() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        mScreenHeightPixels = metrics.heightPixels;
        mScreenWidthPixels = metrics.widthPixels;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ImgVw_StartSearch) {
            revealEdit();
        } else if (id == R.id.ImgVw_DoneSearch) {
            hideEdit();
        }
    }

    public void revealEdit() {
        if (mViewState == ViewState.ShowingRevealedLayout) {
            if (!mKeepLastSearch)
                mSearchEditText.setText(null);
            revealEditView();
        }
    }

    public void hideEdit() {
        if (mViewState == ViewState.ShowingEditLayout) {
            hideEditView();
        }
    }

    private void revealEditView() {
        mViewState = ViewState.ShowingAnimation;
        if (mStatusListener != null)
            mStatusListener.spinnerIsOpening();
        DrawableCompat.setTint(mStartSearchImageView.getDrawable(), ContextCompat.getColor(mContext, R.color.colorWhite));

        final int cx = mRevealContainerCardView.getLeft();
        final int cxr = mRevealContainerCardView.getRight();
        final int cy = (mRevealContainerCardView.getTop() + mRevealContainerCardView.getHeight())/2;
        final int reverse_startradius = Math.max(mRevealContainerCardView.getWidth(), mRevealContainerCardView.getHeight());
        final int reverse_endradius = 0;

        if (!mPopupWindow.isShowing())
            mPopupWindow.showAsDropDown(this, cx, 0);

        Animator revealAnimator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            revealAnimator = ViewAnimationUtils.createCircularReveal(mRevealContainerCardView, cx, cy, reverse_startradius, reverse_endradius);
        }
        revealAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mViewState = ViewState.ShowingEditLayout;
                DrawableCompat.setTint(mStartSearchImageView.getDrawable(), ContextCompat.getColor(mContext, R.color.colorBlack));

                mRevealContainerCardView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        Animator animator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            animator = ViewAnimationUtils.createCircularReveal(mContainerCardView, cxr, cy, reverse_endradius, reverse_startradius);
        }
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mContainerCardView.setVisibility(View.VISIBLE);
                mViewState = ViewState.ShowingEditLayout;
                DrawableCompat.setTint(mStartSearchImageView.getDrawable(), ContextCompat.getColor(mContext, R.color.colorBlack));

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mSpinnerListContainer.setVisibility(View.VISIBLE);
        mContainerCardView.setVisibility(View.VISIBLE);

        animator.setDuration(mAnimDuration);
        revealAnimator.setDuration(mAnimDuration);


        animator.start();
        revealAnimator.start();

        mPopupWindow.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mPopupWindow.getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Animator spinnerListContainerAnimator = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    spinnerListContainerAnimator = ViewAnimationUtils.createCircularReveal(mPopupWindow.getContentView(), cxr, cy, reverse_endradius, reverse_startradius);
                }
                spinnerListContainerAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mSpinnerListContainer.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                spinnerListContainerAnimator.setDuration(mAnimDuration);
                spinnerListContainerAnimator.start();
            }
        });

    }

    private void hideEditView() {
        mViewState = ViewState.ShowingAnimation;
        if (mStatusListener != null)
            mStatusListener.spinnerIsClosing();
        final int cx = mContainerCardView.getLeft();
        final int cxr = mContainerCardView.getRight();
        final int cy = (mContainerCardView.getTop() + mContainerCardView.getHeight())/2;
        final int reverse_startradius = Math.max(mContainerCardView.getWidth(), mContainerCardView.getHeight());
        final int reverse_endradius = 0;

        Animator revealAnimator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            revealAnimator = ViewAnimationUtils.createCircularReveal(mRevealContainerCardView, cx, cy, reverse_endradius, reverse_startradius);
        }
        revealAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mViewState = ViewState.ShowingRevealedLayout;
                mRevealContainerCardView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        Animator cardViewanimator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cardViewanimator = ViewAnimationUtils.createCircularReveal(mContainerCardView, cxr, cy, reverse_startradius, reverse_endradius);
        }
        cardViewanimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mContainerCardView.setVisibility(View.INVISIBLE);
                mViewState = ViewState.ShowingRevealedLayout;
                ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mSearchEditText.getWindowToken(), 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mRevealContainerCardView.setVisibility(View.VISIBLE);
        cardViewanimator.setDuration(mAnimDuration);
        cardViewanimator.start();

        revealAnimator.setDuration(mAnimDuration);
        revealAnimator.start();

        if (mPopupWindow.isShowing()) {
            Animator spinnerListContainerAnimator = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerListContainerAnimator = ViewAnimationUtils.createCircularReveal(mPopupWindow.getContentView(), cxr, cy, reverse_startradius, reverse_endradius);
            }
            spinnerListContainerAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mSpinnerListContainer.setVisibility(View.GONE);
                    mPopupWindow.dismiss();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            spinnerListContainerAnimator.setDuration(mAnimDuration);
            spinnerListContainerAnimator.start();
        }
    }

    public boolean isInsideSearchEditText(MotionEvent event) {
        Rect editTextRect = new Rect();
        mSearchEditText.getHitRect(editTextRect);
        if (!editTextRect.contains((int)event.getX(), (int)event.getY())) {
            return false;
        }
        return true;
    }

    public void setStatusListener(IStatusListener statusListener) {
        mStatusListener = statusListener;
    }



    static class SavedState extends BaseSavedState {
        ViewState mViewState;
        int mAnimDuration;
        @Px int mBordersSize;
        @Px int mExpandSize;
        @ColorInt int mBoarderColor;
        @ColorInt int mRevealViewBackgroundColor;
        @ColorInt int mStartEditTintColor;
        @ColorInt int mEditViewBackgroundColor;
        @ColorInt int mEditViewTextColor;
        @ColorInt int mDoneEditTintColor;
        boolean mShowBorders;
        boolean mKeepLastSearch;
        String mRevealEmptyText;
        String mSearchHintText;
        String mNoItemsFoundText;
        int mSelectedViewPosition;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            mViewState = ViewState.values()[in.readInt()];
            mAnimDuration = in.readInt();
            mBordersSize = in.readInt();
            mExpandSize = in.readInt();
            mBoarderColor = in.readInt();
            mRevealViewBackgroundColor = in.readInt();
            mStartEditTintColor = in.readInt();
            mEditViewBackgroundColor = in.readInt();
            mEditViewTextColor = in.readInt();
            mDoneEditTintColor = in.readInt();
            mShowBorders = in.readInt() > 0 ? true : false;
            mKeepLastSearch = in.readInt() > 0 ? true : false;
            mRevealEmptyText = in.readString();
            mSearchHintText = in.readString();
            mNoItemsFoundText = in.readString();
            mSelectedViewPosition = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(mViewState.ordinal());
            out.writeInt(mAnimDuration);
            out.writeInt(mBordersSize);
            out.writeInt(mExpandSize);
            out.writeInt(mBoarderColor);
            out.writeInt(mRevealViewBackgroundColor);
            out.writeInt(mStartEditTintColor);
            out.writeInt(mEditViewBackgroundColor);
            out.writeInt(mEditViewTextColor);
            out.writeInt(mDoneEditTintColor);
            out.writeInt(mShowBorders ? 1 : 0);
            out.writeInt(mKeepLastSearch ? 1 : 0);
            out.writeString(mRevealEmptyText);
            out.writeString(mSearchHintText);
            out.writeString(mNoItemsFoundText);
            out.writeInt(mSelectedViewPosition);
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
