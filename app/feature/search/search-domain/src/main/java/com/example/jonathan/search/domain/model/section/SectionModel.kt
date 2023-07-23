package com.example.jonathan.search.domain.model.section

import com.example.jonathan.search.domain.model.item.ItemModel

data class SectionModel(
    val display: SectionDisplayEnum,
    val config: SectionConfigModel,
    val items: List<ItemModel>,
    val header: SectionHeaderModel?
)
