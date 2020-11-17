package com.example.becamobile2020.presentation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.database.entity.HeroEntity
import com.example.becamobile2020.data.repository.HerosReposioryAPI
import com.example.becamobile2020.data.response.Character

class HeroesViewModel(
    private val reposioryAPI: HerosReposioryAPI
) : ViewModel(){

    fun getHeroes() : MutableLiveData<List<Character>> {return reposioryAPI.getHeroes()}
    fun getAllHeroesDAO() : LiveData<List<HeroEntity>>{return reposioryAPI.getAllHeroesDAO()}

    fun getHeroesByName(query : String) : MutableLiveData<List<Character>> {return reposioryAPI.getHeroesByName(query)}
    fun getHeroesByNameDAO(query: String) : LiveData<List<HeroEntity>>{return reposioryAPI.getHeroesByNameDAO(query)}
}