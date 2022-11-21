package com.example.usecasesapp.domain.repository

import com.example.usecasesapp.domain.models.SaveUserNameParam
import com.example.usecasesapp.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}