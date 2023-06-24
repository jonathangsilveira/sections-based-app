package com.example.jonathan.component

import android.view.View
import androidx.annotation.LayoutRes

interface ViewHolderItem<CR: CommandReceiver> {
    val id: String
    @LayoutRes fun viewType(): Int
    fun isRecyclable(): Boolean
    fun bind(itemView: View, position: Int, onCommandChanged: (Command<CR>) -> Unit)
    fun unbind(itemView: View)
}
