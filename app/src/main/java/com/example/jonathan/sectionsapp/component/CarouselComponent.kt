package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.jonathan.component.ContainerViewHolderComponent
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.CarouselItemBinding
import com.example.jonathan.sectionsapp.setHorizontalLayoutManager

class CarouselComponent(
    private val itemDecoration: ItemDecoration
) : ContainerViewHolderComponent<CarouselItemBinding>() {
    override fun initViewBinding(itemView: View): CarouselItemBinding {
        return CarouselItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.carousel_item

    override fun bind(binding: CarouselItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding.carouselItems) {
            removeItemDecoration(itemDecoration)
            addItemDecoration(itemDecoration)
            setHorizontalLayoutManager(false)
            setOnItemEventListener(onItemEvent)
            setAdapterTo(this)
        }
    }
}