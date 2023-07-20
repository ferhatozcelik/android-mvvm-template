package com.ferhatozcelik.androidmvvmtemplate.ui.adapters

import com.ferhatozcelik.androidmvvmtemplate.databinding.ListItemBinding
import com.ferhatozcelik.androidmvvmtemplate.interfaces.ItemClickListener
import com.ferhatozcelik.androidmvvmtemplate.ui.base.BaseAdapter

class ListAdapter(list: List<String>, itemClickListener: ItemClickListener) : BaseAdapter<ListItemBinding, String>(ListItemBinding::inflate, list, itemClickListener) {
    private val TAG = ListAdapter::class.java.simpleName

    override fun onBindViewHolder(holder: BaseViewHolder<ListItemBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }

}

