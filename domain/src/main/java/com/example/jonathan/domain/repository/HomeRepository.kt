package com.example.jonathan.domain.repository

import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.domain.request.HomeRequest

interface HomeRepository {
    suspend fun getHome(request: HomeRequest): List<Section>
}