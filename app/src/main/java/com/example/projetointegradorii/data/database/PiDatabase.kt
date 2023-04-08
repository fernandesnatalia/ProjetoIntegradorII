package com.example.projetointegradorii.data.messageDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetointegradorii.data.messageDatabase.dao.MessageDAO
import com.example.projetointegradorii.data.messageDatabase.entities.Message

@Database(entities = [Message::class],version = 1)
abstract class MessageDatabase : RoomDatabase() {

    abstract fun msgDAO(): MessageDAO
}