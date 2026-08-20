package com.example.koffi.Database.Drink

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinks")
data class DrinkEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val isRecommended: Boolean = false,
    val isPopular: Boolean = false
)