package com.example.becamobile2020.presentation.heroes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.ApiService
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.data.response.Character
import com.example.becamobile2020.data.response.HeroesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModel : ViewModel(){

    var query : String = "Spider"
    val _heroesLiveData = MutableLiveData<List<Character>>()
    val heroesLiveData : LiveData<List<Character>> = _heroesLiveData


    fun getHeroes(){
        ApiService.service.getHeroes().enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {heroesResponse ->
                        _heroesLiveData.value = heroesResponse.data.results
                    }
                }

            }
            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
    }

    fun getHeroesSelected(query: String){
        ApiService.service.getHeroesSelected(query).enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {heroesResponse ->
                        _heroesLiveData.value = heroesResponse.data.results
                    }
                }

            }
            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
    }


}