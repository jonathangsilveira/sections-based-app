package com.example.jonathan.data.response.property

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class LayoutResponse {
    @SerialName("grid") GRID,
    @SerialName("linear") LINEAR
}