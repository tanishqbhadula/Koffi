package com.example.koffi.Screens.SignUp

data class SignUpUiState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val termsAccepted: Boolean = false
)