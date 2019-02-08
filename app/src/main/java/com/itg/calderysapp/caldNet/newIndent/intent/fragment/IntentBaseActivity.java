package com.itg.calderysapp.caldNet.newIndent.intent.fragment;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonInterface;
import com.itg.calderysapp.common.CommonMethod;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntentBaseActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, CommonInterface.ShowSearchMenu {

    private static final int FROM_DEALER=1;
    private static final int FROM_INTENT=2;
    private static final int FROM_STATUS=3;

    private static final String TAG = "IntentBaseActivity";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.base_container)
    FrameLayout mBaseContainer;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private FragmentManager fm;
    private SearchView searchView;
    private CommonInterface.SearchDataListener attachedSearchListener;
    private int from=-1;
    private MenuItem searchMenuItem=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_base);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        checkIntent();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void checkIntent() {
        if (getIntent().hasExtra(CommonMethod.FROM)) {
            if (getIntent().getStringExtra(CommonMethod.FROM_DEALER) != null) {
                if(getSupportActionBar()!=null)
                        getSupportActionBar().setTitle("Dealer");
                from=FROM_DEALER;
                getSupportActionBar().setTitle("Dealer");
                callFragment(DealerCodeFragment.newInstance(""));
            } else if (getIntent().getStringExtra(CommonMethod.FROM_INTENT) != null) {
                if(getSupportActionBar()!=null)
                        getSupportActionBar().setTitle("Indent");
                from=FROM_INTENT;
                getSupportActionBar().setTitle("Indent");
                DealerModel model=null;
                if(getIntent().hasExtra(CommonMethod.DEALER_DATA)) {
                    model = getIntent().getParcelableExtra(CommonMethod.DEALER_DATA);
                }
                callFragment(IntentsSelectionFragment.newInstance(model));

            } else if (getIntent().getStringExtra(CommonMethod.FROM_STATUS) != null) {

                from=FROM_STATUS;
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setTitle("Status");

                callFragment(StatusFragment.newInstance("", ""));
            }

        }
    }

    private void callFragment(Fragment fragment) {
        if (fm == null)
            fm = getSupportFragmentManager();
        FragmentTransaction ft = fm
                .beginTransaction();
        ft.add(R.id.base_container, fragment, fragment.getClass().getSimpleName());
//        ft.addToBackStack(fragment.getClass().getSimpleName());

        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchMenuItem = menu.findItem(R.id.action_search);
        MenuItemListener();

        return true;
    }

    private void MenuItemListener() {

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
                if (attachedSearchListener != null){
                    searchMenuItem.setTitle(null);
                    attachedSearchListener.onCollapsed();
                }
                return true; // OR FALSE IF YOU DIDN'T WANT IT TO CLOSE!
            }
        });
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    public void DealerItemClicked(DealerModel model) {

        Intent resultIntent = new Intent();
// TODO Add extras or a data URI to this intent as appropriate.
        resultIntent.putExtra(CommonMethod.DEALER, model);
//         this.modelDealer = model;
         setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void IndentModelClicked(IndentModel model) {
        Intent resultIntent = new Intent();
// TODO Add extras or a data URI to this intent as appropriate.
        resultIntent.putExtra(CommonMethod.INDENT, model);

        setResult(RESULT_OK, resultIntent);
       finish();

    }

    @Override
    public void onHideShowSearchMenu() {
        if(searchView !=null && searchMenuItem!=null){
            searchView.setVisibility(View.VISIBLE);
            MenuItemListener();


        }

    }
}
