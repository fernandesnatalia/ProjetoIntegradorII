package com.example.projetointegradorii.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "message")
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text:String
) : Parcelable