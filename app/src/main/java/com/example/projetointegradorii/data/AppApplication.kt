package com.example.projetointegradorii.data

import android.app.Application
import androidx.room.Room
import com.example.projetointegradorii.data.database.PiDatabase

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            PiDatabase::class.java, "pi-database"
        )
            .fallbackToDestructiveMigration().allowMainThreadQueries()
            .build()
    }

    companion object {
        private lateinit var database: PiDatabase
        fun getDatabase(): PiDatabase {
            return database
        }
    }
}