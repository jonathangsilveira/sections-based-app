package com.example.jonathan.sectionsapp

import androidx.viewbinding.ViewBinding

abstract class ContainerItem<VB : ViewBinding> : BindingItem<VB>(), Container {
    private var placeholder: Item? = null
    protected var adapter: ItemAdapter = ItemAdapter()
        private set

    override fun add(item: Item) {
        this.adapter.add(item)
    }

    override fun addAll(items: List<Item>) {
        this.adapter.addAll(items)
    }

    override fun remove(item: Item) {
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

    override fun isEmpty(): Boolean {
        return this.adapter.isEmpty()
    }

    override fun contains(item: Item): Boolean = this.adapter.contains(item)

    fun setPlaceholder(placeholder: Item) {
        this.placeholder = placeholder
    }

    fun newAdapter(): ItemAdapter {
        val newInstance = ItemAdapter()
        this.adapter = newInstance
        return newInstance
    }

    private fun updateEmptyState() {
        if (shouldDisplayPlaceholder())
            showPlaceholder()
    }

    private fun shouldDisplayPlaceholder(): Boolean {
        return isEmpty() && hasPlaceholder()
    }

    private fun showPlaceholder() {
        this.placeholder?.let {
            this.adapter.add(it)
        }
    }

    private fun hasPlaceholder(): Boolean = placeholder != null
}