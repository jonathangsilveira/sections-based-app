package com.example.jonathan.domain.model.properties

data class Cover(
    val url: String?,
    val shape: Shape,
    val rounded: Boolean,
    val size: SizeType
): Element
