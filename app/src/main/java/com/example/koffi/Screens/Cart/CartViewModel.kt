package com.example.koffi.Screens.Cart

import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    val cartItems = CartManager.items

    fun increasesQuantity(item: CartItem) {
        CartManager.updateQuantity(item,item.quantity+1)
    }

    fun decreasesQuantity(item: CartItem) {
        CartManager.updateQuantity(item,item.quantity-1)
    }

    fun removeItem(item: CartItem) {
        CartManager.remove(item)
    }

    fun getTotal(items: List<CartItem>): Double {
        return items.sumOf{ it.price * it.quantity }
    }
}