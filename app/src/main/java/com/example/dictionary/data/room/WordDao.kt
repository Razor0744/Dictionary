package com.example.dictionary.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dictionary.domain.model.Word

@Dao
interface WordDao {
    @Query("SELECT * FROM word")
    fun getWords(): List<Word>

    @Query("SELECT * FROM word WHERE daysWithoutMistakes < 8")
    fun getWordsByDaysMin(): List<Word>

    @Query("SELECT * FROM word WHERE daysWithoutMistakes > 7")
    fun getWordsByDaysMax(): List<Word>

    @Insert
    fun addWord(word: Word)

    @Update
    fun updateDay(word: Word)
}