package com.example.jonathan.component

interface Container {
    fun add(item: UIComponent)
    fun addAll(items: List<UIComponent>)
    fun remove(item: UIComponent)
    fun removeAt(position: Int)
    fun clear()
    fun isEmpty(): Boolean
    fun contains(item: UIComponent): Boolean
}