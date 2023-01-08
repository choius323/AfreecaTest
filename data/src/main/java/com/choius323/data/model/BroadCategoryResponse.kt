package com.choius323.data.model

import com.google.gson.annotations.SerializedName

data class BroadCategoryResponse(
    @SerializedName("broad_category")
    val categories: List<CategoryResponse>
)