package com.ferhatozcelik.androidmvvmtemplate.ui.fragments.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferhatozcelik.androidmvvmtemplate.common.extensions.gone
import com.ferhatozcelik.androidmvvmtemplate.common.extensions.show
import com.ferhatozcelik.androidmvvmtemplate.databinding.FragmentHomeBinding
import com.ferhatozcelik.androidmvvmtemplate.interfaces.ItemClickListener
import com.ferhatozcelik.androidmvvmtemplate.ui.adapters.ListAdapter
import com.ferhatozcelik.androidmvvmtemplate.ui.base.BaseFragment
import com.ferhatozcelik.androidmvvmtemplate.util.collectOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), ItemClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewExamples.layoutManager = LinearLayoutManager(requireContext())

        collectOnStarted(viewModel.uiState) { state ->
            renderState(state)
        }
    }

    private fun renderState(state: HomeUiState) {
        when (state) {
            is HomeUiState.Loading -> {
                binding.progressLoading.show()
                binding.textError.gone()
            }

            is HomeUiState.Success -> {
                binding.progressLoading.gone()
                binding.textError.gone()
                binding.recyclerViewExamples.adapter = ListAdapter(
                    list = state.examples.map { it.title.orEmpty() },
                    itemClickListener = this
                )
            }

            is HomeUiState.Error -> {
                binding.progressLoading.gone()
                binding.textError.text = state.message
                binding.textError.show()
            }
        }
    }

    override fun onClick(objects: Any?) {
        // Navigate to DetailFragment using the Navigation Component, e.g.:
        // findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMyDeviceFragment())
    }
}
