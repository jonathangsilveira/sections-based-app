package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isGone
import coil.load
import coil.size.Scale
import com.example.jonathan.component.BindableViewHolderItem
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.domain.model.item.AlbumItem
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.AlbumItemBinding

class AlbumItem(
    private val album: AlbumItem
) : BindableViewHolderItem<AlbumItemBinding>() {
    override fun initViewBinding(itemView: View): AlbumItemBinding {
        return AlbumItemBinding.bind(itemView)
    }

    override fun viewType(): Int = R.layout.album_item

    override fun bind(binding: AlbumItemBinding, position: Int, onItemEvent: OnItemEvent) {
        with(binding) {
            albumItemTitleText.text = album.title
            bindSubtitle(this)
            bindCover(this)
            root.setOnClickListener { onItemEvent(HomeItemEvent.ItemClicked) }
            root.setOnLongClickListener {
                onItemEvent(HomeItemEvent.ItemLongClicked)
                true
            }
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
            placeholder(R.drawable.album_placeholder)
            error(R.drawable.album_placeholder)
            scale(Scale.FIT)
        }
    }
}