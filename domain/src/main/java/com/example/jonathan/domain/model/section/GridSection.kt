package com.example.jonathan.domain.model.section

import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.Header

data class GridSection(
    override val id: Int,
    override val header: Header?,
    override val items: List<SectionItem>,
    val columnsCount: Int
): Section