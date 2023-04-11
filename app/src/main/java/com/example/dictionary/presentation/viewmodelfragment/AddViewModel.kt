package com.example.dictionary.presentation.viewmodelfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.usecase.AddWordUseCase
import com.example.dictionary.domain.usecase.GetWordsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(
    private val addWordUseCase: AddWordUseCase,
    private val getWordsUseCase: GetWordsUseCase
) : ViewModel() {

    var words = MutableLiveData<List<Word>>()

    fun addWord(word: Word) {
        CoroutineScope(Dispatchers.Default).launch {
            addWordUseCase.execute(word = word)
        }
    }

    fun getWords() {
        words.postValue(getWordsUseCase.execute())
    }

}