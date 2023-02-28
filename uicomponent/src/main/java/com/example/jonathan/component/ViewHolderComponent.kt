package com.example.jonathan.component

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

interface ViewHolderComponent {
    val id: String
    @LayoutRes fun viewType(): Int
    fun createViewHolder(parent: ViewGroup): ComponentViewHolder
    fun inflateLayout(parent: ViewGroup): View
    fun bind(itemView: View, position: Int, onItemEvent: OnItemEvent)
    fun isSameAs(other: ViewHolderComponent): Boolean
    fun isSameContentAs(other: ViewHolderComponent): Boolean
}
