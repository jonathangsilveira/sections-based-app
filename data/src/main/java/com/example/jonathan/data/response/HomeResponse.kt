package com.example.jonathan.data.response

import com.example.jonathan.data.response.item.SectionItemResponse
import com.example.jonathan.data.response.property.ConfigResponse
import com.example.jonathan.data.response.property.CoverResponse
import com.example.jonathan.data.response.property.ItemTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class HomeResponse(
    val result: List<SectionResponse>
) {

    @Serializable
    data class SectionResponse(
        val header: HeaderResponse?,
        val config: ConfigResponse?,
        @SerialName("item_type") val itemType: ItemTypeResponse,
        val items: List<SectionItemResponse>
    ) {
        @Serializable
        data class HeaderResponse(
            val title: String,
            val subtitle: String?,
            val cover: CoverResponse?
        )
    }
}
