package com.example.dictionary.presentation.viewmodelfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.usecase.GetWordsByDaysMinUseCase
import com.example.dictionary.domain.usecase.GetWordsUseCase
import com.example.dictionary.domain.usecase.UpdateDayUseCase

class TrainingViewModel(
    private val getWordsByDaysMinUseCase: GetWordsByDaysMinUseCase,
    private val updateDayUseCase: UpdateDayUseCase,
    private val getWordsUseCase: GetWordsUseCase
) : ViewModel() {

    var words = MutableLiveData<List<Word>>()

    fun getWordsMin() {
        words.postValue(getWordsByDaysMinUseCase.execute())
    }

    fun updateDay(word: Word) {
        updateDayUseCase.execute(word = word)
    }

    fun getWords() {
        words.postValue(getWordsUseCase.execute())
    }
}