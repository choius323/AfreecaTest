package com.choius323.data.model

import com.google.gson.annotations.SerializedName

data class BroadListResponse(
    @SerializedName("total_cnt")
    val totalCount: Int,
    @SerializedName("page_no")
    val page: Int,
    @SerializedName("broad")
    val broadList: List<BroadResponse>,
    @SerializedName("time")
    val time: Int,
)
