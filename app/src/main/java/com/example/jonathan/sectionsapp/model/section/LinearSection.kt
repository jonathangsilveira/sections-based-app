package com.example.jonathan.sectionsapp.model.section

import com.example.jonathan.sectionsapp.model.item.SectionItem
import com.example.jonathan.sectionsapp.model.properties.Header

data class LinearSection(
    override val id: Int,
    override val header: Header?,
    override val items: List<SectionItem>,
    val orientation: Orientation = Orientation.VERTICAL
) : Section {
    enum class Orientation { VERTICAL, HORIZONTAL }
}
