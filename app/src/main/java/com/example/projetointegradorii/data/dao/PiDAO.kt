package com.example.projetointegradorii.data.messageDatabase.dao

import androidx.room.*
import com.example.projetointegradorii.data.messageDatabase.entities.Message

@Dao
interface MessageDAO {

    @Query("Select * From message")
    fun getAllMessages(): List<Message>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMessageList(message: Message)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessage(message: Message)

    @Query("DELETE FROM message WHERE id = :id")
    fun deleteMessage(id: Int)
}