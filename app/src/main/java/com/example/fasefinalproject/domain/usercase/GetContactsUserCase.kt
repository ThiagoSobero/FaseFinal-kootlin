package com.example.fasefinalproject.domain.usercase



import com.example.fasefinalproject.domain.model.Contact
import com.example.fasefinalproject.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(
    private val repository: ContactRepository
) {
    operator fun invoke(): Flow<List<Contact>> =
        repository.getContacts()
}