package com.example.quranapplication.index_surahs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.IndexsFragment;
import com.example.quranapplication.R;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;



public class SurahFragment extends Fragment {

    private RecyclerView myRecyclerview;
    private ArrayList<Surah> surahs ;
    private RecyclerViewAdapter adapter;


    //------------------------------------------------------//
    private static final String ARGUMENT_POSITION = "argument_position";
    private static final String ARGUMENT_NAME = "argument_name";


    public SurahFragment() {
        // Required empty public constructor
    }

    //------------------------------------//


    public static SurahFragment newInstance(int position,String name) {

        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        args.putString(ARGUMENT_NAME, name);
        SurahFragment fragment = new SurahFragment();
        fragment.setArguments(args);
        return fragment;
    }
    //------------------------------------//



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //-------------------------------------------------------------------//
        surahs=new ArrayList<>();


        surahs.add(new Surah("al-Fatihah","Makkah | 7",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al-Baqarah","Madinah | 286",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al Imran","Madinah | 200",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("An-Nisa","Madinah | 176",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al-Ma'idah","Madinah| 120",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al-An'am","Makkah | 165",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al-A'raf","Makkah | 206",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al-Anfal","Madinah | 75",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("At-Tawbah","Madinah | 129",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Yunus","Makkah | 109",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Hud","Makkah | 123",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));

        surahs.add(new Surah("Yusuf","Makkah | 111",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));

        surahs.add(new Surah("Ar-Ra'd","Madinah| 43",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));

        surahs.add(new Surah("Ibrahim","Makkah| 52",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));

        surahs.add(new Surah("Al-Hijr","Makkah| 99",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("An-Nahl","Makkah| 128",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));
        surahs.add(new Surah("Al-Isra","Makkah| 111",R.drawable.ic_star,
                R.drawable.ic_speaker_filled_audio_tool));


        adapter=new RecyclerViewAdapter(surahs,getContext());

        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_surah,container,false);
        myRecyclerview=v.findViewById(R.id.sur_rv_id);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getActivity());
        myRecyclerview.setLayoutManager(lm);
        myRecyclerview.setAdapter(adapter);
        myRecyclerview.setHasFixedSize(true);

        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
