package com.ferhatozcelik.androidmvvmtemplate.domain.repository

import com.ferhatozcelik.androidmvvmtemplate.data.entity.ExampleEntity
import com.ferhatozcelik.androidmvvmtemplate.data.model.Resource
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {

    /**
     * Emits the locally cached examples first (if any) and then the freshly
     * fetched/synced examples from the remote API, wrapped as [Resource] states.
     */
    fun getExampleList(): Flow<Resource<List<ExampleEntity>>>
}
