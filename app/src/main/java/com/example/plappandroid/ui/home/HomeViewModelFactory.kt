package com.example.plappandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.plappandroid.data.repository.PlantRepository


//to preserve the state of view model when the fragment is destroyed
class HomeViewModelFactory(
    private val plantRepository: PlantRepository
) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(plantRepository) as T
    }
}