package com.example.jonathan.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class UIComponentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: UIComponent, position: Int) {
        item.bind(itemView, position)
    }
}