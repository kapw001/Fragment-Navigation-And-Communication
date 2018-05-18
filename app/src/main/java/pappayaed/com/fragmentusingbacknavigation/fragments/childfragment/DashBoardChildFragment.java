package pappayaed.com.fragmentusingbacknavigation.fragments.childfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pappayaed.com.fragmentusingbacknavigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardChildFragment extends Fragment {


    public DashBoardChildFragment() {
        // Required empty public constructor
    }

    private FragmentAddCallBack fragmentAddCallBack;

    private static final String TAG = "DashBoardChildFragment";

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board_child, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fragmentAddCallBack != null) {

//                    if (getChildFragmentManager().getBackStackEntryCount() > 0) {
//
//                        getChildFragmentManager().popBackStack();
//                    }

                    fragmentAddCallBack.addFragment(1, false);

                } else {
                    Log.e(TAG, "onClick: not listener not added ");
                }
            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
