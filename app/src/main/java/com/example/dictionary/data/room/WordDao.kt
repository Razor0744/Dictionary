package com.example.dictionary.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dictionary.domain.model.Word

@Dao
interface WordDao {
    @Query("SELECT * FROM word")
    fun getAll(): List<Word>

    @Insert
    fun insertWord(word: Word)
}