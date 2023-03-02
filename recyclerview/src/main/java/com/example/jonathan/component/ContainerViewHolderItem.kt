package com.example.jonathan.component

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ContainerViewHolderItem<VB : ViewBinding>
    : BindingViewHolderItem<VB>(), ViewHolderItemContainer {
    private val adapter: ItemAdapter = ItemAdapter()
    private var placeholder: ViewHolderItem? = null

    override fun add(item: ViewHolderItem) {
        if (isShowingPlaceholder()) removePlaceholder()
        this.adapter.add(item)
    }

    override fun addAll(items: List<ViewHolderItem>) {
        if (isShowingPlaceholder()) removePlaceholder()
        this.adapter.addAll(items)
    }

    override fun remove(item: ViewHolderItem) {
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

    override fun contains(item: ViewHolderItem): Boolean =
        this.adapter.contains(item)

    fun setPlaceholder(placeholder: ViewHolderItem) {
        this.placeholder = placeholder
    }

    fun setOnItemEventListener(onItemEvent: OnItemEvent) {
        this.adapter.onActionItem = onItemEvent
    }

    fun setAdapterTo(recyclerView: RecyclerView) {
        recyclerView.adapter = this.adapter
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