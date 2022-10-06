package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.CarouselItemBinding

class CarouselComponent(
    private val items: List<com.example.jonathan.component.ViewHolderComponent>
): com.example.jonathan.component.ContainerViewHolderComponent<CarouselItemBinding>() {
    override fun initViewBinding(itemView: View): CarouselItemBinding {
        return CarouselItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.carousel_item

    override fun bind(binding: CarouselItemBinding, position: Int) {
        binding.carouselItems.layoutManager = LinearLayoutManager(
            binding.root.context,
            RecyclerView.HORIZONTAL,
            false
        )
        binding.carouselItems.adapter = super.adapter
        addAll(items)
    }
}