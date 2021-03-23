package com.example.quranapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.quranapplication.index_surahs.JuzFragment;
import com.example.quranapplication.index_surahs.MyTab;
import com.example.quranapplication.index_surahs.SurahFragment;
import com.example.quranapplication.index_surahs.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;


public class IndexsFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private static final String ARG_NAME = "arg_name";



    public IndexsFragment() {
        // Required empty public constructor
    }

    //----------------------------------------------------------------//

    public static IndexsFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        IndexsFragment fragment = new IndexsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //-----------------------------------------------------------------//




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_indexs, container, false);
        tabLayout = v.findViewById(R.id.tablayout_id);
       viewPager = v.findViewById(R.id.viewpager_id);

        //-------------------------------------------------------//
        tabLayout.setupWithViewPager(viewPager);
        adapter = new ViewPagerAdapter(getParentFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        return v;

    }


}