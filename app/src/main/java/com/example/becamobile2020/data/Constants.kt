package com.example.becamobile2020.data

import java.util.*

const val PUBLIC_KEY = "your public key here"
const val PRIVATE_KEY = "your private key here"
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"