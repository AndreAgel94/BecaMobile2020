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

    val _heroesLiveData = MutableLiveData<List<Character>>()
    val heroesLiveData : LiveData<List<Character>> = _heroesLiveData

    fun getHeroes(){
        //heroesLiveData.value = createFakeHeroes()
        ApiService.service.getHeroes().enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    val listHeroes: MutableList<Hero> = mutableListOf()

                    response.body()?.let {heroesResponse ->
                        _heroesLiveData.value = heroesResponse.data.results
                    }
//                        for (item in heroesResponse.data.results) {
//
//                            val hero : Hero = Hero(
//                                name = item.name,
//                                description = item.description,
//                                heroimage = item.thumbnail.path,
//                                extension = item.thumbnail.extension
//                            )
//                            listHeroes.add(hero)
//                        }
//
//                    }
//                    for (item in listHeroes) {
//
//                        Log.i("maluco1111", item.heroimage + item.extension)
//
//                    }
                   // heroesLiveData.value = listHeroes
                }

            }

            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
    }

}