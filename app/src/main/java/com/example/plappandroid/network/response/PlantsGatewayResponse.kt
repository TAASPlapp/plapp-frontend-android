package com.example.plappandroid.network.response

import com.example.plappandroid.data.db.entity.Plant

data class PlantsGatewayResponse (
    val success : Boolean,
    val message : String,
    val content : List<Plant>
)