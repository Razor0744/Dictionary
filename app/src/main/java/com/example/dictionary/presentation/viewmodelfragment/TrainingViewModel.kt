package com.example.dictionary.presentation.viewmodelfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.usecase.GetWordsByDaysMaxUseCase
import com.example.dictionary.domain.usecase.GetWordsByDaysMinUseCase
import com.example.dictionary.domain.usecase.UpdateDayUseCase

class TrainingViewModel(
    private val getWordsByDaysMaxUseCase: GetWordsByDaysMaxUseCase,
    private val getWordsByDaysMinUseCase: GetWordsByDaysMinUseCase,
    private val updateDayUseCase: UpdateDayUseCase
) : ViewModel() {

    var wordsMax = MutableLiveData<List<Word>>()
    var wordsMin = MutableLiveData<List<Word>>()

    fun getWordsMin() {
        wordsMin.postValue(getWordsByDaysMinUseCase.execute())
    }

    fun getWordsMax() {
        wordsMax.postValue(getWordsByDaysMaxUseCase.execute())
    }

    fun updateDay(word: Word) {
        updateDayUseCase.execute(word = word)
    }
}