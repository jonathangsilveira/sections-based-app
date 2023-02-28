package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isGone
import coil.load
import coil.size.Scale
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.domain.model.properties.Header
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.HeaderItemBinding

class HeaderComponent(
    private val header: Header
) : BindingViewHolderComponent<HeaderItemBinding>() {
    override fun initViewBinding(itemView: View): HeaderItemBinding {
        return HeaderItemBinding.bind(itemView)
    }

    override fun bind(binding: HeaderItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding) {
            headetItemTitleText.text = header.title
            bindSubtitle(binding)
            bindCover(binding)
        }
    }

    override fun viewType(): Int = R.layout.header_item

    private fun bindSubtitle(binding: HeaderItemBinding) {
        with(binding.headerItemSubtitleText) {
            text = header.subtitle
            isGone = header.subtitle.isNullOrEmpty()
        }
    }

    private fun bindCover(binding: HeaderItemBinding) {
        with(binding.headerItemCoverImage) {
            isGone = header.cover == null
            load(header.cover?.url) {
                placeholder(R.drawable.ic_baseline_image_24)
                error(R.drawable.ic_round_broken_image_24)
                scale(Scale.FIT)
            }
        }
    }
}