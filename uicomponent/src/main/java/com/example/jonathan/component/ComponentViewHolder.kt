package com.example.jonathan.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ComponentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ViewHolderComponent, position: Int) {
        item.bind(itemView, position)
    }
}