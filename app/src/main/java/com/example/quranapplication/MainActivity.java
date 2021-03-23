package com.example.quranapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quranapplication.index_surahs.JuzFragment;
import com.example.quranapplication.index_surahs.MyTab;
import com.example.quranapplication.index_surahs.SurahFragment;
import com.example.quranapplication.index_surahs.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setItemIconTintList(null);//for coloring the icons
        NavController controller = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, controller);



    }

}







