package com.example.jonathan.data.response.property

import kotlinx.serialization.Serializable

@Serializable
internal data class CoverResponse(
    val url: String?,
    val size: SizeResponse?
)
