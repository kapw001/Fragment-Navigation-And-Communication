package pappayaed.com.fragmentusingbacknavigation.viewpager.viewpageadapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pappayaed.com.fragmentusingbacknavigation.twofraginoneactivitycommunication.FragmentA;

/**
 * Created by yasar on 18/5/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "ViewPagerAdapter";

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    private String data;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public void addFragment(Fragment fragment, String title) {

        this.fragmentList.add(fragment);
        this.titleList.add(title);

        notifyDataSetChanged();

    }

    public void addAllFragment(List<Fragment> fragmentList, List<String> titleList) {

        this.fragmentList.addAll(fragmentList);
        this.titleList.addAll(titleList);

        notifyDataSetChanged();
    }

    public void updateData(String data) {

        this.data = data;
        notifyDataSetChanged();

        Log.e(TAG, "updateData: " + data);
    }


    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titleList.get(position);
    }


    @Override
    public int getItemPosition(@NonNull Object object) {

        if (object instanceof FragmentA) {

            ((FragmentA) object).setData(data);

            return POSITION_NONE;

        }

        return super.getItemPosition(object);
    }
}