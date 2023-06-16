package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.jonathan.component.ContainerViewHolderItem
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.GridItemBinding

class GridItem(
    private val item: Section,
    private val itemDecorator: ItemDecoration
) : ContainerViewHolderItem<GridItemBinding>() {
    override fun initViewBinding(itemView: View): GridItemBinding {
        return GridItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.grid_item

    override fun bind(binding: GridItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding.gridItems) {
            addItemDecoration(itemDecorator)
            layoutManager = GridLayoutManager(
                context,
                item.config?.columns ?: 0,
                RecyclerView.VERTICAL,
                false
            )
            setAdapterTo(this)
        }
    }

    override fun unbind(binding: GridItemBinding) = with(binding.gridItems) {
        removeItemDecoration(itemDecorator)
    }
}