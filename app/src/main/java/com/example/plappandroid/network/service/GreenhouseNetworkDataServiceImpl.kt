package com.example.plappandroid.network.service

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.plappandroid.internal.NoConnectivityException
import com.example.plappandroid.network.ApiGatewayService
import com.example.plappandroid.network.response.PlantsGatewayResponse
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class GreenhouseNetworkDataServiceImpl(
    private val apiGatewayService: ApiGatewayService
) : GreenhouseNetworkDataService {
    private val _downloadedPlants = MutableLiveData<PlantsGatewayResponse>()
    override val downloadedPlants: LiveData<PlantsGatewayResponse>
        //cast Mutable live data to live data -> not able to change from the user
        // we manage this data only from here -> incapsulation
        get() = _downloadedPlants



    override suspend fun getPlants() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                Log.d("PlantRepositoryImpl", token)

                Log.d("PlantRepositoryImpl", "Sending token");
                apiGatewayService.registerFirebaseToken(token.toString());
                Log.d("PlantRepositoryImpl", "Sent")
            })

        try {
             val plants = apiGatewayService.getPlants().await()
            _downloadedPlants.postValue(plants)
        }catch (e:NoConnectivityException){
            Log.e("Connectivity", "NO internet connection", e)
        }

    }


}