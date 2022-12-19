@file:OptIn(ExperimentalSerializationApi::class)

package com.example.jonathan.data.response.item

import com.example.jonathan.data.response.property.CoverResponse
import com.example.jonathan.data.response.property.SizeResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonClassDiscriminator

@JsonClassDiscriminator("type")
internal interface SectionItemResponse {
    val id: String?
    val size: SizeResponse?
    val cover: CoverResponse?
    val title: String?
    val subtitle: String?
}