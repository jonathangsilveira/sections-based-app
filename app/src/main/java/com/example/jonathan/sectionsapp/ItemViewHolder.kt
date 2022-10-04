package com.example.jonathan.sectionsapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item, position: Int) {
        item.bind(itemView, position)
    }
}