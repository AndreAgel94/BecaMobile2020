package com.example.becamobile2020.data.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.becamobile2020.data.database.entity.HeroEntity
import com.example.becamobile2020.data.model.Hero

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun save(hero : HeroEntity)

    @Query("SELECT * FROM hero WHERE id = :id")
    suspend fun getHeroById(id: String) : HeroEntity

    @Query("SELECT * FROM hero WHERE name LIKE '%' || :name || '%'")
    fun getHeroByName(name : String) : LiveData<List<HeroEntity>>

    @Query("SELECT * FROM hero")
   suspend fun getAllHeroes() : List<HeroEntity>
}