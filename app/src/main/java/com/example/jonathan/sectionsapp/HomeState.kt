package com.example.jonathan.sectionsapp

import com.example.jonathan.component.ViewHolderComponent

internal data class HomeState(
    val isLoading: Boolean = false,
    val results: List<ViewHolderComponent> = emptyList(),
    val error: String? = null
)
