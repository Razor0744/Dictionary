package com.example.dictionary.presentation.viewmodelfragment

import androidx.lifecycle.ViewModel
import com.example.dictionary.domain.model.Word
import com.example.dictionary.domain.usecase.AddWordUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(private val addWordUseCase: AddWordUseCase) : ViewModel() {

    fun addWord(word: Word) {
        CoroutineScope(Dispatchers.IO).launch {
            addWordUseCase.execute(word = word)
        }
    }
}