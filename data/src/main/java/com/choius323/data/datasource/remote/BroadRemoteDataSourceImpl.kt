package com.choius323.data.datasource.remote

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.choius323.data.BuildConfig
import com.choius323.data.api.BroadService
import com.choius323.domain.model.Broad
import com.choius323.domain.model.Category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BroadRemoteDataSourceImpl @Inject constructor(
    private val broadService: BroadService
) : BroadRemoteDataSource {

    override suspend fun getCategory(): Result<List<Category>> {
        return runCatching {
            broadService.getCategoryList(KEY_AFREECA).body()?.categories?.map { it.toCategory() }
                ?: emptyList()
        }
    }

    override fun getBroadList(category: Category, pageSize: Int): Flow<PagingData<Broad>> {
        return Pager(config = PagingConfig(pageSize = pageSize)) {
            Log.d("BroadRemoteDataSourceImpl", "getBroadList: Pager")
            BroadPagingSource(broadService, KEY_AFREECA, category, pageSize)
        }.flow
    }

    companion object {
        private const val KEY_AFREECA = BuildConfig.KEY_AFREECA
    }
}