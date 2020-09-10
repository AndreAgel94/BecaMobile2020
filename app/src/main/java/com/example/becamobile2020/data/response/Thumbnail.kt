package com.example.becamobile2020.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Thumbnail(

    val path : String,
    val extension : String
)