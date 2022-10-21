package com.example.jonathan.sectionsapp.component

import android.view.View
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.BannerItemBinding

class BannerComponent(
    private val title: String,
    private val onClick: () -> Unit
) : BindingViewHolderComponent<BannerItemBinding>() {
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