package com.example.jonathan.domain.model.item

import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.SizeType

data class AlbumItem(
    override val id: Int,
    override val cover: Cover,
    override val size: SizeType,
    override val title: String?,
    val subtitle: String?
): SectionItem