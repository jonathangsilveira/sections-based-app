package com.example.jonathan.domain.model.section

import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.Header

interface Section {
    val id: Int
    val header: Header?
    val items: List<SectionItem>
}