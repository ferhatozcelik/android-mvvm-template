package com.ferhatozcelik.androidmvvmtemplate.data.services

import com.ferhatozcelik.androidmvvmtemplate.data.model.ExampleModel
import retrofit2.Response
import retrofit2.http.*

interface AppService {

    @GET("/api/v1/example")
    suspend fun getExampleResult(): Response<List<ExampleModel>>

}