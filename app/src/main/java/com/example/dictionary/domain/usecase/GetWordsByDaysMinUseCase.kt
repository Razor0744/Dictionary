package com.example.dictionary.domain.usecase

import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.repositoty.WordRepository

class GetWordsByDaysMinUseCase(private val wordRepository: WordRepository) {

    fun execute(): List<Word> {
        return wordRepository.getWordsByDaysMin()
    }
}