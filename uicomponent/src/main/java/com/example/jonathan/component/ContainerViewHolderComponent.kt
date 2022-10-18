package com.example.jonathan.component

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ContainerViewHolderComponent<VB : ViewBinding>(
    private val adapter: ComponentAdapter = ComponentAdapter()
) : BindingViewHolderComponent<VB>(), Container by adapter {
    private var placeholder: ViewHolderComponent? = null

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

    fun setPlaceholder(placeholder: ViewHolderComponent) {
        this.placeholder = placeholder
    }

    fun setAdapterTo(recyclerView: RecyclerView) {
        recyclerView.adapter = this.adapter
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