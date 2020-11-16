package com.example.becamobile2020.presentation.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.repository.HerosReposioryAPI
import com.example.becamobile2020.data.response.Character

class HeroesViewModel(
    private val reposioryAPI: HerosReposioryAPI
) : ViewModel(){

    fun getHeroes() : MutableLiveData<List<Character>> {
        return reposioryAPI.getHeroes()
    }

    fun getHeroesSelected(query : String) : MutableLiveData<List<Character>> {
        return reposioryAPI.getHeroesSelected(query)
    }



}