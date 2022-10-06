package com.example.jonathan.sectionsapp.component

import android.view.View
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.MessageItemBinding

class MessageComponent(
    private val message: String
): com.example.jonathan.component.BindingViewHolderComponent<MessageItemBinding>() {
    override fun initViewBinding(itemView: View): MessageItemBinding {
        return MessageItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.message_item

    override fun bind(binding: MessageItemBinding, position: Int) {
        binding.messageItemText.text = message
    }
}