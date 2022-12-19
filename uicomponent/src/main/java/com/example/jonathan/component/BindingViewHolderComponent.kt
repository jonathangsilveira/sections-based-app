package com.example.jonathan.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.util.UUID

abstract class BindingViewHolderComponent<VB : ViewBinding> : ViewHolderComponent {
    override val id: String = UUID.randomUUID().toString()
    override fun createViewHolder(parent: ViewGroup): ComponentViewHolder {
        return ComponentViewHolder(inflateLayout(parent))
    }

    override fun inflateLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context)
            .inflate(
                viewType(),
                parent,
                false
            )
    }
    override fun bind(itemView: View, position: Int) {
        bind(initViewBinding(itemView), position)
    }

    override fun isSameAs(other: ViewHolderComponent): Boolean = this == other

    override fun isSameContentAs(other: ViewHolderComponent): Boolean = id == other.id

    abstract fun initViewBinding(itemView: View): VB
    abstract fun bind(binding: VB, position: Int)
}
