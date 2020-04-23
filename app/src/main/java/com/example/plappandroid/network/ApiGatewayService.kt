package com.example.plappandroid.network

import com.example.plappandroid.data.db.entity.Plant
import com.example.plappandroid.network.response.AuthGatewayResponse
import com.example.plappandroid.network.response.PlantsGatewayResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiGatewayService {

    @GET("greenhouse/plants")
    fun getPlants(): Deferred<PlantsGatewayResponse>

    @GET("greenhouse/plant")
    fun getPlant(@Query("plantId") plantId: Long): Deferred<Plant>

    @GET("auth/login")
    fun login(cred: Credentials): AuthGatewayResponse

    @GET("auth/signup")
    fun sigup(cred: Credentials): AuthGatewayResponse

    @GET("api/notifications/register")
    fun registerFirebaseToken(firebaseToken: String): AuthGatewayResponse

    companion object {
        private const val plappServerUrl: String = "https://plapp-api-gateway.herokuapp.com/api/";

        operator fun invoke(
            //injection
            connectivityInterceptor: ConnectivityInterceptor
        ): ApiGatewayService {
            val requestInterceptor = Interceptor { chain ->

                //todo: aggiungere session token qui
                val url = chain.request().url

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer d19a0ca0-3142-4345-9f1d-68383d53a3d4")
                        .build()
                    chain.proceed(newRequest)
                }
                .build()

            return Retrofit.Builder().client(okHttpClient)
                .baseUrl(plappServerUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiGatewayService::class.java)
        }
    }


}