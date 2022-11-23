package com.example.parsingapp.di

import com.example.parsingapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(repository = get()) }
}