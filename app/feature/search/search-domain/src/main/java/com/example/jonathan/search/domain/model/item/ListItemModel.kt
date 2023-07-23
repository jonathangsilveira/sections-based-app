package com.example.jonathan.search.domain.model.item

import com.example.jonathan.search.domain.model.common.NavigationModel
import com.example.jonathan.search.domain.model.icon.IconModel
import com.example.jonathan.search.domain.model.image.ImageModel
import com.example.jonathan.search.domain.model.text.TextModel

data class ListItemModel(
    val image: ImageModel,
    val title: TextModel,
    val subtitle: TextModel?,
    val trailingIcon: IconModel?,
    val verifiedIcon: IconModel?,
    override val navigation: NavigationModel,
    override val cacheId: String?
) : ItemModel
