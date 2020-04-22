package com.example.plappandroid

import android.app.Application
import com.example.plappandroid.data.db.PlappDatabase
import com.example.plappandroid.data.repository.PlantRepository
import com.example.plappandroid.data.repository.PlantRepositoryImpl
import com.example.plappandroid.network.service.GreenhouseNetworkDataService
import com.example.plappandroid.network.service.GreenhouseNetworkDataServiceImpl
import com.example.plappandroid.network.ApiGatewayService
import com.example.plappandroid.network.ConnectivityInterceptor
import com.example.plappandroid.network.ConnectivityInterceptorImpl
import com.example.plappandroid.ui.home.HomeViewModelFactory
import com.example.plappandroid.ui.home.mangeplant.ManagePlantViewmodelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class PlappApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@PlappApplication))

        bind() from singleton { PlappDatabase(instance()) }
        bind() from singleton { instance<PlappDatabase>().plantDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApiGatewayService(instance()) }
        bind<GreenhouseNetworkDataService>() with singleton {
            GreenhouseNetworkDataServiceImpl(
                instance()
            )
        }
        bind<PlantRepository>() with singleton { PlantRepositoryImpl(instance(), instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
        bind() from factory { plantId: Long -> ManagePlantViewmodelFactory(instance(), plantId) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}