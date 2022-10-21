package com.example.jonathan.component

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ComponentAdapter : RecyclerView.Adapter<ComponentViewHolder>(), Container {
    private val items: MutableList<ViewHolderComponent> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        val item = getItemOrThrow(viewType)
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType()
    }

    private fun getItemOrThrow(viewType: Int): ViewHolderComponent {
        return items.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    override fun add(component: ViewHolderComponent) {
        this.items.add(component)
        notifyItemInserted(this.items.lastIndex)
    }

    override fun addAll(components: List<ViewHolderComponent>) {
        this.items.addAll(components)
        val insertedCount = itemCount
        notifyItemRangeInserted(0, insertedCount)
    }

    override fun remove(component: ViewHolderComponent) {
        val position = this.items.indexOf(component)
        removeAt(position)
    }

    override fun removeAt(position: Int) {
        this.items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun clear() {
        val removedCount = itemCount
        this.items.clear()
        notifyItemRangeRemoved(0, removedCount)
    }

    override fun isEmpty(): Boolean = this.items.isEmpty()

    override fun contains(component: ViewHolderComponent): Boolean = this.items.contains(component)
}