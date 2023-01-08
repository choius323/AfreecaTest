package com.choius323.data.model


import com.choius323.domain.model.Category
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("cate_name")
    val cateName: String,
    @SerializedName("cate_no")
    val cateNo: String,
//    @SerializedName("child")
//    val childCategory: List<ChildCategory>,
) {
    fun toCategory() = Category(
        name = cateName,
        num = cateNo,
    )
}