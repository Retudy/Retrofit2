package com.android.retrofit.data


import com.squareup.moshi.Json

data class RESULT(
    @Json(name = "CODE")
    val cODE: String?,
    @Json(name = "MESSAGE")
    val mESSAGE: String?
)