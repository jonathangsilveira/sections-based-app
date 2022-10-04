package com.example.jonathan.sectionsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BindingItem<VB : ViewBinding> : Item {
    override fun createViewHolder(parent: ViewGroup): ItemViewHolder {
        return ItemViewHolder(inflateLayout(parent))
    }

    override fun inflateLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(
            viewType(),
            parent,
            false
        )
    }
    override fun bind(itemView: View, position: Int) {
        bind(initViewBinding(itemView), position)
    }
    abstract fun initViewBinding(itemView: View): VB
    abstract fun bind(binding: VB, position: Int)
}
