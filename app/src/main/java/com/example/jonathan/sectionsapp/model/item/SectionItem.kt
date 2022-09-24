package com.example.jonathan.sectionsapp.model.item

import com.example.jonathan.sectionsapp.model.properties.Cover
import com.example.jonathan.sectionsapp.model.properties.SizeType
import com.example.jonathan.sectionsapp.model.properties.Text

interface SectionItem {
    val id: Int
    val cover: Cover
    val size: SizeType
    val title: Text
}