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
public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        call();
    }


    private void call() {
        TextView textView = (TextView) getView().findViewById(R.id.textView);

        textView.setText(this.data);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                FragmentB fragmentB = (FragmentB) ((Main3Activity) getActivity()).getmSectionsPagerAdapter().getItem(((Main3Activity) getActivity()).getmViewPager().getCurrentItem());
//
//                fragmentB.call("fczxvcxzvzxvxvzdsfsdfds");

                ((Main3Activity) getActivity()).setData("Hello");

            }
        });
    }

    private String data = "Default";

    public void setData(String data) {

        this.data = data;


    }


}
