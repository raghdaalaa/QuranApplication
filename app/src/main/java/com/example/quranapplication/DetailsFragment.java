package com.example.quranapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quranapplication.Chapterdata.QuranClient;
import com.example.quranapplication.Chapterdata.QuranInterface;
import com.example.quranapplication.VersesModel.Verse;
import com.example.quranapplication.VersesModel.VerseModel;
import com.example.quranapplication.Versesdata.VersesClient;
import com.example.quranapplication.Versesdata.VersesInterface;
import com.example.quranapplication.pojo.Chapter;
import com.example.quranapplication.pojo.QuranModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsFragment extends Fragment {

   RecyclerView recyclerView;
    VersesAdapter versesAdapter;
    List<Verse> verseList = new ArrayList<>();
    VersesInterface versesInterface;
    Chapter recivedChapter_id;
    Verse verse;
   // TextView datail_tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_indexs, container, false);

       recyclerView = v.findViewById(R.id.surah_rv_id);
      //  datail_tv=v.findViewById(R.id.tv2);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            recivedChapter_id= (Chapter) args.getSerializable("ChapterId");
         //  verse.setChapterId(recivedChapter_id.getChapterNumber());
        }
       setUpPostsRv();
        getAllPosts();

    }

    private void setUpPostsRv() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        versesAdapter = new VersesAdapter(verseList, getContext());

        recyclerView.setAdapter(versesAdapter);

    }

    private void getAllPosts() {

        versesInterface = VersesClient.getRetrofit().create(VersesInterface.class);
        verse.setChapterId(recivedChapter_id.getChapterNumber());
            Call<VerseModel> call = versesInterface.getVerses(verse.getChapterId()+"");
            call.enqueue(new Callback<VerseModel>() {
                @Override
                public void onResponse(Call<VerseModel> call, Response<VerseModel> response) {
                    verseList.clear();
                    verseList.addAll(response.body().getVerses());
                    Log.d("gff", verseList.toString());
                    versesAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<VerseModel> call, Throwable t) {
                    call.cancel();
                    Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

        }
    }
