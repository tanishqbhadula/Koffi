package com.example.koffi.Screens.Cart

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object CartManager {
    private val _items = MutableStateFlow<List<CartItem>>(emptyList())
    val items = _items.asStateFlow()

    fun addItem(item: CartItem) {
        val existing = _items.value.find { it.id == item.id && it.size == item.size }
        _items.value = if(existing != null) {
            _items.value.map {
                if(it.id == item.id && it.size == item.size) {
                    it.copy(quantity = it.quantity + 1)
                }
                else it
            }
        }
        else {
            _items.value + item
        }
    }

    fun remove(item: CartItem) {
        _items.value -= item
    }

    fun updateQuantity(item: CartItem, newQuantity: Int) {
        _items.value = _items.value.map {
            if(it.id == item.id && it.size == item.size) {
                it.copy(quantity = newQuantity)
            }
            else it
        }.filter {
            it.quantity > 0
        }
    }

    fun clearCart() {
        _items.value = emptyList()
    }
}