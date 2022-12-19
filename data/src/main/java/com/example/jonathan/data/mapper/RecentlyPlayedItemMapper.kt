package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.item.RecentlyPlayedItemResponse
import com.example.jonathan.domain.model.item.RecentlyPlayedItem
import com.example.jonathan.domain.model.item.SectionItem

internal class RecentlyPlayedItemMapper(
    override val coverMapper: CoverMapper,
    override val sizeMapper: SizeMapper
) : ItemMapper<RecentlyPlayedItemResponse> {
    override fun map(value: RecentlyPlayedItemResponse): SectionItem {
        return RecentlyPlayedItem(
            id = value.id.orEmpty(),
            title = value.title,
            cover = coverMapper.map(value.cover!!),
            size = sizeMapper.map(value.size),
            isPlaying = value.isPlaying ?: false
        )
    }
}