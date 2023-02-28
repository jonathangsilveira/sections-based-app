package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.jonathan.component.ContainerViewHolderComponent
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.VerticalListItemBinding

class ListComponent(
    private val itemDecoration: ItemDecoration
) : ContainerViewHolderComponent<VerticalListItemBinding>() {
    override fun initViewBinding(itemView: View): VerticalListItemBinding {
        return VerticalListItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.vertical_list_item

    override fun bind(binding: VerticalListItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding.verticalList) {
            removeItemDecoration(itemDecoration)
            addItemDecoration(itemDecoration)
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )
            setAdapterTo(this)
        }
    }
}