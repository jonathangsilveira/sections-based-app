package com.example.jonathan.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.util.UUID

abstract class BindingViewHolderItem<VB : ViewBinding> : ViewHolderItem {
    override val id: String = UUID.randomUUID().toString()
    override fun createViewHolder(parent: ViewGroup): ItemViewHolder {
        return ItemViewHolder(inflateLayout(parent))
    }

    override fun inflateLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context)
            .inflate(
                viewType(),
                parent,
                false
            )
    }
    override fun bind(itemView: View, position: Int, onItemEvent: OnItemEvent) {
        bind(initViewBinding(itemView), position, onItemEvent)
    }

    override fun isSameAs(other: ViewHolderItem): Boolean = this == other

    override fun isSameContentAs(other: ViewHolderItem): Boolean = id == other.id

    abstract fun initViewBinding(itemView: View): VB
    abstract fun bind(binding: VB, position: Int, onItemEvent: OnItemEvent)
}
