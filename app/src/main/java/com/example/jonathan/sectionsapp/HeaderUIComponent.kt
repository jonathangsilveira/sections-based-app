package com.example.jonathan.sectionsapp

import android.view.View
import com.example.jonathan.sectionsapp.databinding.HeaderItemBinding

class HeaderUIComponent(private val title: String) : com.example.jonathan.component.BindingUIComponent<HeaderItemBinding>() {
    override fun initViewBinding(itemView: View): HeaderItemBinding {
        return HeaderItemBinding.bind(itemView)
    }

    override fun bind(binding: HeaderItemBinding, position: Int) {
        with(binding) {
            headetItemTitleText.text = title
        }
    }

    override fun viewType(): Int = R.layout.header_item
}