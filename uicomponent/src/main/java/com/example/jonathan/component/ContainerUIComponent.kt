package com.example.jonathan.component

import androidx.viewbinding.ViewBinding

abstract class ContainerUIComponent<VB : ViewBinding> : BindingUIComponent<VB>(), Container {
    private var placeholder: UIComponent? = null
    protected var adapter: UIComponentAdapter = UIComponentAdapter()
        private set

    override fun add(item: UIComponent) {
        this.adapter.add(item)
    }

    override fun addAll(items: List<UIComponent>) {
        this.adapter.addAll(items)
    }

    override fun remove(item: UIComponent) {
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

    override fun contains(item: UIComponent): Boolean = this.adapter.contains(item)

    fun setPlaceholder(placeholder: UIComponent) {
        this.placeholder = placeholder
    }

    fun newAdapter(): UIComponentAdapter {
        val newInstance = UIComponentAdapter()
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