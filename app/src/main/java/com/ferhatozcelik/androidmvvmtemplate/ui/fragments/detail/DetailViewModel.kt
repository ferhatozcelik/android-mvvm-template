package com.ferhatozcelik.androidmvvmtemplate.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.ferhatozcelik.androidmvvmtemplate.domain.repository.ExampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val exampleRepository: ExampleRepository) : ViewModel() {
    private val TAG = DetailViewModel::class.java.simpleName


}