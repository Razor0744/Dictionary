package com.example.dictionary.presentation.viewmodelfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.usecase.GetWordsUseCase

class HomeViewModel(private val getWordsUseCase: GetWordsUseCase) : ViewModel() {

    var words = MutableLiveData<List<Word>>()

    fun getWords() {
        words.postValue(getWordsUseCase.execute())
    }

}