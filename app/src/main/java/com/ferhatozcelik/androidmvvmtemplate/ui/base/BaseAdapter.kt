package com.ferhatozcelik.androidmvvmtemplate.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ferhatozcelik.androidmvvmtemplate.interfaces.ItemClickListener

abstract class BaseAdapter<VB : ViewBinding, M>(private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB, private val list: List<M>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder<VB>>() {
    private val TAG = "BaseAdapter"

    class BaseViewHolder<VB : ViewBinding>(binding: VB) : RecyclerView.ViewHolder(binding.root) {
        var binding: VB

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val binding = bindingFactory(LayoutInflater.from(parent.context), parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        val device = list[position]
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(device)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

