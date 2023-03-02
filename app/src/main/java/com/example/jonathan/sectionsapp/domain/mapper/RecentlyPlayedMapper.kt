package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.domain.mapper.Mapper

internal class RecentlyPlayedMapper: Mapper<com.example.jonathan.domain.model.item.RecentlyPlayedItem, ViewHolderItem> {
    override fun map(value: com.example.jonathan.domain.model.item.RecentlyPlayedItem): ViewHolderItem {
        return com.example.jonathan.sectionsapp.component.RecentlyPlayedItem(value)
    }
}