package pappayaed.com.fragmentusingbacknavigation.fragments.childfragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pappayaed.com.fragmentusingbacknavigation.R;
import pappayaed.com.fragmentusingbacknavigation.fragments.DashBoardFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBroadChildFirstFragment extends Fragment {


    private FragmentAddCallBack fragmentAddCallBack;

    private static final String TAG = "DashBroadChildFirstFrag";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        try {

            fragmentAddCallBack = (FragmentAddCallBack) context;

        } catch (ClassCastException e) {

            try {

                fragmentAddCallBack = (FragmentAddCallBack) getParentFragment();

            } catch (ClassCastException e1) {
                Log.e(TAG, "onAttach: second " + e1.getMessage());
            }

            Log.e(TAG, "onAttach: First " + e.getMessage());
        }


    }

    public DashBroadChildFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_broad_child_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (getParentFragment() instanceof DashBoardFragment) {

                    ((DashBoardFragment) getParentFragment()).addDashBoardFragment(2, true);
                }

//                if (fragmentAddCallBack != null) {
//
//                    fragmentAddCallBack.addFragment(2, true);
//
//                } else {
//                    Log.e(TAG, "onClick: not listener not added ");
//                }
            }
        });
    }
}
