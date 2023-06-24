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


class ItemAdapter<CR : CommandReceiver>(
    var onCommandChanged: (Command<CR>) -> Unit = {}
) : RecyclerView.Adapter<ItemViewHolder<CR>>(), ViewHolderItemContainer<CR> {
    private val itemDiffer: DiffUtil.ItemCallback<ViewHolderItem<CR>> = ViewHolderItemDiffer()
    private val listDiffer: AsyncListDiffer<ViewHolderItem<CR>> = AsyncListDiffer(
        AdapterListUpdateCallback(this),
        AsyncDifferConfig.Builder(itemDiffer).build()
    )
    private var itemForViewTypeLookUp: ViewHolderItem<CR>? = null

    private val currentList: List<ViewHolderItem<CR>>
        get() = listDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<CR> {
        val item = getItemOrThrow(viewType)
        val itemView = inflateLayout(parent, item.viewType())
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder<CR>, position: Int) {
        val item = getItem(position)
        item.bind(holder.itemView, position, onCommandChanged)
        holder.item = item
    }

    override fun onFailedToRecycleView(
        holder: ItemViewHolder<CR>
    ): Boolean = holder.canRecycleItemView()

    override fun onViewRecycled(holder: ItemViewHolder<CR>) {
        with(holder) { item?.unbind(itemView) }
    }

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType()
    }

    override fun add(item: ViewHolderItem<CR>) {
        updateItems {
            add(item)
            submitItems(this)
        }
    }

    override fun addAll(items: List<ViewHolderItem<CR>>) {
        updateItems {
            addAll(items)
            submitItems(this)
        }
    }

    override fun remove(item: ViewHolderItem<CR>) {
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

    override fun contains(item: ViewHolderItem<CR>): Boolean = currentList.contains(item)

    fun submitItems(items: List<ViewHolderItem<CR>>?) {
        listDiffer.submitList(items)
    }

    private fun inflateLayout(parent: ViewGroup, @LayoutRes layoutResId: Int): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(layoutResId, parent, false)
    }

    private fun updateItems(
        block: MutableList<ViewHolderItem<CR>>.() -> Unit
    ): List<ViewHolderItem<CR>> {
        val mutableCurrentList = currentList.toMutableList()
        mutableCurrentList.apply(block)
        return mutableCurrentList
    }

    private fun getItem(position: Int): ViewHolderItem<CR> = currentList[position]

    private fun getItemOrThrow(viewType: Int): ViewHolderItem<CR> {
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