package com.example.usecasesapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usecasesapp.domain.models.SaveUserNameParam
import com.example.usecasesapp.domain.usecase.GetUserNameUseCase
import com.example.usecasesapp.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {

    private val resultLiveData = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveData

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        resultLiveData.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveData.value = "${userName.firstName} ${userName.lastName}"
    }
}