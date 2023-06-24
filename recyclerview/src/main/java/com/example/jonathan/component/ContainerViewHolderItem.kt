package com.example.jonathan.component

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ContainerViewHolderItem<VB : ViewBinding, CR : CommandReceiver>
    : BindableViewHolderItem<VB, CR>(), ViewHolderItemContainer<CR> {
    private val adapter: ItemAdapter<CR> = ItemAdapter()
    private var placeholder: ViewHolderItem<CR>? = null

    override fun add(item: ViewHolderItem<CR>) {
        if (isShowingPlaceholder()) removePlaceholder()
        this.adapter.add(item)
    }

    override fun addAll(items: List<ViewHolderItem<CR>>) {
        if (isShowingPlaceholder()) removePlaceholder()
        this.adapter.addAll(items)
    }

    override fun remove(item: ViewHolderItem<CR>) {
        this.adapter.remove(item)
        updateEmptyState()
    }

    override fun removeAt(position: Int) {
        this.adapter.removeAt(position)
        updateEmptyState()
    }

    override fun clear() {
        this.adapter.clear()
        updateEmptyState()
    }

    override fun isEmpty(): Boolean = isEmpty() || isShowingPlaceholder()

    override fun contains(item: ViewHolderItem<CR>): Boolean =
        this.adapter.contains(item)

    fun setPlaceholder(placeholder: ViewHolderItem<CR>) {
        this.placeholder = placeholder
    }

    fun setAdapterTo(recyclerView: RecyclerView) {
        recyclerView.adapter = this.adapter
    }

    fun setOnCommandChangedListener(action: (Command<CR>) -> Unit) {
        this.adapter.onCommandChanged = action
    }

    private fun updateEmptyState() {
        if (shouldDisplayPlaceholder())
            showPlaceholder()
    }

    private fun shouldDisplayPlaceholder(): Boolean {
        return isEmpty() || isShowingPlaceholder().not()
    }

    private fun showPlaceholder() {
        this.placeholder?.let {
            this.adapter.add(it)
        }
    }

    private fun isShowingPlaceholder(): Boolean {
        val placeholder = placeholder ?: return false
        return this.adapter.contains(placeholder)
    }

    private fun removePlaceholder() {
        placeholder?.let { this.adapter.remove(it) }
    }
}