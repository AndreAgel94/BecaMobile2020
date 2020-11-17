package com.example.becamobile2020.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import com.example.becamobile2020.data.api.ApiService
import com.example.becamobile2020.data.database.dao.HeroDao
import com.example.becamobile2020.data.database.entity.HeroEntity
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.data.response.Character
import com.example.becamobile2020.data.response.HeroesResponse
import com.example.becamobile2020.presentation.registration.RegistrationViewParams
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HerosReposioryAPI(
    private val dao : HeroDao
) {

    val heroesLivedata : MutableLiveData<List<Character>> = MutableLiveData()
    val oneHeroLiveData : MutableLiveData<Character> = MutableLiveData()


    fun getAllHeroesDAO()  : LiveData<List<HeroEntity>> {return dao.getAllHeroes()}

    fun getHeroes() : MutableLiveData<List<Character>>{
        ApiService.service.getHeroes().enqueue(object : Callback<HeroesResponse> {

            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful){
                    response.body()?.let {heroesResponse ->
                        heroesLivedata.value = heroesResponse.data.results
                        for (hero in heroesResponse.data.results){
                            val entity = HeroEntity(hero.id,
                                hero.name,
                                hero.description,
                                hero.thumbnail.path,
                                hero.thumbnail.extension
                            )
                            dao.save(entity)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {

            }

        })
        return heroesLivedata
    }

    fun getHeroesByNameDAO(query: String) : LiveData<List<HeroEntity>> {return dao.getHeroByName(query)}

    fun getHeroesByName(query: String) : MutableLiveData<List<Character>>{ // by name
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

    fun getCharByIdDAO(id: String) : LiveData<HeroEntity>{return dao.getHeroById(id)}

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