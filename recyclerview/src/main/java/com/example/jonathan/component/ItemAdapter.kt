package com.example.jonathan.component

import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    var onActionItem: OnItemEvent = {}
) : RecyclerView.Adapter<ItemViewHolder>(), ViewHolderItemContainer {
    private val itemDiffer: DiffUtil.ItemCallback<ViewHolderItem> = ItemDiffer()
    private val listDiffer: AsyncListDiffer<ViewHolderItem> = AsyncListDiffer(
        AdapterListUpdateCallback(this),
        AsyncDifferConfig.Builder(itemDiffer).build()
    )
    private var itemForViewTypeLookUp: ViewHolderItem? = null

    private val currentList: List<ViewHolderItem> get() = listDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = getItemOrThrow(viewType)
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindTo(item, position, onActionItem)
    }

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType()
    }

    private fun getItemOrThrow(viewType: Int): ViewHolderItem {
        itemForViewTypeLookUp?.let {
            if (it.viewType() == viewType) {
                return it
            }
        }
        val item = currentList.find { it.viewType() == viewType }
            ?: throw NotImplementedError()
        itemForViewTypeLookUp = item
        return item
    }

    override fun add(item: ViewHolderItem) {
        updateCurrentList {
            add(item)
            updateItems(this)
        }
    }

    override fun addAll(items: List<ViewHolderItem>) {
        updateCurrentList {
            addAll(items)
            updateItems(this)
        }
    }

    override fun remove(item: ViewHolderItem) {
        val position = currentList.indexOf(item)
        removeAt(position)
    }

    override fun removeAt(position: Int) {
        updateCurrentList {
            removeAt(position)
            updateItems(this)
        }
    }

    override fun clear() {
        updateItems(listOf())
    }

    override fun isEmpty(): Boolean = currentList.isEmpty()

    override fun contains(item: ViewHolderItem): Boolean = currentList.contains(item)

    private fun getItem(position: Int): ViewHolderItem = currentList[position]

    private fun updateCurrentList(
        block: MutableList<ViewHolderItem>.() -> Unit
    ): List<ViewHolderItem> {
        val mutableCurrentList = currentList.toMutableList()
        mutableCurrentList.apply(block)
        return mutableCurrentList
    }

    fun updateItems(items: List<ViewHolderItem>?) {
        listDiffer.submitList(items)
    }
}