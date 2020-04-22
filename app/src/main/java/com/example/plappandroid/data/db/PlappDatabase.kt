package com.example.plappandroid.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.plappandroid.data.db.dao.PlantDAO
import com.example.plappandroid.data.db.entity.Plant


//todo: add all others entity
@Database(
    entities = [Plant::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(StatusConverter::class)
abstract class PlappDatabase() : RoomDatabase() {
    abstract fun plantDao(): PlantDAO


    //need to be a singleton
    companion object {
        //every class has immediate access to the value
        @Volatile
        private var instance: PlappDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            //get the application context
            Room.databaseBuilder(
                context.applicationContext,
                PlappDatabase::class.java,
                "plapp.db"
            )

                    //TODO: change in production
                .fallbackToDestructiveMigration()
                .build()

    }
}