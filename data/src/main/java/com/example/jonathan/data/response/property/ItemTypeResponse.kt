package com.example.jonathan.data.response.property

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class ItemTypeResponse {
    @SerialName("recently_played") RECENTLY_PLAYED,
    @SerialName("album") ALBUM,
    @SerialName("row") ROW
}