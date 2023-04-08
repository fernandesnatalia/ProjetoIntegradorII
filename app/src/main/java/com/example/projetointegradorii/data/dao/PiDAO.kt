package com.example.projetointegradorii.data.dao

import androidx.room.*
import com.example.projetointegradorii.data.entities.Message
import com.example.projetointegradorii.data.entities.Service

@Dao
interface PiDAO {

    @Query("Select * From message")
    fun getAllMessages(): List<Message>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMessageList(message: Message)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessage(message: Message)

    @Query("DELETE FROM message WHERE id = :id")
    fun deleteMessage(id: Int)

    @Query("Select * From service")
    fun getAllServices(): List<Service>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateServiceList(service: Service)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertService(service: Service)

    @Query("DELETE FROM service WHERE id = :id")
    fun deleteService(id: Int)
}