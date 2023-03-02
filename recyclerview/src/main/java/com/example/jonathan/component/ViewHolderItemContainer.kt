package com.example.jonathan.component

interface ViewHolderItemContainer {
    fun add(item: ViewHolderItem)
    fun addAll(items: List<ViewHolderItem>)
    fun remove(item: ViewHolderItem)
    fun removeAt(position: Int)
    fun clear()
    fun isEmpty(): Boolean
    fun contains(item: ViewHolderItem): Boolean
}