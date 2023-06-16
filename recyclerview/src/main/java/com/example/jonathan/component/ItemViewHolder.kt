package com.example.jonathan.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var item: ViewHolderItem? = null
    fun canRecycleItemView(): Boolean = item?.isRecyclable() ?: false
}