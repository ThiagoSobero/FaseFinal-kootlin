package com.example.fasefinalproject.data.mappers



import com.example.fasefinalproject.data.local.ContactEntity
import com.example.fasefinalproject.domain.model.Contact

fun ContactEntity.toDomain(): Contact =
    Contact(
        id = id,
        name = name,
        city = city,
        picture = picture
    )