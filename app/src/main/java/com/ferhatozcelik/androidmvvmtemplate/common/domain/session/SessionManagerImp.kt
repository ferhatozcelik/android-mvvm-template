package com.wiseria.common.domain.session

import com.ferhatozcelik.androidmvvmtemplate.common.data.preferences.Preferences
import javax.inject.Inject

class SessionManagerImp @Inject constructor(private val preferences: Preferences) : SessionManager {

    private var accessToken: String? = null

    private var refreshToken: String? = null

    override fun getAccessToken(): String? {
        if (accessToken == null) {
            accessToken = preferences.getAccessToken()
        }
        return accessToken
    }

    override fun setAccessToken(token: String) {
        accessToken = token
    }

    override fun saveAccessToken() {
        accessToken?.let { token ->
            preferences.setAccessToken(token)
        }
    }

    override fun deleteAccessToken() {
        accessToken = null
        preferences.deleteAccessToken()
    }

    override fun getRefreshToken(): String? {
        if (refreshToken == null) {
            refreshToken = preferences.getRefreshToken()
        }
        return refreshToken
    }

    override fun setRefreshToken(token: String) {
        refreshToken = token
    }

    override fun saveRefreshToken() {
        refreshToken?.let { token ->
            preferences.setRefreshToken(token)
        }
    }

    override fun deleteRefreshToken() {
        refreshToken = null
        preferences.deleteRefreshToken()
    }

    override fun logOut() {
        deleteAccessToken()
        deleteRefreshToken()
    }

    override fun saveTokens(accessToken: String, refreshToken: String) {
        setAccessToken(accessToken)
        saveAccessToken()
        setRefreshToken(refreshToken)
        saveRefreshToken()
    }
}