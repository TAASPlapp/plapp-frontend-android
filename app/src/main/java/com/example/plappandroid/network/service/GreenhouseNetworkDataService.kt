package com.example.plappandroid.network.service

import androidx.lifecycle.LiveData
import com.example.plappandroid.network.response.PlantsGatewayResponse

//for interacting with apiGatewayService and deal with exceptions
interface GreenhouseNetworkDataService {
    val downloadedPlants : LiveData<PlantsGatewayResponse>
    suspend fun getPlants()
}