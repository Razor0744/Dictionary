package com.example.dictionary.presentation.viewmodelfragment

import androidx.lifecycle.ViewModel
import com.example.dictionary.domain.usecase.GetWordsUseCase
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HomeViewModel(private val getWordsUseCase: GetWordsUseCase) : ViewModel() {

    suspend fun getWords() = suspendCoroutine {
        it.resume(getWordsUseCase.execute())
    }

}