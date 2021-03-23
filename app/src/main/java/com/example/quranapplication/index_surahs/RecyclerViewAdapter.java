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

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

   List<Surah> surahs;
   Context context;

    public RecyclerViewAdapter(List<Surah> surahs, Context context) {
        this.surahs=surahs;
        this.context=context;
    }

//------------------------------------------------------------//
    @NonNull
    @Override
    // بعمل من خلالها انفلات للتصميم اللي انا عملته
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).
                inflate(R.layout.item_design,parent,
                false);

        return new MyViewHolder(v);
    }
    //------------------------------------------------------------------------//

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Surah s=surahs.get(position);
        holder.tv_sur.setText(s.getSur_Name());
        holder.tv_num_sur.setText(s.getSur_number());
        holder.iv_star.setImageResource(s.getPhoto_star());
        holder.iv_speaker.setImageResource(s.getPhoto_speaker());

    }
    //------------------------------------------------------------------------//
    @Override
    public int getItemCount() {
        return surahs.size();
    }

    // viewHolder class
    class MyViewHolder extends RecyclerView.ViewHolder{
          private TextView tv_sur;
          private TextView tv_num_sur;
          private ImageView iv_star;
        private ImageView iv_speaker;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sur=itemView.findViewById(R.id.tv1_id);
            tv_num_sur=itemView.findViewById(R.id.tv2_id);
           iv_star=itemView.findViewById(R.id.iv_id);
            iv_speaker=itemView.findViewById(R.id.iv2_id);
        }
    }


}
