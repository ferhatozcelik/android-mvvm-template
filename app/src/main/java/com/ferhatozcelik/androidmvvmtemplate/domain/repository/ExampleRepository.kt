package com.ferhatozcelik.androidmvvmtemplate.domain.repository

import com.ferhatozcelik.androidmvvmtemplate.data.entity.ExampleEntity
import com.ferhatozcelik.androidmvvmtemplate.data.model.ExampleModel
import retrofit2.Response


interface ExampleRepository {

    suspend fun getExampleApiData(): Response<List<ExampleModel>>

    suspend fun getExampleLocalData(): List<ExampleEntity>

}