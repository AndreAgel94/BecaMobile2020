package com.example.becamobile2020.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroThumbnailResponse(

    val path : String,
    val extension : String
)