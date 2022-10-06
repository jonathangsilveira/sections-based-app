package com.example.jonathan.component

import androidx.viewbinding.ViewBinding

abstract class ContainerViewHolderComponent<VB : ViewBinding> : BindingViewHolderComponent<VB>(),
    Container {
    private var placeholder: ViewHolderComponent? = null
    protected var adapter: ViewHolderComponentAdapter = ViewHolderComponentAdapter()
        private set

    override fun add(component: ViewHolderComponent) {
        this.adapter.add(component)
    }

    override fun addAll(components: List<ViewHolderComponent>) {
        this.adapter.addAll(components)
    }

    override fun remove(component: ViewHolderComponent) {
        this.adapter.remove(component)
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

    override fun contains(component: ViewHolderComponent): Boolean =
        this.adapter.contains(component)

    fun setPlaceholder(placeholder: ViewHolderComponent) {
        this.placeholder = placeholder
    }

    fun newAdapter(): ViewHolderComponentAdapter {
        val newInstance = ViewHolderComponentAdapter()
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