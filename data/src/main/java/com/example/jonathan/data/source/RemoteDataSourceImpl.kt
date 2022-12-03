package com.example.jonathan.data.source

import com.example.jonathan.data.HomeService
import com.example.jonathan.data.mapper.Mapper
import com.example.jonathan.data.request.HomeRequestData
import com.example.jonathan.data.response.HomeResponse
import com.example.jonathan.domain.model.section.Section

internal class RemoteDataSourceImpl(
    private val homeService: HomeService,
    private val mapper: Mapper<HomeResponse.SectionResponse, Section>
) : RemoteDataSource {
    override suspend fun getHome(request: HomeRequestData): List<Section> {
        val response = homeService.getHome(request)
        return response.result.map { mapper.map(it) }
    }
}