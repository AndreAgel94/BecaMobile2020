package com.example.becamobile2020.data

import java.util.*

const val PUBLIC_KEY = "90d3a000c01c8afc57416dece53616c5"
const val PRIVATE_KEY = "744f9ef85c3f718e91d15861291e4ae35cf05697"
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"