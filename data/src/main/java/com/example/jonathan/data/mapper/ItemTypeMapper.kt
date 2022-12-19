package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.property.ItemTypeResponse
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.properties.ItemType

internal class ItemTypeMapper : Mapper<ItemTypeResponse, ItemType> {
    override fun map(value: ItemTypeResponse): ItemType {
        return when (value) {
            ItemTypeResponse.RECENTLY_PLAYED -> ItemType.RECENTLY_PLAYED
            ItemTypeResponse.ALBUM -> ItemType.ALBUM
            ItemTypeResponse.ROW -> ItemType.ROW
        }
    }
}