package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.jonathan.component.ContainerViewHolderComponent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.VerticalListItemBinding

class ListComponent(
    private val itemDecoration: ItemDecoration
) : ContainerViewHolderComponent<VerticalListItemBinding>() {
    override fun initViewBinding(itemView: View): VerticalListItemBinding {
        return VerticalListItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.vertical_list_item

    override fun bind(binding: VerticalListItemBinding, position: Int) {
        with(binding.verticalList) {
            removeItemDecoration(itemDecoration)
            addItemDecoration(itemDecoration)
            setAdapterTo(this)
        }
    }
}