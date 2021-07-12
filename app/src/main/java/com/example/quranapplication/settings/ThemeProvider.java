package com.example.quranapplication.settings;

import android.app.UiModeManager;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import com.example.quranapplication.R;

import java.security.InvalidParameterException;

public class ThemeProvider {
    private Context context;

    public ThemeProvider(Context context) {
        this.context = context;
    }

    public int getThemeFromPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String selectedTheme  = sharedPreferences.getString(
                context.getString(R.string.theme_preferences_key),
                context.getString(R.string.system_theme_preference_value)
        );

        if (selectedTheme != null){
            return getTheme(selectedTheme);
        } else return AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
    }

    public String getThemeDescriptionForPreference(String preferenceValue) {
        String result;
        if (preferenceValue.equals(context.getString(R.string.dark_theme_preference_value))){
            result = context.getString(R.string.dark_theme_description);
        } else if (preferenceValue.equals(context.getString(R.string.light_theme_preference_value))){
            result = context.getString(R.string.light_theme_description);
        } else {
            result = context.getString(R.string.system_theme_description);
        }

        return result;
    }

    public int getTheme(String selectedTheme){
        int result;
        if (selectedTheme.equals(context.getString(R.string.dark_theme_preference_value))) result = UiModeManager.MODE_NIGHT_YES;
        else if (selectedTheme.equals(context.getString(R.string.light_theme_preference_value))) result = UiModeManager.MODE_NIGHT_NO;
        else if (selectedTheme.equals(context.getString(R.string.system_theme_preference_value))) result = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
        else throw new InvalidParameterException("Theme not defined for " + selectedTheme);
        return result;
    }
}
