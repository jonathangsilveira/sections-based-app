package com.example.jonathan.sectionsapp

import android.view.View
import com.example.jonathan.sectionsapp.databinding.GridItemBinding

class GridUIComponent(
    items: List<com.example.jonathan.component.UIComponent>? = null
): com.example.jonathan.component.ContainerUIComponent<GridItemBinding>() {

    init {
        if (!items.isNullOrEmpty())
            addAll(items)
    }

    override fun initViewBinding(itemView: View): GridItemBinding {
        return GridItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.grid_item

    override fun bind(binding: GridItemBinding, position: Int) {
        binding.gridItems.adapter = this.adapter
    }
}