package com.example.jonathan.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindTo(item: ViewHolderItem, position: Int, onItemEvent: OnItemEvent) {
        item.bind(itemView, position, onItemEvent)
    }
}