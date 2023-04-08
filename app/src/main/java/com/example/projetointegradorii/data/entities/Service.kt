package com.example.projetointegradorii.data.messageDatabase.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "service")
data class Service(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text:String
) : Parcelable
