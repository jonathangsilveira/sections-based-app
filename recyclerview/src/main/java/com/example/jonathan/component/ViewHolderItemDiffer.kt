package com.example.jonathan.component

import androidx.recyclerview.widget.DiffUtil

class ViewHolderItemDiffer : DiffUtil.ItemCallback<ViewHolderItem>() {
    override fun areItemsTheSame(
        oldItem: ViewHolderItem,
        newItem: ViewHolderItem
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: ViewHolderItem,
        newItem: ViewHolderItem
    ): Boolean = oldItem.id == newItem.id
}