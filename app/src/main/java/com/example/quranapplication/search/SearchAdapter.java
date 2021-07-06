package com.example.quranapplication.search;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.R;
import com.example.quranapplication.VersesModel.Verse;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter  extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private final List<Result> resultSearch = new ArrayList<>();


//    public void addVerses(List<Verse> versesList) {
//        this.versesList.addAll(versesList);
//        notifyDataSetChanged();
//    }


    public void addResult(List<Result> resultSearch) {
        this.resultSearch.addAll(resultSearch);
        notifyDataSetChanged();
    }

    public SearchAdapter() {

    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout

        return new SearchViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.search_item
                        , parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.searchArabic.setText(Html.fromHtml(Html.
                       fromHtml(resultSearch.get(position).getText()).toString()));
        holder.searchTrans.setText(Html.fromHtml(Html.
                fromHtml(resultSearch.get(position).getTranslations().
                        get(0).getText()).toString()));

    }

    @Override
    public int getItemCount() {
        return resultSearch.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView searchArabic,searchTrans;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            searchArabic=itemView.findViewById(R.id.tv_searchArabic);
            searchTrans=itemView.findViewById(R.id.tv_searchTrans);
        }
    }

}
