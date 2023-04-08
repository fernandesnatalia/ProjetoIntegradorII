package com.example.projetointegradorii.domain.repository

import com.example.projetointegradorii.data.dao.PiDAO
import com.example.projetointegradorii.data.entities.Message
import com.example.projetointegradorii.data.entities.Service

class RoomDatabaseRepository(private val dao: PiDAO){

    fun insertMessage(message: Message) = dao.insertMessage(message)

    fun deleteMessage(message: Message) = dao.deleteMessage(message.id)

    fun getMessages():List<Message> = dao.getAllMessages()

    fun insertService(service: Service) = dao.insertService(service)

    fun deleteService(service: Service) = dao.deleteService(service.id)

    fun getServices():List<Service> = dao.getAllServices()
}