package com.ferhatozcelik.androidmvvmtemplate.ui.fragments.detail

import android.os.Bundle
import android.view.View
import com.ferhatozcelik.androidmvvmtemplate.databinding.FragmentDetailBinding
import com.ferhatozcelik.androidmvvmtemplate.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {
    private val TAG = DetailFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}