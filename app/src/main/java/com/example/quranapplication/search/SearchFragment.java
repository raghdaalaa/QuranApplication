package com.example.quranapplication.search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quranapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    Button search_bt;
    EditText search_et;
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;
    List<Result> resultList = new ArrayList<>();
    SearchInterface searchInterface;
    private int currentPage = 1;
    Search search;
    private String quary;
    List<Result> collect;
    List<Result> results;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search, container, false);
        search_bt = v.findViewById(R.id.search_bt);
        search_et = v.findViewById(R.id.search_et);
        recyclerView = v.findViewById(R.id.recyclerview);
        search = new Search();
        return v;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                checkMatching(search.getQuery());
                getAllResult(1);

            }
        });
    }

    //_____________________________________________________________________________/


//    private void checkMatching(String query) {
//        query.contains(" ")
//        String translation;
//        for (int i=0;i<resultList.size(); i++){
//
//            translation = resultList.get(i).getTranslations().get(0).getText().toString();
//            if (translation.contains(query)){
//
//            }
//
//        }
//    }

    //_____________________________________________________________________________/
    public void getAllResult(int page) {
        searchInterface = SearchClient.getRetrofit().create(SearchInterface.class);
        Callback<Search> callback = new Callback<Search>() {
            @Override
            public void onResponse(@NotNull Call<Search> call,
                                   @NotNull Response<Search> response) {
                resultList.clear();

                search = Objects.requireNonNull(response.body());
               results = response.body().getResults();
                //                    filteration start
               collect = results.stream().filter(s -> s.getText().contains(quary)).collect(Collectors.toList());
                searchAdapter.addResult(results);
            }
            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                call.cancel();
                Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();

            }

        };
        quary = search_et.getText().toString();
        searchInterface.getResultOfSearch(quary, "en").enqueue(callback);

    }
    //_____________________________________________________________________________/

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        searchAdapter = new SearchAdapter();
        recyclerView.setAdapter(searchAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Integer totalPages = search.getTotalPages();
                    if (currentPage != totalPages) {
                        Toast.makeText(getContext(), currentPage + "", Toast.LENGTH_SHORT).show();
                        getAllResult(++currentPage);

                    }
                }
            }
        });
    }
}