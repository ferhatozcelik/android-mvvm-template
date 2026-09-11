package com.ferhatozcelik.androidmvvmtemplate.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferhatozcelik.androidmvvmtemplate.data.entity.ExampleEntity
import com.ferhatozcelik.androidmvvmtemplate.data.model.Resource
import com.ferhatozcelik.androidmvvmtemplate.domain.usecase.GetExampleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * UI state exposed by [HomeViewModel] following the Loading / Success / Error pattern.
 */
sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val examples: List<ExampleEntity>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getExampleListUseCase: GetExampleListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadExamples()
    }

    fun loadExamples() {
        viewModelScope.launch {
            getExampleListUseCase().collect { resource ->
                _uiState.value = when (resource) {
                    is Resource.Loading -> HomeUiState.Loading
                    is Resource.Success -> HomeUiState.Success(resource.data)
                    is Resource.Error -> HomeUiState.Error(resource.errorMessage)
                }
            }
        }
    }
}
