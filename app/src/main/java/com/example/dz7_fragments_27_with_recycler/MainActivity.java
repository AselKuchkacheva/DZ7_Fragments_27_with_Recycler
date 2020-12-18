package com.example.dz7_fragments_27_with_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnClickChangeF {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private View fragmentView;
    private boolean mViewFragment = false;
    public static String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentView = findViewById(R.id.fragment_second);
        if (fragmentView != null) mViewFragment = true;

        if (mViewFragment) {
            mViewFragment = false;
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_first_land, new ChangeFragment());
            transaction.commit();
        }
    }

    @Override
    public void changeDisplay(Destination destination) {
        View fragmentView = findViewById(R.id.fragment_second);
        if (fragmentView != null) {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_second, TextFragment.newInstance(destination));
            transaction.commit();
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY, destination);
            startActivity(intent);
        }
    }
}