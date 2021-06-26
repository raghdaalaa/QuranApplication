package com.example.quranapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.pojo.Chapter;
import com.example.quranapplication.pojo.QuranModel;

import java.util.List;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder>{


    List<Chapter> QuranList;
    Context context;

    public QuranAdapter(List<Chapter> quranList, Context context) {
        QuranList = quranList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout

        return new QuranViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_item
                        , parent, false));
    }

   @Override
    public void onBindViewHolder(@NonNull QuranViewHolder holder, int position) {
        // بتستدعي كل اما ييجي يعمل bind ل viewholder جديد
        holder.nameArabic_Tv.setText(QuranList.get(position).getNameArabic());
        holder.chapterNumber_tv.setText(QuranList.get(position).getChapterNumber()+"");
        holder.nameSimple_Tv.setText(QuranList.get(position).getNameSimple());
        holder.versesCount.setText(QuranList.get(position).getVersesCount()+"");

    }

    @Override
    public int getItemCount() {
        return QuranList.size();
    }



    public class QuranViewHolder extends RecyclerView.ViewHolder {
        // viewholder دا الحاجة اللي هتشيل الفيو بتاعي
        //inflate layout items
        TextView nameArabic_Tv,chapterNumber_tv,nameSimple_Tv,versesCount;

        public QuranViewHolder(@NonNull View itemView) {
            super(itemView);
            nameArabic_Tv=itemView.findViewById(R.id.nameArabic_Tv);
            chapterNumber_tv=itemView.findViewById(R.id.chapterNumber_tv);
            nameSimple_Tv=itemView.findViewById(R.id.nameSimple_Tv);
            versesCount=itemView.findViewById(R.id.versesCount);

        }
    }


}