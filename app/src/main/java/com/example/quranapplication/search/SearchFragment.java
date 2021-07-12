package com.example.quranapplication.search;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
import java.util.Optional;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {
    Button search_bt;
    EditText search_et;
    EditText total_results;
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;
    List<Result> resultList = new ArrayList<>();
    SearchInterface searchInterface;
    Search search;
    List<Result> resultsList;
    private int currentPage = 1;
    private String searchQuery;
    private @NonNull String languageid;

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
                SearchFragmentArgs bundle = SearchFragmentArgs.fromBundle(getArguments());
        languageid = bundle.getLanguageid();
           setUpRecyclerView();
        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage = 1;
                getAllResult(currentPage);
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

                searchAdapter.addResult(resultsList);
                total_results.setText(String.format("TotalResult = %d", resultsList.size()));

            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                call.cancel();
                Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();

            }

        };
        searchQuery = search_et.getText().toString();
        searchInterface.getResultOfSearch(searchQuery, languageid, page).enqueue(callback);

    }

    private boolean containsQuery(Result s) {
        Optional<Translation> first = s.getTranslations().stream().findFirst();
        boolean translationFound = false;
        if (first.isPresent()) {
            translationFound = isMatchFound(first.get().getText());
        }

        return translationFound;

    }

    private boolean isMatchFound(String text) {
        String textOnly = Jsoup.parse(text).text();
        return textOnly.toLowerCase().contains(searchQuery.toLowerCase());
    }

    //_____________________________________________________________________________/

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));
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