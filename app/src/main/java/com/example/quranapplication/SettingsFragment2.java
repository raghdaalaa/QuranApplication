package com.example.quranapplication;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import static android.graphics.Color.parseColor;

public class SettingsFragment2 extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.root_preferences, rootKey);
//        Load_setting();

    }
}

//
//
//    @SuppressLint("Range")
//    public void Load_setting(){
//        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
//        boolean chk_nigth = sp.getBoolean("night_mood" ,false);
//        if (chk_nigth){
//            getListView().setBackgroundColor(Color.parseColor("#222222"));
//        }else{
//            getListView().setBackgroundColor(Color.parseColor("#ffffff"));
//        }
//        CheckBoxPreference chk_night_instant = (CheckBoxPreference)findPreference("night_mood");
//        chk_night_instant.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            @Override
//            public boolean onPreferenceChange(Preference prefs, Object obj) {
//
//                boolean yes = (boolean)obj;
//                if(yes){
//                  getListView().setBackgroundColor(Color.parseColor("#222222"));
//                }else {
//                    getListView().setBackgroundColor(Color.parseColor("#ffffff"));
//                }
//                return true;
//            }
//        });
//
//    }
//
//    @Override
//    public void onResume() {
//        Load_setting();
//        super.onResume();
//    }
//}