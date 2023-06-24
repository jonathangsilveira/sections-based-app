package com.example.jonathan.component

interface ViewHolderItemContainer<CR: CommandReceiver> {
    fun add(item: ViewHolderItem<CR>)
    fun addAll(items: List<ViewHolderItem<CR>>)
    fun remove(item: ViewHolderItem<CR>)
    fun removeAt(position: Int)
    fun clear()
    fun isEmpty(): Boolean
    fun contains(item: ViewHolderItem<CR>): Boolean
}