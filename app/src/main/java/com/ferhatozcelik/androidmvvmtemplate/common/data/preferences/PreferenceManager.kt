package com.ferhatozcelik.androidmvvmtemplate.common.data.preferences

import android.content.Context
import javax.inject.Inject

class PreferenceManager @Inject constructor(
    context: Context
) : SharedPreferences(context), Preferences {

    override fun getPrefName() = "WiseriaPrefs"

    override fun getAccessToken() = preferences.getString(PreferencesConstants.KEY_ACCESS_TOKEN, "")


    override fun setAccessToken(token: String) {
        preferences.edit().putString(PreferencesConstants.KEY_ACCESS_TOKEN, token).apply()
    }

    override fun deleteAccessToken() {
        preferences.edit().remove(PreferencesConstants.KEY_ACCESS_TOKEN).apply()
    }

    override fun getRefreshToken() =
        preferences.getString(PreferencesConstants.KEY_REFRESH_TOKEN, "")

    override fun setRefreshToken(token: String) {
        preferences.edit().putString(PreferencesConstants.KEY_REFRESH_TOKEN, token).apply()
    }

    override fun deleteRefreshToken() {
        preferences.edit().remove(PreferencesConstants.KEY_REFRESH_TOKEN).apply()
    }

}