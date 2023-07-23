package com.example.jonathan.search.domain.model

import com.example.jonathan.search.domain.model.icon.IconModel
import com.example.jonathan.search.domain.model.image.ImageModel
import com.example.jonathan.search.domain.model.text.TextModel

data class ListItemModel(
    val image: ImageModel,
    val title: TextModel,
    val subtitle: TextModel?,
    val trailingIcon: IconModel?,
    val verifiedIcon: IconModel?
)
