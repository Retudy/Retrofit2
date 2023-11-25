package com.android.retrofit.data


import com.squareup.moshi.Json

data class Head(
    @Json(name = "api_version")
    val apiVersion: String?,
    @Json(name = "list_total_count")
    val listTotalCount: Int?,
    @Json(name = "RESULT")
    val rESULT: RESULT?
)