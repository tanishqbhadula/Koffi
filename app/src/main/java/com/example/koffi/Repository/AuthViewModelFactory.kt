package com.example.koffi.Repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.koffi.Repository.AuthRepository
import com.example.koffi.Screens.SignUp.SignInViewModel
import com.example.koffi.Screens.SignUp.SignUpViewModel

class AuthViewModelFactory(
    private val repository: AuthRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return when {

            modelClass.isAssignableFrom(
                SignUpViewModel::class.java
            ) -> SignUpViewModel(repository)

            modelClass.isAssignableFrom(
                SignInViewModel::class.java
            ) -> SignInViewModel(repository)

            else -> throw IllegalArgumentException(
                "Unknown ViewModel class"
            )
        } as T
    }
}