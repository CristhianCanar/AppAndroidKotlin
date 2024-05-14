package com.cristhian.apprecordar.data.utils

import android.content.Context
import android.content.SharedPreferences

class Prefs(context:Context) {
    val PREFS_NAME = "String inicial"
    val SHARED_NAME = "String intercambiable"

    val prefsName: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var name: String
        get() = prefsName.getString(SHARED_NAME, "").toString()
        set(value) =prefsName.edit().putString(SHARED_NAME, value).apply()

}