package com.example.usecasesapp.di

import com.example.usecasesapp.domain.usecase.GetUserNameUseCase
import com.example.usecasesapp.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}