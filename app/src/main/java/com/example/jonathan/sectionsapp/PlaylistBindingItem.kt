package com.example.jonathan.sectionsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.jonathan.sectionsapp.databinding.PlaylistItemBinding
import com.example.jonathan.sectionsapp.model.item.PlaylistItem

class PlaylistBindingItem(
    private val playlistItem: PlaylistItem,
    private val onClick: () -> Unit
): BindingItem<PlaylistItemBinding>() {
    override fun inflateViewGroup(parent: ViewGroup): PlaylistItemBinding {
        return PlaylistItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    }
    override fun bind(binding: PlaylistItemBinding, position: Int) {
        with(binding) {
            playlistItemTitleText.text = playlistItem.title.value
            playlistItemRecentImage.isVisible = playlistItem.isRecentPlayed
        }
    }
    override fun viewType(): Int = R.layout.playlist_item
}