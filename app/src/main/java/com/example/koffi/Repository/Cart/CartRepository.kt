package com.example.koffi.Repository.Cart

import com.example.koffi.Database.Cart.CartDao
import com.example.koffi.Database.Cart.CartEntity
import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val cartDao: CartDao
) {

    fun getCartItems(): Flow<List<CartEntity>> {
        return cartDao.getCartItems()
    }

    suspend fun addToCart(
        productId: String,
        name: String,
        size: String,
        price: Double
    ) {
        val existingItem =
            cartDao.getCartItemByProductIdAndSize(
                productId = productId,
                size = size
            )

        if (existingItem != null) {

            cartDao.updateCartItem(
                existingItem.copy(
                    quantity = existingItem.quantity + 1
                )
            )

        } else {

            cartDao.insertCartItem(
                CartEntity(
                    productId = productId,
                    name = name,
                    size = size,
                    price = price,
                    quantity = 1
                )
            )
        }
    }

    suspend fun increaseQuantity(item: CartEntity) {
        cartDao.updateCartItem(
            item.copy(
                quantity = item.quantity + 1
            )
        )
    }

    suspend fun decreaseQuantity(item: CartEntity) {
        if (item.quantity <= 1) {
            cartDao.deleteCartItem(item)
        } else {
            cartDao.updateCartItem(
                item.copy(
                    quantity = item.quantity - 1
                )
            )
        }
    }

    suspend fun removeItem(item: CartEntity) {
        cartDao.deleteCartItem(item)
    }

    suspend fun clearCart() {
        cartDao.clearCart()
    }
}