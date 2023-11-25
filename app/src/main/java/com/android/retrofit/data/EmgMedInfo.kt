package com.android.retrofit.data


import com.squareup.moshi.Json

data class EmgMedInfo(
    @Json(name = "head")
    val head: List<Head?>?,
    @Json(name = "row")
    val row: List<Row?>?
)