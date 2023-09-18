package com.ferhatozcelik.androidmvvmtemplate.common.data.preferences

interface Preferences {

    fun getAccessToken(): String?

    fun setAccessToken(token: String)
    fun deleteAccessToken()

    fun getRefreshToken(): String?

    fun setRefreshToken(token: String)

    fun deleteRefreshToken()

}