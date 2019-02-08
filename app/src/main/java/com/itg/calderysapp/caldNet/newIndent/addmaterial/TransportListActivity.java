package com.itg.calderysapp.caldNet.newIndent.addmaterial;

import android.app.SearchManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportListViewModel;
import com.itg.calderysapp.databinding.ActivityTransportListBinding;

public class TransportListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {


    private static final String TAG = "TransportListActivity";
    private SearchView searchView;

    ActivityTransportListBinding binding;
    TransportListViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_transport_list);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setModel();
    }

    private void setModel() {
        model=new TransportListViewModel(this);
        binding.setTransportModel(model);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
//        searchView.setVisibility(View.GONE);
        searchView.setIconified(false);

        MenuItem searchMenuItem = menu.findItem(R.id.action_search);

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
                    searchMenuItem.setTitle(null);
                return true; // OR FALSE IF YOU DIDN'T WANT IT TO CLOSE!
            }
        });

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        if(!TextUtils.isEmpty(s)){
            model.setSearch(s);
        }else
            model.setSearch("");

        return true;


    }

    @Override
    public boolean onQueryTextChange(String s) {
            if (!TextUtils.isEmpty(s))
                model.setSearch(s);
            else
                model.setSearch("");
        Log.d(TAG, "onQueryTextChange: s" + s);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onClose() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
