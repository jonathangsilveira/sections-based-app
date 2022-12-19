package com.example.jonathan.data.response.item

import com.example.jonathan.data.response.property.CoverResponse
import com.example.jonathan.data.response.property.SizeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("row")
internal data class RowItemResponse(
    override val id: String?,
    override val size: SizeResponse?,
    override val cover: CoverResponse?,
    override val title: String?,
    override val subtitle: String?,
    val isPlaying: Boolean?
) : SectionItemResponse