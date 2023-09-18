package com.ferhatozcelik.androidmvvmtemplate.common.data.preferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

abstract class SharedPreferences(context: Context) {

    abstract fun getPrefName(): String

    protected val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PreferencesConstants.KEYSTORE_NAME,MODE_PRIVATE)
    }
}