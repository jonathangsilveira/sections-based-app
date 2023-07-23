package com.example.jonathan.search.domain.model.item

import com.example.jonathan.search.domain.model.common.NavigableModel

interface ItemModel : NavigableModel {
    val cacheId: String?
}