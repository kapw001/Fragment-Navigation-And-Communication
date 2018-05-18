package pappayaed.com.fragmentusingbacknavigation.twofraginoneactivitycommunication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pappayaed.com.fragmentusingbacknavigation.R;

public class Main2Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction().replace(R.id.first_frag, fragmentA).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.second_frag, fragmentB).commit();


    }
}
