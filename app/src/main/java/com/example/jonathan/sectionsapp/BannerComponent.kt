package com.example.jonathan.sectionsapp

import android.view.View
import com.example.jonathan.sectionsapp.databinding.BannerItemBinding

class BannerComponent(
    private val title: String,
    private val onClick: () -> Unit
) : com.example.jonathan.component.BindingViewHolderComponent<BannerItemBinding>() {
    override fun initViewBinding(itemView: View): BannerItemBinding {
        return BannerItemBinding.bind(itemView)
    }

    override fun bind(binding: BannerItemBinding, position: Int) {
        with(binding) {
            bannerItemTitle.text = title
            root.setOnClickListener { onClick() }
        }
    }

    override fun viewType(): Int = R.layout.banner_item
}