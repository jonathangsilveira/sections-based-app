package com.example.jonathan.search.domain.model.section

import com.example.jonathan.search.domain.model.common.ButtonModel
import com.example.jonathan.search.domain.model.image.ImageModel
import com.example.jonathan.search.domain.model.text.TextModel

data class SectionHeaderModel(
    val title: TextModel,
    val subtitle: TextModel?,
    val image: ImageModel?,
    val button: ButtonModel?
)
