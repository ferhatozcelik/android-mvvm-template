package com.ferhatozcelik.androidmvvmtemplate.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.ferhatozcelik.androidmvvmtemplate.domain.usecase.main.GetLocalUseCase
import com.ferhatozcelik.androidmvvmtemplate.domain.usecase.main.GetRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getLocalUseCase: GetLocalUseCase,
                                          private val getRemoteUseCase: GetRemoteUseCase) : ViewModel() {
    private val TAG = DetailViewModel::class.java.simpleName


}