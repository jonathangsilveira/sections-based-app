package com.example.jonathan.domain.model.item

import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.SizeType

data class RecentlyPlayedItem(
    override val id: String,
    override val cover: Cover,
    override val size: SizeType,
    override val title: String?,
    val isPlaying: Boolean
): SectionItem
