package com.itg.calderysapp.home;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.gallery.GalleryActivity;
import com.itg.calderysapp.caldConnect.pds.PDSActivity;
import com.itg.calderysapp.caldConnect.update.AddActivity;
import com.itg.calderysapp.caldNet.newIndent.Deetails.ViewDetailsActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIndentNewActivity;
import com.itg.calderysapp.caldNet.newIndent.createIntent.CreateIntentActivity;
import com.itg.calderysapp.caldNet.newIndent.home.HomeCalderysNetFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.ApproveIntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.IntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UserType;
import com.itg.calderysapp.login.LoginActivity;
import com.itg.calderysapp.notification.NotificationModel.Message;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseHomeActivity implements View.OnClickListener, CommonInterface.hideShowFabListner, SearchView.OnQueryTextListener, CommonInterface.hideFabListener, SearchView.OnCloseListener, CommonInterface.ShowSettingMenu, CommonInterface.ShowSearchMenu {

    private static final int RC_GALLERY = 23;
    private static final int RC_PDS = 98;
    private static final int RC_UPDATE = 75;
    private static final String TAG = "HomeActivity";
    private static final String CHANNEL_ID = "ssuuu";
    private static final int RC_HOME_NET = 67;
    private static final int RC_SETTING_NET = 34;
    @BindView(R.id.fab_home)
    public
    FloatingActionButton mFabHome;
    @BindView(R.id.frame_container)
    FrameLayout mFrameContainer;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    @BindView(R.id.container)
    CoordinatorLayout mContainer;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    private FragmentManager fm;
    private boolean allPermissionGranted = false;
    private Fragment fragment;
    private BottomNavigationView navigation;
    private CommonInterface.BackpressListner backpressListner;
    private SearchView searchView;
    private CommonInterface.SearchDataListener attachedSearchListener;
    private NotificationManager mNotificationManager;
    public MenuItem searchMenuItem = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        setSupportActionBar(mToolbar);
        setMenus(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mFabHome.setOnClickListener(this);

        if (AppType.isCaldConnect()) {
            init();
//            hideFab();
            checkCaldConnectNotificationIntent();
        } else {
            initCaldreysNet();
            checkCaldNetNotificationIntent();
        }

        checkLogin();
//        checkIntent();

        askForPermission();


    }

    private void checkCaldNetNotificationIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_NOTIFICATION)) {
            Message message = getIntent().getParcelableExtra(CommonMethod.FROM_NOTIFICATION);
            if (message.getCondition().getClasstype() == CommonMethod.CREATE_INDENT) {
                callFragment(IntentFragment.newInstance("", ""));
                Intent intent = new Intent(this, ViewDetailsActivity.class);

                IndentModel m = new Gson().fromJson(message.getCondition().getData(), IndentModel.class);
                Log.d(TAG, "checkCaldNetNotificationIntent:  CREATE_INDENT " + new Gson().toJson(m));


                intent.putExtra(CommonMethod.FROM_APPROVED_INDENT, m);
                startActivity(intent);
            } else if (message.getCondition().getClasstype() == CommonMethod.INDENT_STATUS) {
                callFragment(IntentFragment.newInstance("", ""));
                Intent intent = new Intent(this, ViewDetailsActivity.class);

                IndentModel m = new Gson().fromJson(message.getCondition().getData(), IndentModel.class);
                intent.putExtra(CommonMethod.FROM_MYINTENTS, m);
                Log.d(TAG, "checkCaldNetNotificationIntent:  INDENT_STATUS " + new Gson().toJson(m));

                startActivity(intent);
            }
        }
    }

    private void checkCaldConnectNotificationIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_NOTIFICATION)) {
            Message message = getIntent().getParcelableExtra(CommonMethod.FROM_NOTIFICATION);
            fragment = HomeFragment.newInstance(message);
            Bundle bundle = new Bundle();
            bundle.putParcelable(CommonMethod.FROM_NOTIFICATION, message);
            if (fm == null)
                fm = getSupportFragmentManager();
            FragmentTransaction ft = fm
                    .beginTransaction();
            ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
            ft.commit();
        }

    }

    private void setNavigationMenuHide() {
        if (navigation != null) {
            if (Prefs.getString(CommonMethod.IS_LOGGIN) != null) {
                if (AppType.isCaldNet()) {
                    if (MyApplication.getInstance().isS()) {
                        navigation.findViewById(R.id.navigation_setting).setVisibility(View.VISIBLE);
                    } else {
                        navigation.findViewById(R.id.navigation_setting).setVisibility(View.INVISIBLE);
                    }

                }
            }

        }

    }


    private void initCaldreysNet() {
        setTitle();
        Fragment fragment = HomeCalderysNetFragment.newInstance("", "");
        initStartFragment(fragment);
        this.fragment = fragment;
        //        if (MyApplication.getInstance().isAdminUser())
        showHideFabForCaldNet(this.fragment);


    }

    private void showHideFabForCaldNet(Fragment fragment) {
        if (fragment != null) {
            if (Prefs.getString(CommonMethod.IS_LOGGIN) != null) {
                if (AppType.isCaldConnect()) {
                    if (MyApplication.getInstance().isAdminUser()) {
                        if (fragment.getClass().getSimpleName().equalsIgnoreCase("HomeFragment"))
                            hideFab();
                        else
                            showFab();
                    } else
                        hideFab();

                } else {
                    if (MyApplication.getInstance().isS()
                            || MyApplication.getInstance().isD()) {
                        if (fragment.getClass().getSimpleName().equalsIgnoreCase("HomeCalderysNetFragment")) {
                            showFab();
                        } else
                            hideFab();
                    } else
                        hideFab();


                }

            }
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (this.fragment != null) {
//            showHideFabForCaldNet(this.fragment);
            hideFab();
            setNavigationMenuHide();
            menuSearchHideShow();

        }
    }

    private void hideFab() {
        mFabHome.hide();
    }

    private void showFab() {
        mFabHome.show();
    }

    void showNotiication(Context mContext) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mContext.getApplicationContext(), "notify_001");
        Intent ii = new Intent(mContext.getApplicationContext(), HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, ii, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle("Today's Bible Verse");
        bigText.setSummaryText("Text in detail");

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle("Your Title");
        mBuilder.setContentText("Your text");
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);

        mNotificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notify_001",
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }

        mNotificationManager.notify(0, mBuilder.build());
    }


    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM_NOTIFICATION)) {
            Message message = getIntent().getParcelableExtra(CommonMethod.FROM_NOTIFICATION);
            if (message.getCondition().getClasstype() == CommonMethod.CREATE_INDENT) {
                callFragment(IntentFragment.newInstance("", ""));
                Intent intent = new Intent(this, ViewDetailsActivity.class);

                IndentModel m = new Gson().fromJson(message.getCondition().getData(), IndentModel.class);
                intent.putExtra(CommonMethod.FROM_APPROVED_INDENT, m);
                startActivity(intent);
            } else {
                this.fragment = HomeFragment.newInstance(message);

                Bundle bundle = new Bundle();
                this.fragment = fragment;
                bundle.putParcelable(CommonMethod.FROM_NOTIFICATION, message);
                if (fm == null)
                    fm = getSupportFragmentManager();
                FragmentTransaction ft = fm
                        .beginTransaction();
                ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
                ft.commit();
            }


        }
    }


    private void init() {
        setTitle();
        Fragment fragment = HomeFragment.newInstance("", "");
        this.fragment = fragment;
        initStartFragment(fragment);
//        if (MyApplication.getInstance().isAdminUser())
//
//            if (fragment.getClass().getSimpleName().equalsIgnoreCase("HomeFragment"))
//                hideFab();
//
//            else
//                showFab();
//
//        else
//            hideFab();


//        mFabHome.hide();

        showHideFabForCaldNet(this.fragment);

        menuSearchHideShow();

    }


    //
    private void checkLogin() {
        if (Prefs.getString(CommonMethod.IS_LOGGIN) == null) {
            startLoginActivity();
            this.finish();
        }
//        else {
//            if(MyApplication.getInstance().isCommercialUser())
//                mFabHome.hide();
//            else
//                mFabHome.show();
//        }
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void callFragment(Fragment fragment) {
        if (fm == null)
            fm = getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction();
        ft.replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
        ft.addToBackStack(fragment.getClass().getSimpleName());

        ft.commit();
        this.fragment =fragment;
        showHideFabForCaldNet(this.fragment);


//        if (!fragment.getClass().getSimpleName().equalsIgnoreCase(fragment.getTag())){
//            ft.addToBackStack(fragment.getClass().getSimpleName());
//
//
//        }
    }

    @SuppressLint("RestrictedApi")
    private void showHideFab(Fragment fragment) {
        this.fragment = fragment;
        if ((fragment.getClass().getSimpleName().equalsIgnoreCase("UpdateFragment"))
                ||
                (fragment.getClass().getSimpleName().equalsIgnoreCase("PDSFragment"))
                || fragment.getClass().getSimpleName().equalsIgnoreCase("GalleryFragment")
                || fragment.getClass().getSimpleName().equalsIgnoreCase("HomeCalderysNetFragment")) {

            showFab();
        } else {
            hideFab();

        }


    }


    private boolean searchCaldConnect(Menu menu) {

        searchMenuItem = menu.findItem(R.id.action_search);
        menuSearchHideShow();


        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
//        searchView.setIconified(false);


        searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do whatever you need
                Log.d(TAG, "onMenuItemActionExpand: item" + item);

                return true; // KEEP IT TO TRUE OR IT DOESN'T OPEN !!
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do whatever you need
                if (attachedSearchListener != null) {
                    searchMenuItem.setTitle(null);

                    attachedSearchListener.onCollapsed();
                }
                return true; // OR FALSE IF YOU DIDN'T WANT IT TO CLOSE!
            }
        });

        return true;
    }

    public void menuSearchHideShow() {
        if (searchMenuItem != null && fragment != null) {
            if (AppType.isCaldConnect()) {
                if ((fragment.getClass().getSimpleName().equalsIgnoreCase("HomeFragment")) || (fragment.getClass().getSimpleName().equalsIgnoreCase("GalleryFragment"))) {
                    hideSearchItem();
                } else
                    showSearchItem();
            } else
                hideSearchItem();
        }
    }

    private void showSearchItem() {
        searchMenuItem.setVisible(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);

        return searchCaldConnect(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.action_logout:
                openDialogue();
//                showNotiication(this);

                break;


        }


        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        Prefs.remove(CommonMethod.IS_LOGGIN);
        Prefs.remove(CommonMethod.USER_TYPE);
        Prefs.remove(CommonMethod.USER_ID);
        startLoginActivity();
        this.finish();
    }

    private void openDialogue() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        logout();
                        dialog.dismiss();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        dialog.dismiss();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to logout?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_home:
                checkFabForFragment();
                break;
        }


    }


    private void checkFabForFragment() {
        if (fragment != null) {
            Intent intent = null;
            if (AppType.isCaldConnect()) {
                if (fragment.getClass().getSimpleName().equalsIgnoreCase("UpdateFragment")) {
                    intent = new Intent(HomeActivity.this, AddActivity.class);
                    startActivityForResult(intent, RC_UPDATE);
                } else if (fragment.getClass().getSimpleName().equalsIgnoreCase("PDSFragment")) {
                    intent = new Intent(HomeActivity.this, PDSActivity.class);
                    startActivityForResult(intent, RC_PDS);
                } else if (fragment.getClass().getSimpleName().equalsIgnoreCase("GalleryFragment")) {
                    intent = new Intent(HomeActivity.this, GalleryActivity.class);
                    startActivityForResult(intent, RC_GALLERY);
                }
            } else {
                if (MyApplication.getInstance().isS()
                        || MyApplication.getInstance().isD()) {
                    if (fragment.getClass().getSimpleName().equalsIgnoreCase("HomeCalderysNetFragment")) {
//                        intent = new Intent(HomeActivity.this, CreateIntentActivity.class);
                        intent = new Intent(HomeActivity.this, CreateIndentNewActivity.class);
                        startActivityForResult(intent, RC_HOME_NET);
                    }
                }


            }
        }


    }

    @Override
    public void grantedAllPermission() {
        allPermissionGranted = true;


    }

    @Override
    public void notGrantedAllPermission() {
        allPermissionGranted = false;


    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle();
        if (fragment != null) {
            showHideFabForCaldNet(this.fragment);
            setNavigationMenuHide();
            menuSearchHideShow();
        }


        //setNavigationMenuHide();


    }

    @Override
    public void onFabShowListner(int navPos) {
//        if (AppType.isCaldConnect()) {
//            if (MyApplication.getInstance().isAdminUser()) {
//                showFab();
//            } else {
//                hideFab();
//            }
//        } else {
//            showHideFabForCaldNet(fragment);
//        }
        showHideFabForCaldNet(this.fragment);
        setNavigationSelected(navPos);


    }

    public void setNavigationSelected(int navPos) {
        if (navigation.getMenu().size() >= navPos) {
            navigation.getMenu().getItem(navPos).setChecked(true);

        }


    }

    @Override
    public void onFabHideListner() {
        hideFab();

    }


    public void setMenuItem() {
        if (navigation != null) {

            setCaldConnectMenuClicks(navigation.getMenu().findItem(R.id.navigation_update));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_GALLERY) {
            if (resultCode == RESULT_OK) {
                if (backpressListner != null)
                    backpressListner.onBackPressListener();

            }
        }
        if (requestCode == RC_PDS) {
            if (resultCode == RESULT_OK) {
                if (backpressListner != null)
                    backpressListner.onBackPressListener();

            }
        }
        if (requestCode == RC_UPDATE) {
            if (resultCode == RESULT_OK) {
                {
                    if (backpressListner != null)
                        backpressListner.onBackPressListener();

                }
            }
        }

        if (requestCode == RC_SETTING_NET) {
            if (requestCode == RESULT_OK) {
                if (backpressListner != null)
                    backpressListner.onBackPressListener();

            }
        }
    }


    public void attachedListener(CommonInterface.BackpressListner backpressListner) {
        this.backpressListner = backpressListner;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        if (attachedSearchListener != null)
            attachedSearchListener.onSearchSubmit(s);

        return true;


    }

    @Override
    public boolean onQueryTextChange(String s) {
        if (attachedSearchListener != null)
            if (!TextUtils.isEmpty(s))
                attachedSearchListener.onSearchQuery(s);
//            else
//                attachedSearchListener.onSearchQueryForAll();

        Log.d(TAG, "onQueryTextChange: s" + s);
        return true;
    }


    public void attachedSearchListener(CommonInterface.SearchDataListener attachedSearchListener) {
        this.attachedSearchListener = attachedSearchListener;
    }

    @Override
    public void onFabHideHomeFragmentListner() {
        if (MyApplication.getInstance().isAdminUser() || MyApplication.getInstance().isCommercialUser())
            hideFab();
    }

    @Override
    public boolean onClose() {
        searchView.setQuery("", false);
        searchView.setIconified(true);
        if (attachedSearchListener != null) {
            Log.d(TAG, "onClose: " + true);
            attachedSearchListener.onCloseSearch();
        }
        return true;
    }

    @Override
    public void onShowSettingMenuForAdmin() {
        setNavigationMenuHide();


    }

    @Override
    public void onHideShowSearchMenu() {
        if (searchMenuItem != null) {
            hideSearchItem();
        }

    }

    private void hideSearchItem() {
        searchMenuItem.setVisible(false);
    }
}
