package com.example.becamobile2020.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data (
    @Json(name = "results")
    val results : List<Character>
)