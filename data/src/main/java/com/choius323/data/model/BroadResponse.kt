package com.choius323.data.model

import com.choius323.domain.model.Broad
import com.google.gson.annotations.SerializedName

data class BroadResponse(
    @SerializedName("broad_bps")
    val bps: String,
    @SerializedName("broad_cate_no")
    val categoryNum: String,
    @SerializedName("broad_grade")
    val grade: String,
    @SerializedName("broad_no")
    val num: String,
    @SerializedName("broad_resolution")
    val resolution: String,
    @SerializedName("broad_start")
    val start: String,
    @SerializedName("broad_thumb")
    val thumb: String,
    @SerializedName("broad_title")
    val title: String,
    @SerializedName("is_password")
    val isPassword: String,
    @SerializedName("profile_img")
    val profileImg: String,
    @SerializedName("total_view_cnt")
    val totalViewCnt: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_nick")
    val userNick: String,
    @SerializedName("visit_broad_type")
    val visitBroadType: String
){
    fun toBroad() = Broad(
        bps = this.bps,
        categoryNum = this.categoryNum,
        grade = this.grade,
        num = this.num,
        resolution = this.resolution,
        start = this.start,
        thumb = this.thumb,
        title = this.title,
        isPassword = this.isPassword,
        profileImg = this.profileImg,
        totalViewCnt = this.totalViewCnt,
        userId = this.userId,
        userNick = this.userNick,
        visitBroadType = this.visitBroadType,
    )
}
