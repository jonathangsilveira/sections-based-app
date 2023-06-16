package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.annotation.DrawableRes
import com.example.jonathan.component.BindableViewHolderItem
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.BannerItemBinding

class BannerItem(
    @DrawableRes private val imageResId: Int,
    private val title: String,
    private val onClick: () -> Unit
) : BindableViewHolderItem<BannerItemBinding>() {
    override fun initViewBinding(itemView: View): BannerItemBinding {
        return BannerItemBinding.bind(itemView)
    }

    override fun bind(binding: BannerItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding) {
            bannerItemImage.setImageResource(imageResId)
            bannerItemTitle.text = title
            root.setOnClickListener { onClick() }
        }
    }

    override fun viewType(): Int = R.layout.banner_item
}