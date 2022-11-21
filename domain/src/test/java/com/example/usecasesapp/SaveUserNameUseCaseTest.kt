package com.example.usecasesapp

import com.example.usecasesapp.domain.models.SaveUserNameParam
import com.example.usecasesapp.domain.models.UserName
import com.example.usecasesapp.domain.repository.UserRepository
import com.example.usecasesapp.domain.usecase.SaveUserNameUseCase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name was already saved`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val testParams = SaveUserNameParam(name = "test first name")
        val actual = useCase.execute(testParams)
        val expected = true
        Assertions.assertEquals(expected, actual)

        // это проверка что userRepository.saveName(saveParam = param) в SaveUserNameUseCase не вызывается never
        // это проверка этого метода .saveName(saveParam = Mockito.any()) в параметрах заглушка Mockito.any() т.к. он не должен вызваться
        Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())
    }

    @Test
    fun `should return true if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val testParams = SaveUserNameParam(name = "new first name")
        val expected = true
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)
        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)
        Assertions.assertEquals(expected, actual)

        // тут таже проверка что и выше, но в этот раз метод должен вызваться один раз
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

    @Test
    fun `should return false if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val testParams = SaveUserNameParam(name = "new first name")
        val expected = false
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)
        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)
        Assertions.assertEquals(expected, actual)

        // тут таже проверка что и выше, но в этот раз метод должен вызваться один раз
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }
}