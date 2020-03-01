package com.example.plappandroid.network

import okhttp3.Interceptor


//to check if there is internet connection and prevent the app to crash
interface ConnectivityInterceptor : Interceptor {
}