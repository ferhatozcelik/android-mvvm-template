package com.wiseria.common.domain.session

interface SessionManager {

    fun getAccessToken(): String?

    fun setAccessToken(token: String)

    fun saveAccessToken()

    fun deleteAccessToken()

    fun getRefreshToken(): String?

    fun setRefreshToken(token: String)

    fun saveRefreshToken()

    fun deleteRefreshToken()

    fun logOut()

    fun saveTokens(accessToken: String, refreshToken: String)

}