package com.example.jonathan.component

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

interface ViewHolderItem {
    val id: String
    @LayoutRes fun viewType(): Int
    fun createViewHolder(parent: ViewGroup): ItemViewHolder
    fun inflateLayout(parent: ViewGroup): View
    fun bind(itemView: View, position: Int, onItemEvent: OnItemEvent)
    fun isSameAs(other: ViewHolderItem): Boolean
    fun isSameContentAs(other: ViewHolderItem): Boolean
}
