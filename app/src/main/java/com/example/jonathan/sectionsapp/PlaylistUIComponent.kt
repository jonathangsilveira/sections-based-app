package com.example.jonathan.sectionsapp

import android.view.View
import androidx.core.view.isVisible
import com.example.jonathan.sectionsapp.databinding.PlaylistItemBinding
import com.example.jonathan.domain.model.item.PlaylistItem

class PlaylistUIComponent(
    private val playlistItem: com.example.jonathan.domain.model.item.PlaylistItem,
    private val onClick: (UIComponent: com.example.jonathan.component.UIComponent) -> Unit
) : com.example.jonathan.component.BindingUIComponent<PlaylistItemBinding>() {
    override fun initViewBinding(itemView: View): PlaylistItemBinding {
        return PlaylistItemBinding.bind(itemView)
    }

    override fun bind(binding: PlaylistItemBinding, position: Int) {
        with(binding) {
            playlistItemTitleText.text = playlistItem.title.value
            playlistItemRecentImage.isVisible = playlistItem.isRecentPlayed
            root.setOnClickListener { onClick(this@PlaylistUIComponent) }
        }
    }

    override fun viewType(): Int = R.layout.playlist_item
}