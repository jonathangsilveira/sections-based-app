package com.example.jonathan.sectionsapp.model.item

import com.example.jonathan.sectionsapp.model.properties.Cover
import com.example.jonathan.sectionsapp.model.properties.SizeType
import com.example.jonathan.sectionsapp.model.properties.Text

data class PlaylistItem(
    override val id: Int,
    override val cover: Cover,
    override val size: SizeType,
    override val title: Text,
    val isRecentPlayed: Boolean
) : SectionItem
