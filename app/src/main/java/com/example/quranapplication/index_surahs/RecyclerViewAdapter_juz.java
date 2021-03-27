package com.example.quranapplication.index_surahs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapplication.R;

import java.util.List;

public class RecyclerViewAdapter_juz extends RecyclerView.Adapter<RecyclerViewAdapter_juz.myViewHolder>{
List<juz>juz ;
Context context ;

    public RecyclerViewAdapter_juz(List<com.example.quranapplication.index_surahs.juz> juz, Context context) {
        this.juz = juz;
        this.context = context;
    }

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(context).inflate(R.layout.juz_design,parent,false);
     return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        juz j=juz.get(position);
        holder.juz_num.setText(j.getJuz_num());
        holder.juz_des.setText(j.getJuz_description());
        holder.icon.setImageResource(j.getIcon()); }

    @Override
    public int getItemCount() {
        return juz.size();
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
    private TextView juz_num ;
    private TextView juz_des;
    private ImageView icon ;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        juz_num=itemView.findViewById(R.id.juz_num);
        juz_des=itemView.findViewById(R.id.juz_desc);
        icon=itemView.findViewById(R.id.iconn);

    }
}
}
