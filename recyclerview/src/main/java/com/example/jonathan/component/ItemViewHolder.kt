package com.example.jonathan.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder<CR: CommandReceiver>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var item: ViewHolderItem<CR>? = null
    fun canRecycleItemView(): Boolean = item?.isRecyclable() ?: false
}