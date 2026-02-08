package com.example.fasefinalproject.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess = _loginSuccess.asStateFlow()

    fun login(user: String, password: String) {
        // Login ficticio: solo comprobamos que no estén vacíos
        _loginSuccess.value = user.isNotBlank() && password.isNotBlank()
    }
}
