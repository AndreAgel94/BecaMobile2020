package com.example.becamobile2020.data

import com.example.becamobile2020.data.response.Data
import com.example.becamobile2020.data.response.HeroesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelServices {

    /*
    http://gateway.marvel.com/v1/public/characters
    ?nameStartsWith=Iron%20Man
    ?ts=1
    &apikey=1234
    &hash=ffd275c5130566a2916217b101f26150

    http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150
     */
    @GET("characters")
    fun getHeroesSelected(

        @Query("nameStartsWith") nameStartsWith : String ,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()  // md5(TS+Pk+PB)
    ): Call<HeroesResponse>

    @GET("characters")
    fun getHeroes(

        //@Query("nameStartsWith") nameStartsWith : String ,
        @Query("limit") limit :Int = 100,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()  // md5(TS+Pk+PB)
    ): Call<HeroesResponse>


}