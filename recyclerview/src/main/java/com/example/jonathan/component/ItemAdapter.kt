package com.example.jonathan.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    var onActionItem: OnItemEvent = {}
) : RecyclerView.Adapter<ItemViewHolder>(), ViewHolderItemContainer {
    private val items: MutableList<ViewHolderItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = getItemOrThrow(viewType)
        val itemView = inflateLayout(parent, item.viewType())
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        item.bind(holder.itemView, position)
        holder.item = item
    }

    override fun onFailedToRecycleView(
        holder: ItemViewHolder
    ): Boolean = holder.canRecycleItemView()

    override fun onViewRecycled(holder: ItemViewHolder) {
        with(holder) { item?.unbind(itemView) }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType()
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

    private fun getItemOrThrow(viewType: Int): ViewHolderItem {
        return items.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    private fun inflateLayout(parent: ViewGroup, @LayoutRes layoutResId: Int): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(layoutResId, parent, false)
    }
}