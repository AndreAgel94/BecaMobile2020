package com.example.becamobile2020.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.becamobile2020.data.model.Hero
import com.example.becamobile2020.data.response.Thumbnail
import com.example.becamobile2020.presentation.registration.RegistrationViewParams

@Entity(tableName = "hero")
data class HeroEntity (
    @PrimaryKey val id : String,
    val name : String,
    val description : String,
    val path : String,
    val extension : String
    )

