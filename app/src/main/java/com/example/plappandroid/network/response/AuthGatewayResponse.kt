package com.example.plappandroid.network.response

data class AuthGatewayResponse (
    val success : Boolean,
    val message : String,
    val content: String
)