package com.example.quranapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.VersesModel.Verse;
import com.example.quranapplication.VersesModel.VerseModel;
import com.example.quranapplication.Versesdata.VersesClient;
import com.example.quranapplication.Versesdata.VersesInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsFragment extends Fragment {

    RecyclerView recyclerView;
    VersesAdapter versesAdapter;
    List<Verse> verseList = new ArrayList<>();
    VersesInterface versesInterface;
    private int chapterId;
    private int currentPage = 1;

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

        DetailsFragmentArgs bundle = DetailsFragmentArgs.fromBundle(getArguments());
        chapterId = bundle.getChapterId();

        setUpPostsRv();
        getAllPosts(chapterId, 1);

    }

    private void setUpPostsRv() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        versesAdapter = new VersesAdapter(verseList, getContext());

        recyclerView.setAdapter(versesAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(getContext(), "ggf", Toast.LENGTH_SHORT).show();               }
            }
        });


    }

    private void getAllPosts(int chapterId, int pageNumber ) {

        versesInterface = VersesClient.getRetrofit().create(VersesInterface.class);

        Call<VerseModel> call = versesInterface.getVerses(chapterId, pageNumber , 17);
        call.enqueue(new Callback<VerseModel>() {
            @Override
            public void onResponse(Call<VerseModel> call, Response<VerseModel> response) {
                verseList.clear();
                List<Verse> verses = response.body().getVerses();
                versesAdapter.setVersesList(verses);
            }

            @Override
            public void onFailure(Call<VerseModel> call, Throwable t) {
                call.cancel();
                Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

// Link - > translation number + "ar, en"
// Enum class (field = translationId -> 16, 17, 124
// Object, EN(11)

// Enum class = Translations
// Translations = (EN(11), AR(12), FR, TR)