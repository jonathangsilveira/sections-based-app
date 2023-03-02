package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.domain.mapper.Mapper

internal class AlbumMapper: Mapper<com.example.jonathan.domain.model.item.AlbumItem, ViewHolderItem> {
    override fun map(value: com.example.jonathan.domain.model.item.AlbumItem) =
        com.example.jonathan.sectionsapp.component.AlbumItem(value)
}