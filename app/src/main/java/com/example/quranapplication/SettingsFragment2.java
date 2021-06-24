package com.example.quranapplication;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment2 extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}