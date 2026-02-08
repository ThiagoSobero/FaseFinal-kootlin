package com.example.fasefinalproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fasefinalproject.domain.repository.ContactRepository


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ContactRepository
) : ViewModel() {

    val contacts = repository.getContacts()

    fun importContacts() {
        viewModelScope.launch {
            repository.importContacts()
        }
    }
}


