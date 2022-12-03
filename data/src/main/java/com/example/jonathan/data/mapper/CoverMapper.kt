package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.property.CoverResponse
import com.example.jonathan.data.response.property.SizeResponse
import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.SizeType

internal class CoverMapper(
    private val sizeMapper: Mapper<SizeResponse?, SizeType>
): Mapper<CoverResponse, Cover> {
    override fun map(value: CoverResponse): Cover {
        return Cover(
            url = value.url,
            size = sizeMapper.map(value.size)
        )
    }
}