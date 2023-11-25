package com.android.retrofit.data


import com.squareup.moshi.Json

data class EmgMedResponse(
    @Json(name = "EmgMedInfo")
    val emgMedInfo: List<EmgMedInfo?>?
)