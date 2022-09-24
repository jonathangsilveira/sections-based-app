package com.example.jonathan.sectionsapp

import android.view.ViewGroup
import androidx.annotation.LayoutRes

interface Item<VH : ItemViewHolder> {
    @LayoutRes fun viewType(): Int
    fun createViewHolder(parent: ViewGroup): VH
    fun bind(holder: VH, position: Int)
}
