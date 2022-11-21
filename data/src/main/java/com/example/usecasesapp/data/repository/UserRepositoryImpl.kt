package com.example.usecasesapp.data.repository

import com.example.usecasesapp.data.storage.UserStorage
import com.example.usecasesapp.data.storage.models.User
import com.example.usecasesapp.domain.models.SaveUserNameParam
import com.example.usecasesapp.domain.models.UserName
import com.example.usecasesapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userStorage: UserStorage,
) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "saveParam.lastName")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}