package com.example.quranapplication.search;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.R;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;


public class SearchFragment extends Fragment {
    Button search_bt;
    EditText search_et;
    EditText total_results;
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;
    List<Result> resultList = new ArrayList<>();
    SearchInterface searchInterface;
    private int currentPage = 1;
    Search search;
    private String quary;
    List<Result> collect;
    List<Result> resultsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        search_bt = v.findViewById(R.id.search_bt);
        total_results = v.findViewById(R.id.total_results);
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
    public void getAllResult(int page) {
        searchInterface = SearchClient.getRetrofit().create(SearchInterface.class);
        Callback<Search> callback = new Callback<Search>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(@NotNull Call<Search> call,
                                   @NotNull Response<Search> response) {
                resultList.clear();

                search = Objects.requireNonNull(response.body());
               resultsList = response.body().getResults();

                collect = resultsList
                       .stream()

                        .filter(s -> containsQuery(s))
                        .collect(Collectors.toList());
                searchAdapter.addResult(collect);
                total_results.setText("TotalResult = "+search.getTotalResults());
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

    private boolean containsQuery(Result s) {
        String translation = s.getTranslations().get(0).getText();
        String textOnly = Jsoup.parse(translation).text();
        return textOnly.contains(quary);
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