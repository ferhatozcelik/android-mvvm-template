package com.ferhatozcelik.androidmvvmtemplate.domain.usecase

import com.ferhatozcelik.androidmvvmtemplate.data.entity.ExampleEntity
import com.ferhatozcelik.androidmvvmtemplate.data.model.Resource
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Encapsulates the single business rule of "load the examples the user should see".
 *
 * Keeping this as its own use case means [com.ferhatozcelik.androidmvvmtemplate.ui.fragments.home.HomeViewModel]
 * never talks to [ExampleRepository] directly, which keeps the ViewModel free of data-layer
 * concerns and makes the business rule independently testable and reusable.
 */
class GetExampleListUseCase @Inject constructor(
    private val exampleRepository: ExampleRepository
) {
    operator fun invoke(): Flow<Resource<List<ExampleEntity>>> = exampleRepository.getExampleList()
}
