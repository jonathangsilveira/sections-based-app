package com.example.jonathan.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UIComponentAdapter : RecyclerView.Adapter<UIComponentViewHolder>(), Container {
    private val items: MutableList<UIComponent> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UIComponentViewHolder {
        val item = getItemOrThrow(viewType)
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: UIComponentViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType()
    }

    fun update(items: List<UIComponent>) {
        clear()
        addAll(items)
    }

    private fun getItemOrThrow(viewType: Int): UIComponent {
        return items.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    override fun add(item: UIComponent) {
        this.items.add(item)
        notifyItemInserted(this.items.lastIndex)
    }

    override fun addAll(items: List<UIComponent>) {
        this.items.addAll(items)
        val insertedCount = itemCount
        notifyItemRangeInserted(0, insertedCount)
    }

    override fun remove(item: UIComponent) {
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

    override fun contains(item: UIComponent): Boolean = this.items.contains(item)
}