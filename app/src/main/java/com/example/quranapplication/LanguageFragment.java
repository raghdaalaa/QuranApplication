package com.example.quranapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;


public class LanguageFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_language, container, false);

        Button btn_en , btn_ar , btn_fr , btn_gr , btn_id , btn_sp , btn_ru ;

        btn_en = v.findViewById(R.id.en_button);
        btn_ar = v.findViewById(R.id.ar_button);
        btn_fr = v.findViewById(R.id.fr_button);
        btn_gr = v.findViewById(R.id.gr_button);
        btn_sp = v.findViewById(R.id.sp_button);
        btn_ru = v.findViewById(R.id.ru_button);
        btn_id = v.findViewById(R.id.id_button);




        btn_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.ENGLISH.toString());
                action.setLanguageisocode(Translationlanguages.ENGLISH.getIntValue());
                Navigation.findNavController(v).navigate(action);
            }
        });


        btn_ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.ARABIC.toString());
                action.setLanguageisocode(Translationlanguages.ARABIC.getIntValue());
                Navigation.findNavController(v).navigate(action);

            }
        });

        btn_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.FRENCH.toString());
                action.setLanguageisocode(Translationlanguages.FRENCH.getIntValue());
                Navigation.findNavController(v).navigate(action);
            }
        });

        btn_gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.German.toString());
                action.setLanguageisocode(Translationlanguages.German.getIntValue());
                Navigation.findNavController(v).navigate(action);
            }
        });

        btn_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.Spanish.toString());
                action.setLanguageisocode(Translationlanguages.Spanish.getIntValue());
                Navigation.findNavController(v).navigate(action);
            }
        });

        btn_ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.Russian.toString());
                action.setLanguageisocode(Translationlanguages.Russian.getIntValue());
                Navigation.findNavController(v).navigate(action);
            }
        });

        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragmentDirections.ActionLanguageFragmentToIndexsFragment action = LanguageFragmentDirections.actionLanguageFragmentToIndexsFragment();
                action.setLanguageid(Translationlanguages.Indonesia.toString());
                action.setLanguageisocode(Translationlanguages.Indonesia.getIntValue());
                Navigation.findNavController(v).navigate(action);
            }
        });

        return  v;
    }
}