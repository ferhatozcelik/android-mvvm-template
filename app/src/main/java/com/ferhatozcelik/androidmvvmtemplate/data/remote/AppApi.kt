package com.ferhatozcelik.androidmvvmtemplate.data.remote

import com.ferhatozcelik.androidmvvmtemplate.data.model.ExampleModel
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("/api/v1/example")
    suspend fun getExampleResult(): Response<List<ExampleModel>>

}