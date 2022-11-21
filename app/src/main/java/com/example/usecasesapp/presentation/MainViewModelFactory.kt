package com.example.usecasesapp.presentation

/*
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usecasesapp.data.repository.UserRepositoryImpl
import com.example.usecasesapp.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasesapp.domain.usecase.GetUserNameUseCase
import com.example.usecasesapp.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    // апликейшен контекст лучше передавать в репозиторий т.к. контекст активити связан с экраном, а это нужно только в презентейшен слое
    private val userStorage by lazy(LazyThreadSafetyMode.NONE) { SharedPrefUserStorage(context = context) }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage) }

    // LazyThreadSafetyMode.NONE - это отключение синхронизации т.к. многопоточка не требуется, а по дефолту лейзи синхронизирован
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}*/
