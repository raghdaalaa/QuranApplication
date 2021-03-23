package com.example.quranapplication.index_surahs;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {


   //  ArrayList<MyTab> tabs=new ArrayList<>();



    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
               SurahFragment surah=new SurahFragment();
                return surah.newInstance(position,"ccdc");
            case 1:
                JuzFragment juz=new JuzFragment();
                return juz;
        }
       // return tabs.get(position).getFragment();
        return  null;
    }
//----------------------------------------------------------------------//
    @Override
    public int getCount() {
        return 2;
    }
//----------------------------------------------------------------------//
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

            case 0:
                return "Surah";
            case 1:
                return "Juz";
        }

        return super.getPageTitle(position);
       // return tabs.get(position).getTabname();
    }

}
