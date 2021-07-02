package com.example.quranapplication;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.VersesModel.Translation;
import com.example.quranapplication.VersesModel.Verse;



import java.util.ArrayList;
import java.util.List;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.VersesViewHolder> {

    List<Verse> versesList;
    List<Translation> translationList;
    Context context;


    // constructor
    public VersesAdapter(List<Verse> versesList, Context context) {
        this.versesList = versesList;
        this.context = context;
    }

    public void setVersesList(List<Verse> versesList){
        this.versesList = versesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VersesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout

        return new VersesViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.verse_item
                        , null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VersesViewHolder holder, int position) {
        // بتستدعي كل اما ييجي يعمل bind ل viewholder جديد

        Verse verse = versesList.get(position);

        holder.ver_Name_ar.setText(verse.getTextIndopak());
        holder.ver_Num.setText(verse.getVerseNumber()+"");
        List<Translation> translations = verse.getTranslations();
        for (int i = 0; i < translations.size(); i++) {
            Translation translation = translations.get(i);

            if (translation.getResourceId() == 12)
                holder.verse_translated.setText(translation.getText());
        }




    }

    @Override
    public int getItemCount() {
        return versesList.size();
    }


    public class VersesViewHolder extends RecyclerView.ViewHolder {
        // viewholder دا الحاجة اللي هتشيل الفيو بتاعي
        //inflate layout items
   TextView ver_Name_ar,ver_Num ,verse_translated;
   Button copy_tv,volume_tv;



        public VersesViewHolder(@NonNull View itemView) {
            super(itemView);
            ver_Name_ar=itemView.findViewById(R.id.verse_ara_tv);
            ver_Num=itemView.findViewById(R.id.verse_Num_tv);
            verse_translated=itemView.findViewById(R.id.verse_translated_tv);
            copy_tv=itemView.findViewById(R.id.copy_button);
            volume_tv=itemView.findViewById(R.id.volume_button);



        }
    }
}