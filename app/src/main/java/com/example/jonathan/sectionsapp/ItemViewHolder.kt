package com.example.jonathan.sectionsapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item<ItemViewHolder>, position: Int) {
        item.bind(this, position)
    }
}