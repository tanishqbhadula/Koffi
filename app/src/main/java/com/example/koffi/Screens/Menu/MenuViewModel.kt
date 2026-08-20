package com.example.koffi.Screens.Menu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.koffi.Database.AppDatabase
import com.example.koffi.Models.Drink
import com.example.koffi.Repository.Drink.DrinkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MenuViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)

    private val repository = DrinkRepository(
        database.drinkDao()
    )

    private val _uiState = MutableStateFlow(MenuUiState())
    val uiState: StateFlow<MenuUiState> = _uiState.asStateFlow()

    private var allDrinks: List<Drink> = emptyList()

    init {
        loadMenu()
    }

    private fun loadMenu() {

        viewModelScope.launch {

            repository.getAllDrinks().collectLatest { drinkEntities ->

                allDrinks = drinkEntities.map { entity ->

                    Drink(
                        id = entity.id,
                        name = entity.name,
                        description = entity.description,
                        price = entity.price,
                        categoryID = stringToCategory(entity.category),
                        isRecommended = entity.isRecommended,
                        isPopular = entity.isPopular
                    )
                }

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    items = getFilteredDrinks(
                        _uiState.value.selectedCategory
                    )
                )
            }
        }
    }

    fun onCategorySelected(category: MenuCategory) {

        _uiState.value = _uiState.value.copy(
            selectedCategory = category,
            items = getFilteredDrinks(category)
        )
    }

    private fun getFilteredDrinks(
        category: MenuCategory
    ): List<Drink> {

        return when (category) {

            MenuCategory.ALL -> allDrinks

            else -> allDrinks.filter {
                it.categoryID == category
            }
        }
    }

    private fun stringToCategory(
        category: String
    ): MenuCategory {

        return when (category) {
            "HOT" -> MenuCategory.HOT
            "COLD" -> MenuCategory.COLD
            else -> MenuCategory.ALL
        }
    }
}