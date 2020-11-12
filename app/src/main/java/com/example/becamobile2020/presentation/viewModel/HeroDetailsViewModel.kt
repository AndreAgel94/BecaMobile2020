package com.example.becamobile2020.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.repository.HerosReposiory
import com.example.becamobile2020.data.response.Character

class HeroDetailsViewModel(
    private val reposiory: HerosReposiory
) : ViewModel() {


      fun getCharById(id: String) : MutableLiveData<Character>{
          return reposiory.getCharById(id)
      }
//    fun getCharById(id : String){ // aplica o método enqueue a getHeroes do MarvelService
//        ApiService.service.getCharById(id).enqueue(object : Callback<HeroesResponse> {
//
//            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        heroesLiveData.value = it.data.results[0]
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

}