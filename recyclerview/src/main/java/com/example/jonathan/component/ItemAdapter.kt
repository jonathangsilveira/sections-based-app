package com.example.jonathan.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    var onActionItem: OnItemEvent = {}
) : RecyclerView.Adapter<ItemViewHolder>(), ViewHolderItemContainer {
    private val itemDiffer: DiffUtil.ItemCallback<ViewHolderItem> = ViewHolderItemDiffer()
    private val listDiffer: AsyncListDiffer<ViewHolderItem> = AsyncListDiffer(
        AdapterListUpdateCallback(this),
        AsyncDifferConfig.Builder(itemDiffer).build()
    )
    private var itemForViewTypeLookUp: ViewHolderItem? = null

    private val currentList: List<ViewHolderItem>
        get() = listDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = getItemOrThrow(viewType)
        val itemView = inflateLayout(parent, item.viewType())
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        item.bind(holder.itemView, position, onActionItem)
        holder.item = item
    }

    override fun onFailedToRecycleView(
        holder: ItemViewHolder
    ): Boolean = holder.canRecycleItemView()

    override fun onViewRecycled(holder: ItemViewHolder) {
        with(holder) { item?.unbind(itemView) }
    }

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType()
    }

    override fun add(item: ViewHolderItem) {
        updateItems {
            add(item)
            submitItems(this)
        }
    }

    override fun addAll(items: List<ViewHolderItem>) {
        updateItems {
            addAll(items)
            submitItems(this)
        }
    }

    override fun remove(item: ViewHolderItem) {
        val position = currentList.indexOf(item)
        removeAt(position)
    }

    override fun removeAt(position: Int) {
        updateItems {
            removeAt(position)
            submitItems(this)
        }
    }

    override fun clear() {
        submitItems(items = null)
    }

    override fun isEmpty(): Boolean = currentList.isEmpty()

    override fun contains(item: ViewHolderItem): Boolean = currentList.contains(item)

    fun submitItems(items: List<ViewHolderItem>?) {
        listDiffer.submitList(items)
    }

    private fun inflateLayout(parent: ViewGroup, @LayoutRes layoutResId: Int): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(layoutResId, parent, false)
    }

    private fun updateItems(
        block: MutableList<ViewHolderItem>.() -> Unit
    ): List<ViewHolderItem> {
        val mutableCurrentList = currentList.toMutableList()
        mutableCurrentList.apply(block)
        return mutableCurrentList
    }

    private fun getItem(position: Int): ViewHolderItem = currentList[position]

    private fun getItemOrThrow(viewType: Int): ViewHolderItem {
        itemForViewTypeLookUp?.let {
            if (it.viewType() == viewType) {
                return it
            }
        }
        val item = currentList.find {
            it.viewType() == viewType
        } ?: throw NotImplementedError()
        itemForViewTypeLookUp = item
        return item
    }
}