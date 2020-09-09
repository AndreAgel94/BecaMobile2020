package com.example.becamobile2020.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroResultsResponse (
    @Json(name = "name")
    val name : String,
    @Json(name = "thumbnail")
    val thumbnail : List<HeroThumbnailResponse>
)