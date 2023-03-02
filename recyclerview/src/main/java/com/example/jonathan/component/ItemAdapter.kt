package com.example.jonathan.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    var onActionItem: OnItemEvent = {}
) : RecyclerView.Adapter<ItemViewHolder>(), ViewHolderItemContainer {
    private val items: MutableList<ViewHolderItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = getItemOrThrow(viewType)
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bindTo(item, position, onActionItem)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType()
    }

    private fun getItemOrThrow(viewType: Int): ViewHolderItem {
        return items.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    override fun add(item: ViewHolderItem) {
        this.items.add(item)
        notifyItemInserted(this.items.lastIndex)
    }

    override fun addAll(items: List<ViewHolderItem>) {
        this.items.addAll(items)
        val insertedCount = itemCount
        notifyItemRangeInserted(0, insertedCount)
    }

    override fun remove(item: ViewHolderItem) {
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

    override fun contains(item: ViewHolderItem): Boolean = this.items.contains(item)
}