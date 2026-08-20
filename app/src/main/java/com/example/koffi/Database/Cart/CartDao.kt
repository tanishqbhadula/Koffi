package com.example.koffi.Database.Cart

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items")
    fun getCartItems(): Flow<List<CartEntity>>
    @Insert
    suspend fun insertCartItem(item: CartEntity)
    @Update
    suspend fun updateCartItem(item: CartEntity)
    @Delete
    suspend fun deleteCartItem(item: CartEntity)
    @Query("DELETE FROM cart_items")
    suspend fun clearCart()
    @Query("SELECT * FROM cart_items WHERE productId = :productId AND size = :size LIMIT 1")
    suspend fun getCartItemByProductIdAndSize(
        productId: String,
        size: String
    ): CartEntity?
}