package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isGone
import coil.load
import coil.size.Scale
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.domain.model.item.AlbumItem
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.AlbumItemBinding

class AlbumComponent(
    private val album: AlbumItem
) : BindingViewHolderComponent<AlbumItemBinding>() {
    override fun initViewBinding(itemView: View): AlbumItemBinding {
        return AlbumItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.album_item

    override fun bind(binding: AlbumItemBinding, position: Int) {
        with(binding) {
            albumItemTitleText.text = album.title
            bindSubtitle(this)
            bindCover(this)
        }
    }

    private fun bindSubtitle(binding: AlbumItemBinding) {
        with(binding.albumItemSubtitleText) {
            isGone = album.subtitle.isNullOrEmpty()
            text = album.subtitle
        }
    }

    private fun bindCover(binding: AlbumItemBinding) {
        binding.albumItemCoverImage.load(album.cover.url) {
            placeholder(R.drawable.ic_baseline_image_24)
            error(R.drawable.ic_round_broken_image_24)
            scale(Scale.FIT)
        }
    }
}