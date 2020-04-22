package com.example.plappandroid.ui.home.mangeplant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.plappandroid.data.repository.PlantRepository

class ManagePlantViewmodelFactory(
    private val plantRepository: PlantRepository,
    private val plantId: Long
) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ManagePlantViewModel(plantRepository, plantId) as T
    }
}