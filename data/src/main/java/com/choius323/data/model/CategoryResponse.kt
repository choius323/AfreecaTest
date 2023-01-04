package com.choius323.data.model


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("cate_name")
    val cateName: String,
    @SerializedName("cate_no")
    val cateNo: Int,
//    @SerializedName("child")
//    val childCategory: List<ChildCategory>,
)