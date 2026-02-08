package com.example.fasefinalproject.di

import android.content.Context
import androidx.room.Room
import com.example.fasefinalproject.data.local.AppDatabase
import com.example.fasefinalproject.data.local.ContactDao




import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "contacts_db"
        ).build()

    @Provides
    fun provideContactDao(db: AppDatabase): ContactDao =
        db.contactDao()
}
