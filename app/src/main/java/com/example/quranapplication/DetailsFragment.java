package com.example.quranapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
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

import static android.content.Context.MODE_PRIVATE;

public class DetailsFragment extends Fragment {
    public static final String LAST_CHAPTER_POSITION_KEY = "LAST_CHAPTER_POSITION_KEY";
    public static final String LAST_PAGE_POSITION_KEY = "LAST_PAGE_POSITION_KEY";
    public static final int LAST_POSITION_KEY_NOT_SET = -1;
    public static int lastPosition;

    RecyclerView recyclerView;
    private VersesAdapter versesAdapter;
    List<Verse> verseList = new ArrayList<>();
    VersesService versesService;
    private int chapterId;
    private int currentPage;
    private Meta meta;
    //save lastposition
    SharedPreferences preferences ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_indexs, container, false);
        recyclerView = v.findViewById(R.id.surah_rv_id);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DetailsFragmentArgs bundle = DetailsFragmentArgs.fromBundle(getArguments());
        chapterId = bundle.getChapterId();
        currentPage = bundle.getPageNumber();

        setUpPostsRv();
        getAllPosts(chapterId,currentPage);
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

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences pref = requireActivity().getSharedPreferences("Quran", MODE_PRIVATE);
        pref.edit().putInt(LAST_CHAPTER_POSITION_KEY, chapterId).apply(); // Clear variable
        pref.edit().putInt(LAST_PAGE_POSITION_KEY, currentPage).apply(); // Clear variable\
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
}
