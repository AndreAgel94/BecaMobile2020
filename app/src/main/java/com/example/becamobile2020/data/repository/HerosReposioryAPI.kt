package com.example.becamobile2020.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.becamobile2020.data.api.ApiService
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.data.response.Character
import com.example.becamobile2020.data.response.HeroesResponse
import com.example.becamobile2020.presentation.registration.RegistrationViewParams
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HerosReposioryAPI {

    val heroesLivedata : MutableLiveData<List<Character>> = MutableLiveData()
    val oneHeroLiveData : MutableLiveData<Character> = MutableLiveData()



    fun getHeroes() : MutableLiveData<List<Character>>{
        ApiService.service.getHeroes().enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {heroesResponse ->
                        heroesLivedata.value = heroesResponse.data.results
                    }
                }
            }

            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
        return heroesLivedata
    }

    fun getHeroesSelected(query: String) : MutableLiveData<List<Character>>{
        ApiService.service.getHeroesSelected(query).enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {heroesResponse ->
                        heroesLivedata.value = heroesResponse.data.results
                    }
                }

            }
            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
        return heroesLivedata
    }

    fun getCharById(id : String) : MutableLiveData<Character>{
        ApiService.service.getCharById(id).enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {heroesResponse ->
                        oneHeroLiveData.value = heroesResponse.data.results[0]
                    }
                }
            }

            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
        return oneHeroLiveData
    }

}