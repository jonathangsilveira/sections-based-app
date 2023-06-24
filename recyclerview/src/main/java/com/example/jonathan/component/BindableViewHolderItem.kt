package com.example.jonathan.component

import android.view.View
import androidx.viewbinding.ViewBinding
import java.util.UUID

abstract class BindableViewHolderItem<VB : ViewBinding, CR: CommandReceiver> : ViewHolderItem<CR> {
    override val id: String = UUID.randomUUID().toString()
    override fun isRecyclable(): Boolean = true
    override fun bind(itemView: View, position: Int, onCommandChanged: (Command<CR>) -> Unit) {
        bind(initViewBinding(itemView), position, onCommandChanged)
    }

    override fun unbind(itemView: View) {
        unbind(initViewBinding(itemView))
    }

    abstract fun initViewBinding(itemView: View): VB
    abstract fun bind(binding: VB, position: Int, onCommandChanged: (Command<CR>) -> Unit)
    open fun unbind(binding: VB) = Unit
}
