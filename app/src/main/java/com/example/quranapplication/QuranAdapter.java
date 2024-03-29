package com.example.quranapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quranapplication.pojo.Chapter;
import java.util.List;
public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder> {
    List<Chapter> QuranList;
    Context context;
    OnChapterClick onChapterClick;
    //recyclerview listeners
    private final String languageid;

    public interface OnChapterClick {
        void onItemClick(View view, int chapterId);
    }
    public QuranAdapter(List<Chapter> quranList, Context context,String languageid, OnChapterClick onChapterClick) {
        QuranList = quranList;
        this.context = context;
        this.onChapterClick = onChapterClick;
        this.languageid=languageid;
    }
    @NonNull
    @Override
    public QuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout
        return new QuranViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.chapter_item
                        , parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull QuranViewHolder holder, int position) {
        // بتستدعي كل اما ييجي يعمل bind ل viewholder جديد
        Chapter chapter = QuranList.get(position);

        holder.nameArabic_Tv.setText(chapter.getNameArabic());
        holder.chapterNumber_tv.setText(chapter.getChapterNumber() + "");

        // arabic chapters without translations
        if(languageid== "ar"){
            holder.nameTranslated_Tv.setText("");
        }
        else {
            holder.nameTranslated_Tv.setText(chapter.getTranslatedName().getName());
        }

        holder.versesCount.setText(chapter.getVersesCount() + "");


        //listeners
        holder.itemView.setOnClickListener(view -> onChapterClick.onItemClick(view, chapter.getId()));
    }
    @Override
    public int getItemCount() {
        return QuranList.size();
    }
    public class QuranViewHolder extends RecyclerView.ViewHolder {
        // viewholder دا الحاجة اللي هتشيل الفيو بتاعي
        //inflate layout items
        TextView nameArabic_Tv, nameTranslated_Tv,chapterNumber_tv, versesCount;

        public QuranViewHolder(@NonNull View itemView) {
            super(itemView);
            nameArabic_Tv = itemView.findViewById(R.id.nameArabic_Tv);
            chapterNumber_tv = itemView.findViewById(R.id.chapterNumber_tv);
            nameTranslated_Tv = itemView.findViewById(R.id.nameTranslated_Tv);
            versesCount = itemView.findViewById(R.id.versesCount);


        }
    }
}