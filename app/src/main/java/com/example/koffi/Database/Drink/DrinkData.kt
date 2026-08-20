package com.example.koffi.Database.Drink

object DrinkData {
    val drinks = listOf(
        DrinkEntity(
            id = "americano_classic",
            name = "Classic Hot Americano",
            description = "A rich and bold espresso-based coffee.",
            price = 179.00,
            category = "HOT",
            isRecommended = true,
            isPopular = false
        ),
        DrinkEntity(
            id = "cold_brew_classic",
            name = "Classic Cold Brew",
            description = "Smooth, refreshing and slowly brewed coffee.",
            price = 199.00,
            category = "COLD",
            isRecommended = true,
            isPopular = false
        ),
        DrinkEntity(
            id = "espresso_double_shot",
            name = "Double Shot Espresso",
            description = "Strong double espresso shot.",
            price = 159.00,
            category = "HOT",
            isRecommended = true,
            isPopular = false
        ),

        DrinkEntity(
            id = "espresso_triple_shot",
            name = "Triple Shot Espresso",
            description = "An intense triple espresso shot.",
            price = 169.00,
            category = "HOT",
            isRecommended = false,
            isPopular = false
        ),
        DrinkEntity(
            id = "classic_latte_hot",
            name = "Classic Hot Latte",
            description = "Creamy espresso with steamed milk.",
            price = 219.00,
            category = "HOT",
            isRecommended = true,
            isPopular = false
        ),
        DrinkEntity(
            id = "classic_mocha",
            name = "Classic Mocha",
            description = "Chocolate, espresso and creamy milk.",
            price = 239.00,
            category = "COLD",
            isRecommended = true,
            isPopular = false
        )
    )
}