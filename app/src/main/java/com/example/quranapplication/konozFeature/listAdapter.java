package com.example.quranapplication.konozFeature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quranapplication.R;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter<items> {
    public listAdapter (Context context, ArrayList<items>itemsArrayList){
        super(context, R.layout.listitem,itemsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        items items=getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false );
        }
        TextView tv1=convertView.findViewById(R.id.title_konoz);
        TextView tv2=convertView.findViewById(R.id.details);
        tv1.setText(items.title);
        tv2.setText(items.details);
        return super.getView(position, convertView, parent);
    }
}
