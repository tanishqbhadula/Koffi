package com.example.koffi.Screens.Cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koffi.Database.Cart.CartEntity
import com.example.koffi.Repository.Cart.CartRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: CartRepository
) : ViewModel() {

    val cartItems: StateFlow<List<CartEntity>> =
        repository.getCartItems()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun increaseQuantity(item: CartEntity) {
        viewModelScope.launch {
            repository.increaseQuantity(item)
        }
    }

    fun decreaseQuantity(item: CartEntity) {
        viewModelScope.launch {
            repository.decreaseQuantity(item)
        }
    }

    fun removeItem(item: CartEntity) {
        viewModelScope.launch {
            repository.removeItem(item)
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            repository.clearCart()
        }
    }

    fun getSubtotal(items: List<CartEntity>): Double {
        return items.sumOf {
            it.price * it.quantity
        }
    }

    fun getItemCount(items: List<CartEntity>): Int {
        return items.sumOf {
            it.quantity
        }
    }
}