package com.choius323.data.api

import com.choius323.data.model.BroadListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BroadService {

    @GET("list")
    suspend fun getBroadList(
        @Query("client_id") id: String,
        @Query("select_value") categoryValue: String,
        @Query("page_no") page: Int,
    ): Response<BroadListResponse>
}