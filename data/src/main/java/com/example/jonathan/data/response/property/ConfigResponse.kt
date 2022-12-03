package com.example.jonathan.data.response.property

import kotlinx.serialization.Serializable

@Serializable
internal data class ConfigResponse(
    val layout: LayoutResponse,
    val orientation: OrientationResponse,
    val columns: Int?
)