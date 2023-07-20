package com.ferhatozcelik.androidmvvmtemplate.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : Any>(private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB) : Fragment() {
    private val TAG = BaseFragment::class.java.simpleName

    lateinit var binding: VB

    val viewModel: VM by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = bindingFactory(inflater, container, false)
        Log.i(TAG, "onCreateView()")
        return binding.root
    }
}