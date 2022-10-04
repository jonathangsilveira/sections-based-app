package com.example.jonathan.domain.model.properties

data class Text(
    val value: String,
    val appearance: Appearance,
    val style: Style
): Element {
    data class Appearance(
        val size: SizeType
    )
    enum class Style { ITALIC, BOLD }
}