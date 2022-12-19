package com.example.jonathan.data.source

import com.example.jonathan.data.request.HomeRequestData
import com.example.jonathan.domain.model.section.Section

internal interface RemoteDataSource {
    suspend fun getHome(request: HomeRequestData): List<Section>
}