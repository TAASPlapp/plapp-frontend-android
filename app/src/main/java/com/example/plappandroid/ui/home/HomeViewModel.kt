package com.example.plappandroid.ui.home

import androidx.lifecycle.ViewModel
import com.example.plappandroid.data.repository.PlantRepository
import com.example.plappandroid.internal.lazyDeferred

class  HomeViewModel(
    private val plantRepository: PlantRepository
) : ViewModel() {


    val plants  by lazyDeferred {
        plantRepository.getPlants()
    }





}
