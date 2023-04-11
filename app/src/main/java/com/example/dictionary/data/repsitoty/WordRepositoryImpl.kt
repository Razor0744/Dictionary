package com.example.dictionary.data.repsitoty

import com.example.dictionary.data.room.WordDao
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.repositoty.WordRepository

class WordRepositoryImpl(private val wordDao: WordDao) : WordRepository {

    override fun getWords(): List<Word> {
        return wordDao.getWords()
    }

    override fun getWordsByDaysMin(): List<Word> {
        return wordDao.getWordsByDaysMin()
    }

    override fun addWord(word: Word) {
        wordDao.addWord(word = word)
    }

    override fun updateDay(word: Word) {
        wordDao.updateDay(word = word)
    }
}