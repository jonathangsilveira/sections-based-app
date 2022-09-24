package com.example.jonathan.sectionsapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private val items: List<Item<ItemViewHolder>> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = items.find { it.viewType() == viewType } ?: throw NotImplementedError()
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType()
    }
}