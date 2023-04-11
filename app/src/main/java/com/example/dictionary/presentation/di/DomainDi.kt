package com.example.dictionary.presentation.di

import com.example.dictionary.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    factory<GetWordsUseCase> {
        GetWordsUseCase(wordRepository = get())
    }

    factory<AddWordUseCase> {
        AddWordUseCase(wordRepository = get())
    }

    factory<GetWordsByDaysMinUseCase> {
        GetWordsByDaysMinUseCase(wordRepository = get())
    }

    factory<UpdateDayUseCase> {
        UpdateDayUseCase(wordRepository = get())
    }
}