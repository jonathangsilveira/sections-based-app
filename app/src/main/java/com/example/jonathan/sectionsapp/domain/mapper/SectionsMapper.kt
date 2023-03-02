package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.*
import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.sectionsapp.R
import com.example.jonathan.sectionsapp.component.CarouselItem
import com.example.jonathan.sectionsapp.component.GridItem
import com.example.jonathan.sectionsapp.component.ListItem
import com.example.jonathan.sectionsapp.decoration.GridMarginItemDecoration
import com.example.jonathan.sectionsapp.decoration.HorizontalItemDecorator
import com.example.jonathan.sectionsapp.decoration.MarginItemDecoration

internal class SectionsMapper(
    private val headerMapper: Mapper<Header, ViewHolderItem>,
    private val itemMapper: Map<ItemType, Mapper<SectionItem, ViewHolderItem?>>
): Mapper<List<Section>, List<ViewHolderItem>> {
    override fun map(value: List<Section>): List<ViewHolderItem> {
        val components = mutableListOf<ViewHolderItem>()
        for (section in value) {
            section.header?.let { header ->
                val headerComponent = headerMapper.map(header)
                components.add(headerComponent)
            }
            val config = section.config ?: continue
            val container = mapContainer(config, section)
            val items = mapItems(section)
            container.addAll(items)
            components.add(container)
        }
        return components
    }

    private fun mapItems(section: Section) = section.items.mapNotNull { item ->
        itemMapper[section.itemType]?.map(item)
    }

    private fun mapContainer(
        config: Config,
        section: Section
    ) = when (config.layout) {
        Layout.GRID -> GridItem(
            item = section,
            itemDecorator = GridMarginItemDecoration(
                top = R.dimen.margin_02,
                bottom = R.dimen.no_margin,
                start = R.dimen.no_margin,
                end = R.dimen.margin_02
            )
        )
        Layout.LINEAR -> when (config.orientation) {
            Orientation.HORIZONTAL -> CarouselItem(
                HorizontalItemDecorator(start = R.dimen.no_margin, end = R.dimen.margin_02)
            )
            Orientation.VERTICAL -> ListItem(MarginItemDecoration())
        }
    }
}