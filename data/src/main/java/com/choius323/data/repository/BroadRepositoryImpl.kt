package com.choius323.data.repository

import androidx.paging.PagingData
import com.choius323.data.datasource.remote.BroadRemoteDataSource
import com.choius323.domain.model.Broad
import com.choius323.domain.model.Category
import com.choius323.domain.repository.BroadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BroadRepositoryImpl @Inject constructor(
    private val broadRemoteDataSource: BroadRemoteDataSource,
) : BroadRepository {
    override suspend fun getCategory(): List<Category> {
        val result = broadRemoteDataSource.getCategory()
        return result.getOrNull() ?: emptyList()
    }

    override fun getBroadList(category: Category): Flow<PagingData<Broad>> {
        return broadRemoteDataSource.getBroadList(category)
    }
}