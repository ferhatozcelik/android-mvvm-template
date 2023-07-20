package com.ferhatozcelik.androidmvvmtemplate.domain.usecase.main

import com.ferhatozcelik.androidmvvmtemplate.common.Resource
import com.ferhatozcelik.androidmvvmtemplate.data.model.ExampleModel
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetRemoteUseCase @Inject constructor(private val cardRepository: ExampleRepository) {
    operator fun invoke(): Flow<Resource<List<ExampleModel>>> = flow {
        emit(Resource.Loading)
        try {
            val response = cardRepository.getExampleApiData()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    emit(Resource.Success(responseBody))
                } else {
                    emit(Resource.Error("List null"))
                }
            } else {
                emit(Resource.Error("Not Successful"))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }
}