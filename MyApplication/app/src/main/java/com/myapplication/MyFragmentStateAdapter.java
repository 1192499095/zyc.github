package com.myapplication;

import static android.content.Intent.getIntent;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.*;

public class MyFragmentStateAdapter extends FragmentStateAdapter {
    List list = new ArrayList();
    int mposition=-1;


    public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity,List list) {
        super(fragmentActivity);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (Fragment) list.get(position);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

}
