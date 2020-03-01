package com.example.plappandroid.data.repository

import androidx.lifecycle.LiveData
import com.example.plappandroid.data.db.entity.Plant

interface PlantRepository {
    //suspend let us call this function from a subroutine
    suspend fun getPlants(): LiveData<out List<Plant>>
    suspend fun getPlant(plantId : Long): LiveData<Plant>

}