package com.example.jonathan.search.domain.model.common

data class NavigationModel(
    val type: NavigationTypeEnum,
    val value: String,
    override val tracking: TrackingModel?
) : TrackableModel
