package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.property.SizeResponse
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.properties.SizeType

internal class SizeMapper: Mapper<SizeResponse?, SizeType> {
    override fun map(value: SizeResponse?): SizeType {
        return when (value) {
            SizeResponse.SMALL -> SizeType.SMALL
            SizeResponse.MEDIUM -> SizeType.MEDIUM
            SizeResponse.LARGE -> SizeType.SMALL
            null -> SizeType.MEDIUM
        }
    }
}