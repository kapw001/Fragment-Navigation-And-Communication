package pappayaed.com.fragmentusingbacknavigation.twofraginoneactivitycommunication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pappayaed.com.fragmentusingbacknavigation.R;
import pappayaed.com.fragmentusingbacknavigation.viewpager.Main3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {


    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentById(R.id.first_frag);
//
//
//                fragmentA.setData("Hey ,it's working");


                ((Main3Activity) getActivity()).setData("zxczxc");


            }
        });
    }

    public void call(String s) {

        TextView textView = getView().findViewById(R.id.textView2);

        textView.setText(s);
    }
}
