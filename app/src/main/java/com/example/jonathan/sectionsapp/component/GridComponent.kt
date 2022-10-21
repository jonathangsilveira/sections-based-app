package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.jonathan.component.ContainerViewHolderComponent
import com.example.jonathan.domain.model.section.GridSection
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.GridItemBinding

class GridComponent(
    private val item: GridSection,
    private val itemDecorator: ItemDecoration
) : ContainerViewHolderComponent<GridItemBinding>() {
    override fun initViewBinding(itemView: View): GridItemBinding {
        return GridItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.grid_item

    override fun bind(binding: GridItemBinding, position: Int) {
        with(binding.gridItems) {
            removeItemDecoration(itemDecorator)
            addItemDecoration(itemDecorator)
            layoutManager = GridLayoutManager(
                context,
                item.columnsCount,
                RecyclerView.VERTICAL,
                false
            )
            setAdapterTo(this)
        }
    }
}