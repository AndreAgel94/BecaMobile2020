package com.example.becamobile2020.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.becamobile2020.data.database.entity.HeroEntity

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(hero : HeroEntity)

    @Query("SELECT * FROM hero WHERE id = :id")
    fun getHero(id: String) : HeroEntity

    @Query("SELECT * FROM hero")
    fun getHeroes() : List<HeroEntity>
}