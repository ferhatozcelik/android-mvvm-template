package com.ferhatozcelik.androidmvvmtemplate.di

import android.app.Application
import androidx.room.Room
import com.ferhatozcelik.androidmvvmtemplate.data.dao.ExampleDao
import com.ferhatozcelik.androidmvvmtemplate.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: AppDatabase.Callback): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "local_database").fallbackToDestructiveMigration().addCallback(callback).build()
    }

    @Provides
    fun provideExampleDao(database: AppDatabase): ExampleDao {
        return database.getExampleDao()
    }
}