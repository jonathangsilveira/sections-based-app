package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.*
import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.sectionsapp.component.CarouselComponent
import com.example.jonathan.sectionsapp.component.GridComponent
import com.example.jonathan.sectionsapp.component.ListComponent
import com.example.jonathan.sectionsapp.decoration.MarginItemDecoration

internal class SectionsMapper(
    private val headerMapper: Mapper<Header, ViewHolderComponent>,
    private val itemMapper: Map<ItemType, Mapper<SectionItem, ViewHolderComponent?>>
): Mapper<List<Section>, List<ViewHolderComponent>> {
    override fun map(value: List<Section>): List<ViewHolderComponent> {
        val components = mutableListOf<ViewHolderComponent>()
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

    private fun mapItems(section: Section) =
        section.items.mapNotNull { item ->
            itemMapper[section.itemType]?.map(item)
        }

    private fun mapContainer(
        config: Config,
        section: Section
    ) = when (config.layout) {
        Layout.GRID -> GridComponent(
            item = section,
            itemDecorator = MarginItemDecoration()
        )
        Layout.LINEAR -> when (config.orientation) {
            Orientation.HORIZONTAL -> CarouselComponent(MarginItemDecoration())
            Orientation.VERTICAL -> ListComponent(MarginItemDecoration())
        }
    }
}