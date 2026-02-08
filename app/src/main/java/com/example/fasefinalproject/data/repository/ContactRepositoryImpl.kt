package com.example.fasefinalproject.data.repository



import com.example.fasefinalproject.data.local.ContactDao
import com.example.fasefinalproject.data.local.ContactEntity
import com.example.fasefinalproject.data.mappers.toDomain
import com.example.fasefinalproject.data.remote.RemoteDataSource
import com.example.fasefinalproject.domain.repository.ContactRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val remote: RemoteDataSource,
    private val dao: ContactDao
) : ContactRepository {

    override fun getContacts() =
        dao.getAll().map { it.map { e -> e.toDomain() } }

    override suspend fun importContacts() {
        val response = remote.getContacts()
        dao.insertAll(response.results.map {
            ContactEntity(
                name = "${it.name.first} ${it.name.last}",
                city = it.location.city,
                picture = it.picture.medium
            )
        })
    }
}

