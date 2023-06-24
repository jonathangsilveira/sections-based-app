package com.example.jonathan.sectionsapp

import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.sectionsapp.component.HomeCommandReceiver

internal data class HomeState(
    val isLoading: Boolean = false,
    val results: List<ViewHolderItem<HomeCommandReceiver>> = emptyList(),
    val error: String? = null
)
