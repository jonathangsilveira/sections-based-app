package com.example.jonathan.sectionsapp.model.section

import com.example.jonathan.sectionsapp.model.item.SectionItem
import com.example.jonathan.sectionsapp.model.properties.Header

data class GridSection(
    override val id: Int,
    override val header: Header?,
    override val items: List<SectionItem>,
    val columnsCount: Int
): Section