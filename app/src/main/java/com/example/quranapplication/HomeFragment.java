package com.example.quranapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {



    //    action bar
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_home,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.about_app){
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_homeFragment_to_aboutAppFragment);}
        if(id== R.id.share_app){
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_homeFragment_to_shareAppFragment);}
//        if(id== R.id.go_to_last){
//            NavController navController = NavHostFragment.findNavController(this);
//            navController.navigate(R.id.action_homeFragment_to_lastreadFragment);}
        if(id== R.id.book_mark){
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_homeFragment_to_bookMarkFragment);}
        if(id== R.id.search){
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_homeFragment_to_searchFragment);}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}