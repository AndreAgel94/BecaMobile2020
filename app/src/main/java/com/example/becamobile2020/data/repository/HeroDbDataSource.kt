package com.example.becamobile2020.data.repository

import com.example.becamobile2020.data.database.dao.HeroDao
import com.example.becamobile2020.data.database.entity.toHero
import com.example.becamobile2020.data.database.entity.toHeroEntity
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.presentation.registration.RegistrationViewParams

class HeroDbDataSource(
    private val heroDAO : HeroDao
) : HeroRepositoryDB{
    override fun createHeroDB(registrationViewParams: RegistrationViewParams) {
//        val heroEntity = registrationViewParams.toHeroEntity()
//        heroDAO.save(heroEntity)
        TODO()
    }

    override fun getHeroDB(id: String): Hero {
//        return heroDAO.getHeroById(id).toHero()
        TODO()
    }

    override fun getHeroByNameDB(name: String) : Hero {
//        return heroDAO.getHeroByName(name).toHero()
        TODO()
    }

    override fun getHeroesDB(): List<Hero> {
        TODO("Achar uma solução para retornar uma lista de Heroes ??")
    }
}



