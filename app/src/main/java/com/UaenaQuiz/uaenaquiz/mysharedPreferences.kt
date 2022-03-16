package com.UaenaQuiz.uaenaquiz

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

    val PREFS_FILENAME = "prefs"
    var PREF_KEY_MY_COUNT = "correctNumber"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    fun getCount(value: String) : String {
        return prefs.getString(PREF_KEY_MY_COUNT, value).toString()
    }

    fun setCount(value:String) {
        prefs.edit().putString(PREF_KEY_MY_COUNT, value).apply()
    }


    fun getBoolean(key:String, value:Boolean) : Boolean {
        return prefs.getBoolean(key, value)
    }

    fun setBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

}