package com.example.jonathan.component

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ContainerViewHolderComponent<VB : ViewBinding>
    : BindingViewHolderComponent<VB>(), Container {
    private val adapter: ComponentAdapter = ComponentAdapter()
    private var placeholder: ViewHolderComponent? = null

    override fun add(component: ViewHolderComponent) {
        if (isShowingPlaceholder()) removePlaceholder()
        this.adapter.add(component)
    }

    override fun addAll(components: List<ViewHolderComponent>) {
        if (isShowingPlaceholder()) removePlaceholder()
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

    override fun isEmpty(): Boolean = isEmpty() || isShowingPlaceholder()

    override fun contains(component: ViewHolderComponent): Boolean =
        this.adapter.contains(component)

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