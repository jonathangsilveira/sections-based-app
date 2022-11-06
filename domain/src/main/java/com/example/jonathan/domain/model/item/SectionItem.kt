package com.example.jonathan.domain.model.item

import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.SizeType

interface SectionItem {
    val id: Int
    val cover: Cover
    val size: SizeType
    val title: String?
}