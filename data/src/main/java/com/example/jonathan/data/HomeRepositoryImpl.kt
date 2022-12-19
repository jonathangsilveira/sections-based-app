package com.example.jonathan.data

import com.example.jonathan.data.request.HomeRequestData
import com.example.jonathan.data.source.RemoteDataSource
import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.domain.repository.HomeRepository
import com.example.jonathan.domain.request.HomeRequest

internal class HomeRepositoryImpl constructor(
    private val remoteDataSource: RemoteDataSource
): HomeRepository {
    override suspend fun getHome(request: HomeRequest): List<Section> {
        return remoteDataSource.getHome(
            request = HomeRequestData(request.userId)
        )
    }
}