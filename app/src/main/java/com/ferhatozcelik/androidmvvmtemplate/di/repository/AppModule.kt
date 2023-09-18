package com.ferhatozcelik.androidmvvmtemplate.di.repository

import com.ferhatozcelik.androidmvvmtemplate.data.dao.ExampleDao
import com.ferhatozcelik.androidmvvmtemplate.data.repository.ExampleRepositoryImp
import com.ferhatozcelik.androidmvvmtemplate.data.services.AppService
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    @Provides
    internal fun provideAppService(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

    @Provides
    internal fun provideExampleRepository(appService: AppService, exampleDao: ExampleDao): ExampleRepository {
        return ExampleRepositoryImp(appService, exampleDao)
    }
}