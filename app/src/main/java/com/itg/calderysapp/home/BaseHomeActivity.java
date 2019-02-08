package com.itg.calderysapp.home;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.gallery.GalleryFragment;
import com.itg.calderysapp.caldConnect.pds.PDSFragment;
import com.itg.calderysapp.caldConnect.update.UpdateFragment;
import com.itg.calderysapp.caldNet.newIndent.home.HomeCalderysNetFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.IntentFragment;
import com.itg.calderysapp.caldNet.newIndent.setting.SettingFragment;
import com.itg.calderysapp.common.AppType;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.MyApplication;
import com.itg.calderysapp.common.Prefs;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public abstract class BaseHomeActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final int RC_STATE = 1234;
    private static final String TAG = "BaseHomeActivity";
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            return initMenuClicks(item);
        }
    };
    FragmentManager fm = null;
    //    private GrantPermissionListener  listener;
    private boolean hasPermission = false;
    private CommonInterface.EasyPermissionListener listener;

    public void setMenus(BottomNavigationView view) {
        int menuRes = AppType.isCaldConnect() ? R.menu.menu_cald_connect : R.menu.menu_cald_net;
        view.inflateMenu(menuRes);


    }

    public boolean initMenuClicks(MenuItem item) {
        createTopic();
        if (AppType.isCaldConnect())
            return setCaldConnectMenuClicks(item);
        else{
            return setCaldNetMenuClicks(item);

        }

    }

    public void createTopic() {
        getTokenId();
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        MyApplication.getInstance().supbscribeToTopic();
    }

    public void getTokenId() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.w(TAG, "getInstanceId failed", task.getException());
                    return;
                }

                // Get new Instance ID token
                String token = task.getResult().getToken();
                Prefs.putString(CommonMethod.TOKEN, task.getResult().getToken());

                // Log and toast
                Log.d(TAG, task.getResult().getToken());
            }
        });
    }


    public void setTitle() {
        if (getSupportActionBar() != null) {
            if (AppType.isCaldConnect()) {
                getSupportActionBar().setTitle(R.string.app_name_connect);
            } else {
                getSupportActionBar().setTitle(R.string.app_name_net);
            }
        }
    }


    private boolean setCaldNetMenuClicks(MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_calderys_net_home:
                callFragment(HomeCalderysNetFragment.newInstance("", ""));
                return true;

            case R.id.navigation_intents:
                callFragment(IntentFragment.newInstance("", ""));
                return true;

            case R.id.navigation_setting:
                callFragment(SettingFragment.newInstance("", ""));
                return true;
        }
        return false;
    }

    public boolean setCaldConnectMenuClicks(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                callFragment(HomeFragment.newInstance("", ""));

                return true;
            case R.id.navigation_gallery:
                callFragment(GalleryFragment.newInstance("", ""));


                return true;
            case R.id.navigation_pds:
                callFragment(PDSFragment.newInstance("", ""));
                return true;

            case R.id.navigation_update:
                callFragment(UpdateFragment.newInstance("", ""));
                return true;


        }
        return false;
    }

    public abstract void callFragment(Fragment fragment);

    public void initStartFragment(Fragment fragment) {
        if (fm == null)
            fm = getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction();
        ft.add(R.id.frame_container, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }

    @AfterPermissionGranted(RC_STATE)
    public void askForPermission() {
        if (checkLocationPermission()) {
            hasPermission = true;
            if (listener != null)
                listener.onGranted();
//            listener.grantedAllPermission();
            grantedAllPermission();
//            return;
        } else {
            EasyPermissions.requestPermissions(this, "You must grant this permission for your login", RC_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA);
        }
    }

    private boolean checkLocationPermission() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (requestCode == RC_STATE) {
//            listener.grantedAllPermission();
            grantedAllPermission();
            if (listener != null)
                listener.onGranted();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (requestCode == RC_STATE) {
//            listener.notGrantedAllPermission();
//            listener=null;
            notGrantedAllPermission();
            if (listener != null)
                listener.onDenied();
        }
    }

//    public void setListener(GrantPermissionListener listener) {
//        this.listener = listener;
//    }


    //    public interface GrantPermissionListener {
    public abstract void grantedAllPermission();

    public abstract void notGrantedAllPermission();

    public void checkPermission(CommonInterface.EasyPermissionListener listener) {
        this.listener = listener;
        askForPermission();
    }


//    }
}
