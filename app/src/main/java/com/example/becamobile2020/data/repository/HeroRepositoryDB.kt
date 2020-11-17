package com.example.becamobile2020.data.repository

import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.presentation.registration.RegistrationViewParams

interface HeroRepositoryDB {
    fun createHeroDB(registrationViewParams : RegistrationViewParams)

    fun getHeroDB(id: String) : Hero

    fun getHeroByNameDB(name : String) : Hero

    fun getHeroesDB() : List<Hero>
}