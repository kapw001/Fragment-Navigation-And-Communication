package pappayaed.com.fragmentusingbacknavigation.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pappayaed.com.fragmentusingbacknavigation.R;
import pappayaed.com.fragmentusingbacknavigation.fragments.childfragment.DashBoardChildFragment;
import pappayaed.com.fragmentusingbacknavigation.fragments.childfragment.DashBroadChildFirstFragment;
import pappayaed.com.fragmentusingbacknavigation.fragments.childfragment.FragmentAddCallBack;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment implements FragmentAddCallBack {


    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        addDashBoardFragment(1, false);

    }

    public void addDashBoardFragment(int postion, boolean isAddedBackStack) {

        Fragment fragment = null;

        switch (postion) {

            case 1:

                fragment = new DashBroadChildFirstFragment();

                break;

            case 2:

                fragment = new DashBoardChildFragment();

                break;

        }

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        Fragment fragment1 = getChildFragmentManager().findFragmentById(R.id.dashboardContent);

        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            getChildFragmentManager().popBackStack();
        }
        if (isAddedBackStack) {


//            if (fragment1.isInLayout()) {
//                transaction.show(fragment);
//            } else {


            transaction.replace(R.id.dashboardContent, fragment, postion + "").addToBackStack(postion + "");
//            }
        } else {


//            if (fragment1.isInLayout()) {
//                transaction.show(fragment);
//            } else {

            transaction.replace(R.id.dashboardContent, fragment, postion + "");
//            }


        }


        transaction.commit();

    }

    @Override
    public void addFragment(int position, boolean isAddBackStack) {

        addDashBoardFragment(position, isAddBackStack);

    }
}
