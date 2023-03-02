package com.example.jonathan.sectionsapp.domain.usecase

import com.example.jonathan.component.ViewHolderItem
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.section.Section
import com.example.jonathan.domain.repository.HomeRepository
import com.example.jonathan.domain.request.HomeRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

internal class GetHomeUseCase(
    private val repository: HomeRepository,
    private val mapper: Mapper<List<Section>, List<ViewHolderItem>>,
    private val ioContext: CoroutineContext = Dispatchers.IO
) {

    suspend operator fun invoke(
        request: HomeRequest
    ): List<ViewHolderItem> = withContext(ioContext) {
        val sections = repository.getHome(request)
        mapper.map(sections)
    }
}