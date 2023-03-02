package com.example.jonathan.sectionsapp.di

import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.item.SectionItem
import com.example.jonathan.domain.model.properties.ItemType
import com.example.jonathan.domain.repository.HomeRepository
import com.example.jonathan.sectionsapp.HomeViewModel
import com.example.jonathan.sectionsapp.domain.mapper.AlbumMapper
import com.example.jonathan.sectionsapp.domain.mapper.HeaderMapper
import com.example.jonathan.sectionsapp.domain.mapper.RecentlyPlayedMapper
import com.example.jonathan.sectionsapp.domain.mapper.SectionsMapper
import com.example.jonathan.sectionsapp.domain.usecase.GetHomeUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(
            getHomeUseCase = GetHomeUseCase(
                repository = get<HomeRepository>(),
                mapper = get<SectionsMapper>()
            )
        )
    }

    @Suppress("UNCHECKED_CAST")
    factory {
        SectionsMapper(
            headerMapper = HeaderMapper(),
            itemMapper = mapOf(
                ItemType.RECENTLY_PLAYED to RecentlyPlayedMapper(),
                ItemType.ALBUM to AlbumMapper()
            ) as Map<ItemType, Mapper<SectionItem, ViewHolderItem?>>
        )
    }
}