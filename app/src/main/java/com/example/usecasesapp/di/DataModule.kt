package com.example.usecasesapp.di

import com.example.usecasesapp.data.repository.UserRepositoryImpl
import com.example.usecasesapp.data.storage.UserStorage
import com.example.usecasesapp.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasesapp.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}