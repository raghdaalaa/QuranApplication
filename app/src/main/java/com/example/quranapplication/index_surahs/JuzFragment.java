package com.example.quranapplication.index_surahs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JuzFragment extends Fragment {
   private RecyclerView recyclerView ;
   private RecyclerViewAdapter_juz recyclerViewAdapter_juz;
   private ArrayList<juz>Juz ;
    private static final String ARGUMENT_POSITION = "argument_position";
    private static final String ARGUMENT_NAME = "argument_name";

    public JuzFragment() {
        // Required empty public constructor
    }
    public static JuzFragment newInstance() {return new JuzFragment();}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Juz=new ArrayList<>();
        Juz.add(new juz("JUZ 1","SART At:AL-FAATIHA VERSE 1",R.drawable.ic_star));
        Juz.add(new juz("JUZ 2","START AT:AL-BAQARA VERSE 142 ",R.drawable.ic_star));
        Juz.add(new juz("JUZ 3","START AT :AL-BAQARA VERSE 253",R.drawable.ic_star));
        Juz.add(new juz("JUZ 4"," ",R.drawable.ic_star));
        Juz.add(new juz("JUZ 5","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 6","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 7","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 8","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 9","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 10","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 11","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 12","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 13","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 14","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 15","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 16","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 17","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 18","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 19","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 20","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 21","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 22","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 23","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 24","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 25","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 26","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 27","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 28","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 29","",R.drawable.ic_star));
        Juz.add(new juz("JUZ 30","",R.drawable.ic_star));

        recyclerViewAdapter_juz=new RecyclerViewAdapter_juz(Juz,getContext());
        View v=inflater.inflate(R.layout.fragment_juz,container,false);
        recyclerView=v.findViewById(R.id.juz_rv_id);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter_juz);
        recyclerView.setHasFixedSize(true);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
