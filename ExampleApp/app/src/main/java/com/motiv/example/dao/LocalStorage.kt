 
package com.motiv.example.dao
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

public class LocalStorage {

    private var sharedPreferences: SharedPreferences

    constructor(context: Context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun putString(key: String, value: String) {
        this.sharedPreferences.edit().putString(key, value).apply()
    } fun putBoolean(key: String, value: Boolean) {
        this.sharedPreferences.edit().putBoolean(key, value).apply()
    } fun putFloat(key: String, value: Float) {
        this.sharedPreferences.edit().putFloat(key, value).apply()
    } fun putInt(key: String, value: Int) {
        this.sharedPreferences.edit().putInt(key, value).apply()
    } fun putLong(key: String, value: Long) {
        this.sharedPreferences.edit().putLong(key, value).apply()
    } fun getString(key: String): String {
        return this.sharedPreferences.getString(key, "")!!
    } fun getBoolean(key: String): Boolean {
        return this.sharedPreferences.getBoolean(key, false)
    } fun getFloat(key: String): Float {
        return this.sharedPreferences.getFloat(key, 0f)
    } fun getInt(key: String): Int {
        return this.sharedPreferences.getInt(key, 0)
    } fun getLong(key: String): Long {
        return this.sharedPreferences.getLong(key, 0)
    }
    companion object {
        @Volatile private var INSTANCE: LocalStorage? = null
        fun getInstance(context: Context): LocalStorage =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(context).also { INSTANCE = it }
            }
        private fun buildInstance(context: Context) = LocalStorage(context)
    }
}
