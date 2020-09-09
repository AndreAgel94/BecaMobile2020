package com.example.becamobile2020.presentation.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.model.Hero

class HeroesViewModel : ViewModel(){

    val heroesLiveData : MutableLiveData<List<Hero>> = MutableLiveData()

    fun getHeroes(){
        heroesLiveData.value = createFakeHeroes()
    }

    fun createFakeHeroes() : List<Hero>{
        return listOf<Hero>(
            Hero("spiderman","imgURL"),
            Hero("spiderman","imgURL"),
            Hero("spiderman","imgURL"),
            Hero("spiderman","imgURL"),
            Hero("spiderman","imgURL")
        )
    }
}