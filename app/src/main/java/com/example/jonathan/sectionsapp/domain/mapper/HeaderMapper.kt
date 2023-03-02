package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.properties.Header
import com.example.jonathan.sectionsapp.component.HeaderItem

internal class HeaderMapper: Mapper<Header, HeaderItem> {
    override fun map(value: Header) = HeaderItem(value)
}