package com.example.quranapplication.index_surahs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.quranapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class JuzFragment extends Fragment {


    public JuzFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_juz,container,false);

        return v;
    }

}
