package com.example.becamobile2020.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.ApiService
import com.example.becamobile2020.data.response.Character
import com.example.becamobile2020.data.response.HeroesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroDetailsViewModel : ViewModel() {

    val heroesLiveData = MutableLiveData<Character>()



    fun getCharById(id : String){ // aplica o método enqueue a getHeroes do MarvelService
        ApiService.service.getCharById(id).enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        heroesLiveData.value = it.data.results[0]
                    }
                }
            }

            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
    }

}