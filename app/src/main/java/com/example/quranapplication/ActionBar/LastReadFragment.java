package com.example.quranapplication.ActionBar;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quranapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LastReadFragment extends Fragment {


    public LastReadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_last_read, container, false);
    }

}
