package com.example.jonathan.component

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter

class ItemListAdapter(
    var onItemEvent: OnItemEvent = {}
) :
    ListAdapter<ViewHolderItem, ItemViewHolder>(ViewHolderComponentDiffer()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = getItemOrThrow(viewType)
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindTo(item, position, onItemEvent)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType()
    }

    private fun getItemOrThrow(viewType: Int): ViewHolderItem {
        return currentList.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    private class ViewHolderComponentDiffer : ItemCallback<ViewHolderItem>() {
        override fun areItemsTheSame(
            oldItem: ViewHolderItem,
            newItem: ViewHolderItem
        ): Boolean = oldItem.isSameAs(newItem)

        override fun areContentsTheSame(
            oldItem: ViewHolderItem,
            newItem: ViewHolderItem
        ): Boolean = oldItem.isSameContentAs(newItem)
    }
}