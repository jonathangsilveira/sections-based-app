package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.annotation.DrawableRes
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.RowItemBinding

class RowComponent(
    @DrawableRes private val coverResId: Int,
    private val title: String,
    private val subtitle: String,
    @DrawableRes private val trailingIconResId: Int,
) : BindingViewHolderComponent<RowItemBinding>() {
    override fun initViewBinding(itemView: View): RowItemBinding {
        return RowItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.row_item

    override fun bind(binding: RowItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding) {
            rowItemCover.setImageResource(coverResId)
            rowItemTitle.text = title
            rowItemSubtitle.text = subtitle
            with(rowItemTrailingIcon) {
                setImageResource(trailingIconResId)
                setOnClickListener { onItemEvent(HomeItemEvent.RemoveItemClicked) }
            }
            root.setOnClickListener { onItemEvent(HomeItemEvent.ItemClicked) }
            root.setOnLongClickListener {
                onItemEvent(HomeItemEvent.ItemLongClicked)
                true
            }
        }
    }
}