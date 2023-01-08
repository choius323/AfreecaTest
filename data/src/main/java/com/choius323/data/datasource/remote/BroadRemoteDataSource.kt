package com.choius323.data.datasource.remote

import androidx.paging.PagingData
import com.choius323.domain.model.Broad
import com.choius323.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface BroadRemoteDataSource {
    suspend fun getCategory(): Result<List<Category>>
    fun getBroadList(category: Category, pageSize: Int = 60): Flow<PagingData<Broad>>
}