package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.HomeResponse
import com.example.jonathan.data.response.item.SectionItemResponse
import com.example.jonathan.data.response.property.ConfigResponse
import com.example.jonathan.data.response.property.ItemTypeResponse
import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.Config
import com.example.jonathan.domain.model.properties.Header
import com.example.jonathan.domain.model.properties.ItemType
import com.example.jonathan.domain.model.section.Section

internal class SectionMapper(
    private val configMapper: Mapper<ConfigResponse, Config>,
    private val headerMapper: Mapper<HomeResponse.SectionResponse.HeaderResponse, Header>,
    private val itemTypeMapper: Mapper<ItemTypeResponse, ItemType>,
    private val itemsMapper: Map<ItemType, Mapper<SectionItemResponse, SectionItem>>
) : Mapper<HomeResponse.SectionResponse, Section> {
    override fun map(value: HomeResponse.SectionResponse): Section {
        val itemType = itemTypeMapper.map(value.itemType)
        return Section(
            header = value.header?.let { headerMapper.map(it) },
            config = value.config?.let { configMapper.map(it) },
            itemType = itemType,
            items = value.items.mapNotNull {
                itemsMapper[itemType]?.map(it)
            }
        )
    }
}