package com.choius323.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.choius323.data.api.BroadService
import com.choius323.domain.model.Broad
import com.choius323.domain.model.Category

class BroadPagingSource(
    private val service: BroadService,
    private val id: String,
    private val category: Category,
    private val pageSize: Int,
) : PagingSource<Int, Broad>() {
    override fun getRefreshKey(state: PagingState<Int, Broad>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Broad> {
        return try {
            val nextPage = params.key ?: 1
            val response = service.getBroadList(
                id = id,
                categoryValue = category.num,
                page = nextPage,
            )
            val broadList = response.body()?.broadList ?: emptyList()
            LoadResult.Page(
                data = broadList.map { it.toBroad() },
                prevKey = null,
                nextKey = if (broadList.size == pageSize) nextPage + 1 else null,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

