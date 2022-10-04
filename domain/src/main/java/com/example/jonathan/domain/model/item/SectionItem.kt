package com.example.jonathan.domain.model.item

import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.SizeType
import com.example.jonathan.domain.model.properties.Text

interface SectionItem {
    val id: Int
    val cover: Cover
    val size: SizeType
    val title: Text
}