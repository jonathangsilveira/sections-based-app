package com.example.jonathan.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BindingUIComponent<VB : ViewBinding> : UIComponent {
    override fun createViewHolder(parent: ViewGroup): UIComponentViewHolder {
        return UIComponentViewHolder(inflateLayout(parent))
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
