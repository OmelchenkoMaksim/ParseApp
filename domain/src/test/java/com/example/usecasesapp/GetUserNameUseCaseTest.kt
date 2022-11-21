package com.example.usecasesapp

import com.example.usecasesapp.domain.models.UserName
import com.example.usecasesapp.domain.repository.UserRepository
import com.example.usecasesapp.domain.usecase.GetUserNameUseCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {
        val testUser = UserName(firstName = "test first name", lastName = "test last name")
        // говорим что при обращении к репозиторию вернем такие данные
        Mockito.`when`(userRepository.getName()).thenReturn(testUser)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first name", lastName = "test last name")

        Assertions.assertEquals(expected, actual)
    }
}