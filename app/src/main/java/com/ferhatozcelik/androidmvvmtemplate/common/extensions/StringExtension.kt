package com.ferhatozcelik.androidmvvmtemplate.common.extensions

import android.util.Log
import java.util.Locale

fun String.capitalize(): String  = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}

fun String.debug(message: String) {
    Log.d(this, message)
}

