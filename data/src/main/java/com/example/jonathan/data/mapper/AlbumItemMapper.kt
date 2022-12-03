package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.item.AlbumItemResponse
import com.example.jonathan.domain.model.item.AlbumItem
import com.example.jonathan.domain.model.item.SectionItem

internal class AlbumItemMapper(
    override val coverMapper: CoverMapper,
    override val sizeMapper: SizeMapper
) : ItemMapper<AlbumItemResponse> {
    override fun map(value: AlbumItemResponse): SectionItem {
        return AlbumItem(
            id = value.id.orEmpty(),
            title = value.title,
            subtitle = value.subtitle,
            cover = coverMapper.map(value.cover!!),
            size = sizeMapper.map(value.size)
        )
    }
}