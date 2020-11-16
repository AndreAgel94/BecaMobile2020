package com.example.becamobile2020.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.presentation.registration.RegistrationViewParams

@Entity(tableName = "hero")
data class HeroEntity (
    @PrimaryKey val id : String,
    val name : String,
    val description : String,
    val path : String,
    val extension : String
    )

fun RegistrationViewParams.toHeroEntity() : HeroEntity{
    return with(this) {
        HeroEntity(
            id = this.id,
            name = this.name,
            description = this.description,
            path = this.path,
            extension = this.extension
        )
    }
}

fun HeroEntity.toHero(): Hero {
    return Hero(
        id = this.id,
        name = this.name,
        description = this.description,
        path = this.path,
        extension = this.extension
    )
}