package com.ferhatozcelik.androidmvvmtemplate.di

import android.content.Context
import com.ferhatozcelik.androidmvvmtemplate.common.data.preferences.PreferenceManager
import com.ferhatozcelik.androidmvvmtemplate.common.data.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): Preferences {
        return PreferenceManager(context)
    }
}
