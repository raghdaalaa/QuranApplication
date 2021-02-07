package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
       bottomNavigationView.setItemIconTintList(null);//for coloring the icons
        NavController controller=Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment);
       NavigationUI.setupWithNavController(bottomNavigationView,controller);
    }
}
