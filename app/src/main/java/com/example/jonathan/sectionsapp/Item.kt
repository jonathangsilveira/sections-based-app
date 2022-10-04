package com.example.jonathan.sectionsapp

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

interface Item {
    @LayoutRes fun viewType(): Int
    fun createViewHolder(parent: ViewGroup): ItemViewHolder
    fun inflateLayout(parent: ViewGroup): View
    fun bind(itemView: View, position: Int)
}
