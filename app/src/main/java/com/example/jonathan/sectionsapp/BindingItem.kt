package com.example.jonathan.sectionsapp

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BindingItem<VB : ViewBinding> : Item<BindingItemViewHolder<VB>> {
    override fun createViewHolder(parent: ViewGroup): BindingItemViewHolder<VB> {
        return BindingItemViewHolder(inflateViewGroup(parent))
    }

    override fun bind(holder: BindingItemViewHolder<VB>, position: Int) {
        bind(holder.binding, position)
    }
    abstract fun inflateViewGroup(parent: ViewGroup): VB
    abstract fun bind(binding: VB, position: Int)
}
