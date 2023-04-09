package com.example.dictionary.presentation.di

import com.example.dictionary.domain.usecase.AddWordUseCase
import com.example.dictionary.domain.usecase.GetWordsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetWordsUseCase> {
        GetWordsUseCase(wordRepository = get())
    }

    factory<AddWordUseCase> {
        AddWordUseCase(wordRepository = get())
    }
}