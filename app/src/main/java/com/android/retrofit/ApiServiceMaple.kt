package com.android.retrofit

import com.android.retrofit.data.MapleData
import com.android.retrofit.data.Ocid
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiServiceMaple {
    @GET("/maplestory/v1/id")
    fun getocid(

        @Header("x-nxopen-api-key") apiKey: String,
        @Query("character_name") charactername: String,

    ): Call<MapleData>

    @GET("/maplestory/v1/character/basic")
    fun getCharacter(
        @Header("x-nxopen-api-key")apiKey: String,
        @Query("ocid") ocid: String,
        @Query("date") date: String
    ): Call<MapleData>
}