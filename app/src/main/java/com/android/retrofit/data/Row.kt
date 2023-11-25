package com.android.retrofit.data


import com.squareup.moshi.Json

data class Row(
    @Json(name = "DISTRCT_DIV_NM")
    val dISTRCTDIVNM: String?,
    @Json(name = "EMGNCY_CENTER_TELNO")
    val eMGNCYCENTERTELNO: String?,
    @Json(name = "MEDCARE_INST_NM")
    val mEDCAREINSTNM: String?,
    @Json(name = "REFINE_LOTNO_ADDR")
    val rEFINELOTNOADDR: String?,
    @Json(name = "REFINE_ROADNM_ADDR")
    val rEFINEROADNMADDR: String?,
    @Json(name = "REFINE_WGS84_LAT")
    val rEFINEWGS84LAT: String?,
    @Json(name = "REFINE_WGS84_LOGT")
    val rEFINEWGS84LOGT: String?,
    @Json(name = "REPRSNT_TELNO")
    val rEPRSNTTELNO: String?,
    @Json(name = "SIGUN_CD")
    val sIGUNCD: String?,
    @Json(name = "SIGUN_NM")
    val sIGUNNM: String?,
    @Json(name = "SUM_DE")
    val sUMDE: String?
)