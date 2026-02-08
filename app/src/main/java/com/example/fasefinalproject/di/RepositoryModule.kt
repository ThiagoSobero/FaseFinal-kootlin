package com.example.fasefinalproject.di


import com.example.fasefinalproject.data.repository.ContactRepositoryImpl
import com.example.fasefinalproject.domain.repository.ContactRepository


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        impl: ContactRepositoryImpl
    ): ContactRepository
}
