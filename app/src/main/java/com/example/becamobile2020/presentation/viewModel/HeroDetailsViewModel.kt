package com.example.becamobile2020.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.becamobile2020.data.database.entity.HeroEntity
import com.example.becamobile2020.data.repository.HerosReposioryAPI
import com.example.becamobile2020.data.response.Character

class HeroDetailsViewModel(
    private val reposioryAPI: HerosReposioryAPI
) : ViewModel() {

//      fun getCharById(id: String) : MutableLiveData<Character>{
//          return reposioryAPI.getCharById(id)
//      }

      fun getCharByIdDAO(id : String) : LiveData<HeroEntity>{return reposioryAPI.getCharByIdDAO(id)}


}