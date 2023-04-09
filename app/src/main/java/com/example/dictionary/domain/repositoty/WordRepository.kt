package com.example.dictionary.domain.repositoty

import com.example.dictionary.domain.model.Word

interface WordRepository {

    fun getWords(): List<Word>

    fun addWord(word: Word)
}