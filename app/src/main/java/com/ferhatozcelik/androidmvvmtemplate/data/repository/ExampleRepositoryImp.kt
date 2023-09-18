package com.ferhatozcelik.androidmvvmtemplate.data.repository

import com.ferhatozcelik.androidmvvmtemplate.data.dao.ExampleDao
import com.ferhatozcelik.androidmvvmtemplate.data.services.AppService
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ExampleRepositoryImp @Inject constructor(private val appService: AppService, private val exampleDao: ExampleDao) : ExampleRepository {
    override suspend fun test() {


    }
}