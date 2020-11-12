package com.example.becamobile2020.presentation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.api.ApiService
import com.example.becamobile2020.data.repository.HerosReposiory
import com.example.becamobile2020.data.response.Character
import com.example.becamobile2020.data.response.HeroesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModel(
    private val reposiory: HerosReposiory
) : ViewModel(){

//    val _heroesLiveData = MutableLiveData<List<Character>>()
//    val heroesLiveData : LiveData<List<Character>> = _heroesLiveData // livedata = MutableLiveData


    fun getHeroes() : MutableLiveData<List<Character>> {
        return reposiory.getHeroes()
    }

    fun getHeroesSelected(query : String) : MutableLiveData<List<Character>> {
        return reposiory.getHeroesSelected(query)
    }


//    fun getHeroes(){ // aplica o método enqueue a getHeroes do MarvelService
//        ApiService.service.getHeroes().enqueue(object : Callback<HeroesResponse> {
//
//            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        _heroesLiveData.value = it.data.results
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {
//
//            }
//
//        })
//    }
//
//    fun getHeroesSelected(query: String){ // aplica o método enqueue a getHeroesSelected do MarvelService
//        ApiService.service.getHeroesSelected(query).enqueue(object : Callback<HeroesResponse> {
//
//            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
//                if (response.isSuccessful){
//                    response.body()?.let {heroesResponse ->
//                        _heroesLiveData.value = heroesResponse.data.results
//                    }
//                }
//
//            }
//            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {
//
//            }
//
//        })
//    }


}