package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.HomeResponse
import com.example.jonathan.data.response.property.CoverResponse
import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.Header

internal class HeaderMapper(
    private val coverMapper: Mapper<CoverResponse, Cover>
): Mapper<HomeResponse.SectionResponse.HeaderResponse, Header> {
    override fun map(value: HomeResponse.SectionResponse.HeaderResponse): Header {
        return Header(
            title = value.title,
            subtitle = value.subtitle,
            cover = value.cover?.let { coverMapper.map(it) }
        )
    }
}