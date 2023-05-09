package com.example.jonathan.component

import androidx.recyclerview.widget.DiffUtil

internal class ItemDiffer : DiffUtil.ItemCallback<ViewHolderItem>() {
    override fun areItemsTheSame(
        oldItem: ViewHolderItem,
        newItem: ViewHolderItem
    ): Boolean = oldItem.isSameAs(newItem)

    override fun areContentsTheSame(
        oldItem: ViewHolderItem,
        newItem: ViewHolderItem
    ): Boolean = oldItem.isSameContentAs(newItem)
}