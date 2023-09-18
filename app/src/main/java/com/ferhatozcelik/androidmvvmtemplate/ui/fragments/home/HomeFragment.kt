package com.ferhatozcelik.androidmvvmtemplate.ui.fragments.home

import android.os.Bundle
import android.view.View
import com.ferhatozcelik.androidmvvmtemplate.databinding.FragmentHomeBinding
import com.ferhatozcelik.androidmvvmtemplate.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    private val TAG = "HomeFragment"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}