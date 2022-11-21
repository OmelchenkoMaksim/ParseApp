package com.example.usecasesapp.di

import com.example.usecasesapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(getUserNameUseCase = get(),
            saveUserNameUseCase = get())
    }
}