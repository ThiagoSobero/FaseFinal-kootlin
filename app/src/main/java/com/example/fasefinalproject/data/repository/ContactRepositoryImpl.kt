package com.example.fasefinalproject.data.repository



import com.example.fasefinalproject.data.local.ContactDao
import com.example.fasefinalproject.data.local.ContactEntity
import com.example.fasefinalproject.data.mappers.toDomain
import com.example.fasefinalproject.data.remote.RemoteDataSource
import com.example.fasefinalproject.domain.repository.ContactRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dao: ContactDao
) : ContactRepository
 {

    override fun getContacts() =
        dao.getAll().map { list ->
            list.map { it.toDomain() }
        }

    override suspend fun importContacts() {
        val response = remoteDataSource.getContacts()

        val entities = response.results.map {
            ContactEntity(
                name = "${it.name.first} ${it.name.last}",
                city = it.location.city,
                picture = it.picture.medium
            )
        }
        dao.insertAll(entities)
    }
}
