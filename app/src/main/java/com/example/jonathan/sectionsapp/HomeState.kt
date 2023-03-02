package com.example.jonathan.sectionsapp

import com.example.jonathan.component.ViewHolderItem

internal data class HomeState(
    val isLoading: Boolean = false,
    val results: List<ViewHolderItem> = emptyList(),
    val error: String? = null
)
