package com.ferhatozcelik.androidmvvmtemplate.domain.usecase.main

import com.ferhatozcelik.androidmvvmtemplate.common.Resource
import com.ferhatozcelik.androidmvvmtemplate.data.model.ExampleModel
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetLocalUseCase @Inject constructor(private val cardRepository: ExampleRepository) {
    operator fun invoke(): Flow<Resource<List<ExampleModel>>> = flow {
        emit(Resource.Loading)
        try {
            val tempList = mutableListOf<ExampleModel>()
            val localList = cardRepository.getExampleLocalData()
            localList.forEach { tempList.add(ExampleModel(it.title, it.description)) }
            emit(Resource.Success(tempList))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}