package com.example.becamobile2020.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.becamobile2020.data.database.dao.HeroDao
import com.example.becamobile2020.data.database.entity.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun heroDao() : HeroDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context) : AppDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}