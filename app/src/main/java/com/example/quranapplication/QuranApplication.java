package com.example.quranapplication;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.quranapplication.settings.ThemeProvider;

public class QuranApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        int theme = new ThemeProvider(this).getThemeFromPreferences();
        AppCompatDelegate.setDefaultNightMode(theme);
    }
}
