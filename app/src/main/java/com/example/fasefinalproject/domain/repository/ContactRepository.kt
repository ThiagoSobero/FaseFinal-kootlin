package com.example.fasefinalproject.domain.repository


import com.example.fasefinalproject.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun getContacts(): Flow<List<Contact>>
    suspend fun importContacts()
}
