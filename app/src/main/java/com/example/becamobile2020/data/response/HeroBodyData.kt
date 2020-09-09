package com.example.becamobile2020.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroBodyData (
    @Json(name = "data")
    val data : List<HeroDataResponse>
)