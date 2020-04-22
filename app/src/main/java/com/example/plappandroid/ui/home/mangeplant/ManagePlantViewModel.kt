package com.example.plappandroid.ui.home.mangeplant

import androidx.lifecycle.ViewModel
import com.example.plappandroid.data.repository.PlantRepository
import com.example.plappandroid.internal.lazyDeferred

class ManagePlantViewModel(
    plantRepository: PlantRepository,
    plantId : Long
) : ViewModel() {

    val plant by lazyDeferred {
        plantRepository.getPlant(plantId)
    }

}
