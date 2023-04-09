package com.example.dictionary.data.repsitoty

import com.example.dictionary.data.room.WordDao
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.repositoty.WordRepository

class WordRepositoryImpl(private val wordDao: WordDao) : WordRepository {

    override fun getWords(): List<Word> {
        return wordDao.getAll()
    }

    override fun addWord(word: Word) {
        wordDao.addWord(word = word)
    }
}