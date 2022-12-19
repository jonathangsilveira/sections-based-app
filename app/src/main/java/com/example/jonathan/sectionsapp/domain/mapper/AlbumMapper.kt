package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.item.AlbumItem
import com.example.jonathan.domain.model.item.RecentlyPlayedItem
import com.example.jonathan.sectionsapp.component.AlbumComponent
import com.example.jonathan.sectionsapp.component.RecentlyPlayedComponent

internal class AlbumMapper: Mapper<AlbumItem, ViewHolderComponent> {
    override fun map(value: AlbumItem) = AlbumComponent(value)
}