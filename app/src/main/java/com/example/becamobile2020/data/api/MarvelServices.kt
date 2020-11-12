package com.example.becamobile2020.data.api


import com.example.becamobile2020.data.HASH
import com.example.becamobile2020.data.PUBLIC_KEY
import com.example.becamobile2020.data.TS
import com.example.becamobile2020.data.md5
import com.example.becamobile2020.data.response.HeroesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
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

    //retorna informações de um heroi pelo seu id
    @GET("characters/{characterId}")
        fun getCharById(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()  // md5(TS+Pk+PB)
    ): Call<HeroesResponse>

    //Pesquisa por um heroi específico pelo nome
    @GET("characters")
    fun getHeroesSelected(

        @Query("nameStartsWith") nameStartsWith : String,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()  // md5(TS+Pk+PB)
    ): Call<HeroesResponse>

    //lista os primeiros 100 herois
    @GET("characters")
    fun getHeroes(

        //@Query("nameStartsWith") nameStartsWith : String ,
        //@Query("limit") limit :Int = 100,
        @Query("ts") ts: String = TS,
        @Query("apikey") apikey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()  // md5(TS+Pk+PB)
    ): Call<HeroesResponse>

}