package com.example.jonathan.data.response.item

import com.example.jonathan.data.response.property.CoverResponse
import com.example.jonathan.data.response.property.SizeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("recently_played")
internal data class RecentlyPlayedItemResponse(
    override val id: String?,
    override val size: SizeResponse?,
    override val cover: CoverResponse?,
    override val title: String?,
    override val subtitle: String?,
    @SerialName("is_playing") val isPlaying: Boolean?
) : SectionItemResponse