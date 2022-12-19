package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.item.RecentlyPlayedItem
import com.example.jonathan.sectionsapp.component.RecentlyPlayedComponent

internal class RecentlyPlayedMapper: Mapper<RecentlyPlayedItem, ViewHolderComponent> {
    override fun map(value: RecentlyPlayedItem): ViewHolderComponent {
        return RecentlyPlayedComponent(value) {  }
    }
}