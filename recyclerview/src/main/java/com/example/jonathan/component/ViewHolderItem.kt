package com.example.jonathan.component

import android.view.View
import androidx.annotation.LayoutRes

interface ViewHolderItem {
    val id: String
    @LayoutRes fun viewType(): Int
    fun isRecyclable(): Boolean
    fun bind(itemView: View, position: Int, onItemEvent: OnItemEvent)
    fun unbind(itemView: View)
}
