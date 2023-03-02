package com.example.jonathan.sectionsapp.component

import android.view.View
import com.example.jonathan.component.BindingViewHolderItem
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.MessageItemBinding

class MessageItem(
    private val message: String
) : BindingViewHolderItem<MessageItemBinding>() {
    override fun initViewBinding(itemView: View): MessageItemBinding {
        return MessageItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.message_item

    override fun bind(binding: MessageItemBinding, position: Int, onItemEvent: OnItemEvent) {
        binding.messageItemText.text = message
    }
}