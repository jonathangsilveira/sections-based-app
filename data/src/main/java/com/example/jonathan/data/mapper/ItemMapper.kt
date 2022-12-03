package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.item.SectionItemResponse
import com.example.jonathan.domain.model.item.SectionItem

internal interface ItemMapper<T: SectionItemResponse>: Mapper<T, SectionItem> {
    val coverMapper: CoverMapper
    val sizeMapper: SizeMapper
}