package com.example.fasefinalproject.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _loginOk = MutableStateFlow(false)
    val loginOk = _loginOk.asStateFlow()

    fun login(user: String, pass: String) {
        _loginOk.value = user.isNotBlank() && pass.isNotBlank()
    }
}


