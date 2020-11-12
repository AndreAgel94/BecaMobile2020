package com.example.becamobile2020.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.becamobile2020.data.repository.HerosReposiory
import com.example.becamobile2020.presentation.viewModel.HeroesViewModel

class HeroesViewModelFactory(
    private val reposiory: HerosReposiory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeroesViewModel(reposiory) as T
    }
}