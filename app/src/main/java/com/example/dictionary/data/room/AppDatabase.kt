package com.example.dictionary.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dictionary.domain.model.Word

@Database(
    entities = [Word::class],
    version = 1,
//    autoMigrations = [AutoMigration(from = 1, to = 1)]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getWordDao(): WordDao
}