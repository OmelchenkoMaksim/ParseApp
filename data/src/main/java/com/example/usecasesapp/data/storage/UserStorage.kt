package com.example.usecasesapp.data.storage

import com.example.usecasesapp.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}