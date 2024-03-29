package com.example.quranapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.VersesModel.Translation;
import com.example.quranapplication.VersesModel.Verse;
import com.example.quranapplication.pojo.Chapter;

import java.util.ArrayList;
import java.util.List;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.VersesViewHolder> {
    private final List<Verse> versesList = new ArrayList<>();
    private final int RUSSIAN = 31;
    private final int selectedLanguage;
    Verse verse;


    public VersesAdapter(int selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public void addVerses(List<Verse> versesList) {
        this.versesList.addAll(versesList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VersesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout
        return new VersesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.verse_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VersesViewHolder holder, int position) {
        Verse verse = versesList.get(position);
        holder.bind(verse);
    }

    @Override
    public int getItemCount() {
        return versesList.size();
    }

    public class VersesViewHolder extends RecyclerView.ViewHolder {
        // viewholder دا الحاجة اللي هتشيل الفيو بتاعي
        //inflate layout items
        TextView ver_Name_ar, ver_Num, verse_translated, basmala;
        Button copy_tv, volume_tv;


        public VersesViewHolder(@NonNull View itemView) {
            super(itemView);
            ver_Name_ar = itemView.findViewById(R.id.verse_ara_tv);
            ver_Num = itemView.findViewById(R.id.verse_Num_tv);
            verse_translated = itemView.findViewById(R.id.verse_translated);
            copy_tv = itemView.findViewById(R.id.copy_button);
            volume_tv = itemView.findViewById(R.id.volume_button);


        }

        public void bind(Verse verse) {

            if (verse.getTextMadani().isEmpty()) {
                ver_Name_ar.setText(verse.getTextIndopak());
            } else {
                ver_Name_ar.setText(verse.getTextMadani());
            }
            ver_Num.setText(verse.getVerseNumber() + "");

            if(selectedLanguage == 3){
                verse_translated.setText("");
            }
            else {

                //  boolean translationFound = true;
                List<Translation> translations = verse.getTranslations();
                for (int i = 0; i < translations.size(); i++) {
                    Translation translation = translations.get(i);

                    if (translation.getResourceId() == selectedLanguage){
                        //    translationFound = true;
                        verse_translated.setText(translation.getText());
                    }

                }
            }

        }
    }
}
