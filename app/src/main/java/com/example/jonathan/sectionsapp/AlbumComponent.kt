package com.example.jonathan.sectionsapp

import android.view.View
import com.example.jonathan.sectionsapp.databinding.AlbumItemBinding

class AlbumComponent(
    private val title: String,
    private val subtitle: String?
) : com.example.jonathan.component.BindingViewHolderComponent<AlbumItemBinding>() {
    override fun initViewBinding(itemView: View): AlbumItemBinding {
        return AlbumItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.album_item

    override fun bind(binding: AlbumItemBinding, position: Int) {
        with(binding) {
            albumItemTitleText.text = title
            albumItemSubtitleText.text = subtitle
        }
    }
}