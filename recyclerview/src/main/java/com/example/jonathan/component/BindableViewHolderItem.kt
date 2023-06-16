package com.example.jonathan.component

import android.view.View
import androidx.viewbinding.ViewBinding
import java.util.UUID

abstract class BindableViewHolderItem<VB : ViewBinding> : ViewHolderItem {
    override val id: String = UUID.randomUUID().toString()
    override fun isRecyclable(): Boolean = true
    override fun bind(itemView: View, position: Int, onItemEvent: OnItemEvent) {
        bind(initViewBinding(itemView), position, onItemEvent)
    }

    override fun unbind(itemView: View) {
        unbind(initViewBinding(itemView))
    }

    abstract fun initViewBinding(itemView: View): VB
    abstract fun bind(binding: VB, position: Int, onItemEvent: OnItemEvent)
    open fun unbind(binding: VB) = Unit
}
