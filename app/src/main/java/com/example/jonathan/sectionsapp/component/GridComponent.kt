package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.jonathan.component.ContainerViewHolderComponent
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.GridItemBinding

class GridComponent(
    private val item: Section,
    private val itemDecorator: ItemDecoration
) : ContainerViewHolderComponent<GridItemBinding>() {
    override fun initViewBinding(itemView: View): GridItemBinding {
        return GridItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.grid_item

    override fun bind(binding: GridItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding.gridItems) {
            removeItemDecoration(itemDecorator)
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
}