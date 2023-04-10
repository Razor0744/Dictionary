package com.example.dictionary.domain.usecase

import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.repositoty.WordRepository

class UpdateDayUseCase(private val wordRepository: WordRepository) {

    fun execute(word: Word) {
        wordRepository.updateDay(word = word)
    }
}