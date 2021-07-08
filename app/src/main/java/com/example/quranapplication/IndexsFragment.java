package com.example.quranapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.Chapterdata.QuranClient;
import com.example.quranapplication.Chapterdata.QuranInterface;
import com.example.quranapplication.IndexsFragmentDirections.ActionIndexsFragmentToDetailsFragment;
import com.example.quranapplication.pojo.Chapter;
import com.example.quranapplication.pojo.QuranModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;
import static com.example.quranapplication.DetailsFragment.LAST_CHAPTER_POSITION_KEY;
import static com.example.quranapplication.DetailsFragment.LAST_PAGE_POSITION_KEY;
import static com.example.quranapplication.DetailsFragment.LAST_POSITION_KEY_NOT_SET;


public class IndexsFragment extends Fragment {


    RecyclerView recyclerView;
    QuranAdapter quranAdapter;
    List<Chapter> quranList = new ArrayList<>();
    QuranInterface quranInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.fragment_indexs, container, false);

        recyclerView = v.findViewById(R.id.surah_rv_id);

        // set last position = null

        return v;
    }
//    actionbar


    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_index, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.about_app) {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_indexsFragment_to_aboutAppFragment);
        }
        if (id == R.id.share_app) {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_indexsFragment_to_shareAppFragment);
        }
        if (id == R.id.language) {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_indexsFragment_to_languageFragment);
        }
        if (id == R.id.search) {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_indexsFragment_to_searchFragment);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpPostsRv();
        getAllPosts();

        SharedPreferences pref = requireActivity().getSharedPreferences("Quran", MODE_PRIVATE);
        int lastChapterPosition = pref.getInt(LAST_CHAPTER_POSITION_KEY, LAST_POSITION_KEY_NOT_SET);
        if (lastChapterPosition == LAST_POSITION_KEY_NOT_SET) {
            // closed the app from index fragment

        } else {
            // get page number, and chapter and send it to details fragment
            int lastPagePosition = pref.getInt(LAST_PAGE_POSITION_KEY, LAST_POSITION_KEY_NOT_SET);
            // open details fragment and send data to it
            navigateToDetails(view, lastChapterPosition, lastPagePosition);
        }
    }

    private void setUpPostsRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        quranAdapter = new QuranAdapter(quranList, getContext(), (view, chapterId) -> navigateToDetails(view, chapterId, 1));
        recyclerView.setAdapter(quranAdapter);
    }

    private void navigateToDetails(View view, int chapterId, int pageNumber) {
        ActionIndexsFragmentToDetailsFragment action = IndexsFragmentDirections.actionIndexsFragmentToDetailsFragment();
        action.setChapterId(chapterId);
        action.setPageNumber(pageNumber);
        Navigation.findNavController(view).navigate(action);
    }

    private void getAllPosts() {
        quranInterface = QuranClient.getRetrofit().create(QuranInterface.class);
        Call<QuranModel> call = quranInterface.getQuran("fr");
        call.enqueue(new Callback<QuranModel>() {
            @Override
            public void onResponse(Call<QuranModel> call, Response<QuranModel> response) {

                quranList.clear();
                quranList.addAll(response.body().getChapters());
                Log.d("gff", quranList.toString());
                quranAdapter.notifyDataSetChanged();


                Toast.makeText(getContext(), "sucsess", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<QuranModel> call, Throwable t) {
                call.cancel();
                Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();


            }
        });
    }
}