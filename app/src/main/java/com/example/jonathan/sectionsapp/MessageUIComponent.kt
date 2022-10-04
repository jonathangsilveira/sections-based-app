package com.example.jonathan.sectionsapp

import android.view.View
import com.example.jonathan.sectionsapp.databinding.MessageItemBinding

class MessageUIComponent(
    private val message: String
): com.example.jonathan.component.BindingUIComponent<MessageItemBinding>() {
    override fun initViewBinding(itemView: View): MessageItemBinding {
        return MessageItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.message_item

    override fun bind(binding: MessageItemBinding, position: Int) {
        binding.messageItemText.text = message
    }
}