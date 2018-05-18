package pappayaed.com.fragmentusingbacknavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import pappayaed.com.fragmentusingbacknavigation.fragments.DashBoardFragment;
import pappayaed.com.fragmentusingbacknavigation.fragments.HomeFragment;
import pappayaed.com.fragmentusingbacknavigation.fragments.MainFragment;
import pappayaed.com.fragmentusingbacknavigation.fragments.NotificationFragment;

public class MainActivity extends BaseActivity {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    item.setCheckable(true);
                    addFragment(R.id.navigation_home, true);

                    return true;
                case R.id.navigation_dashboard:
                    item.setCheckable(true);
                    addFragment(R.id.navigation_dashboard, true);
                    return true;
                case R.id.navigation_notifications:
                    item.setCheckable(true);
                    addFragment(R.id.navigation_notifications, true);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        setSupportActionBar(toolbar);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        addFragment(-1, false);

        navigation.getMenu().findItem(R.id.navigation_home).setCheckable(false);

    }


    public void addFragment(int id, boolean isAddBackStack) {

        Fragment fragment = null;
        String title = "";

        switch (id) {

            case R.id.navigation_home:
                title = getString(R.string.title_home);
                fragment = new HomeFragment();

                break;

            case R.id.navigation_dashboard:
                title = getString(R.string.title_dashboard);
                fragment = new DashBoardFragment();
                break;

            case R.id.navigation_notifications:
                title = getString(R.string.title_notifications);
                fragment = new NotificationFragment();
                break;

            default:
                title = "Main";
                fragment = new MainFragment();
                break;


        }

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (isAddBackStack) {


            if (isFragmentAlreadyAdded(fragmentManager, title)) {
                fragmentTransaction.show(fragment);
            } else {

                if (fragmentManager.getBackStackEntryCount() > 0) fragmentManager.popBackStack();

                fragmentTransaction.replace(R.id.content, fragment, title).addToBackStack(title);
            }

            setActionBarTitle(title, true);

        } else {
            setActionBarTitle(title, false);

            if (isFragmentAlreadyAdded(fragmentManager, title)) {
                fragmentTransaction.show(fragment);
            } else {
                if (fragmentManager.getBackStackEntryCount() > 0) fragmentManager.popBackStack();
                fragmentTransaction.replace(R.id.content, fragment, title);
            }


        }

        fragmentTransaction.commit();


    }

    private boolean isFragmentAlreadyAdded(FragmentManager manager, String tag) {

        Fragment faFragment = manager.findFragmentByTag(tag);

        if (faFragment != null && faFragment.isAdded()) {

            return true;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            onBackPressed();

            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private static final String TAG = "MainActivity";

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed: " + fragmentManager.getBackStackEntryCount());

        if (fragmentManager != null && fragmentManager.getBackStackEntryCount() > 0) {

            Fragment fragment = fragmentManager.findFragmentById(R.id.content);

            FragmentManager childManager = fragment.getChildFragmentManager();

            if (childManager.getBackStackEntryCount() > 0) {

                childManager.popBackStack();

            } else {


                fragmentManager.popBackStack();

                navigation.getMenu().findItem(R.id.navigation_home).setCheckable(false);
                navigation.getMenu().findItem(R.id.navigation_dashboard).setCheckable(false);
                navigation.getMenu().findItem(R.id.navigation_notifications).setCheckable(false);


                if (fragmentManager.getBackStackEntryCount() <= 1) {

                    setActionBarTitle("Main", false);
                }
            }

        } else {
            super.onBackPressed();
        }


    }
}
