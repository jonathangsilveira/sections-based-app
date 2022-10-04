package com.example.jonathan.sectionsapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>(), Container {
    private val items: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = getItemOrThrow(viewType)
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

    fun update(items: List<Item>) {
        clear()
        addAll(items)
    }

    private fun getItemOrThrow(viewType: Int): Item {
        return items.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    override fun add(item: Item) {
        this.items.add(item)
        notifyItemInserted(this.items.lastIndex)
    }

    override fun addAll(items: List<Item>) {
        this.items.addAll(items)
        val insertedCount = itemCount
        notifyItemRangeInserted(0, insertedCount)
    }

    override fun remove(item: Item) {
        val position = this.items.indexOf(item)
        removeAt(position)
    }

    override fun removeAt(position: Int) {
        this.items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun clear() {
        val removedCount = itemCount
        this.items.clear()
        notifyItemRangeRemoved(0, removedCount)
    }

    override fun isEmpty(): Boolean = this.items.isEmpty()
}