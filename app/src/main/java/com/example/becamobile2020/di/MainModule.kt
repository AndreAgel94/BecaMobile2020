package com.example.becamobile2020.di

import android.app.Application
import androidx.room.Room
import com.example.becamobile2020.data.database.AppDataBase
import com.example.becamobile2020.data.database.dao.HeroDao
import com.example.becamobile2020.data.repository.HerosReposioryAPI
import com.example.becamobile2020.presentation.viewModel.HeroDetailsViewModel
import com.example.becamobile2020.presentation.viewModel.HeroesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {


    viewModel {
        HeroesViewModel(
            HerosReposioryAPI(get())
        )
    }

    viewModel {
        HeroDetailsViewModel(
            HerosReposioryAPI(get())
        )
    }
    factory{ HerosReposioryAPI(get())}

    single { Room.databaseBuilder(
        get(),
        AppDataBase::class.java,
        "app_database"
    ).build() }
    single { get<AppDataBase>().heroDao() }
}

//val dataBaseModule = module{
//    fun provideDatabase(application: Application) : AppDataBase{
//        return Room.databaseBuilder(application,AppDataBase::class.java,"app_database").build()
//    }
//    fun provideHeroDAO(database: AppDataBase) : HeroDao{
//        return database.heroDao()
//    }
//
//    single { provideDatabase(androidApplication()) }
//    single { provideHeroDAO(get()) }
//}



