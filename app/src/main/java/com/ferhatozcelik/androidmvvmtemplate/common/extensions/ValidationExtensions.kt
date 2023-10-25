package com.ferhatozcelik.androidmvvmtemplate.common.extensions

import android.util.Patterns
import android.webkit.URLUtil
import java.net.MalformedURLException
import java.net.URL

fun String.isValidPhoneNumber(): Boolean {
    return this.all { it.isDigit() }
}

fun String.isValidEmail(): Boolean {
    if (isEmpty()) return false
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    if (isEmpty() || this.length < 6) return false
    return true
}

fun String.isValidUrl(): Boolean {
    try {
        URL(this)
        return URLUtil.isValidUrl(this) && Patterns.WEB_URL.matcher(this).matches()
    } catch (ignored: MalformedURLException) {
    }
    return false
}