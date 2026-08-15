package com.example.koffi.Screens.SignUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun onFirstNameChange(value: String) {
        _uiState.update {
            it.copy(firstName = value)
        }
    }

    fun onLastNameChange(value: String) {
        _uiState.update {
            it.copy(lastName = value)
        }
    }

    fun onEmailChange(value: String) {
        _uiState.update {
            it.copy(email = value)
        }
    }

    fun onPasswordChange(value: String) {
        _uiState.update {
            it.copy(password = value)
        }
    }

    fun onTermsChanged(value: Boolean) {
        _uiState.update {
            it.copy(termsAccepted = value)
        }
    }

    fun canRegister(): Boolean {
        val state = _uiState.value
        return state.firstName.isNotBlank() &&
                state.lastName.isNotBlank() &&
                state.email.isNotBlank() &&
                state.password.isNotBlank() &&
                state.termsAccepted
    }
}