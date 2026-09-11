package com.ferhatozcelik.androidmvvmtemplate.data.model

/**
 * A generic wrapper describing the state of a piece of data as it moves through the
 * repository -> use case -> ViewModel pipeline.
 *
 * Combine this with [kotlinx.coroutines.flow.Flow] in repositories/use cases and expose it
 * to the UI as part of a `StateFlow` so screens can render Loading / Success / Error states.
 */
sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val errorMessage: String, val throwable: Throwable? = null) : Resource<Nothing>()
}
