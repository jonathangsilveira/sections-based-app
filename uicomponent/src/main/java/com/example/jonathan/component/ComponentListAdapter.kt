package com.example.jonathan.component

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter

class ComponentListAdapter :
    ListAdapter<ViewHolderComponent, ComponentViewHolder>(ViewHolderComponentDiffer()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentViewHolder {
        val item = getItemOrThrow(viewType)
        return item.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType()
    }

    private fun getItemOrThrow(viewType: Int): ViewHolderComponent {
        return currentList.find { it.viewType() == viewType } ?: throw NotImplementedError()
    }

    private class ViewHolderComponentDiffer : ItemCallback<ViewHolderComponent>() {
        override fun areItemsTheSame(
            oldItem: ViewHolderComponent,
            newItem: ViewHolderComponent
        ): Boolean = oldItem.isSameAs(newItem)

        override fun areContentsTheSame(
            oldItem: ViewHolderComponent,
            newItem: ViewHolderComponent
        ): Boolean = oldItem.isSameContentAs(newItem)
    }
}