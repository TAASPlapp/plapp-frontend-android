package com.example.plappandroid.data.repository

import androidx.lifecycle.LiveData
import com.example.plappandroid.data.db.PlantDAO
import com.example.plappandroid.data.db.entity.Plant
import com.example.plappandroid.network.response.PlantsGatewayResponse
import com.example.plappandroid.network.service.GreenhouseNetworkDataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime


//data caching
class PlantRepositoryImpl(
    private val greenhouseNetworkDataService: GreenhouseNetworkDataService,
    private val plantDAO: PlantDAO

) : PlantRepository {

    init {
        greenhouseNetworkDataService.downloadedPlants.observeForever { newCurrentPlants ->
            persistFetchedPlants(newCurrentPlants)
        }
    }

    override suspend fun getPlants(): LiveData<out List<Plant>> {
        return withContext(Dispatchers.IO) {
            initPlantsData()
            return@withContext plantDAO.getPlants()
        }
    }

    private suspend fun initPlantsData() {
        //todo: mod when we add plant  -> now is always true
        if (isFetchNeeded(ZonedDateTime.now().minusHours(1))) {
            fetchPlants()
        }

    }

    override suspend fun getPlant(plantId: Long): LiveData<Plant> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun persistFetchedPlants(fetchedPlants: PlantsGatewayResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            val plants : List<Plant> = fetchedPlants.content
            for (plant: Plant in plants)
                plantDAO.upsert(plant)
        }
    }

    private suspend fun fetchPlants() {
        greenhouseNetworkDataService.getPlants()
    }

    private fun isFetchNeeded(lastFetchTime: ZonedDateTime): Boolean {
        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchTime.isBefore(thirtyMinutesAgo)
    }
}