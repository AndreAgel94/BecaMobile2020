package com.example.becamobile2020.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.becamobile2020.data.repository.HerosReposioryAPI
import com.example.becamobile2020.presentation.viewModel.HeroesViewModel

class HeroesViewModelFactory(
    private val reposioryAPI: HerosReposioryAPI
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeroesViewModel(reposioryAPI) as T
    }
}