package com.example.jonathan.sectionsapp.component

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.jonathan.component.BindingViewHolderComponent
import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.model.item.ShortcutItem
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.databinding.LatestPlaylistsItemBinding

class LatestPlaylistComponent(
    private val shortcut: ShortcutItem,
    private val onClick: (component: ViewHolderComponent) -> Unit
) : BindingViewHolderComponent<LatestPlaylistsItemBinding>() {
    override fun initViewBinding(itemView: View): LatestPlaylistsItemBinding {
        return LatestPlaylistsItemBinding.bind(itemView)
    }

    override fun bind(binding: LatestPlaylistsItemBinding, position: Int) {
        bindTitle(binding)
        bindRecentIndicator(binding)
        setOnClickListener(binding)
    }

    override fun viewType(): Int = R.layout.latest_playlists_item

    private fun bindTitle(binding: LatestPlaylistsItemBinding) {
        with(binding.shortcutItemTitleText) {
            isGone = shortcut.title.isNullOrEmpty()
            text = shortcut.title
        }
    }

    private fun bindRecentIndicator(binding: LatestPlaylistsItemBinding) {
        binding.shortcutItemRecentImage.isVisible = shortcut.isPlaying
    }

    private fun setOnClickListener(binding: LatestPlaylistsItemBinding) {
        binding.root.setOnClickListener { onClick(this) }
    }
}