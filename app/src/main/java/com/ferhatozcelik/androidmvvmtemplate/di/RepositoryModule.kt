package com.ferhatozcelik.androidmvvmtemplate.di

import com.ferhatozcelik.androidmvvmtemplate.data.dao.ExampleDao
import com.ferhatozcelik.androidmvvmtemplate.data.remote.ExampleApi
import com.ferhatozcelik.androidmvvmtemplate.data.repository.ExampleRepositoryImpl
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideExampleRepository(exampleDao: ExampleDao, exampleApi: ExampleApi): ExampleRepository {
        return ExampleRepositoryImpl(exampleDao, exampleApi)
    }

}