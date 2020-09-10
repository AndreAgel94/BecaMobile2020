package com.example.becamobile2020.data

import java.util.*

const val PUBLIC_KEY = "pk"
const val PRIVATE_KEY = "private_key"
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"