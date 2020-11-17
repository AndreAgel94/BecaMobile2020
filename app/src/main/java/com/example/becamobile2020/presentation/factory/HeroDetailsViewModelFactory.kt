package com.example.becamobile2020.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.becamobile2020.data.repository.HerosReposioryAPI
import com.example.becamobile2020.presentation.viewModel.HeroDetailsViewModel

class HeroDetailsViewModelFactory(
    private val reposioryAPI: HerosReposioryAPI
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeroDetailsViewModel(reposioryAPI) as T
    }
}