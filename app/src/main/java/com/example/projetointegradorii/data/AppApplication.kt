package com.example.projetointegradorii.data.messageDatabase

import android.app.Application
import androidx.room.Room

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            MessageDatabase::class.java, "message-database"
        )
            .fallbackToDestructiveMigration().allowMainThreadQueries()
            .build()
    }

    companion object {
        private lateinit var database: MessageDatabase
        fun getMessageDatabase(): MessageDatabase {
            return database
        }
    }
}