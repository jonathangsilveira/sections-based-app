package com.example.jonathan.search.domain.model.image

import com.example.jonathan.search.domain.model.common.SizeEnum

data class ImageModel(
    val placeholder: ImagePlaceholderEnum,
    val shape: ImageShapeEnum,
    val size: SizeEnum,
    val url: String?
)
