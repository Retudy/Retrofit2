package com.android.retrofit.data


import com.google.gson.annotations.SerializedName

data class MapleData(
    @SerializedName("character_class")
    val characterClass: String?,
    @SerializedName("character_class_level")
    val characterClassLevel: String?,
    @SerializedName("character_exp")
    val characterExp: Long?,
    @SerializedName("character_exp_rate")
    val characterExpRate: String?,
    @SerializedName("character_gender")
    val characterGender: String?,
    @SerializedName("character_guild_name")
    val characterGuildName: String?,
    @SerializedName("character_image")
    val characterImage: String?,
    @SerializedName("character_level")
    val characterLevel: Int?,
    @SerializedName("character_name")
    val characterName: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("world_name")
    val worldName: String?,
    val ocid: String
)