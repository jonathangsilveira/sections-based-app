package com.example.jonathan.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ComponentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindTo(item: ViewHolderComponent, position: Int, onItemEvent: OnItemEvent) {
        item.bind(itemView, position, onItemEvent)
    }
}