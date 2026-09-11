package com.ferhatozcelik.androidmvvmtemplate.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ferhatozcelik.androidmvvmtemplate.interfaces.ItemClickListener

abstract class BaseAdapter<VB : ViewBinding, M>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    protected val list: List<M>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<VB>>() {

    class BaseViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val binding = bindingFactory(LayoutInflater.from(parent.context), parent, false)
        return BaseViewHolder(binding)
    }

    @CallSuper
    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        val item = list[position]
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(item)
        }
    }

    override fun getItemCount(): Int = list.size
}

