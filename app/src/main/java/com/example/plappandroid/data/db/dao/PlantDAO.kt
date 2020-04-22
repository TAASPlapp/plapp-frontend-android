package com.example.plappandroid.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.plappandroid.data.db.entity.Plant

@Dao
interface PlantDAO {

    //update or insert replace on conflict -> update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(plantEntry: Plant)

    @Query("select * from plant")
    fun getPlants(): LiveData<List<Plant>>

    @Query("select * from plant where plantId == :id")
    fun getPlant(id: Long): LiveData<Plant>
}