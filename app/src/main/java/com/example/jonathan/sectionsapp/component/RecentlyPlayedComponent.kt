package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import coil.load
import coil.size.Scale
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.component.OnItemEvent
import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.model.item.RecentlyPlayedItem
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.LatestPlaylistsItemBinding

class RecentlyPlayedComponent(
    private val recentlyPlayedItem: RecentlyPlayedItem
) : BindingViewHolderComponent<LatestPlaylistsItemBinding>() {
    override fun initViewBinding(itemView: View): LatestPlaylistsItemBinding {
        return LatestPlaylistsItemBinding.bind(itemView)
    }

    override fun bind(
        binding: LatestPlaylistsItemBinding,
        position: Int,
        onItemEvent: OnItemEvent
    ) {
        bindImage(binding)
        bindTitle(binding)
        bindRecentIndicator(binding)
        with(binding.root) {
            setOnClickListener { HomeItemEvent.ItemClicked }
            setOnLongClickListener {
                HomeItemEvent.ItemLongClicked
                true
            }
        }
    }

    override fun viewType(): Int = R.layout.latest_playlists_item

    private fun bindImage(binding: LatestPlaylistsItemBinding) {
        binding.shortcutItemRecentImage
            .load(recentlyPlayedItem.cover.url) {
                placeholder(R.drawable.album_placeholder)
                error(R.drawable.album_placeholder)
                scale(Scale.FIT)
            }
    }

    private fun bindTitle(binding: LatestPlaylistsItemBinding) {
        with(binding.shortcutItemTitleText) {
            isGone = recentlyPlayedItem.title.isNullOrEmpty()
            text = recentlyPlayedItem.title
        }
    }

    private fun bindRecentIndicator(binding: LatestPlaylistsItemBinding) {
        binding.shortcutItemRecentImage.isVisible = recentlyPlayedItem.isPlaying
    }
}