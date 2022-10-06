package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isVisible
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.PlaylistItemBinding

class PlaylistComponent(
    private val playlistItem: com.example.jonathan.domain.model.item.PlaylistItem,
    private val onClick: (ViewHolderComponent: com.example.jonathan.component.ViewHolderComponent) -> Unit
) : com.example.jonathan.component.BindingViewHolderComponent<PlaylistItemBinding>() {
    override fun initViewBinding(itemView: View): PlaylistItemBinding {
        return PlaylistItemBinding.bind(itemView)
    }

    override fun bind(binding: PlaylistItemBinding, position: Int) {
        with(binding) {
            playlistItemTitleText.text = playlistItem.title.value
            playlistItemRecentImage.isVisible = playlistItem.isRecentPlayed
            root.setOnClickListener { onClick(this@PlaylistComponent) }
        }
    }

    override fun viewType(): Int = R.layout.playlist_item
}