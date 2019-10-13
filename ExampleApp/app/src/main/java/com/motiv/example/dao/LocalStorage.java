package com.motiv.example.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.fragment.app.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import javax.inject.*;

public class LocalStorage {

    private SharedPreferences sharedPreferences;
    private static LocalStorage instance;

    public LocalStorage(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void putString(java.lang.String key, java.lang.String value) {
        this.sharedPreferences.edit().putString(key, value).apply();
    }

    public void putBoolean(java.lang.String key, boolean value) {
        this.sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void putFloat(java.lang.String key, float value) {
        this.sharedPreferences.edit().putFloat(key, value).apply();
    }

    public void putInt(java.lang.String key, int value) {
        this.sharedPreferences.edit().putInt(key, value).apply();
    }

    public void putLong(java.lang.String key, long value) {
        this.sharedPreferences.edit().putLong(key, value).apply();
    }

    public java.lang.String getString(java.lang.String key) {

        return this.sharedPreferences.getString(key, "");
    }

    public boolean getBoolean(java.lang.String key) {

        return this.sharedPreferences.getBoolean(key, false);
    }

    public float getFloat(java.lang.String key) {

        return this.sharedPreferences.getFloat(key, 0f);
    }

    public int getInt(java.lang.String key) {

        return this.sharedPreferences.getInt(key, 0);
    }

    public long getLong(java.lang.String key) {

        return this.sharedPreferences.getLong(key, 0);
    }

    public static LocalStorage getInstance(Context context) {
        if (instance == null) {
            instance = new LocalStorage(context);
        }
        return instance;
    }
}
