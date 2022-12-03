package com.example.jonathan.domain.model.section

import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.Config
import com.example.jonathan.domain.model.properties.Header
import com.example.jonathan.domain.model.properties.ItemType

data class Section(
    val header: Header?,
    val config: Config?,
    val itemType: ItemType,
    val items: List<SectionItem>
)