package com.example.jonathan.sectionsapp

interface Container {
    fun add(item: Item)
    fun addAll(items: List<Item>)
    fun remove(item: Item)
    fun removeAt(position: Int)
    fun clear()
    fun isEmpty(): Boolean
}