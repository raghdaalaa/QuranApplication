package com.example.quranapplication.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.Preference.SummaryProvider;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.example.quranapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static android.graphics.Color.parseColor;

public class SettingsFragment extends PreferenceFragmentCompat {


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