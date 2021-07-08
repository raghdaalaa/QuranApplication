package com.example.quranapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.VersesModel.Meta;
import com.example.quranapplication.VersesModel.Verse;
import com.example.quranapplication.VersesModel.VerseModel;
import com.example.quranapplication.Versesdata.VersesClient;
import com.example.quranapplication.Versesdata.VersesService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class DetailsFragment extends Fragment {

    RecyclerView recyclerView;
    private VersesAdapter versesAdapter;
    List<Verse> verseList = new ArrayList<>();
    VersesService versesService;
    private int chapterId;
    private int currentPage = 1;
    private Meta meta;
    //save lastposition
    private int lastposition  ;
    SharedPreferences preferences ;

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
        //get last position :
        preferences= getContext().getSharedPreferences("last",Context.MODE_PRIVATE);
        int chapterId_saved =preferences.getInt("last",0);
        chapterId=chapterId_saved ;
        chapterId = bundle.getChapterId();
        setUpPostsRv();
        getAllPosts(chapterId,1);
    }
    private void setUpPostsRv() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        versesAdapter = new VersesAdapter();

        recyclerView.setAdapter(versesAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    // Log.d("ManoO", "Bottom");
                    Integer totalPages = meta.getTotalPages();
                    if (currentPage != totalPages) {
                        getAllPosts(chapterId, ++currentPage);
                    } }


            }
        });
    }

    private void getAllPosts(int chapterId, int pageNumber) {

        versesService = VersesClient.getRetrofit().create(VersesService.class);

        Callback<VerseModel> callback = new Callback<VerseModel>() {
            @Override
            public void onResponse(@NotNull Call<VerseModel> call, @NotNull Response<VerseModel> response) {
                verseList.clear();
                meta = Objects.requireNonNull(response.body()).getMeta();
                versesAdapter.addVerses(response.body().getVerses());
            }

            @Override
            public void onFailure(@NotNull Call<VerseModel> call, @NotNull Throwable t) {
                call.cancel();
                Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        };

        versesService.getVerses(chapterId, pageNumber,33).enqueue(callback);
    }
//save last postion
    @Override
    public void onDestroy() {
        super.onDestroy();
        lastposition=chapterId ;
        preferences= getContext().getSharedPreferences("last",Context.MODE_PRIVATE);
        SharedPreferences.Editor e= preferences.edit();
        e.putInt("last",lastposition);
        e.commit();
    }
}

// Link - > translation number + "ar, en"
// Enum class (field = translationId -> 16, 17, 124
// Object, EN(11)
// Enum class = Translations
// Translations = (EN(11), AR(12), FR, TR)