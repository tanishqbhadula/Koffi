package com.example.koffi.Screens.Home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.koffi.Models.Category
import com.example.koffi.Models.Drink
import com.example.koffi.Screens.Menu.MenuCategory
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState

    init { loadHomeData() }

    private fun loadHomeData() {
        val categories = listOf(
            Category("all", "All"),
            Category("hot", "Hot"),
            Category("cold", "Cold"),
            Category("frappe", "Frappes"),
            Category("latte", "Latte"),
            Category("snacks", "Snacks")
        )
        val drinks = listOf(
            Drink("a1", "one", "desc", 0.0, MenuCategory.ALL),
            Drink("a2", "two", "desc", 0.0, MenuCategory.ALL),
            Drink("a3", "three", "desc", 0.0, MenuCategory.ALL),
            Drink("a4", "four", "desc", 0.0, MenuCategory.ALL),
            Drink("a5", "five", "desc", 0.0, MenuCategory.ALL),
        )
        _uiState.value = HomeUIState(
            userName = "Tanishq",
            isDelivery = true,
            selectedCategoryID = "all",
            categories = categories,
            drinks = drinks.filter { it.isRecommended },
            popular = drinks.filter { it.isPopular },
            isLoading = false
        )
    }

    fun onDeliveryModeChange(isDelivery: Boolean) {
        _uiState.update { it.copy(isDelivery = isDelivery) }
    }

    fun onCategoryChange(id: String) {
        _uiState.update { it.copy(selectedCategoryID = id) }
    }
}