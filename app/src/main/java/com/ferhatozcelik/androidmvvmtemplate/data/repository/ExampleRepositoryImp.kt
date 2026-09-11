package com.ferhatozcelik.androidmvvmtemplate.data.repository

import com.ferhatozcelik.androidmvvmtemplate.data.dao.ExampleDao
import com.ferhatozcelik.androidmvvmtemplate.data.entity.ExampleEntity
import com.ferhatozcelik.androidmvvmtemplate.data.model.Resource
import com.ferhatozcelik.androidmvvmtemplate.data.services.AppService
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleRepositoryImp @Inject constructor(
    private val appService: AppService,
    private val exampleDao: ExampleDao
) : ExampleRepository {

    override fun getExampleList(): Flow<Resource<List<ExampleEntity>>> = flow {
        emit(Resource.Loading)

        val cached = exampleDao.getExampleData()
        if (cached.isNotEmpty()) {
            emit(Resource.Success(cached))
        }

        try {
            val response = appService.getExampleResult()
            val remoteExamples = response.body()

            if (response.isSuccessful && remoteExamples != null) {
                remoteExamples.forEach { example ->
                    exampleDao.insert(
                        ExampleEntity(title = example.title, description = example.description)
                    )
                }
                emit(Resource.Success(exampleDao.getExampleData()))
            } else if (cached.isEmpty()) {
                emit(Resource.Error("Request failed with HTTP ${response.code()}"))
            }
        } catch (exception: IOException) {
            if (cached.isEmpty()) {
                emit(Resource.Error(exception.message ?: "Network error", exception))
            }
        } catch (exception: HttpException) {
            if (cached.isEmpty()) {
                emit(Resource.Error(exception.message ?: "Server error", exception))
            }
        }
    }.flowOn(Dispatchers.IO)
}
