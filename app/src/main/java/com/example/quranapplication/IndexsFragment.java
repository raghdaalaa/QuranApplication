package com.example.quranapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.Chapterdata.QuranClient;
import com.example.quranapplication.Chapterdata.QuranInterface;
import com.example.quranapplication.IndexsFragmentDirections.ActionIndexsFragmentToDetailsFragment;
import com.example.quranapplication.pojo.Chapter;
import com.example.quranapplication.pojo.QuranModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IndexsFragment extends Fragment {


    RecyclerView recyclerView;
    QuranAdapter quranAdapter;
    List<Chapter> quranList = new ArrayList<>();
    QuranInterface quranInterface;
    private String languageid;
    private int languageisocode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_indexs, container, false);





        recyclerView = v.findViewById(R.id.surah_rv_id);
        return v;


    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get chapter translation from language fragment
        IndexsFragmentArgs bundle = IndexsFragmentArgs.fromBundle(getArguments());
        languageid = bundle.getLanguageid();
        languageisocode=bundle.getLanguageisocode();
        setUpPostsRv();
        getAllPosts();

    }

    private void setUpPostsRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        quranAdapter = new QuranAdapter(quranList, getContext(), (view, chapterId) -> {
            ActionIndexsFragmentToDetailsFragment action = IndexsFragmentDirections.actionIndexsFragmentToDetailsFragment();
            action.setChapterId(chapterId);
            action.setLanguageisocode2(languageisocode);
            Navigation.findNavController(view).navigate(action);
        });

        recyclerView.setAdapter(quranAdapter);

    }

    private void getAllPosts() {
        quranInterface = QuranClient.getRetrofit().create(QuranInterface.class);

        // use enum class
     //   String string = Translationlanguages.Russian.toString();
        Call<QuranModel> call = quranInterface.getQuran(languageid);

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
  