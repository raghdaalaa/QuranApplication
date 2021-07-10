package com.example.quranapplication.settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.quranapplication.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    // Todo Tutorial https://medium.com/swlh/androids-dark-mode-through-user-configurations-4df9d75b0db0

    private ThemeProvider themeProvider;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        themeProvider = new ThemeProvider(getContext());
        ListPreference darkModePreferences = getPreferenceManager().findPreference(getString(R.string.theme_preferences_key));
        assert darkModePreferences != null;
        darkModePreferences.setOnPreferenceChangeListener((preference, newValue) -> {
            if (newValue instanceof String) {
                int theme = themeProvider.getTheme((String) newValue);
                AppCompatDelegate.setDefaultNightMode(theme);
            }
            return true;
        });
        darkModePreferences.setSummaryProvider(preference -> {
            ListPreference listPreference = (ListPreference) preference;
            return themeProvider.getThemeDescriptionForPreference(listPreference.getValue());
        });
    }
}