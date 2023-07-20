package com.ferhatozcelik.androidmvvmtemplate.data.repository

import com.ferhatozcelik.androidmvvmtemplate.data.dao.ExampleDao
import com.ferhatozcelik.androidmvvmtemplate.data.remote.ExampleApi
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository

class ExampleRepositoryImpl(private val exampleDao: ExampleDao, private val exampleApi: ExampleApi) : ExampleRepository {

    override suspend fun getExampleApiData() = exampleApi.getExampleResult()

    override suspend fun getExampleLocalData() = exampleDao.getExampleData()

}