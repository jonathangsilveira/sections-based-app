package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.item.RowItemResponse
import com.example.jonathan.domain.model.item.RowItem

internal class RowItemMapper(
    override val coverMapper: CoverMapper,
    override val sizeMapper: SizeMapper
) : ItemMapper<RowItemResponse> {
    override fun map(value: RowItemResponse): RowItem {
        return RowItem(
            id = value.id.orEmpty(),
            title = value.title,
            subtitle = value.subtitle,
            cover = coverMapper.map(value.cover!!),
            size = sizeMapper.map(value.size)
        )
    }
}