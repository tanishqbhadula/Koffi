package com.example.koffi.Database.Cart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val cartItemId: Int = 0,
    val productId: String,
    val name: String,
    val size: String,
    val price: Double,
    val quantity: Int
)