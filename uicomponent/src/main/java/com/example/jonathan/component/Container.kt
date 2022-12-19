package com.example.jonathan.component

interface Container {
    fun add(component: ViewHolderComponent)
    fun addAll(components: List<ViewHolderComponent>)
    fun remove(component: ViewHolderComponent)
    fun removeAt(position: Int)
    fun clear()
    fun isEmpty(): Boolean
    fun contains(component: ViewHolderComponent): Boolean
}