package com.example.becamobile2020.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private fun initRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service: MarvelServices = initRetrofit().create(MarvelServices::class.java)

}