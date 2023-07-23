package com.example.jonathan.search.domain.model.common

data class ButtonModel(
    val text: String,
    override val navigation: NavigationModel,
) : NavigableModel
