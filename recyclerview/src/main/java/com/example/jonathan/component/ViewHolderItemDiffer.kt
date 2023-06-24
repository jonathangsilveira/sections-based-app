package com.example.jonathan.component

import androidx.recyclerview.widget.DiffUtil

class ViewHolderItemDiffer<CR : CommandReceiver> : DiffUtil.ItemCallback<ViewHolderItem<CR>>() {
    override fun areItemsTheSame(
        oldItem: ViewHolderItem<CR>,
        newItem: ViewHolderItem<CR>
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: ViewHolderItem<CR>,
        newItem: ViewHolderItem<CR>
    ): Boolean = oldItem.id == newItem.id
}