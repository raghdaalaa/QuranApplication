package com.example.quranapplication.search;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
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

import static android.app.Activity.RESULT_OK;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;


public class SearchFragment extends Fragment {
    Button search_bt;
    EditText search_et;
    TextView total_results;
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;
    List<Result> resultList = new ArrayList<>();
    SearchInterface searchInterface;
    private int currentPage = 1;
    Search search;
    private String quary;
    List<Result> collect;
    List<Result> resultsList;
    private String searchQuery;
    private @NonNull String languageid;
    //voice search (google assistant)
    ImageButton mic ;
    protected static final int RESULT_SPEECH=1 ;
    // link voice with language
   //  String languageid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search, container, false);
        search_bt = v.findViewById(R.id.search_bt);
        total_results = v.findViewById(R.id.total_results);
        search_et = v.findViewById(R.id.search_et);
        recyclerView = v.findViewById(R.id.recyclerview);
        search = new Search();
        //voice search
        search_et = v.findViewById(R.id.search_et);
        mic=v.findViewById(R.id.mic);
//----------------------------------------------------------------------------------------------
      // voice model
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageid);


                try {
                    startActivityForResult(intent, RESULT_SPEECH);

                } catch (ActivityNotFoundException a) {
//                    Toast t = Toast.makeText(getActivity().getApplicationContext(), "Unfortunately, this device does not support talk",
//                            Toast.LENGTH_SHORT);
//                    t.show();
//          0          Toast.makeText(context.getApplicationContext(), "Unfortunately, this device does not support talk", Toast.LENGTH_LONG).show();

                }
            }
        });

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
                total_results.setText("TotalResult = "+search.getTotalResults());

            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                call.cancel();
                Toast.makeText(getContext(), "Failed:" + t.getMessage(), Toast.LENGTH_LONG).show();
               // Toast.makeText(getContext(), "No Result Matched", Toast.LENGTH_LONG).show();

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
       // recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));
        searchAdapter = new SearchAdapter(languageid);
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

    //voice model

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    search_et.setText(text.get(0));
                }
                break;
            }

        }
    }
}