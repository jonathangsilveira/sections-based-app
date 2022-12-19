package com.example.jonathan.data.response.property

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class OrientationResponse {
    @SerialName("horizontal") HORIZONTAL,
    @SerialName("vertical") VERTICAL
}