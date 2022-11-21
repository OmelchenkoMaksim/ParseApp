package com.example.usecasesapp.domain.usecase

import com.example.usecasesapp.domain.models.UserName
import com.example.usecasesapp.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}