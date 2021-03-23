package com.example.quranapplication.index_surahs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private int count;
    public ViewPagerAdapter(FragmentActivity fragmentActivity, int count) {
        super(fragmentActivity);
        this.count = count;
    }


//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return SurahFragment.newInstance();
            case 1:
                return new JuzFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
