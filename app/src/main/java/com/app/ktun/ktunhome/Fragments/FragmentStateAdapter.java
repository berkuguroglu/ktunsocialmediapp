package com.app.ktun.ktunhome.Fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.app.ktun.ktunhome.MainActivity;
import com.app.ktun.ktunhome.R;

import java.util.ArrayList;

public class FragmentStateAdapter extends FragmentStatePagerAdapter {


    ArrayList<Fragment> fragments = new ArrayList<>();
    public FragmentStateAdapter(FragmentManager fm)
    {
        super(fm);
        this.fragments.add(loginFragment.newInstance("loginFragment", "loginFragment"));
        this.fragments.add(homeFragment.newInstance("homeFragment", "loginFragment"));
        this.fragments.add(graduateFragment.newInstance("homeFragmentFragment", "loginFragment"));

    }

    @Override
    public Fragment getItem(int i) {


        return this.fragments.get(i);

    }

    @Override
    public int getCount() {
        return 3;
    }
}
