package com.example.becamobile2020.data

import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.data.response.HeroBodyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelServices {

    /*
    http://gateway.marvel.com/v1/public/characters
    ?ts=1
    &apikey=1234
    &hash=ffd275c5130566a2916217b101f26150

    http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150
     */


    @GET("v1/public/characters")
    fun getHeroes(
        @Query("ts") ts: String = "1599662551",
        @Query("apikey") apikey: String = "90d3a000c01c8afc57416dece53616c5",
        @Query("hash") hash: String = "0ce0b85c77ceb03a4d1b0c847fbc599d"
    ): Call<HeroBodyData>

}