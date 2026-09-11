package com.ferhatozcelik.androidmvvmtemplate

import android.app.Application
import com.google.android.material.color.DynamicColors
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Applies Material You dynamic color theming on Android 12+ devices automatically.
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
