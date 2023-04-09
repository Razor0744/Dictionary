package com.example.dictionary.presentation.di

import androidx.room.Room
import com.example.dictionary.data.repsitoty.WordRepositoryImpl
import com.example.dictionary.data.room.AppDatabase
import com.example.dictionary.data.room.WordDao
import com.example.dictionary.domain.repositoty.WordRepository
import org.koin.dsl.module

val dataModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "database"
        ).build()
    }

    single<WordDao> {
        get<AppDatabase>().getWordDao()
    }

    single<WordRepository> {
        WordRepositoryImpl(wordDao = get())
    }
}