package com.example.projetointegradorii.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetointegradorii.data.dao.PiDAO
import com.example.projetointegradorii.data.entities.Message
import com.example.projetointegradorii.data.entities.Service

@Database(entities = [Message::class, Service::class],version = 3)
abstract class PiDatabase : RoomDatabase() {
    abstract fun piDAO(): PiDAO
}