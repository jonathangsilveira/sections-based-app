package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import coil.load
import coil.size.Scale
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.model.item.RecentlyPlayedItem
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.LatestPlaylistsItemBinding

class RecentlyPlayedComponent(
    private val recentlyPlayedItem: RecentlyPlayedItem,
    private val onClick: (component: ViewHolderComponent) -> Unit
) : BindingViewHolderComponent<LatestPlaylistsItemBinding>() {
    override fun initViewBinding(itemView: View): LatestPlaylistsItemBinding {
        return LatestPlaylistsItemBinding.bind(itemView)
    }

    override fun bind(binding: LatestPlaylistsItemBinding, position: Int) {
        bindImage(binding)
        bindTitle(binding)
        bindRecentIndicator(binding)
        setOnClickListener(binding)
    }

    override fun viewType(): Int = R.layout.latest_playlists_item

    private fun bindImage(binding: LatestPlaylistsItemBinding) {
        binding.shortcutItemRecentImage
            .load(recentlyPlayedItem.cover.url) {
                placeholder(R.drawable.ic_baseline_image_24)
                error(R.drawable.ic_round_broken_image_24)
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

    private fun setOnClickListener(binding: LatestPlaylistsItemBinding) {
        binding.root.setOnClickListener { onClick(this) }
    }
}