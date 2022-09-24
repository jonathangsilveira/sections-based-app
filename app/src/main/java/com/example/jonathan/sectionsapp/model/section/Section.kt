package com.example.jonathan.sectionsapp.model.section

import com.example.jonathan.sectionsapp.model.item.SectionItem
import com.example.jonathan.sectionsapp.model.properties.Header

interface Section {
    val id: Int
    val header: Header?
    val items: List<SectionItem>
}