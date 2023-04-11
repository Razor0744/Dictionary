package com.example.dictionary.presentation.di

import com.example.dictionary.presentation.viewmodelfragment.AddViewModel
import com.example.dictionary.presentation.viewmodelfragment.HomeViewModel
import com.example.dictionary.presentation.viewmodelfragment.TrainingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<HomeViewModel> {
        HomeViewModel(getWordsUseCase = get())
    }

    viewModel<AddViewModel> {
        AddViewModel(addWordUseCase = get())
    }

    viewModel<TrainingViewModel> {
        TrainingViewModel(
            getWordsByDaysMinUseCase = get(),
            updateDayUseCase = get(),
            getWordsUseCase = get()
        )
    }
}