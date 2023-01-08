package com.choius323.domain.repository

import androidx.paging.PagingData
import com.choius323.domain.model.Broad
import com.choius323.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface BroadRepository {
    suspend fun getCategory(): List<Category>

    fun getBroadList(category: Category): Flow<PagingData<Broad>>
}